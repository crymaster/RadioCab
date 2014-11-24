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
    private int paytype_ID;
    private String paytype_For;
    private String paytype_Name;
    private int paytype_Days;
    private float paytype_Fee;
    private int paytype_Status;

    public int getPaytype_ID() {
        return paytype_ID;
    }

    public void setPaytype_ID(int Paytype_ID) {
        this.paytype_ID = Paytype_ID;
    }

    public String getPaytype_For() {
        return paytype_For;
    }

    public void setPaytype_For(String Paytype_For) {
        this.paytype_For = Paytype_For;
    }

    public String getPaytype_Name() {
        return paytype_Name;
    }

    public void setPaytype_Name(String Paytype_Name) {
        this.paytype_Name = Paytype_Name;
    }

    public int getPaytype_Days() {
        return paytype_Days;
    }

    public void setPaytype_Days(int Paytype_Days) {
        this.paytype_Days = Paytype_Days;
    }

    public float getPaytype_Fee() {
        return paytype_Fee;
    }

    public void setPaytype_Fee(float Paytype_Fee) {
        this.paytype_Fee = Paytype_Fee;
    }

    public int getPaytype_Status() {
        return paytype_Status;
    }

    public void setPaytype_Status(int Paytype_Status) {
        this.paytype_Status = Paytype_Status;
    }


    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (paytype_Status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
}
