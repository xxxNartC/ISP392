package ControllerDashbroad;


import DAL.PreOrderDAO;
import Model.Account;
import Model.PreOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;

public class ReservationManager extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReservationManager</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReservationManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
                String id_raw = request.getParameter("id");
                PreOrderDAO dao = new PreOrderDAO();

                try {
                    int id = Integer.parseInt(id_raw);
                    PreOrder preOrder = dao.getPreOrderById(id);
                    request.setAttribute("preOrder", preOrder);
                    request.getRequestDispatcher("ReservationsManager.jsp").forward(request, response);
                } catch (Exception e) {
                    response.sendRedirect("errorPage.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String preOrderIDStr = request.getParameter("preOrderID");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String tableIDStr = request.getParameter("tableID");
        String bookDateStr = request.getParameter("book_date");
        String numberOfPeopleStr = request.getParameter("number_of_people");
        String timeStr = request.getParameter("time");
        String status = request.getParameter("status");

        String errorMessage = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        try {
            int preOrderID = Integer.parseInt(preOrderIDStr);
            int tableID = Integer.parseInt(tableIDStr);
            int numberOfPeople = Integer.parseInt(numberOfPeopleStr);
            Date bookDate = dateFormat.parse(bookDateStr);
            Date time = timeFormat.parse(timeStr);

            PreOrder preOrder = new PreOrder(preOrderID, tableID, name, phone, bookDate, numberOfPeople, time, status);
            PreOrderDAO dao = new PreOrderDAO();
            dao.updatePreOrder(preOrder);

            response.sendRedirect("ManagerProcessing");
        } catch (ParseException | NumberFormatException  e) {
            errorMessage = "Invalid input: " + e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ReservationsManager.jsp").forward(request, response);
        } catch (Exception e) {
            errorMessage = "Error updating pre-order: " + e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ReservationsManager.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
