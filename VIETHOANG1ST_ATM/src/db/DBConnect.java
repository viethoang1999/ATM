/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Quoc
 */
public class DBConnect {
    public  static Connection opConnection(){
        Properties p = new Properties();
        File file  = new File("config.properties");
        try {
            if (!file.exists()) {
                file.createNewFile();
                p.setProperty("serverName", "localhost");
                p.setProperty("dbName", "DB_ATM");
                p.setProperty("port", "1433");
                p.setProperty("userName", "sa");
                p.setProperty("password", "131199");
                FileOutputStream fos = new FileOutputStream(file);
                p.store(fos, "");
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputStream input = null;
        try {
            input  = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            System.out.println("loi "+ex.getMessage());
        }
        try {
            p.load(input);
        } catch (IOException ex) {
            System.out.println("loi "+ex.getMessage());
        }
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String userName = p.getProperty("userName");
        String password = p.getProperty("password");
        String port = p.getProperty("port");
        String dbName = p.getProperty("dbName");
        String serverName = p.getProperty("serverName");
        String url = "jdbc:sqlserver://" + serverName + ":" + port;
        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url + ";databaseName="+ dbName, userName, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return con;
        
    }   
    public static void main(String[] args) {
        System.out.println(opConnection());
    }
    public  static void closeAll(Connection con, CallableStatement cstmt, ResultSet rs){
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cstmt!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
