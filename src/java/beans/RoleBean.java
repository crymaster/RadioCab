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
public class RoleBean {
    private int Role_ID;
    private String Role_Name;
    private int Role_status;

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int Role_ID) {
        this.Role_ID = Role_ID;
    }

    public String getRole_Name() {
        return Role_Name;
    }

    public void setRole_Name(String Role_Name) {
        this.Role_Name = Role_Name;
    }

    public int getRole_status() {
        return Role_status;
    }

    public void setRole_status(int Role_status) {
        this.Role_status = Role_status;
    }
    

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (Role_status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
    
}
