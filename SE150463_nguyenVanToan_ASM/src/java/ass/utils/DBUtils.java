/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
public class DBUtils implements Serializable {

    public static Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context cos = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) cos.lookup("DBCon");
        Connection con = ds.getConnection();
        return con;
    }
    
}
