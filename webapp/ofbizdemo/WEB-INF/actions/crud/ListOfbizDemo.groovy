
context.ofbizDemoTypes = from("OfbizDemoType").queryList()
context.ofbizDemoList = from("OfbizDemo").queryList()

// Entity Query API se simplify structure mil gya h to query instead of specifying multiple parameter
// we can API which provides simple sql structure

//ofbizDemoTypes = delegator.findList("OfbizDemoType", null, null, null, null, false);
//context.ofbizDemoTypes = ofbizDemoTypes;
//ofbizDemoList = delegator.findList("OfbizDemo", null, null, null, null, false);
//context.ofbizDemoList = ofbizDemoList;

