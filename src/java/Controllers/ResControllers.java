package Controllers;

import DAL.PreOrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ResControllers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("viewRes.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String bookDate = request.getParameter("book_date");
        String tableNumber = request.getParameter("table_number");
        String bookTime = request.getParameter("book_time");

        // Basic validation
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        if (name == null || name.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Name is required.\\n");
        }
        if (email == null || email.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Email is required.\\n");
        }
        if (phone == null || phone.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Phone is required.\\n");
        }
        if (bookDate == null || bookDate.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Booking date is required.\\n");
        }
        if (tableNumber == null || tableNumber.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Table number is required.\\n");
        }
        if (bookTime == null || bookTime.trim().isEmpty()) {
            isValid = false;
            errorMessage.append("Booking time is required.\\n");
        }

        if (isValid) {
            // Convert bookDate and bookTime to Date object
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date bookDateTime = null;
            try {
                bookDateTime = dateTimeFormat.parse(bookDate + " " + bookTime);
            } catch (ParseException e) {
                isValid = false;
                errorMessage.append("Invalid date or time format.\\n");
            }

            if (isValid) {
                // Set request attributes to forward to review page
                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("bookDate", bookDate);
                request.setAttribute("tableNumber", tableNumber);
                request.setAttribute("bookTime", bookDateTime);

                PreOrderDAO pre = new PreOrderDAO();
                try {
                    pre.addPreOrder2(Integer.parseInt(tableNumber), name, email, phone, bookDateTime);
                    // Forward to the review page
                    request.getRequestDispatcher("viewRes.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    errorMessage.append("Database error: " + e.getMessage() + "\\n");
                    generateErrorPopup(response, errorMessage.toString());
                }
            } else {
                generateErrorPopup(response, errorMessage.toString());
            }
        } else {
            generateErrorPopup(response, errorMessage.toString());
        }
    }

    private void generateErrorPopup(HttpServletResponse response, String message) throws IOException {
        String popupHtml = "<script>"
                + "alert('Reservation failed!\\n" + message + "');"
                + "window.history.back();"
                + "</script>";
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(popupHtml);
    }

    @Override
    public String getServletInfo() {
        return "Reservation Controller";
    }
}
