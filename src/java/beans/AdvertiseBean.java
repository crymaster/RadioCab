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
public class AdvertiseBean {

    private int adv_ID;
    private int com_ID;
    private String Com_Name;
    private String adv_Image;
    private Timestamp adv_Regdate;
    private String adv_Description;
    private int adv_Status;

    public int getAdv_ID() {
        return adv_ID;
    }

    public void setAdv_ID(int adv_ID) {
        this.adv_ID = adv_ID;
    }

    public int getCom_ID() {
        return com_ID;
    }

    public void setCom_ID(int com_ID) {
        this.com_ID = com_ID;
    }

    public String getCom_Name() {
        return Com_Name;
    }

    public void setCom_Name(String Com_Name) {
        this.Com_Name = Com_Name;
    }

    public String getAdv_Image() {
        return adv_Image;
    }

    public void setAdv_Image(String adv_Image) {
        this.adv_Image = adv_Image;
    }

    public Timestamp getAdv_Regdate() {
        return adv_Regdate;
    }

    public void setAdv_Regdate(Timestamp adv_Regdate) {
        this.adv_Regdate = adv_Regdate;
    }

    public String getAdv_Description() {
        return adv_Description;
    }

    public void setAdv_Description(String adv_Description) {
        this.adv_Description = adv_Description;
    }

    public int getAdv_Status() {
        return adv_Status;
    }

    public void setAdv_Status(int adv_Status) {
        this.adv_Status = adv_Status;
    }

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (adv_Status) {
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
