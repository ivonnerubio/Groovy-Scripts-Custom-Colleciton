def execute(){
// Get form Details

    FormVO formVo = formService.getFormDetails();

    String inputXml = formVo.getXmlData();
    String designUnit =  formService.getFormFieldValuesFromXML(inputXml, "DesignUnit");
    int designUnitDynamicVariable = 0;

    if(designUnit =="AC1 ‐ AC Traction Power"){
        designUnitDynamicVariable = 1;
    }else if(designUnit == "BR1 ‐ Eastchester Avenue Bridge"){
        designUnitDynamicVariable = 2;
    }else if(designUnit == "BR2 ‐ Bronxdale Bridge"){
        designUnitDynamicVariable = 3;
    }else if(designUnit == "BR3 ‐ Bronx River Bridge"){
        designUnitDynamicVariable = 4;
    }else if(designUnit == "BR5 ‐ Bridges"){
        designUnitDynamicVariable = 5;
    }else if(designUnit == "BRX1 ‐ Bronx Interlocking"){
        designUnitDynamicVariable = 6;
    }else if(designUnit == "CX1 ‐ Track 6 Reconstruction"){
        designUnitDynamicVariable = 7;
    }else if(designUnit == "DC1 ‐ DC Traction Power"){
        designUnitDynamicVariable = 8;
    }else if(designUnit == "HP1 ‐ Hunts Point Track and OCS Portals"){
        designUnitDynamicVariable = 9;
    }else if(designUnit == "HP2 ‐ Hunts Point Civil and Systems"){
        designUnitDynamicVariable = 10;
    }else if(designUnit == "HP3 ‐ Hunts Point Station"){
        designUnitDynamicVariable = 11;
    }else if(designUnit == "LEG1 ‐ Leggett Track and Civil Package"){
        designUnitDynamicVariable = 12;
    }
   
    

    List<ScriptResponseVO> responseActions = new ArrayList<ScriptResponseVO>();

    ScriptResponseVO variableParamVo = new ScriptResponseVO();

    variableParamVo.setResponseAction(ResponseActionEnum.UPDATE_WORKFLOW_VARIABLE);

    Map<String, Object> variableParamMap = new HashMap<>();

    variableParamMap.put(IGroovyConstant.DYNAMIC_ADECISION_VARIABLE, designUnitDynamicVariable); // You can set any value between 1 to 99 to this variable

    variableParamVo.setResponseObject(variableParamMap);

    responseActions.add(variableParamVo);

    return responseActions;

}