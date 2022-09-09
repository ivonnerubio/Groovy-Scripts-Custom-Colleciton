def execute(){   

def DocumentVO docVo = documentService.getDocumentDetails();

def revId = createPlaceHolders(docVo,"---");

distributeFile("For Publishing",revId,"01 Architect,08 Project Manager", "3","true",true,"2");

}

 

def createPlaceHolders(def docVo,def poiName){

HashMap<String,String> documentDetails = new HashMap<>();

documentDetails.put("DocRef", docVo.getDocRef());

documentDetails.put("POI", poiName);

documentDetails.put("DocTitle", docVo.getDocTitle());

documentDetails.put("Revision", docVo.getRevision());

documentDetails.put("revisionNotes", docVo.getRevision());

documentDetails.put("publish_as_private","1");

return documentService.createPlaceHolders(documentDetails);

}

 

def distributeFile(def actionName ,def revisionIds , def distributionList, def actionDueDays, def isForPlaceHolder , def isSendNotification ,def distributionType){

HashMap<Object, Object> distributeFile = new HashMap<Object, Object>();

distributeFile.put("actionName", actionName);

distributeFile.put("revisionIds", revisionIds);

distributeFile.put("distributionList", distributionList);

distributeFile.put("actionDueDays", actionDueDays);

distributeFile.put("isForPlaceHolder", isForPlaceHolder);               

distributeFile.put("isSendNotification", isSendNotification);

distributeFile.put("distributionType", distributionType);

return documentService.distributeFile(distributeFile);

}