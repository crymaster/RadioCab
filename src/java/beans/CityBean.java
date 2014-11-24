/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import db.ConfigApp;
import java.io.Serializable;

/**
 *
 * @author quangphamngoc
 */
public class CityBean implements Serializable{
    private int city_ID;
    private String city_Name;
    private int city_Status;

    public CityBean() {
    }

    public int getCity_ID() {
        return city_ID;
    }

    public void setCity_ID(int City_ID) {
        this.city_ID = City_ID;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String City_Name) {
        this.city_Name = City_Name;
    }

    public int getCity_Status() {
        return city_Status;
    }

    public void setCity_Status(int City_Status) {
        this.city_Status = City_Status;
    }

    
    
    /**
     * @return the statusAsString
     */
    public String getStatusAsString() {
        //Tuy thuoc vao gia tri cua status
        //Dung string luu trong class ConfigApp
        if (city_Status==1){
            return ConfigApp.statusOK;
        } else{
            return ConfigApp.statusNotOK;
        }
    }
    
    
}
