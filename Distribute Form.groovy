def execute() {

    String subject = "Distribution From Groovy";

    List<DistributionVO> distVoList = new ArrayList<DistributionVO>();

    distributeForm(Recipient.USER, "irubio@asite.com", SystemActionsForms.ACTION_FORM_RESPOND, 22, distVoList);

    // distributeForm(Recipient.ROLE, "Example Role", SystemActionsForms.ACTION_FORM_RESPOND, 5, distVoList);
    // distributeForm(Recipient.ORG, "Example Org", SystemActionsForms.ACTION_FOR_INFORMATION, 2, distVoList);

    // distributeForm(Recipient.GROUP, "Example Form Dist Group", distVoList);

    formService.distributeForm(distVoList, subject);

}

// For ORG, ROLE, USER.F

def distributeForm(def recipientType, def recipientName,  def actionName, def actionDueDays, def distVoList){

    DistributionVO vo = new DistributionVO();

    vo.setRecipientType(recipientType);

    vo.setRecipientName(recipientName);

    vo.setActionId(actionName);

    vo.setDueDays(actionDueDays);

    vo.setSendMail(true);

    distVoList.add(vo);

}

// For only distribution group

def distributeForm(def recipientType, def recipientName, def distVoList){

  distributeForm(recipientType, recipientName, 0, 0, distVoList);

} 