/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CompanyBean;
import beans.DriverBean;
import db.CompanyDB;
import db.DriverDB;
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
public class ProfileAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        String username = "";
        int userId = 0;
        String type = "";
        for (Cookie cookie : cookies) {
            if ("rcUsername".equals(cookie.getName())) {
                username = cookie.getValue();
            }
            if ("rcUserId".equals(cookie.getName())) {
                userId = Integer.parseInt(cookie.getValue());
            }
            if ("rcUserType".equals(cookie.getName())){
                type = cookie.getValue();
            }
        }
        if(type.equals("company")){
            CompanyBean company = CompanyDB.getCompanyByID(userId);
            request.setAttribute("company", company);
        } else if(type.equals("driver")){
            DriverBean driver = DriverDB.getDriverByID(userId);
            request.setAttribute("driver", driver);
        }
        return mapping.findForward(ActionResult.SUCCESS);
    }
    
}
