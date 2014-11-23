/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.PaymenttypeBean;
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
public class PaymenttypeDB {

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

    public static List<PaymenttypeBean> getAllPaymenttype() {
        List<PaymenttypeBean> list = new ArrayList<PaymenttypeBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPaymentType");
                while (rs.next()) {
                    PaymenttypeBean item = new PaymenttypeBean();
                    item.setPaytype_ID(rs.getInt("ptID"));
                    item.setPaytype_For(rs.getString("ptFor"));
                    item.setPaytype_Name(rs.getString("ptType"));
                    item.setPaytype_Days(rs.getInt("ptDays"));
                    item.setPaytype_Fee(rs.getFloat("ptFee"));
                    item.setPaytype_Status(rs.getInt("ptStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymenttypeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<PaymenttypeBean> getAllAvailablePaymenttype() {
        List<PaymenttypeBean> list = new ArrayList<PaymenttypeBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPaymentType WHERE ptStatus = 1");
                while (rs.next()) {
                    PaymenttypeBean item = new PaymenttypeBean();
                    item.setPaytype_ID(rs.getInt("ptID"));
                    item.setPaytype_For(rs.getString("ptFor"));
                    item.setPaytype_Name(rs.getString("ptType"));
                    item.setPaytype_Days(rs.getInt("ptDays"));
                    item.setPaytype_Fee(rs.getFloat("ptFee"));
                    item.setPaytype_Status(rs.getInt("ptStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymenttypeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static PaymenttypeBean getPaymenttypeByID(int gr_id) {
        PaymenttypeBean item = new PaymenttypeBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPaymentType WHERE ptID = " + gr_id);
                while (rs.next()) {
                    item.setPaytype_ID(rs.getInt("ptID"));
                    item.setPaytype_For(rs.getString("ptFor"));
                    item.setPaytype_Name(rs.getString("ptType"));
                    item.setPaytype_Days(rs.getInt("ptDays"));
                    item.setPaytype_Fee(rs.getFloat("ptFee"));
                    item.setPaytype_Status(rs.getInt("ptStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymenttypeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean editPaymenttype(PaymenttypeBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblPaymentType` SET `ptFee` = ?, `ptStatus` = ? "
                        + "WHERE `ptID` = ?;");
                pstmt.setFloat(1, item.getPaytype_Fee());
                pstmt.setInt(2, item.getPaytype_Status());
                pstmt.setInt(3, item.getPaytype_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymenttypeBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int addPaymenttype(PaymenttypeBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblPaymentType` (`ptFor`,`ptType`,`ptDays`,`ptFee`) VALUES (?,?,?,?);");
                pstmt.setString(1, item.getPaytype_For());
                pstmt.setString(2, item.getPaytype_Name());
                pstmt.setInt(3, item.getPaytype_Days());
                pstmt.setFloat(4, item.getPaytype_Fee());
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
            Logger.getLogger(PaymenttypeBean.class.getName()).log(Level.SEVERE, null, ex);
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
