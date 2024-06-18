/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.PreOrderDAO;
import Model.PreOrder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
@WebServlet(name = "PreOrderController", urlPatterns = {"/PreOrderController"})
public class PreOrderController extends HttpServlet {

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
            out.println("<title>Servlet PreOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PreOrderController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("reservation.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String bookDateStr = request.getParameter("book_date");
        String numberOfPeopleStr = request.getParameter("number_of_people");

        String errorMessage = null;
        Timestamp timestamp = null;
        int numberOfPeople = 0;
        if (name == null || name.trim().isEmpty()) {
            errorMessage = "Name cannot be empty";
        } else if (email == null || email.trim().isEmpty()) {
            errorMessage = "Email cannot be empty";
        } else if (!isValidEmail(email)) {
            errorMessage = "Email is not valid";
        } else if (phone == null || phone.trim().isEmpty()) {
            errorMessage = "Phone number cannot be empty";
        } else if (!isValidPhoneNumber(phone)) {
            errorMessage = "Phone number is not valid";
        } else if (bookDateStr == null || bookDateStr.trim().isEmpty()) {
            errorMessage = "Booking date cannot be empty";
        } else if (numberOfPeopleStr == null || numberOfPeopleStr.trim().isEmpty()) {
            errorMessage = "Number of people cannot be empty";
        } else {
            try {
                numberOfPeople = Integer.parseInt(numberOfPeopleStr);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                Date bookDate = dateFormat.parse(bookDateStr);
                Date currentDate = new Date();
                if (bookDate.before(currentDate)) {
                    errorMessage = "Booking date must be in the future";
                }
                timestamp = new Timestamp(bookDate.getTime());
            } catch (NumberFormatException e) {
                errorMessage = "Number of people must be a valid integer";
            } catch (ParseException e) {
                errorMessage = "Error parsing date";
            }
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/reservation.jsp").forward(request, response);
            return;
        }
        int status = 0;
        PreOrder preOrder = new PreOrder(0, 0, name, phone, email, timestamp, numberOfPeople, status);
        PreOrderDAO preOrderDao = new PreOrderDAO();
        int result = preOrderDao.createPreOrder(preOrder);
        if(result > 0) {
            response.sendRedirect("PreOrderController?success=Preorder successfullly");
        } else {
            response.sendRedirect("PreOrderController?error=Preorder fail");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String phone) {
        String regex = "^0\\d{9}$";
        return phone.matches(regex);
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
