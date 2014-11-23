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
public class CityBean {
    private int City_ID;
    private String City_Name;
    private int City_Status;

    public int getCity_ID() {
        return City_ID;
    }

    public void setCity_ID(int City_ID) {
        this.City_ID = City_ID;
    }

    public String getCity_Name() {
        return City_Name;
    }

    public void setCity_Name(String City_Name) {
        this.City_Name = City_Name;
    }

    public int getCity_Status() {
        return City_Status;
    }

    public void setCity_Status(int City_Status) {
        this.City_Status = City_Status;
    }

    

    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (City_Status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
    
}
