/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.actionform;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author son
 */
public class OrderAdvertiseForm extends ActionForm {

    private String advDescription;
    private FormFile image;
    private int paymentType;
    private ArrayList paymentTypeList;

    public String getAdvDescription() {
        return advDescription;
    }

    public void setAdvDescription(String advDescription) {
        this.advDescription = advDescription;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public ArrayList getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(ArrayList paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public FormFile getImage() {
        return image;
    }

    public void setImage(FormFile image) {
        this.image = image;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        return super.validate(mapping, request); //To change body of generated methods, choose Tools | Templates.
    }
}
