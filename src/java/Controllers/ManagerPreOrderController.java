/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.PreOrderDAO;
import Model.Account;
import Model.PreOrder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author HP
 */
public class ManagerPreOrderController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagerPreOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerPreOrderController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account accountLogin = (Account) session.getAttribute("account");
        if (accountLogin != null && accountLogin.getAccountType().equals("manager")) {
            String action = request.getParameter("action");
            action = action != null ? action : "";
            PreOrderDAO preOrderDao = new PreOrderDAO();
            switch (action) {
                case "view":
                    try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    PreOrder preOrder = preOrderDao.getPreOrderById(id);
                    request.setAttribute("preOrder", preOrder);
                    request.getRequestDispatcher("viewPreOrder.jsp").forward(request, response);
                } catch (Exception e) {
                    response.sendRedirect("ManagerPreOrderController?error=Id is not valid");
                }
                break;
                default:
                    List<PreOrder> preOrders = preOrderDao.getAllPreOrders();
                    request.setAttribute("preOrders", preOrders);
                    request.getRequestDispatcher("managerPreOrder.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login");
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
        HttpSession session = request.getSession();
        Account accountLogin = (Account) session.getAttribute("account");
        if (accountLogin != null && accountLogin.getAccountType().equals("manager")) {
            String action = request.getParameter("action");
            action = action != null ? action : "";
            PreOrderDAO preOrderDao = new PreOrderDAO();
            switch (action) {
                case "edit":
                    try {
                    int status = Integer.parseInt(request.getParameter("status"));
                    int preOrderID = Integer.parseInt(request.getParameter("preOrderID"));
                    PreOrder preOrder = preOrderDao.getPreOrderById(preOrderID);
                    if(preOrder != null) {
                        boolean result = preOrderDao.updateStatusPreOrder(status, preOrderID);
                        if(result) {
                            response.sendRedirect("ManagerPreOrderController?success=Change status successfully");
                        } else {
                            response.sendRedirect("ManagerPreOrderController?error=Change status fail");
                        }
                    } else {
                        response.sendRedirect("ManagerPreOrderController?error=Can not found this pre Order");
                    }
                } catch (Exception e) {
                    response.sendRedirect("ManagerPreOrderController?error=Id is not valid");
                }
                break;
                default:
                    List<PreOrder> preOrders = preOrderDao.getAllPreOrders();
                    request.setAttribute("preOrders", preOrders);
                    request.getRequestDispatcher("managerPreOrder.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login");
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
