/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CityBean;
import com.radiocab.in.actionform.SearchCompanyForm;
import db.CityDB;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;

/**
 *
 * @author Son
 */
public class CompanyAction extends org.apache.struts.action.Action {

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Cookie cookie = new Cookie("rcPage", "company");
        cookie.setMaxAge(60 * 60); //1 hour
        response.addCookie(cookie);
        SearchCompanyForm searchForm = (SearchCompanyForm) form;
        ArrayList<CityBean> cities = (ArrayList) CityDB.getAllAvailableCity();
        CityBean allCity = new CityBean();
        allCity.setCity_ID(0);
        allCity.setCity_Name("Whole country");
        cities.add(allCity);
        searchForm.setCityList(cities);
        return mapping.findForward(ActionResult.SUCCESS);
    }
}
