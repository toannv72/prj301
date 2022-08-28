/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toan.registration;

import toan.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class RegistrationDAO implements Serializable {

    private static final String CHECK_LOGIN = "SELECT username, password FROM Registration WHERE username = ? and password = ?";
    private static final String SEARCH = "SELECT username, password, lastname, isAdmin FROM Registration WHERE lastname like ?";
    private static final String DELETE = "DELETE FROM Registration WHERE username = ?";
    private static final String UPDATE = "UPDATE Registration SET password = ?, lastname = ?, isAdmin = ? WHERE username = ?";
    private static final String INSERT = "INSERT INTO Registration (username,password,lastname,isAdmin) VALUES (?, ?, ?, ?)";

    public boolean CheckLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(CHECK_LOGIN);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    List<RegistrationDTO> listAccounts;

    public List<RegistrationDTO> getListAccounts() {
        //bam get la auto ra
        return listAccounts;
    }

    public void searchLastname(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(SEARCH);
            stm.setString(1, "%" + searchValue + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String lastname = rs.getString("lastname");
                boolean role = rs.getBoolean("isAdmin");
                RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                if (listAccounts == null) {
                    listAccounts = new ArrayList<>();
                }
                listAccounts.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean deleteRecord(String pk) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(DELETE);
            stm.setString(1, pk);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }

        } finally {
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateRecord(String username, String pw, boolean role, String lastname) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(UPDATE);
            stm.setString(1, pw);
            stm.setString(2, lastname);
            stm.setBoolean(3, role);
            stm.setString(4, username);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }

        } finally {
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;

    }

    public boolean insertAccount(String username, String password, String fullname, boolean role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(INSERT);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setBoolean(4, role);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }

        } finally {
            if (stm != null) {
                con.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
