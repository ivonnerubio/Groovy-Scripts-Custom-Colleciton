def execute(){

    DocumentVO document = documentService.getDocumentDetails();

    String documentVersion = document.getVer();

    List<ScriptResponseVO> responseActions = new ArrayList<ScriptResponseVO>();

    ScriptResponseVO variableParamVo = new ScriptResponseVO();

    variableParamVo.setResponseAction(ResponseActionEnum.UPDATE_WORKFLOW_VARIABLE);

    Map<String, Object> variableParamMap = new HashMap<>();

    variableParamMap.put(IGroovyConstant.DYNAMIC_ADECISION_VARIABLE, documentVersion); // You can set any value between 1 to 99 to this variable

    variableParamVo.setResponseObject(variableParamMap);

    responseActions.add(variableParamVo);

    return responseActions;

}