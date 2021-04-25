package servlet;

import exception.user.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/reg.jsp").forward(req,resp);
        }else {
            resp.getWriter().println("You are in action account." +
                    "If you want to register a new account please log out.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        //default
        int age;
        try {
            age = Integer.parseInt(req.getParameter("age"));
        }catch (NumberFormatException e){
            age = -1;
        }
        String password = req.getParameter("password");

        try {
            userService.userRegister(username,fname,lname,age,password);
            req.setAttribute("rmessage","User " + username + " is successfully registered.");
        } catch (UserException e) {
            req.setAttribute("rmessage",e.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/reg.jsp").forward(req,resp);
    }

}
