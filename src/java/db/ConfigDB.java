/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

/**
 *
 * @author quangphamngoc
 */
public class ConfigDB {
    public static final String DBUSER = "root";
    public static final String DBPASS = "";
    public static final String DBNAME = "radiocabs";
    public static final String DBPORT = "3306";
    public static final Boolean DEBUG_MODE = true;
    
    
    //Config Table For Admin Loin
    public static final String AdminTable = "tblAdmin";
    public static final String AdminNameColumn = "admUsername";
    public static final String AdminPassColumn = "admPass";                 
    public static final String RoleTable = "tblRole";
    public static final String RoleIDColumn = "rolID";
}
