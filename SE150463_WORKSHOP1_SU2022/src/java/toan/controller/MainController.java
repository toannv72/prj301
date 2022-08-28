/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package toan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TOAN
 */
public class MainController extends HttpServlet {

    private final String loginController = "LoginController";
    private final String searchController = "SearchController";
    private final String addItemServlet = "AddItemServlet";
    private final String deleteItemServlet = "DeleteItemServlet";
    private final String viewItemServlet = "ViewItemController";
    private final String updateServlet = "UpdateController";
    private final String deleteServlet = "DeleteServlet";
    private final String createNewAccount = "CreateNewAccountController";
    private final String logoutServlet = "LogoutServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {
            String url = "";
            String button = request.getParameter("btAction");
            if (button.equals("Login")) {
                url = loginController;
            } else if (button.equals("Search")) {
                url = searchController;
            } else if (button.equals("Add book to your cart")) {
                url = addItemServlet;
            } else if (button.equals("Remove cart")) {
                url = deleteItemServlet;
            } else if (button.equals("View your cart")) {
                url = viewItemServlet;
            } else if (button.equals("Delete")) {
                url = deleteServlet;
            } else if (button.equals("Update")) {
                url = updateServlet;
            } else if (button.equals("Create new account")) {
                url = createNewAccount;
            } else if (button.equals("logout")) {
                url = logoutServlet;
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
