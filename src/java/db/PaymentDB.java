/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.PaymentBean;
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
public class PaymentDB {

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

    public static List<PaymentBean> getAllDriverPayment() {
        List<PaymentBean> list = new ArrayList<PaymentBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPayment");
                while (rs.next()) {
                    PaymentBean item = new PaymentBean();
                    item.setPay_ID(rs.getInt("payID"));
                    item.setPaytype_ID(rs.getInt("ptID"));
                    if (String.valueOf(rs.getInt("comID")).length() > 0) {
                        item.setCom_ID(rs.getInt("comID"));
                    }
                    if (String.valueOf(rs.getInt("advID")).length() > 0) {
                        item.setCom_ID(rs.getInt("advID"));
                    }
                    if (String.valueOf(rs.getInt("drvID")).length() > 0) {
                        item.setCom_ID(rs.getInt("drvID"));
                    }
                    item.setPay_Time(rs.getTimestamp("payTime"));
                    item.setPay_TimeExpired(rs.getTimestamp("payTimeExpired"));
                    item.setPay_Total(rs.getFloat("payTotal"));
                    item.setPay_Status(rs.getInt("payStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static PaymentBean getPaymentByID(int gr_id) {
        PaymentBean item = new PaymentBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPayment "
                        + "WHERE payID = " + gr_id);
                while (rs.next()) {
                    item.setPay_ID(rs.getInt("payID"));
                    item.setPaytype_ID(rs.getInt("ptID"));
                    if (String.valueOf(rs.getInt("comID")).length() > 0) {
                        item.setCom_ID(rs.getInt("comID"));
                    }
                    if (String.valueOf(rs.getInt("advID")).length() > 0) {
                        item.setCom_ID(rs.getInt("advID"));
                    }
                    if (String.valueOf(rs.getInt("drvID")).length() > 0) {
                        item.setCom_ID(rs.getInt("drvID"));
                    }
                    item.setPay_Time(rs.getTimestamp("payTime"));
                    item.setPay_TimeExpired(rs.getTimestamp("payTimeExpired"));
                    item.setPay_Total(rs.getFloat("payTotal"));
                    item.setPay_Status(rs.getInt("payStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean confirmPayment(int payid) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblPayment` SET `payStatus`='1' WHERE `payID`=?;");
                pstmt.setInt(1, payid);
                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static boolean cancelPayment(int payid) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblPayment` SET `payStatus`='0' WHERE `payID`=?;");
                pstmt.setInt(1, payid);
                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static boolean addPayment(PaymentBean item) {
        boolean returnValue = true;
        connect();
        try {
            if (!connect()) {
                returnValue = false;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblPayment` (`ptID`, `comID`, "
                        + "`advID`, `drvID`, `payTotal`) "
                        + "VALUES (?,?,?,?,?);");
                pstmt.setInt(1, item.getPaytype_ID());
                if (item.getCom_ID() == 0) {
                    pstmt.setNull(2, java.sql.Types.INTEGER);
                } else {
                    pstmt.setInt(2, item.getCom_ID());
                }
                if (item.getAdv_ID() == 0) {
                    pstmt.setNull(3, java.sql.Types.INTEGER);
                } else {
                    pstmt.setInt(3, item.getAdv_ID());
                }
                if (item.getDriver_ID() == 0) {
                    pstmt.setNull(4, java.sql.Types.INTEGER);
                } else {
                    pstmt.setInt(4, item.getDriver_ID());
                }
                pstmt.setFloat(5, item.getPay_Total());
                int kq = pstmt.executeUpdate();
                if (kq == 0) {
                    returnValue = false;
                }
            }

        } catch (SQLException ex) {
            returnValue = false;
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return returnValue;
    }

    public static PaymentBean getPaymentByDriverId(int driverId) {
        PaymentBean item = new PaymentBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPayment "
                        + "WHERE drvID = " + driverId+ " AND payStatus = 1");
                while (rs.next()) {
                    item.setPay_ID(rs.getInt("payID"));
                    item.setPaytype_ID(rs.getInt("ptID"));
                    if (String.valueOf(rs.getInt("comID")).length() > 0) {
                        item.setCom_ID(rs.getInt("comID"));
                    }
                    if (String.valueOf(rs.getInt("advID")).length() > 0) {
                        item.setCom_ID(rs.getInt("advID"));
                    }
                    if (String.valueOf(rs.getInt("drvID")).length() > 0) {
                        item.setCom_ID(rs.getInt("drvID"));
                    }
                    item.setPay_Time(rs.getTimestamp("payTime"));
                    item.setPay_TimeExpired(rs.getTimestamp("payTimeExpired"));
                    item.setPay_Total(rs.getFloat("payTotal"));
                    item.setPay_Status(rs.getInt("payStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }
    
    public static List<PaymentBean> getPaymentByComId(int comId) {
        ArrayList<PaymentBean> items = new ArrayList<>();
        PaymentBean item = null;
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblPayment "
                        + "WHERE comID = " + comId+ " AND payStatus = 1");
                while (rs.next()) {
                    item = new PaymentBean();
                    item.setPay_ID(rs.getInt("payID"));
                    item.setPaytype_ID(rs.getInt("ptID"));
                    if (String.valueOf(rs.getInt("comID")).length() > 0) {
                        item.setCom_ID(rs.getInt("comID"));
                    }
                    if (String.valueOf(rs.getInt("advID")).length() > 0) {
                        item.setAdv_ID(rs.getInt("advID"));
                    }
                    if (String.valueOf(rs.getInt("drvID")).length() > 0) {
                        item.setDriver_ID(rs.getInt("drvID"));
                    }
                    item.setPay_Time(rs.getTimestamp("payTime"));
                    item.setPay_TimeExpired(rs.getTimestamp("payTimeExpired"));
                    item.setPay_Total(rs.getFloat("payTotal"));
                    item.setPay_Status(rs.getInt("payStatus"));
                    items.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return items;
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
