/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.AdvertiseBean;
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
public class AdvertiseDB {

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

    public static List<AdvertiseBean> getAllAdvertise() {
        List<AdvertiseBean> list = new ArrayList<AdvertiseBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblAdvertise "
                        + "inner join tblCompany on tblAdvertise.comID = tblCompany.comID");
                while (rs.next()) {
                    AdvertiseBean item = new AdvertiseBean();
                    item.setAdv_ID(rs.getInt("advID"));
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setAdv_Image(rs.getString("advImageURL"));
                    item.setAdv_Regdate(rs.getTimestamp("advRegDate"));
                    item.setAdv_Description(rs.getString("advDescription"));
                    item.setAdv_Status(rs.getInt("advStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<AdvertiseBean> getAllAvailableAdvertise() {
        List<AdvertiseBean> list = new ArrayList<AdvertiseBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblAdvertise "
                        + "inner join tblCompany on tblAdvertise.comID = tblCompany.comID "
                        + "WHERE advStatus = 1");
                while (rs.next()) {
                    AdvertiseBean item = new AdvertiseBean();
                    item.setAdv_ID(rs.getInt("advID"));
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setAdv_Image(rs.getString("advImageURL"));
                    item.setAdv_Regdate(rs.getTimestamp("advRegDate"));
                    item.setAdv_Description(rs.getString("advDescription"));
                    item.setAdv_Status(rs.getInt("advStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static AdvertiseBean getAdvertiseByID(int gr_id) {
        AdvertiseBean item = new AdvertiseBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblAdvertise "
                        + "inner join tblCompany on tblAdvertise.comID = tblCompany.comID "
                        + "WHERE advID = " + gr_id);
                while (rs.next()) {
                    item.setAdv_ID(rs.getInt("advID"));
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setAdv_Image(rs.getString("advImageURL"));
                    item.setAdv_Regdate(rs.getTimestamp("advRegDate"));
                    item.setAdv_Description(rs.getString("advDescription"));
                    item.setAdv_Status(rs.getInt("advStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean editAdvertise(AdvertiseBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblAdvertise` SET `advImageURL` = ?, "
                        + "`advDescription` = ?, `advStatus` = ? "
                        + "WHERE `advID` = ?");

                pstmt.setString(1,item.getAdv_Image());
                pstmt.setString(2,item.getAdv_Description());
                pstmt.setInt(3,item.getAdv_Status());
                pstmt.setInt(4,item.getAdv_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdvertiseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int addAdvertise(AdvertiseBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblAdvertise` (`comID`, "
                        + "`advImageURL`, `advDescription`) "
                        + "VALUES (?,?,?);");
                pstmt.setInt(1,item.getCom_ID());
                pstmt.setString(2,item.getAdv_Image());
                pstmt.setString(3,item.getAdv_Description());
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
            Logger.getLogger(AdvertiseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
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
