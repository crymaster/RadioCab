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

    private int driver_ID;
    private String driver_uName;
    private String driver_Pass;
    private String driver_Name;
    private String driver_Contactperson;
    private int city_ID;
    private String city_Name;
    private String driver_Address;
    private String driver_Image;
    private String driver_Mobile;
    private String driver_Tel;
    private String driver_Email;
    private String driver_Exp;
    private String driver_Description;
    private Timestamp driver_RegDate;
    private int driver_Status;

    public int getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(int driver_ID) {
        this.driver_ID = driver_ID;
    }

    public String getDriver_uName() {
        return driver_uName;
    }

    public void setDriver_uName(String driver_uName) {
        this.driver_uName = driver_uName;
    }

    public String getDriver_Pass() {
        return driver_Pass;
    }

    public void setDriver_Pass(String driver_Pass) {
        this.driver_Pass = driver_Pass;
    }

    public String getDriver_Name() {
        return driver_Name;
    }

    public void setDriver_Name(String driver_Name) {
        this.driver_Name = driver_Name;
    }

    public String getDriver_Contactperson() {
        return driver_Contactperson;
    }

    public void setDriver_Contactperson(String driver_Contactperson) {
        this.driver_Contactperson = driver_Contactperson;
    }

    public int getCity_ID() {
        return city_ID;
    }

    public void setCity_ID(int city_ID) {
        this.city_ID = city_ID;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public String getDriver_Address() {
        return driver_Address;
    }

    public void setDriver_Address(String driver_Address) {
        this.driver_Address = driver_Address;
    }

    public String getDriver_Image() {
        return driver_Image;
    }

    public void setDriver_Image(String driver_Image) {
        this.driver_Image = driver_Image;
    }

    public String getDriver_Mobile() {
        return driver_Mobile;
    }

    public void setDriver_Mobile(String driver_Mobile) {
        this.driver_Mobile = driver_Mobile;
    }

    public String getDriver_Tel() {
        return driver_Tel;
    }

    public void setDriver_Tel(String driver_Tel) {
        this.driver_Tel = driver_Tel;
    }

    public String getDriver_Email() {
        return driver_Email;
    }

    public void setDriver_Email(String driver_Email) {
        this.driver_Email = driver_Email;
    }

    public String getDriver_Exp() {
        return driver_Exp;
    }

    public void setDriver_Exp(String driver_Exp) {
        this.driver_Exp = driver_Exp;
    }

    public String getDriver_Description() {
        return driver_Description;
    }

    public void setDriver_Description(String driver_Description) {
        this.driver_Description = driver_Description;
    }

    public Timestamp getDriver_RegDate() {
        return driver_RegDate;
    }

    public void setDriver_RegDate(Timestamp driver_RegDate) {
        this.driver_RegDate = driver_RegDate;
    }

    public int getDriver_Status() {
        return driver_Status;
    }

    public void setDriver_Status(int driver_Status) {
        this.driver_Status = driver_Status;
    }

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (driver_Status) {
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
