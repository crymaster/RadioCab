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
    private String Com_uName;
    private String Com_Pass;
    private String Com_Name;
    private String Com_Contactperson;
    private String Com_Designation;
    private String Com_Image;
    private int City_ID;
    private String City_Name;
    private String Com_Address;
    private String Com_Mobile;
    private String Com_Tel;
    private String Com_Fax;
    private String Com_Email;
    private Timestamp Com_RegDate;
    private int Com_Status;
    private int Mem_ID;
    private String Mem_Name;

    public int getCom_ID() {
        return Com_ID;
    }

    public void setCom_ID(int Com_ID) {
        this.Com_ID = Com_ID;
    }

    public String getCom_uName() {
        return Com_uName;
    }

    public void setCom_uName(String Com_uName) {
        this.Com_uName = Com_uName;
    }

    public String getCom_Pass() {
        return Com_Pass;
    }

    public void setCom_Pass(String Com_Pass) {
        this.Com_Pass = Com_Pass;
    }

    public String getCom_Name() {
        return Com_Name;
    }

    public void setCom_Name(String Com_Name) {
        this.Com_Name = Com_Name;
    }

    public String getCom_Contactperson() {
        return Com_Contactperson;
    }

    public void setCom_Contactperson(String Com_Contactperson) {
        this.Com_Contactperson = Com_Contactperson;
    }

    public String getCom_Designation() {
        return Com_Designation;
    }

    public void setCom_Designation(String Com_Designation) {
        this.Com_Designation = Com_Designation;
    }

    public String getCom_Image() {
        return Com_Image;
    }

    public void setCom_Image(String Com_Image) {
        this.Com_Image = Com_Image;
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

    public String getCom_Address() {
        return Com_Address;
    }

    public void setCom_Address(String Com_Address) {
        this.Com_Address = Com_Address;
    }

    public String getCom_Mobile() {
        return Com_Mobile;
    }

    public void setCom_Mobile(String Com_Mobile) {
        this.Com_Mobile = Com_Mobile;
    }

    public String getCom_Tel() {
        return Com_Tel;
    }

    public void setCom_Tel(String Com_Tel) {
        this.Com_Tel = Com_Tel;
    }

    public String getCom_Fax() {
        return Com_Fax;
    }

    public void setCom_Fax(String Com_Fax) {
        this.Com_Fax = Com_Fax;
    }

    public String getCom_Email() {
        return Com_Email;
    }

    public void setCom_Email(String Com_Email) {
        this.Com_Email = Com_Email;
    }

    public Timestamp getCom_RegDate() {
        return Com_RegDate;
    }

    public void setCom_RegDate(Timestamp Com_RegDate) {
        this.Com_RegDate = Com_RegDate;
    }

    public int getCom_Status() {
        return Com_Status;
    }

    public void setCom_Status(int Com_Status) {
        this.Com_Status = Com_Status;
    }

    public int getMem_ID() {
        return Mem_ID;
    }

    public void setMem_ID(int Mem_ID) {
        this.Mem_ID = Mem_ID;
    }

    public String getMem_Name() {
        return Mem_Name;
    }

    public void setMem_Name(String Mem_Name) {
        this.Mem_Name = Mem_Name;
    }
  

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (Com_Status){
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
