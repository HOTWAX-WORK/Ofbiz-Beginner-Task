package com.ofbizdemo.services;
import java.util.Map;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

public class OfbizDemoService {
    public static final String Module=OfbizDemoService.class.getName();
    public static Map<String,Object> createOfbizDemo(DispatchContext dctx,Map<String, ? extends Object> context)
    {
        Map<String,Object> result=ServiceUtil.returnSuccess();
        Delegator delegator=dctx.getDelegator();
        try
        {
            GenericValue ofbizDemo=delegator.makeValue("OfbizDemo");
            ofbizDemo.setNextSeqId();
            ofbizDemo.setNonPKFields(context);
            ofbizDemo=delegator.create(ofbizDemo);
            result.put("ofbizDemoId",ofbizDemo.getString("ofbizDemoId"));
            Debug.log("Java Service implementation in OFBiz"+ ofbizDemo.getString("ofbizDemoId"));
        }
        catch (GenericEntityException e)
        {
            Debug.logError(e,Module);
            return ServiceUtil.returnError("Error in Ofbiz DEmo entity" + Module);
        }
        return result;

    }
}