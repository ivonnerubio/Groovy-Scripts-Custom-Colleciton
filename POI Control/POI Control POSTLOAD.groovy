def execute(){
  
    // get the current revision of the document and initialize a global revision variable that will be applied to the file
    DocumentVO document = documentService.getDocumentDetails();
    String revision_new = document.getRevision();
    String doc_publisher = document.getPublisherName();
 	
  if(revision_new=="Auto"){
    revision_new ="00";
  }
    
    // hash map to retrieve the previous revision
    HashMap<Object, Object> optionMap = new HashMap();

    optionMap.put(RevisionOption.GET_REVISIONS, RevisionOption.PREVIOUS_REVISION);
 
    optionMap.put(RevisionDetailsOption.BASIC_DETAILS, true);

    optionMap.put(RevisionOption.INCLUDE_DEACTIVATED, false);

    Map<String, DocumentVO> revisionsMap = documentService.getDocumentRevisionDetail(document, optionMap); // Here revisionsMap will have issue number as key and DocumentVO as value.
  
  if(!doc_publisher.equals("Workflow Agent System")){
    // if statement to see if the revision map is NOT EMPTY
      if(!revisionsMap.isEmpty()){
     
        // retrieve the revision and save into a String variable

        Map.Entry<String, DocumentVO> entry = revisionsMap.entrySet().iterator().next();
        String docRef_revision = entry.getKey();
        DocumentVO document_previous = entry.getValue();
        String revision_previous = document_previous.getRevision();
		
        // convert the string into an integer and add one
        int revision_pre = Integer.parseInt(revision_previous);
        revision_pre = revision_pre + 1;


        // turn the revision to an integer and set the new revision number
        if (revision_pre <= 9) {
            revision_new = "0" + revision_pre.toString();
        }
        else{
            revision_new = revision_pre.toString();
        } 
    }
  
  }
    // apply the new revision to the file
    documentContext.getDocVO().revision = revision_new;     
    documentService.updateDocument(documentContext);

}