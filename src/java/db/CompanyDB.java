/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.CompanyBean;
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
public class CompanyDB {

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

    public static List<CompanyBean> getAllCompany() {
        List<CompanyBean> list = new ArrayList<CompanyBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblCompany "
                        + "inner join tblCity on tblCompany.citID = tblCity.citID "
                        + "inner join tblMembershipType on tblCompany.mtID = tblMembershipType.mtID");
                while (rs.next()) {
                    CompanyBean item = new CompanyBean();
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_uName(rs.getString("comUsername"));
                    item.setCom_Pass(rs.getString("comPass"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setCom_Contactperson(rs.getString("comContactPerson"));
                    item.setCom_Designation(rs.getString("comDesignation"));
                    item.setCom_Image(rs.getString("comImageURL"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setCom_Address(rs.getString("comAddress"));
                    item.setCom_Mobile(rs.getString("comMobile"));
                    item.setCom_Tel(rs.getString("comTel"));
                    item.setCom_Fax(rs.getString("comFax"));
                    item.setCom_Email(rs.getString("comEmail"));
                    item.setCom_RegDate(rs.getTimestamp("comRegDate"));
                    item.setCom_Status(rs.getInt("comStatus"));
                    item.setMem_ID(rs.getInt("mtID"));
                    item.setMem_Name(rs.getString("mtName"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<CompanyBean> getAllAvailableCompany() {
        List<CompanyBean> list = new ArrayList<CompanyBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblCompany "
                        + "inner join tblCity on tblCompany.citID = tblCity.citID "
                        + "inner join tblMembershipType on tblCompany.mtID = tblMembershipType.mtID "
                        + "WHERE comStatus = 1");
                while (rs.next()) {
                    CompanyBean item = new CompanyBean();
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_uName(rs.getString("comUsername"));
                    item.setCom_Pass(rs.getString("comPass"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setCom_Contactperson(rs.getString("comContactPerson"));
                    item.setCom_Designation(rs.getString("comDesignation"));
                    item.setCom_Image(rs.getString("comImageURL"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setCom_Address(rs.getString("comAddress"));
                    item.setCom_Mobile(rs.getString("comMobile"));
                    item.setCom_Tel(rs.getString("comTel"));
                    item.setCom_Fax(rs.getString("comFax"));
                    item.setCom_Email(rs.getString("comEmail"));
                    item.setCom_RegDate(rs.getTimestamp("comRegDate"));
                    item.setCom_Status(rs.getInt("comStatus"));
                    item.setMem_ID(rs.getInt("mtID"));
                    item.setMem_Name(rs.getString("mtName"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static CompanyBean getCompanyByID(int gr_id) {
        CompanyBean item = new CompanyBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblCompany "
                        + "inner join tblCity on tblCompany.citID = tblCity.citID "
                        + "inner join tblMembershipType on tblCompany.mtID = tblMembershipType.mtID "
                        + "WHERE comID = " + gr_id);
                while (rs.next()) {
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_uName(rs.getString("comUsername"));
                    item.setCom_Pass(rs.getString("comPass"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setCom_Contactperson(rs.getString("comContactPerson"));
                    item.setCom_Designation(rs.getString("comDesignation"));
                    item.setCom_Image(rs.getString("comImageURL"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setCom_Address(rs.getString("comAddress"));
                    item.setCom_Mobile(rs.getString("comMobile"));
                    item.setCom_Tel(rs.getString("comTel"));
                    item.setCom_Fax(rs.getString("comFax"));
                    item.setCom_Email(rs.getString("comEmail"));
                    item.setCom_RegDate(rs.getTimestamp("comRegDate"));
                    item.setCom_Status(rs.getInt("comStatus"));
                    item.setMem_ID(rs.getInt("mtID"));
                    item.setMem_Name(rs.getString("mtName"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean editCompany(CompanyBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblCompany` SET `comName` = ?, "
                        + "`comContactPerson` = ?, `comDesignation` = ?, `comImageURL` = ?, `citID` = ?, "
                        + "`comAddress` = ?, `comMobile` = ?, `comTel` = ?, "
                        + "`comFax` = ?, `comEmail` = ?, `comStatus` = ?, `mtID` = ? "
                        + "WHERE `comID` = ?");

                pstmt.setString(1, item.getCom_Name());
                pstmt.setString(2, item.getCom_Contactperson());
                pstmt.setString(3, item.getCom_Designation());
                pstmt.setString(4, item.getCom_Image());
                pstmt.setInt(5, item.getCity_ID());
                pstmt.setString(6, item.getCom_Address());
                pstmt.setString(7, item.getCom_Mobile());
                pstmt.setString(8, item.getCom_Tel());
                pstmt.setString(9, item.getCom_Fax());
                pstmt.setString(10, item.getCom_Email());
                pstmt.setInt(11, item.getCom_Status());
                pstmt.setInt(12, item.getMem_ID());
                pstmt.setInt(13, item.getCom_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int addCompany(CompanyBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblCompany` (`comUsername`, `comPass`, "
                        + "`comName`, `comContactPerson`, `comDesignation`, `comImageURL`, "
                        + "`citID`, `comAddress`, `comMobile`, `comTel`, `comFax`, "
                        + "`comEmail`, `mtID`, `comStatus`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                pstmt.setString(1, item.getCom_uName());
                pstmt.setString(2, item.getCom_Pass());
                pstmt.setString(3, item.getCom_Name());
                pstmt.setString(4, item.getCom_Contactperson());
                pstmt.setString(5, item.getCom_Designation());
                pstmt.setString(6, item.getCom_Image());
                pstmt.setInt(7, item.getCity_ID());
                pstmt.setString(8, item.getCom_Address());
                pstmt.setString(9, item.getCom_Mobile());
                pstmt.setString(10, item.getCom_Tel());
                pstmt.setString(11, item.getCom_Fax());
                pstmt.setString(12, item.getCom_Email());
                pstmt.setInt(13, item.getMem_ID());
                pstmt.setInt(14, item.getCom_Status());
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
            Logger.getLogger(CompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return lastid;
    }

    public static List<CompanyBean> search(String comName, int cityId) {
        List<CompanyBean> list = new ArrayList<CompanyBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                comName += "%";
                String sql = "SELECT * FROM tblCompany "
                        + " INNER JOIN tblCity ON tblCompany.citID = tblCity.citID"
                        + " WHERE comStatus = 1 "
                        + " AND ( comUsername LIKE '" + comName + "' OR comName LIKE '" + comName + "')";
                if (cityId != 0) {
                    sql += "AND tblCity.citID = " + cityId;
                }
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    CompanyBean item = new CompanyBean();
                    item.setCom_ID(rs.getInt("comID"));
                    item.setCom_uName(rs.getString("comUsername"));
                    item.setCom_Pass(rs.getString("comPass"));
                    item.setCom_Name(rs.getString("comName"));
                    item.setCom_Contactperson(rs.getString("comContactPerson"));
                    item.setCom_Designation(rs.getString("comDesignation"));
                    item.setCom_Image(rs.getString("comImageURL"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setCom_Address(rs.getString("comAddress"));
                    item.setCom_Mobile(rs.getString("comMobile"));
                    item.setCom_Tel(rs.getString("comTel"));
                    item.setCom_Fax(rs.getString("comFax"));
                    item.setCom_Email(rs.getString("comEmail"));
                    item.setCom_RegDate(rs.getTimestamp("comRegDate"));
                    item.setCom_Status(rs.getInt("comStatus"));
                    item.setMem_ID(rs.getInt("mtID"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
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
