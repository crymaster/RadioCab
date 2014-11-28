package com.radiocab.in.action;

import beans.CompanyBean;
import db.CompanyDB;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author son
 */
public class CompanyDetailAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        if (id == null) {
            return mapping.findForward(ActionResult.FAILURE);
        }
        int comId = 0;
        try {
            comId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return mapping.findForward(ActionResult.FAILURE);
        }
        
        CompanyBean company = CompanyDB.getCompanyByID(comId);
        if (company == null) {
            return mapping.findForward(ActionResult.FAILURE);
        }
        Cookie cookie = new Cookie("rcPage", "company");
        cookie.setMaxAge(60 * 60); //1 hour
        response.addCookie(cookie);
        request.setAttribute("company", company);
        return mapping.findForward(ActionResult.SUCCESS);
    }

}
