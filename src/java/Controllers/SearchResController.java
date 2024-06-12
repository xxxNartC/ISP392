package Controllers;

import DAL.PreOrderDAO;
import Model.PreOrder;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchResController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("searchRes.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phone = request.getParameter("phone");

        PreOrderDAO preOrderDAO = new PreOrderDAO();
        try {
            List<PreOrder> preOrders = preOrderDAO.getPreOrdersByPhone(phone);
            if (preOrders != null && !preOrders.isEmpty()) {
                request.setAttribute("preOrders", preOrders);
            } else {
                request.setAttribute("errorMessage", "No reservations found for the provided phone number.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to retrieve reservations. Please try again later.");
        }

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Search Reservation Controller";
    }
}
