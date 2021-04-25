package servlet;

import entity.User;
import exception.user.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req,resp);
        }else {
            resp.getWriter().println("Please sign in or register new account.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String new_password = req.getParameter("new_password");
        String repeated_new_password = req.getParameter("repeated_new_password");
        User user = (User) req.getSession().getAttribute("user");
        try {
            userService.updatePassword(user,new_password,repeated_new_password);
            req.setAttribute("upmessage","Your password successfully edit.");
        } catch (UserException e) {
            req.setAttribute("upmessage",e.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req,resp);
    }
}
