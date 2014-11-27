/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.DriverBean;
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
public class DriverDB {

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

    public static List<DriverBean> getAllDriver() {
        List<DriverBean> list = new ArrayList<DriverBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblDriver inner join tblCity on tblDriver.citID = tblCity.citID");
                while (rs.next()) {
                    DriverBean item = new DriverBean();
                    item.setDriver_ID(rs.getInt("drvID"));
                    item.setDriver_uName(rs.getString("drvUsername"));
                    item.setDriver_Pass(rs.getString("drvPass"));
                    item.setDriver_Name(rs.getString("drvName"));
                    item.setDriver_Contactperson(rs.getString("drvContactPerson"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setDriver_Address(rs.getString("drvAddress"));
                    item.setDriver_Image(rs.getString("drvImage"));
                    item.setDriver_Mobile(rs.getString("drvMobile"));
                    item.setDriver_Tel(rs.getString("drvTel"));
                    item.setDriver_Email(rs.getString("drvEmail"));
                    item.setDriver_Exp(rs.getString("drvExp"));
                    item.setDriver_Description(rs.getString("drvDescription"));
                    item.setDriver_RegDate(rs.getTimestamp("drvRegDate"));
                    item.setDriver_Status(rs.getInt("drvStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<DriverBean> getAllAvailableDriver() {
        List<DriverBean> list = new ArrayList<DriverBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblDriver inner join tblCity on tblDriver.citID = tblCity.citID WHERE drvStatus = 1");
                while (rs.next()) {
                    DriverBean item = new DriverBean();
                    item.setDriver_ID(rs.getInt("drvID"));
                    item.setDriver_uName(rs.getString("drvUsername"));
                    item.setDriver_Pass(rs.getString("drvPass"));
                    item.setDriver_Name(rs.getString("drvName"));
                    item.setDriver_Contactperson(rs.getString("drvContactPerson"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setDriver_Address(rs.getString("drvAddress"));
                    item.setDriver_Image(rs.getString("drvImage"));
                    item.setDriver_Mobile(rs.getString("drvMobile"));
                    item.setDriver_Tel(rs.getString("drvTel"));
                    item.setDriver_Email(rs.getString("drvEmail"));
                    item.setDriver_Exp(rs.getString("drvExp"));
                    item.setDriver_Description(rs.getString("drvDescription"));
                    item.setDriver_RegDate(rs.getTimestamp("drvRegDate"));
                    item.setDriver_Status(rs.getInt("drvStatus"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static DriverBean getDriverByID(int gr_id) {
        DriverBean item = new DriverBean();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblDriver inner join tblCity on tblDriver.citID = tblCity.citID WHERE drvID = " + gr_id);
                while (rs.next()) {
                    item.setDriver_ID(rs.getInt("drvID"));
                    item.setDriver_uName(rs.getString("drvUsername"));
                    item.setDriver_Pass(rs.getString("drvPass"));
                    item.setDriver_Name(rs.getString("drvName"));
                    item.setDriver_Contactperson(rs.getString("drvContactPerson"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setDriver_Address(rs.getString("drvAddress"));
                    item.setDriver_Image(rs.getString("drvImage"));
                    item.setDriver_Mobile(rs.getString("drvMobile"));
                    item.setDriver_Tel(rs.getString("drvTel"));
                    item.setDriver_Email(rs.getString("drvEmail"));
                    item.setDriver_Exp(rs.getString("drvExp"));
                    item.setDriver_Description(rs.getString("drvDescription"));
                    item.setDriver_RegDate(rs.getTimestamp("drvRegDate"));
                    item.setDriver_Status(rs.getInt("drvStatus"));
                }
            }

        } catch (SQLException ex) {
            item = null;
            Logger.getLogger(DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
    }

    public static boolean editDriver(DriverBean item) {
        boolean success = false;
        try {
            if (!connect()) {

            } else {
                pstmt = con.prepareStatement("UPDATE `" + ConfigDB.DBNAME + "`.`tblDriver` SET `drvName` = ?, "
                        + "`drvContactPerson` = ?, `citID` = ?, `drvAddress` = ?, `drvImage` = ?, `drvMobile` = ?, `drvTel` = ?, "
                        + "`drvEmail` = ?, `drvExp` = ?, `drvDescription` = ?, `drvStatus` = ? "
                        + "WHERE `drvID` = ?;");

                pstmt.setString(1,item.getDriver_Name());
                pstmt.setString(2,item.getDriver_Contactperson());
                pstmt.setInt(3,item.getCity_ID());
                pstmt.setString(4,item.getDriver_Address());
                pstmt.setString(5,item.getDriver_Image());
                pstmt.setString(6,item.getDriver_Mobile());
                pstmt.setString(7,item.getDriver_Tel());
                pstmt.setString(8,item.getDriver_Email());
                pstmt.setString(9,item.getDriver_Exp());
                pstmt.setString(10,item.getDriver_Description());
                pstmt.setInt(11,item.getDriver_Status());
                pstmt.setInt(12,item.getDriver_ID());

                int kq = pstmt.executeUpdate();
                if (kq != 0) {
                    success = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        return success;
    }

    public static int addDriver(DriverBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblDriver` (`drvUsername`, `drvPass`, "
                        + "`drvName`, `drvContactPerson`, `citID`, `drvAddress`, `drvImage`, `drvMobile`, `drvTel`, "
                        + "`drvEmail`, `drvExp`, `drvDescription`,`drvStatus`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
                pstmt.setString(1,item.getDriver_uName());
                pstmt.setString(2,item.getDriver_Pass());
                pstmt.setString(3,item.getDriver_Name());
                pstmt.setString(4,item.getDriver_Contactperson());
                pstmt.setInt(5,item.getCity_ID());
                pstmt.setString(6,item.getDriver_Address());
                pstmt.setString(7,item.getDriver_Image());
                pstmt.setString(8,item.getDriver_Mobile());
                pstmt.setString(9,item.getDriver_Tel());
                pstmt.setString(10,item.getDriver_Email());
                pstmt.setString(11,item.getDriver_Exp());
                pstmt.setString(12,item.getDriver_Description());
                pstmt.setInt(13, item.getDriver_Status());
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
            Logger.getLogger(DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }
        //PermissionDB.addPermission(lastid);
        return lastid;
    }

    public static List<DriverBean> search(String drvName, int cityId) {
        List<DriverBean> list = new ArrayList<DriverBean>();
        try {
            if (!connect()) {
                return list;
            } else {
                drvName += "%";
                String sql = "SELECT * FROM tblDriver "
                        + " INNER JOIN tblCity ON tblDriver.citID = tblCity.citID"
                        + " WHERE drvStatus = 1 "
                        + " AND ( drvUsername LIKE '" + drvName + "' OR drvName LIKE '" + drvName + "')";
                if (cityId != 0) {
                    sql += "AND tblCity.citID = " + cityId;
                }
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    DriverBean item = new DriverBean();
                    item.setDriver_ID(rs.getInt("drvID"));
                    item.setDriver_uName(rs.getString("drvUsername"));
                    item.setDriver_Pass(rs.getString("drvPass"));
                    item.setDriver_Name(rs.getString("drvName"));
                    item.setDriver_Contactperson(rs.getString("drvContactPerson"));
                    item.setDriver_Image(rs.getString("drvImage"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setDriver_Address(rs.getString("drvAddress"));
                    item.setDriver_Mobile(rs.getString("drvMobile"));
                    item.setDriver_Tel(rs.getString("drvTel"));
                    item.setDriver_Email(rs.getString("drvEmail"));
                    item.setDriver_RegDate(rs.getTimestamp("drvRegDate"));
                    item.setDriver_Status(rs.getInt("drvStatus"));
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
    
     public static DriverBean driverLogin(String drvName, String password) {
        DriverBean item = null;
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tblDriver inner join tblCity on tblDriver.citID = tblCity.citID WHERE drvUsername = '" + drvName+"' AND drvPass = '"+password+"'");
                while (rs.next()) {
                    item = new DriverBean();
                    item.setDriver_ID(rs.getInt("drvID"));
                    item.setDriver_uName(rs.getString("drvUsername"));
                    item.setDriver_Pass(rs.getString("drvPass"));
                    item.setDriver_Name(rs.getString("drvName"));
                    item.setDriver_Contactperson(rs.getString("drvContactPerson"));
                    item.setCity_ID(rs.getInt("citID"));
                    item.setCity_Name(rs.getString("citName"));
                    item.setDriver_Address(rs.getString("drvAddress"));
                    item.setDriver_Image(rs.getString("drvImage"));
                    item.setDriver_Mobile(rs.getString("drvMobile"));
                    item.setDriver_Tel(rs.getString("drvTel"));
                    item.setDriver_Email(rs.getString("drvEmail"));
                    item.setDriver_Exp(rs.getString("drvExp"));
                    item.setDriver_Description(rs.getString("drvDescription"));
                    item.setDriver_RegDate(rs.getTimestamp("drvRegDate"));
                    item.setDriver_Status(rs.getInt("drvStatus"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DriverDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return item;
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
