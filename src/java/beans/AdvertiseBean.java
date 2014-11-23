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
    private int Adv_ID;
    private int Com_ID;
    private String Com_Name;
    private String Adv_Image;
    private Timestamp Adv_Regdate;
    private String Adv_Description;
    private int Adv_Status;
  

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (Adv_Status){
            case 1:
                return ConfigApp.statusOK;
            case 0:
                return ConfigApp.statusNotOK;
            case 2:
                return ConfigApp.statusNotActive;
        }
        return "";
    }

    public int getAdv_ID() {
        return Adv_ID;
    }

    public void setAdv_ID(int Adv_ID) {
        this.Adv_ID = Adv_ID;
    }

    public int getCom_ID() {
        return Com_ID;
    }

    public void setCom_ID(int Com_ID) {
        this.Com_ID = Com_ID;
    }

    public String getCom_Name() {
        return Com_Name;
    }

    public void setCom_Name(String Com_Name) {
        this.Com_Name = Com_Name;
    }

    public String getAdv_Image() {
        return Adv_Image;
    }

    public void setAdv_Image(String Adv_Image) {
        this.Adv_Image = Adv_Image;
    }

    public Timestamp getAdv_Regdate() {
        return Adv_Regdate;
    }

    public void setAdv_Regdate(Timestamp Adv_Regdate) {
        this.Adv_Regdate = Adv_Regdate;
    }

    public String getAdv_Description() {
        return Adv_Description;
    }

    public void setAdv_Description(String Adv_Description) {
        this.Adv_Description = Adv_Description;
    }

    public int getAdv_Status() {
        return Adv_Status;
    }

    public void setAdv_Status(int Adv_Status) {
        this.Adv_Status = Adv_Status;
    }
    
    
}
