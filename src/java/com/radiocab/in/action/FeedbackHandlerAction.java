/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.action;

import beans.CityBean;
import beans.FeedbackBean;
import com.radiocab.in.actionform.FeedbackForm;
import db.CityDB;
import db.FeedbackDB;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.ActionResult;
import utils.EmailValidator;
import utils.PhoneNumberValidator;

/**
 *
 * @author son
 */
public class FeedbackHandlerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        FeedbackForm fbForm = (FeedbackForm) form;
        ArrayList errors = new ArrayList();
        if(fbForm.getName()== null || fbForm.getName().trim().equals("")){
            errors.add("error.fbName.required");
        }
        if(fbForm.getDescription()== null || fbForm.getDescription().trim().equals("")){
            errors.add("error.fbDescription.required");
        }
        if(!PhoneNumberValidator.validate(fbForm.getMobile())){
                errors.add("error.mobile.wrongformat");
        }
        if(!fbForm.getEmail().equals("")){
            if(!EmailValidator.validate(fbForm.getEmail()))
                errors.add("error.email.wrongformat");
        }
        if(errors.size()>0){
            request.setAttribute("errors", errors);
            return mapping.findForward(ActionResult.FAILURE);
        }
        FeedbackBean fb = new FeedbackBean();
        fb.setFbName(fbForm.getName());
        fb.setFbType(fbForm.getType());
        fb.setFbMobile(fbForm.getMobile());
        fb.setFbEmail(fbForm.getEmail());
        fb.setFbDescription(fbForm.getDescription());
        int id = FeedbackDB.addFeedback(fb);
        if (id == -1) {
            ArrayList<CityBean> cityList = (ArrayList<CityBean>) CityDB.getAllAvailableCity();
            fbForm.setCityList(cityList);
            return mapping.findForward(ActionResult.FAILURE);
        }
        ArrayList<CityBean> cityList = (ArrayList<CityBean>) CityDB.getAllAvailableCity();
        fbForm.setCityList(cityList);
        return mapping.findForward(ActionResult.SUCCESS);
    }
}