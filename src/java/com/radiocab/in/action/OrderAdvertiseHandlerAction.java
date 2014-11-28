/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.AdvertiseBean;
import beans.PaymentBean;
import beans.PaymenttypeBean;
import com.radiocab.in.actionform.OrderAdvertiseForm;
import db.AdvertiseDB;
import db.PaymentDB;
import db.PaymenttypeDB;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import utils.ImageValidator;
import utils.UploadImageUtil;

/**
 *
 * @author son
 */
public class OrderAdvertiseHandlerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("rcUserType".equals(cookie.getName()) && cookie.getValue().equalsIgnoreCase("company")) {
                String username = "";
                int userId = 0;
                for (Cookie cookie1 : cookies) {
                    if ("rcUsername".equals(cookie1.getName())) {
                        username = cookie1.getValue();
                    }
                    if ("rcUserId".equals(cookie1.getName())) {
                        userId = Integer.parseInt(cookie1.getValue());
                    }
                }
                ArrayList errors = new ArrayList();
                OrderAdvertiseForm orderForm = (OrderAdvertiseForm) form;
                if (orderForm.getImage() != null) {
                    if (!ImageValidator.validate(orderForm.getImage().getFileName())) {
                        errors.add("error.image.wrongext");
                    }
                    if (orderForm.getImage().getFileSize() > 2097152) {
                        errors.add("error.image.toobig");
                    }
                }
                if (errors.size() > 0) {
                    request.setAttribute("errors", errors);
                    return mapping.findForward(ActionResult.FAILURE);
                }
                FormFile file = orderForm.getImage();
                Random rd = new Random();
                String fileName = rd.nextInt(10000) + file.getFileName();
                String filePath = getServlet().getServletContext().getRealPath("/") + "upload/advertise";
                UploadImageUtil.upload(fileName, filePath, file.getFileData());
                AdvertiseBean adv = new AdvertiseBean();
                adv.setAdv_Image(fileName);
                adv.setCom_ID(userId);
                adv.setAdv_Status(0);
                adv.setAdv_Description(orderForm.getAdvDescription());
                int id = AdvertiseDB.addAdvertise(adv);

                if (id == -1) {
                    errors.add("registerError");
                    request.setAttribute("errors", errors);
                    ArrayList<PaymenttypeBean> payments = (ArrayList) PaymenttypeDB.getPaymentTypeByPtFor("Advertise");
                    orderForm.setPaymentTypeList(payments);
                    return mapping.findForward(ActionResult.FAILURE);
                } else {
                    adv.setAdv_ID(id);
                    PaymentBean payment = new PaymentBean();
                    payment.setPaytype_ID(orderForm.getPaymentType());
                    payment.setCom_ID(userId);
                    payment.setAdv_ID(id);
                    Date today = new Date();
                    payment.setPay_Time(new Timestamp(today.getTime()));
                    payment.setPay_Total(0);
                    payment.setPay_Status(2);

                    if (!PaymentDB.addPayment(payment)) {
                        errors.add("registerError");
                        request.setAttribute("errors", errors);
                        return mapping.findForward(ActionResult.FAILURE);
                    }
                    return mapping.findForward(ActionResult.SUCCESS);
                }
            }
        }
        return mapping.findForward(ActionResult.NOT_AVAILABLE);
    }
}
