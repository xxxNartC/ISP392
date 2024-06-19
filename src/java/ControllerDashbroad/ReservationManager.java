package ControllerDashbroad;

import DAL.PreOrderDAO;
import Model.PreOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            out.println("<h1>Servlet ReservationManager at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("ReservationManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String bookDateStr = request.getParameter("book_date");
        String numberOfPeopleStr = request.getParameter("number_of_people");

        String errorMessage = null;
        Date bookDate = null;
        int numberOfPeople = 0;

        if (name == null || name.trim().isEmpty()) {
            errorMessage = "Tên không được để trống";
        } else if (phone == null || phone.trim().isEmpty()) {
            errorMessage = "Số điện thoại không được để trống";
        } else if (bookDateStr == null || bookDateStr.trim().isEmpty()) {
            errorMessage = "Ngày đặt bàn không được để trống";
        } else if (numberOfPeopleStr == null || numberOfPeopleStr.trim().isEmpty()) {
            errorMessage = "Số lượng người không được để trống";
        } else {
            try {
                numberOfPeople = Integer.parseInt(numberOfPeopleStr);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                bookDate = dateFormat.parse(bookDateStr);
                Date currentDate = new Date();
                if (bookDate.before(currentDate)) {
                    errorMessage = "Ngày đặt bàn phải là ngày trong tương lai";
                }
            } catch (NumberFormatException e) {
                errorMessage = "Số lượng người phải là số nguyên hợp lệ";
            } catch (ParseException e) {
                errorMessage = "Lỗi khi phân tích ngày tháng";
            }
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("reservation.jsp").forward(request, response);
            return;
        }

        String status = "Đang chờ";
        PreOrder preOrder = new PreOrder(0, 0, name, phone, bookDate, numberOfPeople, new Date(), status);
        PreOrderDAO preOrderDao = new PreOrderDAO();
        int result = preOrderDao.createPreOrder(preOrder);

        if (result > 0) {
            response.sendRedirect("ReservationManager?success=Đặt bàn thành công");
        } else {
            response.sendRedirect("ReservationManager?error=Đặt bàn thất bại");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
  
    
    