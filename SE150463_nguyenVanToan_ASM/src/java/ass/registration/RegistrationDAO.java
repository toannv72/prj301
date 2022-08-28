/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass.registration;

import ass.utils.DBUtils;
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

    public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT userID from tblLogin where userID = ? and password = ?";
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
    private List<RegistrationDTO> accounts;

    public void search(String search) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT * from tblCourse where name like ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    String image = rs.getString("image");
                    String desc = rs.getString("description");
                    int tuitionFee = rs.getInt("tuitionFee");
                    String startDate = rs.getString("startDate");
                    String endDate = rs.getString("endDate");
                    String category = rs.getString("category");
                    RegistrationDTO dto = new RegistrationDTO(name, image, desc, tuitionFee, startDate, endDate, category);
                    if (accounts == null) {
                        accounts = new ArrayList<>();
                    }
                    accounts.add(dto);
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

    public List<RegistrationDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<RegistrationDTO> accounts) {
        this.accounts = accounts;
    }

    public boolean delete(String name) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM tblCourse WHERE name LIKE ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, "%" + name + "%");
                if (ptm.executeUpdate() > 0) {
                    return true;
                }
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean update(String name, String image, String desc, int tuitionFee, String startDate, String endDate, String category) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblCourse SET image = ?, description = ?, tuitionFee = ?, startDate = ?, endDate = ?, category = ? where name = ?";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, image);
                ptm.setString(2, desc);
                ptm.setInt(3, tuitionFee);
                ptm.setString(4, startDate);
                ptm.setString(5, endDate);
                ptm.setString(6, category);
                ptm.setString(7, name);
                if (ptm.executeUpdate() > 0) {
                    return true;
                }
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insert(String name, String image, String desc, int tuitionFee, String startDate, String endDate, String category) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT tblCourse(image, description, tuitionFee, startDate, endDate, category, name) VALUES (?,?,?,?,?,?,?)";
                ptm = con.prepareStatement(sql);
                ptm.setString(1, image);
                ptm.setString(2, desc);
                ptm.setInt(3, tuitionFee);
                ptm.setString(4, startDate);
                ptm.setString(5, endDate);
                ptm.setString(6, category);
                ptm.setString(7, name);
                if (ptm.executeUpdate() > 0) {
                    return true;
                }
            }
        } finally {
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
