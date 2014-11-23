/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import db.ConfigApp;
import java.sql.Date;

/**
 *
 * @author quangphamngoc
 */
public class AdminBean {
    private int Ad_ID;
    private int Role_ID;
    private String Ad_Account;
    private String Ad_Password;
    private String Ad_Phone;
    private String Ad_Email;
    private int Ad_Status;
    private String Ad_Avatar;
    private String Role_Name;

    /**
     * @return the Ad_ID
     */
    public int getAd_ID() {
        return Ad_ID;
    }

    /**
     * @param Ad_ID the Ad_ID to set
     */
    public void setAd_ID(int Ad_ID) {
        this.Ad_ID = Ad_ID;
    }

    /**
     * @return the Role_ID
     */
    public int getRole_ID() {
        return Role_ID;
    }

    /**
     * @param Role_ID the Role_ID to set
     */
    public void setRole_ID(int Role_ID) {
        this.Role_ID = Role_ID;
    }

    /**
     * @return the Ad_Account
     */
    public String getAd_Account() {
        return Ad_Account;
    }

    /**
     * @param Ad_Account the Ad_Account to set
     */
    public void setAd_Account(String Ad_Account) {
        this.Ad_Account = Ad_Account;
    }

    /**
     * @return the Ad_Password
     */
    public String getAd_Password() {
        return Ad_Password;
    }

    /**
     * @param Ad_Password the Ad_Password to set
     */
    public void setAd_Password(String Ad_Password) {
        this.Ad_Password = Ad_Password;
    }

    /**
     * @return the Ad_Phone
     */
    public String getAd_Phone() {
        return Ad_Phone;
    }

    /**
     * @param Ad_Phone the Ad_Phone to set
     */
    public void setAd_Phone(String Ad_Phone) {
        this.Ad_Phone = Ad_Phone;
    }

    /**
     * @return the Ad_Email
     */
    public String getAd_Email() {
        return Ad_Email;
    }

    /**
     * @param Ad_Email the Ad_Email to set
     */
    public void setAd_Email(String Ad_Email) {
        this.Ad_Email = Ad_Email;
    }

    /**
     * @return the Ad_Status
     */
    public int getAd_Status() {
        return Ad_Status;
    }

    /**
     * @param Ad_Status the Ad_Status to set
     */
    public void setAd_Status(int Ad_Status) {
        this.Ad_Status = Ad_Status;
    }


    /**
     * @return the Ad_Avatar
     */
    public String getAd_Avatar() {
        return Ad_Avatar;
    }

    /**
     * @param Ad_Avatar the Ad_Avatar to set
     */
    public void setAd_Avatar(String Ad_Avatar) {
        this.Ad_Avatar = Ad_Avatar;
    }

    /**
     * @return the Role_Name
     */
    public String getRole_Name() {
        return Role_Name;
    }

    /**
     * @param Role_Name the Role_Name to set
     */
    public void setRole_Name(String Role_Name) {
        this.Role_Name = Role_Name;
    }
    
    public String getAd_Status_InString(){
        if(this.Ad_Status == 1){
            return ConfigApp.statusOK;
        }
        return ConfigApp.statusNotOK;
    }
}
