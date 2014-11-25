/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radiocab.in.actionform;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author son
 */
public class RegisterCompanyForm extends org.apache.struts.action.ActionForm {

    private String comUsername;
    private String comPass;
    private String comPassConfirm;
    private String comName;
    private String comContactPerson;
    private String comDesignation;
    private String comAddress;
    private int cityId;
    private String comMobile;
    private String comTel;
    private String comFax;
    private String comEmail;
    private int membershipType;
    private int paymentType;
    private ArrayList cityList;
    private ArrayList membershipTypeList;
    private ArrayList paymentTypeList;

    public String getComUsername() {
        return comUsername;
    }

    public void setComUsername(String comUsername) {
        this.comUsername = comUsername;
    }

    public String getComPass() {
        return comPass;
    }

    public void setComPass(String comPass) {
        this.comPass = comPass;
    }

    public String getComPassConfirm() {
        return comPassConfirm;
    }

    public void setComPassConfirm(String comPassConfirm) {
        this.comPassConfirm = comPassConfirm;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComContactPerson() {
        return comContactPerson;
    }

    public void setComContactPerson(String comContactPerson) {
        this.comContactPerson = comContactPerson;
    }

    public String getComDesignation() {
        return comDesignation;
    }

    public void setComDesignation(String comDesignation) {
        this.comDesignation = comDesignation;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getComMobile() {
        return comMobile;
    }

    public void setComMobile(String comMobile) {
        this.comMobile = comMobile;
    }

    public String getComTel() {
        return comTel;
    }

    public void setComTel(String comTel) {
        this.comTel = comTel;
    }

    public String getComFax() {
        return comFax;
    }

    public void setComFax(String comFax) {
        this.comFax = comFax;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public int getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(int membershipType) {
        this.membershipType = membershipType;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public ArrayList getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList cityList) {
        this.cityList = cityList;
    }

    public ArrayList getMembershipTypeList() {
        return membershipTypeList;
    }

    public void setMembershipTypeList(ArrayList membershipTypeList) {
        this.membershipTypeList = membershipTypeList;
    }

    public ArrayList getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(ArrayList paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    /**
     *
     */
    public RegisterCompanyForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
