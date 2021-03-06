/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.DriverBean;
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
public class DriverDetailAction extends Action {

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
        DriverBean driver = DriverDB.getDriverByID(comId);
        if (driver == null) {
            return mapping.findForward(ActionResult.FAILURE);
        }
        Cookie cookie = new Cookie("rcPage", "driver");
        cookie.setMaxAge(60 * 60); //1 hour
        response.addCookie(cookie);
        request.setAttribute("driver", driver);
        return mapping.findForward(ActionResult.SUCCESS);
    }

}
