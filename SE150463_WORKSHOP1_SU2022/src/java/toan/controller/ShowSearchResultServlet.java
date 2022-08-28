/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package toan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toan.registration.RegistrationDTO;

/**
 *
 * @author TOAN
 */
public class ShowSearchResultServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");
            out.println("</head>");
            out.println("<body>");
            String search = request.getParameter("txtSearch");
            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCH_RESULT");
            if (result != null) {
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>Username</th>");
                out.println("<th>Password</th>");
                out.println("<th>Lastname</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                int count = 0;
                for (RegistrationDTO dto : result) {
                    String urlRewriting = "MainController?btAction=Delete&pk=" + dto.getUsername() + "&txtSearch=" + search;
                    out.println("<form action='MainController' method='post'>");
                    out.println("<tr>");
                    out.println("<td>" + ++count + "</td>");
                    out.println("<td>" + dto.getUsername() + "<input type='hidden' name='txtUsername' value='" + dto.getUsername() + "'></td>");
                    out.println("<td><input type='text' name='txtPassword' value='" + dto.getPassword() + "'></td>");
                    out.println("<td><input type='text' name='txtLastname' value='" + dto.getLastname() + "'></td>");
                    if (dto.isRole()) {
                        out.println("<td><input type='checkbox' name='chkRole' value='ON' checked='checked'/></td>");
                    } else {
                        out.println("<td><input type='checkbox' name='chkRole' value='ON'/></td>");
                    }
                    out.println("<td><a href='" + urlRewriting + "'>Delete</a></td>");
                    out.println("<td><input type='submit' value='Update' name='btAction'/><input type='hidden' value='" + search + "' name='txtSearch'/></td>");
                    out.println("</tr>");
                    out.println("</form>");
                }
                out.println("</tbody>");
                out.println("</table>");
                String error = (String) request.getAttribute("ERROR");
                if (error != null) {
                    out.println(error);
                }
            } else {
                out.println("No result matched");
            }
            out.println("</body>");
            out.println("</html>");
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
