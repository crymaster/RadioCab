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
public class MembertypeBean {
    private int Mem_ID;
    private String Mem_Name;
    private float Mem_Fee;
    private int Mem_Status;

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
    
    public float getMem_Fee() {
        return Mem_Fee;
    }

    public void setMem_Fee(float Mem_Fee) {
        this.Mem_Fee = Mem_Fee;
    }

    public int getMem_Status() {
        return Mem_Status;
    }

    public void setMem_Status(int Mem_Status) {
        this.Mem_Status = Mem_Status;
    }

    

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (Mem_Status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
    
}
