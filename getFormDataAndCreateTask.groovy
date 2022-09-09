def execute() {

  FormVO formVo = formService.getFormDetails();
  
  String testSubject = "This will assign";
  
  //List<DistributionVO> distributionUsers = new ArrayList<DistributionVO>();

  List<DistributionVO> user1 = new ArrayList<DistributionVO>();
  user1.setRecipientType(Recipient.USER);
  user1.setRecipientName("Ivonne Rubio");
  user1.setActionId(String.valueOf(SystemActionsForms.ACTION_FOR_INFORMATION));
  user1.setDueDays("3");
  
 // distributionUsers.put(user1);
  
  
  
 // HashMap distributionMap = new HashMap();

/*  for(DistributionVO user : distributionUsers){

  String userType = user.setRecipientType(USER);

  String userName = user.setRecipientName(Ivonne Rubio);

  distributionMap.put(userType, userName,);
  
  

  }
  */
  
  
 /*for(DistributionVO attachment : distributionTest){
     distributionTest.setRecipientType(ADD);
     distributionTest.setRecipientName("Ivonne Rubio");
      distributionTest.setActionId(ACTION_FOR_INFORMATION);
      distributionTest.setDueDays(7);

 
    }*/
  
  
  
  
  formService.distributeForm(user1, testSubject);
  
}