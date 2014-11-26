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

    private int pay_ID;
    private int paytype_ID;
    private int adv_ID;
    private int com_ID;
    private int driver_ID;
    private Timestamp pay_Time;
    private Timestamp pay_TimeExpired;
    private float pay_Total;
    private int pay_Status;

    public int getPay_ID() {
        return pay_ID;
    }

    public void setPay_ID(int pay_ID) {
        this.pay_ID = pay_ID;
    }

    public int getPaytype_ID() {
        return paytype_ID;
    }

    public void setPaytype_ID(int paytype_ID) {
        this.paytype_ID = paytype_ID;
    }

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

    public int getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(int driver_ID) {
        this.driver_ID = driver_ID;
    }

    public Timestamp getPay_Time() {
        return pay_Time;
    }

    public void setPay_Time(Timestamp pay_Time) {
        this.pay_Time = pay_Time;
    }

    public Timestamp getPay_TimeExpired() {
        return pay_TimeExpired;
    }

    public void setPay_TimeExpired(Timestamp pay_TimeExpired) {
        this.pay_TimeExpired = pay_TimeExpired;
    }

    public float getPay_Total() {
        return pay_Total;
    }

    public void setPay_Total(float pay_Total) {
        this.pay_Total = pay_Total;
    }

    public int getPay_Status() {
        return pay_Status;
    }

    public void setPay_Status(int pay_Status) {
        this.pay_Status = pay_Status;
    }

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        switch (pay_Status) {
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
