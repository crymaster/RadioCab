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
    private int mem_ID;
    private String mem_Name;
    private float mem_Fee;
    private int mem_Status;

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
    
    public float getMem_Fee() {
        return mem_Fee;
    }

    public void setMem_Fee(float mem_Fee) {
        this.mem_Fee = mem_Fee;
    }

    public int getMem_Status() {
        return mem_Status;
    }

    public void setMem_Status(int mem_Status) {
        this.mem_Status = mem_Status;
    }

    

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (mem_Status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
    
}
