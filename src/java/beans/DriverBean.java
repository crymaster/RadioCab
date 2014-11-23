/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import db.ConfigApp;
import java.sql.Timestamp;

/**
 *
 * @author quangphamngoc
 */
public class DriverBean {
    private int Driver_ID;
    private String Driver_uName;
    private String Driver_Pass;
    private String Driver_Name;
    private String Driver_Contactperson;
    private int City_ID;
    private String City_Name;
    private String Driver_Address;
    private String Driver_Image;
    private String Driver_Mobile;
    private String Driver_Tel;
    private String Driver_Email;
    private String Driver_Exp;
    private String Driver_Description;
    private Timestamp Driver_RegDate;
    private int Driver_Status;

    public int getDriver_ID() {
        return Driver_ID;
    }

    public void setDriver_ID(int Driver_ID) {
        this.Driver_ID = Driver_ID;
    }

    public String getDriver_uName() {
        return Driver_uName;
    }

    public void setDriver_uName(String Driver_uName) {
        this.Driver_uName = Driver_uName;
    }

    public String getDriver_Pass() {
        return Driver_Pass;
    }

    public void setDriver_Pass(String Driver_Pass) {
        this.Driver_Pass = Driver_Pass;
    }

    public String getDriver_Name() {
        return Driver_Name;
    }

    public void setDriver_Name(String Driver_Name) {
        this.Driver_Name = Driver_Name;
    }

    public String getDriver_Contactperson() {
        return Driver_Contactperson;
    }

    public void setDriver_Contactperson(String Driver_Contactperson) {
        this.Driver_Contactperson = Driver_Contactperson;
    }

    public int getCity_ID() {
        return City_ID;
    }

    public void setCity_ID(int City_ID) {
        this.City_ID = City_ID;
    }
    
    public String getCity_Name() {
        return City_Name;
    }

    public void setCity_Name(String City_Name) {
        this.City_Name = City_Name;
    }
    public String getDriver_Address() {
        return Driver_Address;
    }

    public void setDriver_Address(String Driver_Address) {
        this.Driver_Address = Driver_Address;
    }

    public String getDriver_Image() {
        return Driver_Image;
    }

    public void setDriver_Image(String Driver_Image) {
        this.Driver_Image = Driver_Image;
    }

    
    public String getDriver_Mobile() {
        return Driver_Mobile;
    }

    public void setDriver_Mobile(String Driver_Mobile) {
        this.Driver_Mobile = Driver_Mobile;
    }

    public String getDriver_Tel() {
        return Driver_Tel;
    }

    public void setDriver_Tel(String Driver_Tel) {
        this.Driver_Tel = Driver_Tel;
    }

    public String getDriver_Email() {
        return Driver_Email;
    }

    public void setDriver_Email(String Driver_Email) {
        this.Driver_Email = Driver_Email;
    }

    public String getDriver_Exp() {
        return Driver_Exp;
    }

    public void setDriver_Exp(String Driver_Exp) {
        this.Driver_Exp = Driver_Exp;
    }

    public String getDriver_Description() {
        return Driver_Description;
    }

    public void setDriver_Description(String Driver_Description) {
        this.Driver_Description = Driver_Description;
    }

    public Timestamp getDriver_RegDate() {
        return Driver_RegDate;
    }

    public void setDriver_RegDate(Timestamp Driver_RegDate) {
        this.Driver_RegDate = Driver_RegDate;
    }

    public int getDriver_Status() {
        return Driver_Status;
    }

    public void setDriver_Status(int Driver_Status) {
        this.Driver_Status = Driver_Status;
    }


    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (Driver_Status){
            case 1:
                return ConfigApp.statusOK;
            case 0:
                return ConfigApp.statusNotOK;
            case 2:
                return ConfigApp.statusNotActive;
        }
        return "";
    }
    
    
}
