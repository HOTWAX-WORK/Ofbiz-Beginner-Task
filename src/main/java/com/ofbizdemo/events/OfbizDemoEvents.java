package com.ofbizdemo.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

public class OfbizDemoEvents{
    public static final String Module=OfbizDemoEvents.class.getName();
    public static String createOfbizDemoEvent(HttpServletRequest request,HttpServletResponse response)
    {
        Delegator delegator=(Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher=(LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin=(GenericValue) request.getSession().getAttribute("userLogin");

        String ofbizDemoTypeId=request.getParameter("ofbizDemoTypeId");
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String comments=request.getParameter("comments");

        if (UtilValidate.isEmpty(firstName) || UtilValidate.isEmpty(lastName)) {
            String eror="Fill the first and last name";
            request.setAttribute("_ERROR_MESSAGE_",eror);
            return "error";
        }

        try
        {
            dispatcher.runSync("createOfbizDemoGroovyService",UtilMisc.toMap("ofbizDemoTypeId",ofbizDemoTypeId,"firstName",firstName,"lastName",lastName,"comments",comments,"userLogin",userLogin));
        }
        catch(GenericServiceException e)
        {
            String eror = "Error creating OfbizDemo entity: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", eror);
            return "error";
        }
        request.setAttribute("_EVENT_MESSAGE_", "Entity created succesfully");
        return "success";



    }

}