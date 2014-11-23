/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import beans.ActionBean;
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
public class ActionDB {

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

    public static List<ActionBean> getAllAction() {
        List<ActionBean> list = new ArrayList<ActionBean>();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `" + ConfigDB.DBNAME + "`.`tblAction` ");
                while (rs.next()) {
                    ActionBean item = new ActionBean();
                    item.setActID(rs.getInt("actID"));
                    item.setActModel(rs.getString("actModel"));
                    item.setActAction(rs.getString("actAction"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }

    public static List<ActionBean> getActionByModule(String model) {
        List<ActionBean> list = new ArrayList<ActionBean>();
        try {
            if (!connect()) {
                return null;
            } else {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `" + ConfigDB.DBNAME + "`.`tblAction` where `actModel` = '" + model + "'");
                while (rs.next()) {
                    ActionBean item = new ActionBean();
                    item.setActID(rs.getInt("actID"));
                    item.setActModel(rs.getString("actModel"));
                    item.setActAction(rs.getString("actAction"));
                    list.add(item);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ActionDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return list;
    }
}
