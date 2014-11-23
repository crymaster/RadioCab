/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.MembertypeBean;
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
public class MembertypeDB {

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

    public static List<MembertypeBean> getAllMembertype() {
        List<MembertypeBean> list = new ArrayList<MembertypeBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblMembershipType");
                while (rs.next()) {
                    MembertypeBean item = new MembertypeBean();
                    item.setMem_ID(rs.getInt("mtID"));
                    item.setMem_Name(rs.getString("mtName"));
                    item.setMem_Fee(rs.getFloat("mtFee"));
                    item.setMem_Status(rs.getInt("mtStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MembertypeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<MembertypeBean> getAllAvailableMembertype() {
        List<MembertypeBean> list = new ArrayList<MembertypeBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblMembershipType WHERE mtStatus = 1");
                while (rs.next()) {
                    MembertypeBean item = new MembertypeBean();
                    item.setMem_ID(rs.getInt("mtID"));
                    item.setMem_Name(rs.getString("mtName"));
                    item.setMem_Fee(rs.getFloat("mtFee"));
                    item.setMem_Status(rs.getInt("mtStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MembertypeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static MembertypeBean getMembertypeByID(int gr_id) {
        MembertypeBean item = new MembertypeBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblMembershipType WHERE mtID = " + gr_id);
                while (rs.next()) {
                    item.setMem_ID(rs.getInt("mtID"));
                    item.setMem_Name(rs.getString("mtName"));
                    item.setMem_Fee(rs.getFloat("mtFee"));
                    item.setMem_Status(rs.getInt("mtStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MembertypeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean editMembertype(MembertypeBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblMembershipType` SET `mtFee` = ?, `mtStatus` = ? WHERE `mtID` = ?;");
                pstmt.setFloat(1, item.getMem_Fee());
                pstmt.setInt(2, item.getMem_Status());
                pstmt.setInt(3, item.getMem_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembertypeBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int addMembertype(MembertypeBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblMembershipType` (`mtName`,`mtFee`) VALUES (?,?);");
                pstmt.setString(1, item.getMem_Name());
                pstmt.setFloat(2, item.getMem_Fee());
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
            Logger.getLogger(MembertypeBean.class.getName()).log(Level.SEVERE, null, ex);
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
