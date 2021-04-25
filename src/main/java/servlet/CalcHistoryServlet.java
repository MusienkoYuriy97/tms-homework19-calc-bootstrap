package servlet;

import entity.User;
import service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history")
public class CalcHistoryServlet extends HttpServlet {
    CalcService calculatorService = new CalcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null){
            User userInSession = (User)req.getSession().getAttribute("user");
            req.setAttribute("operations",calculatorService.getOperationByUsername(userInSession.getUsername()));
            getServletContext().getRequestDispatcher("/WEB-INF/history.jsp").forward(req,resp);
        }else{
            resp.getWriter().println("Please sign in or register new account.");
        }
    }
}
