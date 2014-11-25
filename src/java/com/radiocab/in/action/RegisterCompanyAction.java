/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CityBean;
import beans.MembertypeBean;
import beans.PaymenttypeBean;
import com.radiocab.in.actionform.RegisterCompanyForm;
import db.CityDB;
import db.MembertypeDB;
import db.PaymenttypeDB;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;
import static utils.ActionResult.SUCCESS;

/**
 *
 * @author son
 */
public class RegisterCompanyAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RegisterCompanyForm regForm = (RegisterCompanyForm) form;
        ArrayList<CityBean> cities = (ArrayList) CityDB.getAllAvailableCity();
        ArrayList<MembertypeBean> members = (ArrayList) MembertypeDB.getAllAvailableMembertype();
        ArrayList<PaymenttypeBean> payments = (ArrayList) PaymenttypeDB.getPaymentTypeByPtFor("Company");
        regForm.setCityList(cities);
        regForm.setMembershipTypeList(members);
        regForm.setPaymentTypeList(payments);
        return mapping.findForward(ActionResult.SUCCESS);
    }
}
