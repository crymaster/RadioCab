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
public class CompanyBean {

    private int Com_ID;
    private String com_uName;
    private String com_Pass;
    private String com_Name;
    private String com_Contactperson;
    private String com_Designation;
    private String com_Image;
    private int city_ID;
    private String city_Name;
    private String com_Address;
    private String com_Mobile;
    private String com_Tel;
    private String com_Fax;
    private String com_Email;
    private Timestamp com_RegDate;
    private int com_Status;
    private int mem_ID;
    private String mem_Name;

    public int getCom_ID() {
        return Com_ID;
    }

    public void setCom_ID(int Com_ID) {
        this.Com_ID = Com_ID;
    }

    public String getCom_uName() {
        return com_uName;
    }

    public void setCom_uName(String com_uName) {
        this.com_uName = com_uName;
    }

    public String getCom_Pass() {
        return com_Pass;
    }

    public void setCom_Pass(String com_Pass) {
        this.com_Pass = com_Pass;
    }

    public String getCom_Name() {
        return com_Name;
    }

    public void setCom_Name(String com_Name) {
        this.com_Name = com_Name;
    }

    public String getCom_Contactperson() {
        return com_Contactperson;
    }

    public void setCom_Contactperson(String com_Contactperson) {
        this.com_Contactperson = com_Contactperson;
    }

    public String getCom_Designation() {
        return com_Designation;
    }

    public void setCom_Designation(String com_Designation) {
        this.com_Designation = com_Designation;
    }

    public String getCom_Image() {
        return com_Image;
    }

    public void setCom_Image(String com_Image) {
        this.com_Image = com_Image;
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

    public String getCom_Address() {
        return com_Address;
    }

    public void setCom_Address(String com_Address) {
        this.com_Address = com_Address;
    }

    public String getCom_Mobile() {
        return com_Mobile;
    }

    public void setCom_Mobile(String com_Mobile) {
        this.com_Mobile = com_Mobile;
    }

    public String getCom_Tel() {
        return com_Tel;
    }

    public void setCom_Tel(String com_Tel) {
        this.com_Tel = com_Tel;
    }

    public String getCom_Fax() {
        return com_Fax;
    }

    public void setCom_Fax(String com_Fax) {
        this.com_Fax = com_Fax;
    }

    public String getCom_Email() {
        return com_Email;
    }

    public void setCom_Email(String com_Email) {
        this.com_Email = com_Email;
    }

    public Timestamp getCom_RegDate() {
        return com_RegDate;
    }

    public void setCom_RegDate(Timestamp com_RegDate) {
        this.com_RegDate = com_RegDate;
    }

    public int getCom_Status() {
        return com_Status;
    }

    public void setCom_Status(int com_Status) {
        this.com_Status = com_Status;
    }

    public int getMem_ID() {
        return mem_ID;
    }

    public void setMem_ID(int mem_ID) {
        this.mem_ID = mem_ID;
    }

    public String getMem_Name() {
        return mem_Name;
    }

    public void setMem_Name(String mem_Name) {
        this.mem_Name = mem_Name;
    }

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (com_Status) {
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
