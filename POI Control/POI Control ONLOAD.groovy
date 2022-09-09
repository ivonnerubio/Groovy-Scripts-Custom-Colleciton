def execute(){


    //create a json object with the details of the current file
    JsonArray attributeDetailsList = new JsonArray();
    DocumentVO document = documentService.getDocumentDetails();

                   
    //set the default value for the revision as 00
    String poiDefaultValue = "Auto";
    attributeDetailsList.add(getAttributeJSON(IDocumentAttribute.POI, IDocumentAttribute.STANDARD, IDocumentAttribute.READ_ONLY, poiDefaultValue)); // Params: Attribute Name, Type Of Atribute, Editable/Read Only, default value


    // set the revision
    document.setResponseStatus(false);

    document.setDynamicObject(attributeDetailsList.toString());

    return document;

  
  

  
    }

     

    // This is a generic method to prepare JSON object. No need to do any change in this method.

    private JsonObject getAttributeJSON(String attributeName, boolean isCustomAttribute, boolean editOption, String defaultValue) {

    JsonObject attribute =  new JsonObject();

    attribute.addProperty("attributeName", attributeName);

    attribute.addProperty("isEditable", false);

    attribute.addProperty("isCustomAttribute", isCustomAttribute);

    attribute.addProperty("defaultValue", defaultValue);

    return attribute;

      
}