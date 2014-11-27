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
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import utils.ActionResult;
import utils.EmailValidator;
import utils.ImageValidator;
import utils.PhoneNumberValidator;
import utils.UploadImageUtil;

/**
 *
 * @author son
 */
public class RegisterDriverHandlerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList errors = new ArrayList();
        RegisterDriverForm regForm = (RegisterDriverForm) form;
        if (regForm.getDrvUsername() == null || regForm.getDrvUsername().trim().equals("")) {
            errors.add("error.drvUsername.required");
        }
        if (regForm.getDrvName() == null || regForm.getDrvName().trim().equals("")) {
            errors.add("error.drvName.required");
        }
        if (regForm.getDrvPass() == null || regForm.getDrvPass().equals("")) {
            errors.add("error.pass.required");
        }
        if (regForm.getDrvPassConfirm() == null || regForm.getDrvUsername().equals("")) {
            errors.add("error.passconfirm.required");
        }
        if (regForm.getDrvAddress() == null || regForm.getDrvAddress().trim().equals("")) {
            errors.add("error.address.required");
        }
        if (!regForm.getDrvPass().equals(regForm.getDrvPassConfirm())) {
            errors.add("error.pass.notequal");
        }
        if (!regForm.getDrvMobile().equals("")) {
            if (!PhoneNumberValidator.validate(regForm.getDrvMobile())) {
                errors.add("error.mobile.wrongformat");
            }
        }
        if (!regForm.getDrvTel().equals("")) {
            if (!PhoneNumberValidator.validate(regForm.getDrvTel())) {
                errors.add("error.tel.wrongformat");
            }
        }
        if (!regForm.getDrvEmail().equals("")) {
            if (!EmailValidator.validate(regForm.getDrvEmail())) {
                errors.add("error.email.wrongformat");
            }
        }
        if (regForm.getImage() != null) {
            if (!ImageValidator.validate(regForm.getImage().getFileName())) {
                errors.add("error.image.wrongext");
            }
            if (regForm.getImage().getFileSize() > 2097152) {
                errors.add("error.image.toobig");
            }
        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            return mapping.findForward(ActionResult.FAILURE);
        }
        FormFile file = regForm.getImage();
        Random rd = new Random();
        String fileName = rd.nextInt(10000) + file.getFileName();
        String filePath = getServlet().getServletContext().getRealPath("/") + "upload/driver";
        UploadImageUtil.upload(fileName, filePath, file.getFileData());
        DriverBean driver = new DriverBean();
        driver.setDriver_uName(regForm.getDrvUsername());
        driver.setDriver_Pass(regForm.getDrvPass());
        driver.setDriver_Name(regForm.getDrvName());
        driver.setDriver_Contactperson(regForm.getDrvContactPerson());
        driver.setDriver_Address(regForm.getDrvAddress());
        driver.setCity_ID(regForm.getCityId());
        driver.setDriver_Image(fileName);
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
            driver.setDriver_ID(id);
            PaymentBean payment = new PaymentBean();
            payment.setPaytype_ID(regForm.getPaymentType());
            payment.setDriver_ID(driver.getDriver_ID());
            Date today = new Date();
            payment.setPay_Time(new Timestamp(today.getTime()));
            payment.setPay_Status(1);

            if (!PaymentDB.addPayment(payment)) {
                errors.add("registerError");
                request.setAttribute("errors", errors);
                return mapping.findForward(ActionResult.FAILURE);
            }

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
