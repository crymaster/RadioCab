/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CityBean;
import beans.PaymenttypeBean;
import com.radiocab.in.actionform.RegisterDriverForm;
import db.CityDB;
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
public class RegisterDriverAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("rcUsername".equals(cookie.getName())) {
                return mapping.findForward(ActionResult.NOT_AVAILABLE);
            }
        }
        RegisterDriverForm regForm = (RegisterDriverForm) form;
        ArrayList<CityBean> cities = (ArrayList) CityDB.getAllAvailableCity();
        ArrayList<PaymenttypeBean> payments = (ArrayList) PaymenttypeDB.getPaymentTypeByPtFor("Driver");
        regForm.setCityList(cities);
        regForm.setPaymentTypeList(payments);
        return mapping.findForward(ActionResult.SUCCESS);
    }
}
