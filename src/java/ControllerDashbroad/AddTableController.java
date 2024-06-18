/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package ControllerDashbroad;

import DAL.PreOrderDAO;
import DAL.TableDAO;
import Model.Account;
import Model.PreOrder;
import Model.Table;
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chutu
 */
public class AddTableController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddTableController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTableController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("login");
        } else {
            if (user.getAccountType().matches("user")) {
                PrintWriter out = response.getWriter();
                out.print("Access Denied");
            } else {
                request.getRequestDispatcher("AddTable.jsp").forward(request, response);
            }
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       int tableNumber = Integer.parseInt(request.getParameter("tableNumber"));
        int seats = Integer.parseInt(request.getParameter("seats"));
        String status = request.getParameter("status");

//        Table table = new Table(tableNumber, seats, status);
        TableDAO dao = new TableDAO();

        try {

            dao.addTable(new Table(tableNumber, seats, status));
        } catch (SQLException  ex) {
            Logger.getLogger(AddTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("dishmana");
    }
    @Override
    public String getServletInfo() {
        return "AddTableController";
    }
}


    

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    


