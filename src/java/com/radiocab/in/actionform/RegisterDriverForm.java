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
public class RegisterDriverForm extends ActionForm {

    private String drvUsername;
    private String drvPass;
    private String drvPassConfirm;
    private String drvName;
    private String drvContactPerson;
    private int cityId;
    private String drvAddress;
    private String drvMobile;
    private String drvTel;
    private String drvEmail;
    private FormFile image;
    private String drvExp;
    private String drvDescription;
    private int paymentType;
    private ArrayList cityList;
    private ArrayList paymentTypeList;

    public String getDrvUsername() {
        return drvUsername;
    }

    public void setDrvUsername(String drvUsername) {
        this.drvUsername = drvUsername;
    }

    public String getDrvPass() {
        return drvPass;
    }

    public void setDrvPass(String drvPass) {
        this.drvPass = drvPass;
    }

    public String getDrvPassConfirm() {
        return drvPassConfirm;
    }

    public void setDrvPassConfirm(String drvPassConfirm) {
        this.drvPassConfirm = drvPassConfirm;
    }

    public String getDrvName() {
        return drvName;
    }

    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    public String getDrvContactPerson() {
        return drvContactPerson;
    }

    public void setDrvContactPerson(String drvContactPerson) {
        this.drvContactPerson = drvContactPerson;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getDrvAddress() {
        return drvAddress;
    }

    public void setDrvAddress(String drvAddress) {
        this.drvAddress = drvAddress;
    }

    public String getDrvMobile() {
        return drvMobile;
    }

    public void setDrvMobile(String drvMobile) {
        this.drvMobile = drvMobile;
    }

    public String getDrvTel() {
        return drvTel;
    }

    public void setDrvTel(String drvTel) {
        this.drvTel = drvTel;
    }

    public String getDrvEmail() {
        return drvEmail;
    }

    public void setDrvEmail(String drvEmail) {
        this.drvEmail = drvEmail;
    }

    public FormFile getImage() {
        return image;
    }

    public void setImage(FormFile image) {
        this.image = image;
    }

    public String getDrvExp() {
        return drvExp;
    }

    public void setDrvExp(String drvExp) {
        this.drvExp = drvExp;
    }

    public String getDrvDescription() {
        return drvDescription;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public void setDrvDescription(String drvDescription) {
        this.drvDescription = drvDescription;
    }

    public ArrayList getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList cityList) {
        this.cityList = cityList;
    }

    public ArrayList getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(ArrayList paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        return super.validate(mapping, request); //To change body of generated methods, choose Tools | Templates.
    }
}
