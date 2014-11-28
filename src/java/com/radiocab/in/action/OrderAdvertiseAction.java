/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.PaymenttypeBean;
import com.radiocab.in.actionform.OrderAdvertiseForm;
import db.PaymenttypeDB;
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
public class OrderAdvertiseAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("rcUserType".equals(cookie.getName()) && cookie.getValue().equalsIgnoreCase("company")) {
                Cookie cookie1 = new Cookie("rcPage", "order");
                cookie1.setMaxAge(60 * 60); //1 hour
                response.addCookie(cookie);
                OrderAdvertiseForm orderForm = (OrderAdvertiseForm) form;
                ArrayList<PaymenttypeBean> payments = (ArrayList) PaymenttypeDB.getPaymentTypeByPtFor("Advertise");
                orderForm.setPaymentTypeList(payments);
                return mapping.findForward(ActionResult.SUCCESS);
            }
        }
        return mapping.findForward(ActionResult.NOT_AVAILABLE);
    }

}
