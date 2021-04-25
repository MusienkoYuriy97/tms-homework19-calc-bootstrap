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

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(req,resp);
        if (req.getSession().getAttribute("user") != null){
            req.setAttribute("users",userService.getUsersList());
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(req,resp);
        }else{
            resp.getWriter().println("Please sign in or register new account.");
        }
    }
}

