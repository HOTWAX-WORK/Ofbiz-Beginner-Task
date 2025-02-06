//Step 15 Groovy service code to add data to the entity
import org.apache.ofbiz.entity.GenericEntityException;

def createOfbizDemo()
{
    result=[:];
    try
    {
        ofbizDemo = delegator.makeValue("OfbizDemo");
        ofbizDemo.setNextSeqId();
        ofbizDemo.setNonPKFields(context);
        ofbizDemo=delegator.create(ofbizDemo);
        result.ofbizDemoId=ofbizDemo.ofbizDemoId;
        logInfo("Groovy Service implementation in OFBiz"+ofbizDemo.getString("ofbizDemoId"));
    }
    catch (GenericEntityException e)
    {
        logError(e.getMessage());
        return error("-----------------ERROR--------------------")
    }
    return result;
}