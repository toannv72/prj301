/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toan.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import toan.utils.DBUtils;

/**
 *
 * @author TOAN
 */
public class RegistrationDAO implements Serializable {

    private List<RegistrationDTO> listAccounts;

    public boolean checkLogin(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT username FROM Registration WHERE username = ? and password = ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public List<RegistrationDTO> getListAccounts() {
        return listAccounts;
    }

    public void searchLastname(String search) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Registration where lastname like ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
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
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean insert(String username, String password, String lastname, boolean role) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Registration(username, password, lastname, isAdmin) VALUES(?, ?, ?, ?)";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, username);
                ptm.setString(2, password);
                ptm.setString(3, lastname);
                ptm.setBoolean(4, role);
                int row = ptm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean delete(String username) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "DELETE FROM Registration WHERE username = ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, username);
                int row = ptm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean update(String username, String password, String lastname, boolean role) throws SQLException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE Registration SET password = ?, isAdmin = ?, lastname = ? Where username = ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, password);
                ptm.setBoolean(2, role);
                ptm.setString(3, lastname);
                ptm.setString(4, username);
                int row = ptm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
