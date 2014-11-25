/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CityBean;
import beans.DriverBean;
import beans.PaymentBean;
import beans.PaymenttypeBean;
import com.radiocab.in.actionform.RegisterDriverForm;
import db.CityDB;
import db.DriverDB;
import db.PaymentDB;
import db.PaymenttypeDB;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;

/**
 *
 * @author son
 */
public class RegisterDriverHandlerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList errors = new ArrayList();
        RegisterDriverForm regForm = (RegisterDriverForm) form;
        DriverBean driver = new DriverBean();
        driver.setDriver_uName(regForm.getDrvUsername());
        driver.setDriver_Pass(regForm.getDrvPass());
        driver.setDriver_Name(regForm.getDrvName());
        driver.setDriver_Contactperson(regForm.getDrvContactPerson());
        driver.setDriver_Address(regForm.getDrvAddress());
        driver.setCity_ID(regForm.getCityId());
        driver.setDriver_Image("link");
        driver.setDriver_Mobile(regForm.getDrvMobile());
        driver.setDriver_Tel(regForm.getDrvTel());
        driver.setDriver_Email(regForm.getDrvEmail());
        driver.setDriver_Description(regForm.getDrvDescription());
        driver.setDriver_Exp(regForm.getDrvExp());
        driver.setDriver_Status(1);
        int id = DriverDB.addDriver(driver);

        if (id == -1) {
            errors.add("registerError");
            request.setAttribute("errors", errors);
            ArrayList<CityBean> cities = (ArrayList) CityDB.getAllAvailableCity();
            ArrayList<PaymenttypeBean> payments = (ArrayList) PaymenttypeDB.getPaymentTypeByPtFor("Driver");
            regForm.setCityList(cities);
            regForm.setPaymentTypeList(payments);
            return mapping.findForward(ActionResult.FAILURE);
        } else {
//            PaymentBean payment = new PaymentBean();
//            payment.setPaytype_ID(regForm.getPaymentType());
//            payment.setDriver_ID(driver.getDriver_ID());
//            Date today = new Date();
//            payment.setPay_Time(new Timestamp(today.getTime()));
//            payment.setPay_Status(1);
//
//            if (!PaymentDB.addPayment(payment)) {
//                errors.add("registerError");
//                request.setAttribute("errors", errors);
//                return mapping.findForward(ActionResult.FAILURE);
//            }
            
            Cookie cookie = new Cookie("rcUsername", driver.getDriver_uName());
            cookie.setMaxAge(60 * 60); //1 hour
            response.addCookie(cookie);
            cookie = new Cookie("rcUserId", driver.getDriver_ID() + "");
            cookie.setMaxAge(60 * 60); //1 hour
            response.addCookie(cookie);
            cookie = new Cookie("rcUserType", "driver");
            cookie.setMaxAge(60 * 60); //1 hour
            response.addCookie(cookie);
            return mapping.findForward(ActionResult.SUCCESS);
        }
    }
}
