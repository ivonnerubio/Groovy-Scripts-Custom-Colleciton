def execute(){                                                   

	// Fetch current document details
	DocumentVO document = documentService.getDocumentDetails();  

	//Prepare ADD/REMOVE Recipients JSON
	JsonObject responseJSON = new JsonObject();        

	// ADD/REMOVE USERS
	JsonArray usersList = new JsonArray();
	setDistribution(document.getPublisherEmail(), Recipient.USER, Recipient.ADD, usersList); // Params: User Email, Type Of Recipient, ADD/REMOVE, listObject.


	JsonObject distributionList = new JsonObject();   
	distributionList.add(Recipient.USER, usersList);
  	distributionList.addProperty(IGroovyConstant.ENABLE_DISTRIBUTION_LIST,"false");
	distributionList.addProperty(IGroovyConstant.CLEAR_DISTRIBUTION_LIST, "true");    // By setting this value to true, it will clear all the recipients from the distribution list in 'To' field.                         
	distributionList.addProperty(IGroovyConstant.APPLY_TO_EDIT_DRAFT,"false");

    responseJSON.add(IGroovyConstant.DISTRIBUTION_LIST, distributionList);                

	document.setResponseStatus(true);
	document.setDynamicObject(responseJSON.toString());   
  
	return document;
}



// Do not change anything in below functions.
// FOR REMOVE
public void setDistribution(String data, String distLevel, String operation, JsonArray arrayList) {
	String ojbect = "name";
	if(Recipient.USER.equals(distLevel)) {
		ojbect = "email";
	}
	JsonObject jsonObject = new JsonObject();
	jsonObject.addProperty(ojbect, data);
	jsonObject.addProperty("operation", operation);
	arrayList.add(jsonObject);
}

// TO ADD
public void setDistribution(String data, String distLevel, String operation, int actionId, String dueDays, JsonArray arrayList) {
	String ojbect = "name";
	if(Recipient.USER.equals(distLevel)) {
		ojbect = "email";
	}
	JsonObject jsonObject = new JsonObject();
	jsonObject.addProperty(ojbect, data);
	jsonObject.addProperty("operation", operation);
	jsonObject.addProperty("actionId", String.valueOf(actionId));
	jsonObject.addProperty("dueDays", dueDays);
	arrayList.add(jsonObject);
}

// PREPARE JSON
public JsonElement addAttributes(String applyToEditDraft, String editable, String defaultValue) {
	JsonElement jsonObject = new JsonObject();
	jsonObject.addProperty(IGroovyConstant.EDITABLE, editable);   
	jsonObject.addProperty(IGroovyConstant.VALUE, defaultValue);
	jsonObject.addProperty(IGroovyConstant.APPLY_TO_EDIT_DRAFT, applyToEditDraft);
	return jsonObject;
  
 
}