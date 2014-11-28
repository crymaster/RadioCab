/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.AdvertiseBean;
import db.AdvertiseDB;
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
public class AdvertiseAction extends Action {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie cookie = new Cookie("rcPage", "advertise");
        cookie.setMaxAge(60 * 60); //1 hour
        response.addCookie(cookie);
        ArrayList<AdvertiseBean> advs = (ArrayList)AdvertiseDB.getAllAvailableAdvertise();
        request.setAttribute("advs", advs);
        return mapping.findForward(ActionResult.SUCCESS); //To change body of generated methods, choose Tools | Templates.
    }

}
