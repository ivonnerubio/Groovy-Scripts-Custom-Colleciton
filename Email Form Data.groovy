def execute() {

// Get form Details

FormVO formVo = formService.getFormDetails();

String inputXml = formVo.getXmlData();

 

// Fields to be extracted from Form XML

Map<String, String> dataMap = new HashMap<>();

dataMap.put("ORI_FORMTITLE", formService.getFormFieldValuesFromXML(inputXml, "ORI_FORMTITLE"));

dataMap.put("PROJECT_NAME", formVo.getProjectName());

dataMap.put("FORM_ID", formVo.getFormCodeNum());  // e.g. EMP001, EMP002...

dataMap.put("First_Name", formService.getFormFieldValuesFromXML(inputXml, "First_Name"));

dataMap.put("Last_Name", formService.getFormFieldValuesFromXML(inputXml, "Last_Name"));
  
  dataMap.put("ATTACHMENT_2", formService.getFormFieldValuesFromXML(inputXml, "Attachment_2"));

dataMap.put("Email_ID", formService.getFormFieldValuesFromXML(inputXml, "Email_ID"));

dataMap.put("Organization", formService.getFormFieldValuesFromXML(inputXml, "Organization"));

dataMap.put("Department", formService.getFormFieldValuesFromXML(inputXml, "Department"));

dataMap.put("Roles", formService.getFormFieldValuesFromXML(inputXml, "Roles"));

dataMap.put("Products", formService.getFormFieldValuesFromXML(inputXml, "Products"));

dataMap.put("TITLE", formService.getFormFieldValuesFromXML(inputXml, "ORI_FORMTITLE"));

  

//Template to format output XML

String xmlTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>   <EMPLOYEE> <EMP_GIVEN_NAME>##ORI_FORMTITLE</EMP_GIVEN_NAME> <PROJECT_NAME>##PROJECT_NAME</PROJECT_NAME> <FORM_ID>##FORM_ID</FORM_ID> <TITLE>##TITLE</TITLE> <ATTACHMENT>##ATTACHMENT_2</ATTACHMENT></EMPLOYEE>";

    

String outputXml = formService.toXML(dataMap, xmlTemplate);

List<String> toRecipient = new ArrayList<>();

toRecipient.add("irubio@asite.com");

List<String> cCRecipient = new ArrayList<>();


   

String emailBody = "Hi, <BR/><BR/> New Employee joined ASITE. <BR/><BR/> Thanks, <BR/> Asite Support";

   

String attachedXmlFileName = formService.getFormFieldValuesFromXML(inputXml, "ORI_FORMTITLE") + "_" + formVo.getFormCodeNum()+".xml";

Map<String, Object> mailDataMap = new HashMap<>();

mailDataMap.put(IGroovyConstant.RECEIPIENT_USERS, toRecipient);

mailDataMap.put(IGroovyConstant.CC_RECEIPIENT_USERS, cCRecipient);

mailDataMap.put(IGroovyConstant.SUBJECT, "Employee Information");

mailDataMap.put(IGroovyConstant.MAIL_BODY, emailBody);

mailDataMap.put(IGroovyConstant.HTML_CONTENT, true);

mailDataMap.put(IGroovyConstant.XML_ATTACHMENT, outputXml);

mailDataMap.put(IGroovyConstant.ATTACHMENT_FILE_NAME, attachedXmlFileName);

notificationService.sendMailWithAttachment(mailDataMap);

}

private String getFileName(String value){

return value.replaceAll("|","_");

}