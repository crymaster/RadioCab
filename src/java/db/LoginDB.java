/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.AdminBean;
//import beans.CustomerBean;
import java.sql.*;

/**
 *
 * @author quangphamngoc
 */
public class LoginDB {

    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static CallableStatement cstmt;
    private static ResultSet rs;
    public static AdminBean currentAdmin;
//    public static CustomerBean currentCustomer;
    public static int error = 0;
    //0 = no error
    //1 = SQL Error
    //2 = Driver Not Found Error
    //3 = Wrong info
    //4 = Banned Account

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

    public static boolean doLogin(String username, String password) {
        boolean result = false;
        if (!connect()) {

            return false;
        }

        try {
            String query = "SELECT * FROM " + ConfigDB.AdminTable + " INNER JOIN " + ConfigDB.RoleTable + " ON " + ConfigDB.AdminTable + "." + ConfigDB.RoleIDColumn + "=" + ConfigDB.RoleTable + "." + ConfigDB.RoleIDColumn + " WHERE " + ConfigDB.AdminNameColumn + " = ? AND " + ConfigDB.AdminPassColumn + "= ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                currentAdmin = new AdminBean();
                currentAdmin.setAd_ID(rs.getInt("admID"));
                currentAdmin.setRole_ID(rs.getInt("rolID"));
                currentAdmin.setAd_Account(rs.getString("admUsername"));
                currentAdmin.setAd_Password(rs.getString("admPass"));
                currentAdmin.setAd_Avatar(rs.getString("admAvartar"));
                currentAdmin.setAd_Phone(rs.getString("admTel"));
                currentAdmin.setAd_Email(rs.getString("admEmail"));
                currentAdmin.setAd_Status(rs.getInt("admStatus"));
                currentAdmin.setRole_Name(rs.getString("rolName"));
                if (currentAdmin.getAd_Status() == ConfigApp.statusNotOKValue) {
                    error = 4;
                    return false;
                }
                //pstmt = con.prepareStatement("SELECT setExpired()");
                //rs = pstmt.executeQuery();
                return true;
            } else {
                error = 3;
                return false;
            }
        } catch (SQLException ex) {
            error = 1;
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return result;
    }



//public static int doUserLogin(String username, String password){
//        int result = 0;
//        if (!connect()){
//            
//            return result;
//        }
//        
//        try {
//            String query = "SELECT * FROM Customers WHERE Cus_Account = ? AND Cus_Password = ? ";
//            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//            rs = pstmt.executeQuery();
//            if (rs.next()){
//                int status = rs.getInt("Cus_Status");
//                if(status == 1 || status == 2){
//                    currentCustomer = new CustomerBean();
//                    currentCustomer.setCus_ID(rs.getInt("Cus_ID"));
//                    currentCustomer.setCus_FirstName(rs.getString("Cus_FirstName"));
//                    currentCustomer.setCus_LastName(rs.getString("Cus_LastName"));
//                    currentCustomer.setCus_MiddleName(rs.getString("Cus_MiddleName"));
//                    currentCustomer.setCus_City(rs.getString("Cus_City"));
//                    currentCustomer.setCus_HouseNo(rs.getString("Cus_HouseNo"));
//                    currentCustomer.setCus_CCNumber(rs.getString("Cus_CCNumber"));
//                    currentCustomer.setCus_Phone(rs.getString("Cus_Phone"));
//                    currentCustomer.setCus_Status(rs.getInt("Cus_Status"));
//                    currentCustomer.setCus_Street(rs.getString("Cus_Street"));
//                    currentCustomer.setCus_Account(rs.getString("Cus_Account"));
//                    currentCustomer.setCus_Password(rs.getString("Cus_Password"));
//                    if(status == 1){
//                        result = 7;
//                    } else{
//                        result = 8;
//                    }
//                } else{
//                    //Banned
//                    result = 4;
//                    return result;
//                }
//            } else{
//                result = 3;
//                return result;
//            }
//        } catch (SQLException ex) {
//            result = 1;
//            System.out.println(ex);
//            ex.printStackTrace();
//        } finally{
//            disconnect();
//        }
//        return result;
//    }
//     
//     
//     public static int doUserSignUp(String username, String password, String firstName){
//        int rsVal = 0;
//        if (!connect()){
//            return rsVal;
//        }
//        
//        try {
//            String query = "INSERT INTO `SuperMarket`.`customers` (`Cus_FirstName`, `Cus_Status`, `Cus_Account`, `Cus_Password`) VALUES (?, ?, ?, ?);";
//            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, firstName);
//            pstmt.setInt(2, 2);
//            pstmt.setString(3, username);
//            pstmt.setString(4, password);
//            int rows = pstmt.executeUpdate();
//            boolean status = true;
//            if (rows > 0){
//                int lastid = -1;
//                pstmt = con.prepareStatement("SELECT LAST_INSERT_ID()");
//                    rs = pstmt.executeQuery();
//                    while (rs.next()) {
//                        lastid = rs.getInt("last_insert_id()");
//                    }
//                rsVal = lastid;
//            } else{
//                rsVal = -2;
//            }
//        } catch (SQLException ex) {
//            rsVal = -3;
//            System.out.println(ex);
//            ex.printStackTrace();
//        } finally{
//            disconnect();
//        }
//        return rsVal;
//    }
     
     
}
