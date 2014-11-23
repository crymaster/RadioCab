/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import db.ConfigApp;

/**
 *
 * @author quangphamngoc
 */
public class PaymenttypeBean {
    private int Paytype_ID;
    private String Paytype_For;
    private String Paytype_Name;
    private int Paytype_Days;
    private float Paytype_Fee;
    private int Paytype_Status;

    public int getPaytype_ID() {
        return Paytype_ID;
    }

    public void setPaytype_ID(int Paytype_ID) {
        this.Paytype_ID = Paytype_ID;
    }

    public String getPaytype_For() {
        return Paytype_For;
    }

    public void setPaytype_For(String Paytype_For) {
        this.Paytype_For = Paytype_For;
    }

    public String getPaytype_Name() {
        return Paytype_Name;
    }

    public void setPaytype_Name(String Paytype_Name) {
        this.Paytype_Name = Paytype_Name;
    }

    public int getPaytype_Days() {
        return Paytype_Days;
    }

    public void setPaytype_Days(int Paytype_Days) {
        this.Paytype_Days = Paytype_Days;
    }

    public float getPaytype_Fee() {
        return Paytype_Fee;
    }

    public void setPaytype_Fee(float Paytype_Fee) {
        this.Paytype_Fee = Paytype_Fee;
    }

    public int getPaytype_Status() {
        return Paytype_Status;
    }

    public void setPaytype_Status(int Paytype_Status) {
        this.Paytype_Status = Paytype_Status;
    }


    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (Paytype_Status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
    
}
