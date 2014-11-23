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
public class PermissionBean {
    private int perID;
    private int rolID;
    private int actID;
    private int perStatus;

    public int getPerID() {
        return perID;
    }

    public void setPerID(int perID) {
        this.perID = perID;
    }

    public int getRolID() {
        return rolID;
    }

    public void setRolID(int rolID) {
        this.rolID = rolID;
    }

    public int getActID() {
        return actID;
    }

    public void setActID(int actID) {
        this.actID = actID;
    }

    public int getPerStatus() {
        return perStatus;
    }

    public void setPerStatus(int perStatus) {
        this.perStatus = perStatus;
    }

    public String getStatusInString(){
        if(perStatus == 1){
            return ConfigApp.statusOK;
        }
        return ConfigApp.statusNotOK;
    }
    
}
