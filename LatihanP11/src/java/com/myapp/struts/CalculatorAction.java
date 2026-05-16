package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CalculatorAction extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        CalculatorForm calcForm = (CalculatorForm) form;
        
        int n1 = calcForm.getNumber1();
        int n2 = calcForm.getNumber2();
        
        calcForm.setResult(n1 + n2);
        
        return mapping.findForward(SUCCESS);
    }
}
