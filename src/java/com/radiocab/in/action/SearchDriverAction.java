/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CityBean;
import beans.DriverBean;
import com.radiocab.in.actionform.SearchDriverForm;
import db.CityDB;
import db.DriverDB;
import java.util.ArrayList;
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
public class SearchDriverAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
      SearchDriverForm searchForm = (SearchDriverForm) form;
        ArrayList<CityBean> cities = (ArrayList) CityDB.getAllAvailableCity();
        CityBean allCity = new CityBean();
        allCity.setCity_ID(0);
        allCity.setCity_Name("Whole country");
        cities.add(allCity);
        searchForm.setCityList(cities);
        ArrayList<DriverBean> drivers = (ArrayList)DriverDB.search(searchForm.getDrvName().toLowerCase().trim(), searchForm.getCityId());
        request.setAttribute("drivers", drivers);
        return mapping.findForward(ActionResult.SUCCESS);
    }
    
}
