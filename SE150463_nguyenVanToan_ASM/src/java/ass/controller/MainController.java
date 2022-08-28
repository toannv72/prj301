/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ass.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class MainController extends HttpServlet {

    private final String loginController = "LoginController";
    private final String searchController = "SearchController";
    private final String logoutController = "LogoutController";
    private final String deleteController = "DeleteController";
    private final String updateController = "UpdateController";
    private final String createCourseController = "CreateCourseController";
    private final String chooseCourseController = "ChooseCourseController";
    private final String deleteCourseController = "DeleteCourseController";
    private final String viewCoursePage = "viewCourse.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = "";
            String button = request.getParameter("btAction");
            if (button.equals("Login")) {
                url = loginController;
            } else if (button.equals("Search")) {
                url = searchController;
            } else if (button.equals("Logout")) {
                url = logoutController;
            } else if (button.equals("Delete")) {
                url = deleteController;
            } else if (button.equals("Update")) {
                url = updateController;
            } else if (button.equals("Create course")) {
                url = createCourseController;
            } else if (button.equals("Add course")) {
                url = chooseCourseController;
            } else if (button.equals("View course")) {
                url = viewCoursePage;
            } else if (button.equals("Remove selected items")) {
                url = deleteCourseController;
            }
            request.getRequestDispatcher(url).forward(request, response);
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
