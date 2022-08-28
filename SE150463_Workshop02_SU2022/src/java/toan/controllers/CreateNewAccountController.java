/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toan.controllers;

import toan.registration.RegistrationDAO;
import toan.registration.RegistrationInsertError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CreateNewAccountController extends HttpServlet {

    private final String LOGINPAGE = "login.jsp";
    private final String ERRORPAGE = "createNewAccount.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERRORPAGE;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = request.getParameter("txtFullname");
        String confirm = request.getParameter("txtConfirm");
        System.out.println(username + password + fullname);
        RegistrationInsertError error = new RegistrationInsertError();
        boolean ckError = false;
        try {
            /* TODO output your page here. You may use following sample code. */

            if (username.trim().length() < 5 || username.trim().length() > 20) {
                error.setUsernameLengthError("username requires 6 - 20 chars");
                ckError = true;
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                error.setPasswordLengthError("password requires 6 - 20 chars");
                ckError = true;
            } else if (!password.trim().equals(confirm)) {
                error.setConfirmNotMatch("password and confirm is not matched");
                ckError = true;
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                error.setFullnameLengthError("full name requires 2 - 50 chars");
                ckError = true;
            }
            if (ckError) {
                request.setAttribute("INSERTERROR", error);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.insertAccount(username, password, fullname, false);
                if (result) {
                    url = LOGINPAGE;
                }
            }

        } catch (NamingException e) {
            log("CreateNewAccountController _Naming" + e.getMessage());
        } catch (SQLException e) {
            log("CreateNewAccountController _SQL" + e.getMessage());
            error.setUsernameIsExisted(username + " is existed");
            request.setAttribute("INSERTERROR", error);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            //out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(CreateNewAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(CreateNewAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
