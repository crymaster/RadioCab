/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
public class RoleDB {

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

    public static List<RoleBean> getAllRole() {
        List<RoleBean> list = new ArrayList<RoleBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblRole");
                while (rs.next()) {
                    RoleBean item = new RoleBean();
                    item.setRole_ID(rs.getInt("rolID"));
                    item.setRole_Name(rs.getString("rolName"));
                    item.setRole_status(rs.getInt("rolStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<RoleBean> getAllAvailableRole() {
        List<RoleBean> list = new ArrayList<RoleBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblRole WHERE rolStatus = 1 and rolName not like '%Super Admin%' ");
                while (rs.next()) {
                    RoleBean item = new RoleBean();
                    item.setRole_ID(rs.getInt("rolID"));
                    item.setRole_Name(rs.getString("rolName"));
                    item.setRole_status(rs.getInt("rolStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static RoleBean getRoleByID(int gr_id) {
        RoleBean item = new RoleBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblRole WHERE rolID = " + gr_id);
                while (rs.next()) {
                    item.setRole_ID(rs.getInt("rolID"));
                    item.setRole_Name(rs.getString("rolName"));
                    item.setRole_status(rs.getInt("rolStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean editRole(RoleBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblRole` SET `rolStatus` = ? WHERE `rolID` = ?;");

                pstmt.setInt(1, item.getRole_status());
                pstmt.setInt(2, item.getRole_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int addRole(RoleBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblRole` (`rolName`) VALUES (?);");
                pstmt.setString(1, item.getRole_Name());
                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    pstmt = con.prepareStatement("SELECT LAST_INSERT_ID()");
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        lastid = rs.getInt("last_insert_id()");
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        PermissionDB.addPermission(lastid);
        return lastid;
    }

//    public static int countTotalGroup(){
//        int count = 0;
//        try {
//            if (!connect()) {
//                
//            } else {
//                stmt = con.createStatement();
//                rs = stmt.executeQuery("SELECT COUNT(*) as Total FROM Groups");
//                if (rs.next()) {
//                    count = rs.getInt("Total");
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, null, ex);
//            
//        } finally {
//            disconnect();
//        }
//        return count;
//    }
}
