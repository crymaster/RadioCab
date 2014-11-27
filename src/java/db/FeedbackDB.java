/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.FeedbackBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author son
 */
public class FeedbackDB {
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

    public static int addFeedback(FeedbackBean item) {
        int lastid = -1;
        connect();
        try {
            if (!connect()) {
                lastid = -1;
            } else {
                pstmt = con.prepareStatement("INSERT INTO `" + ConfigDB.DBNAME + "`.`tblFeedback` (`fbName`, `fbType`, "
                        + "`fbMobile`, `fbEmail`, `fbDescription`) VALUES (?,?,?,?,?);");
                pstmt.setString(1,item.getFbName());
                pstmt.setString(2,item.getFbType());
                pstmt.setString(3,item.getFbMobile());
                pstmt.setString(4,item.getFbEmail());
                pstmt.setString(5,item.getFbDescription());
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
}
