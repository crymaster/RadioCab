/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CompanyBean;
import beans.PaymentBean;
import beans.PaymenttypeBean;
import com.radiocab.in.actionform.RegisterCompanyForm;
import db.CompanyDB;
import db.PaymentDB;
import db.PaymenttypeDB;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;

/**
 *
 * @author son
 */
public class RegisterCompanyAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList errors = new ArrayList();
        RegisterCompanyForm regForm = (RegisterCompanyForm) form;
        CompanyBean company = new CompanyBean();
        company.setCom_uName(regForm.getComUsername());
        company.setCom_Pass(regForm.getComPass());
        company.setCom_Name(regForm.getComName());
        company.setCom_Designation(regForm.getComDesignation());
        company.setCom_Contactperson(regForm.getComContactPerson());
        company.setCom_Address(regForm.getComAddress());
        company.setCity_ID(regForm.getCityId());
        company.setCom_Image("link");
        company.setCom_Mobile(regForm.getComMobile());
        company.setCom_Tel(regForm.getComTel());
        company.setCom_Fax(regForm.getComFax());
        company.setCom_Email(regForm.getComEmail());
        company.setMem_ID(regForm.getMembershipType());
        company.setCom_RegDate(new Timestamp(new Date().getTime()));
        company.setCom_Status(1);
        int id = CompanyDB.addCompany(company);
        
        if(id == -1){
            errors.add("registerError");
            request.setAttribute("errors", errors);
            return mapping.findForward(ActionResult.FAILURE);
        }
        else {
            PaymentBean payment = new PaymentBean();
            payment.setPaytype_ID(regForm.getPaymentType());
            payment.setCom_ID(company.getCom_ID());
            Date today = new Date();
            payment.setPay_Time(new Timestamp(today.getTime()));
            payment.setPay_Status(1);
            
            if(!PaymentDB.addPayment(payment)){
                errors.add("registerError");
                request.setAttribute("errors", errors);
                return mapping.findForward(ActionResult.FAILURE);
            }
            
            Cookie cookie = new Cookie("rcUsername", company.getCom_uName());
            cookie.setMaxAge(60*60); //1 hour
            response.addCookie(cookie);
            cookie = new Cookie("rcUserId", company.getCom_ID()+"");
            cookie.setMaxAge(60*60); //1 hour
            response.addCookie(cookie);
            cookie = new Cookie("rcUserType", "company");
            cookie.setMaxAge(60*60); //1 hour
            response.addCookie(cookie);
            return mapping.findForward(ActionResult.SUCCESS);
        }
    }
}
