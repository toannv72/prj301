/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toan.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TOAN
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=PRJ301_3W_2";
            Connection con = DriverManager.getConnection(url, "sa", "12345");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
}
