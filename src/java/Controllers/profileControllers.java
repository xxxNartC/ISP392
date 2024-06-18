package Controllers;

import DAL.UserDao;
import Model.Account;
import Model.Users;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class profileControllers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Your existing processRequest logic, if any
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession(true);
        // Retrieve the user parameter from the request
        String user_r = request.getParameter("account");

        // Assuming DAO is a class that interacts with the database
        UserDao dao = new UserDao();

        // Fetch the Customer object based on the user_r parameter
        Users user1 = (Users) ss.getAttribute("user");
        try {
            user1 = dao.getUserByUsername(user_r);
        } catch (SQLException ex) {
            Logger.getLogger(profileControllers.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Set the retrieved Customer object as a request attribute
        ss.setAttribute("pro", user1);

        // Forward the request to profile.jsp for displaying the profile
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); // You can implement doPost if needed
    }

    @Override
    public String getServletInfo() {
        return "Profile Servlet";
    }
}
