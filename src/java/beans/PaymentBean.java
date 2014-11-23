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
public class PaymentBean {

    private int Pay_ID;
    private int Paytype_ID;
    private int Adv_ID;
    private int Com_ID;
    private int Driver_ID;
    private Timestamp Pay_Time;
    private Timestamp Pay_TimeExpired;
    private float Pay_Total;
    private int Pay_Status;

    public int getCom_ID() {
        return Com_ID;
    }

    public void setCom_ID(int Com_ID) {
        this.Com_ID = Com_ID;
    }

    public int getPay_ID() {
        return Pay_ID;
    }

    public void setPay_ID(int Pay_ID) {
        this.Pay_ID = Pay_ID;
    }

    public int getPaytype_ID() {
        return Paytype_ID;
    }

    public void setPaytype_ID(int Paytype_ID) {
        this.Paytype_ID = Paytype_ID;
    }

    public int getAdv_ID() {
        return Adv_ID;
    }

    public void setAdv_ID(int Adv_ID) {
        this.Adv_ID = Adv_ID;
    }

    public int getDriver_ID() {
        return Driver_ID;
    }

    public void setDriver_ID(int Driver_ID) {
        this.Driver_ID = Driver_ID;
    }

    public Timestamp getPay_Time() {
        return Pay_Time;
    }

    public void setPay_Time(Timestamp Pay_Time) {
        this.Pay_Time = Pay_Time;
    }

    public Timestamp getPay_TimeExpired() {
        return Pay_TimeExpired;
    }

    public void setPay_TimeExpired(Timestamp Pay_TimeExpired) {
        this.Pay_TimeExpired = Pay_TimeExpired;
    }

    public float getPay_Total() {
        return Pay_Total;
    }

    public void setPay_Total(float Pay_Total) {
        this.Pay_Total = Pay_Total;
    }

    public int getPay_Status() {
        return Pay_Status;
    }

    public void setPay_Status(int Pay_Status) {
        this.Pay_Status = Pay_Status;
    }

    
    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (Pay_Status) {
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
