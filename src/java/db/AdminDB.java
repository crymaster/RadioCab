/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.AdminBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangphamngoc
 */
public class AdminDB {

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

    public static boolean changeAvatar(String fileName, int Ad_ID) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `"+ConfigDB.DBNAME+"`.`tblAdmin` SET `admAvartar`=? WHERE `admID`=?;");
                pstmt.setString(1, fileName);
                pstmt.setInt(2, Ad_ID);

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int changePassword(String oldPassword, String newPassword, int Ad_ID) {
        /*
         0: Connect SQL Error
         1: Wrong old password
         2: Update new password error
         3: success
         */
        int success = -1;
        try {
            if (!connect()) {
                success = 0;
            } else {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM tblAdmin WHERE admID = '" + Ad_ID + "' AND admPass = '" + oldPassword + "'");
                if (rs.next()) {
                    pstmt = con.prepareStatement("UPDATE `"+ConfigDB.DBNAME+"`.`tblAdmin` SET `admPass`=? WHERE `admID`=?;");
                    pstmt.setString(1, newPassword);
                    pstmt.setInt(2, Ad_ID);

                    int kq = pstmt.executeUpdate();
                    if (kq != 0) {
                        success = 3;
                    } else{
                        success = 2;
                    }
                } else {
                    success = 1;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
            success = 0;
        } finally {
            disconnect();
        }
        return success;
    }

    public static AdminBean getAdminByID(int id) {
        AdminBean item = new AdminBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM " + ConfigDB.AdminTable + " INNER JOIN " + ConfigDB.RoleTable + " ON " + ConfigDB.AdminTable + "." + ConfigDB.RoleIDColumn + "=" + ConfigDB.RoleTable + "." + ConfigDB.RoleIDColumn + " WHERE admID = " + id;
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    item.setAd_ID(rs.getInt("admID"));
                    item.setRole_ID(rs.getInt("rolID"));
                    item.setAd_Account(rs.getString("admUsername"));
                    item.setAd_Password(rs.getString("admPass"));
                    item.setAd_Avatar(rs.getString("admAvartar"));
                    item.setAd_Phone(rs.getString("admTel"));
                    item.setAd_Email(rs.getString("admEmail"));
                    item.setAd_Status(rs.getInt("admStatus"));
                    item.setRole_Name(rs.getString("rolName"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return item;
    }
    
    
    public static List<AdminBean> getAllAdmins() {
        List<AdminBean> list = new ArrayList<AdminBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + ConfigDB.AdminTable + " INNER JOIN " + ConfigDB.RoleTable + " ON " + ConfigDB.AdminTable + "." + ConfigDB.RoleIDColumn + "=" + ConfigDB.RoleTable + "." + ConfigDB.RoleIDColumn);
                while (rs.next()) {
                    AdminBean item = new AdminBean();
                    item.setAd_ID(rs.getInt("admID"));
                    item.setRole_ID(rs.getInt("rolID"));
                    item.setAd_Account(rs.getString("admUsername"));
                    item.setAd_Password(rs.getString("admPass"));
                    item.setAd_Avatar(rs.getString("admAvartar"));
                    item.setAd_Phone(rs.getString("admTel"));
                    item.setAd_Email(rs.getString("admEmail"));
                    item.setAd_Status(rs.getInt("admStatus"));
                    item.setRole_Name(rs.getString("rolName"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return list;
    }
    
     public static boolean editAdmin(AdminBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `"+ConfigDB.DBNAME+"`.`tblAdmin` SET `rolID`= ?, "
                        + "`admEmail`= ?, `admTel`= ?, `admStatus`= ? "
                        + "WHERE `admID`= ?;");
                System.out.println(pstmt.getParameterMetaData());
                pstmt.setInt(1, item.getRole_ID());
                pstmt.setString(2, item.getAd_Email());
                pstmt.setString(3, item.getAd_Phone());
                pstmt.setInt(4, item.getAd_Status());
                pstmt.setInt(5, item.getAd_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    System.out.println("Successfully Edit Admin");
                    success = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }
     
     public static int addAdmin(AdminBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `"+ConfigDB.DBNAME+"`.`tblAdmin` (`rolID`, `admUsername`, `admPass`, `admEmail`, `admTel`) VALUES "
                        + "(?, ?, ?, ?, ?)");
                pstmt.setInt(1, item.getRole_ID());
                pstmt.setString(2, item.getAd_Account());
                pstmt.setString(3, item.getAd_Password());
                pstmt.setString(4, item.getAd_Email());
                pstmt.setString(5, item.getAd_Phone());
                
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
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return lastid;
    }
}
