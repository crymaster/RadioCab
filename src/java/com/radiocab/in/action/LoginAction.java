/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CompanyBean;
import beans.DriverBean;
import com.radiocab.in.actionform.LoginForm;
import db.CompanyDB;
import db.DriverDB;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;

/**
 *
 * @author son
 */
public class LoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList errors = new ArrayList();
        LoginForm loginForm = (LoginForm) form;
        if (request.getMethod().equals(HttpMethod.GET)) {
            loginForm.setType("company");
            return mapping.findForward(ActionResult.INPUT);
        } else {
            if (loginForm.getType().equals("company")) {
                CompanyBean company = CompanyDB.companyLogin(loginForm.getUsername(), loginForm.getPassword());
                if (company != null) {
                    Cookie cookie = new Cookie("rcUsername", company.getCom_uName());
                    cookie.setMaxAge(60 * 60); //1 hour
                    response.addCookie(cookie);
                    cookie = new Cookie("rcUserId", company.getCom_ID() + "");
                    cookie.setMaxAge(60 * 60); //1 hour
                    response.addCookie(cookie);
                    cookie = new Cookie("rcUserType", "company");
                    cookie.setMaxAge(60 * 60); //1 hour
                    response.addCookie(cookie);
                    return mapping.findForward(ActionResult.SUCCESS);
                } else {
                    errors.add("loginError");
                    request.setAttribute("errors", errors);
                    return mapping.findForward(ActionResult.FAILURE);
                }
            } else {
                DriverBean driver = DriverDB.driverLogin(loginForm.getUsername(), loginForm.getPassword());
                if (driver != null) {
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
                } else {
                    errors.add("loginError");
                    request.setAttribute("errors", errors);
                    return mapping.findForward(ActionResult.FAILURE);
                }
            }
        }
    }
}
