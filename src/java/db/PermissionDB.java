/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.ActionBean;
import beans.AdminBean;
import beans.PermissionBean;
import beans.RoleBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangphamngoc
 */
public class PermissionDB {

    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static CallableStatement cstmt;
    private static ResultSet rs;
    public static int error = 0;

    public static boolean connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            error = 2;
            return false;

        }
        // TODO code application logic here
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:" + ConfigDB.DBPORT + "/" + ConfigDB.DBNAME, ConfigDB.DBUSER, ConfigDB.DBPASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            //Co the do sai ten db
            error = 1;
            e.printStackTrace();
            return false;
        }

        if (con != null) {
            System.out.println("You made it, take control your database now!");
            return true;
        } else {
            System.out.println("Failed to make connection!");
            return false;
        }
    }

    public static void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            error = 1;
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public static List<PermissionBean> getPermissionByRoleID(int rid) {
        List<PermissionBean> list = new ArrayList<PermissionBean>();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `" + ConfigDB.DBNAME + "`.`tblPermission` WHERE rolID = " + rid);
                while (rs.next()) {
                    PermissionBean item = new PermissionBean();
                    item.setPerID(rs.getInt("perID"));
                    item.setRolID(rs.getInt("rolID"));
                    item.setActID(rs.getInt("actID"));
                    item.setPerStatus(rs.getInt("perStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PermissionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static PermissionBean getPermission(int rolID, int actID) {
        PermissionBean item = new PermissionBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `" + ConfigDB.DBNAME + "`.`tblPermission` WHERE rolID = " + rolID + " and actID = "+actID);
                while (rs.next()) {
                    
                    item.setPerID(rs.getInt("perID"));
                    item.setRolID(rs.getInt("rolID"));
                    item.setActID(rs.getInt("actID"));
                    item.setPerStatus(rs.getInt("perStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PermissionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }
    
    public static boolean editPermission(List<PermissionBean> list) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                List<Integer> kq = new ArrayList<Integer>();
                for (PermissionBean item : list) {
                    pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblPermission` SET `perStatus`=? WHERE `perID`=?;");
                    pstmt.setInt(1, item.getPerStatus());
                    pstmt.setInt(2, item.getPerID());
                    int rs = pstmt.executeUpdate();
                    if (rs != 0) {
                        kq.add(rs);
                    }
                }

                if (kq.size() == list.size()) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermissionBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static boolean addPermission(int id) {
//        boolean success = false;
        boolean success = false;
        connect();
        try {
            List<ActionBean> list = ActionDB.getAllAction();
            List<Integer> kq = new ArrayList<Integer>();

            for (ActionBean actionBean : list) {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblPermission` (`rolID`, `actID`) VALUES "
                        + "(?, ?)");
                pstmt.setInt(1, id);
                pstmt.setInt(2, actionBean.getActID());
                int rs = pstmt.executeUpdate();
                if (rs != 0) {
                    kq.add(rs);
                }
            }
            if (kq.size() == list.size()) {
                success = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PermissionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }
    
    public static boolean checkPermission(String rolID, String model, String action){
        boolean result = false;
        PermissionBean item = new PermissionBean();
        if (!connect()){
            return result;
        }
        try {
            Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `" + ConfigDB.DBNAME + "`.`tblPermission` "
                        + " inner join `" + ConfigDB.DBNAME + "`.`tblAction` on `" + ConfigDB.DBNAME + "`.tblPermission.actID = tblAction.actID "
                        + "WHERE rolID = '" + rolID + "' and actModel = '" + model + "' and actAction = '" + action + "'");
                while (rs.next()) {
                    item.setPerStatus(rs.getInt("perStatus"));
                }
                if(item.getPerStatus() != 0){
                    result = true;
                }
        } catch (SQLException ex) {
            Logger.getLogger(PermissionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return result;
    }
}
