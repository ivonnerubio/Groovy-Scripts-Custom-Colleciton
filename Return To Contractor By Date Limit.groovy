def execute() {

    DocumentVO document = documentService.getDocumentDetails();
    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
    Date date = new Date();
  	formatter.format(date);
    if (!document.getHasAttachment()) {

        document.setResponseStatus(false);

        document.setResponseMessage("Uploaded document should have attachment." + formatter.format(date));

    }

    return document;

}