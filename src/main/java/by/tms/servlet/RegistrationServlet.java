package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.service.UserServiceImpl;
import by.tms.service.exceptions.DouplicateUserException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    private static final String DUPLICATE_USER = "This user already exist!";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        User user = new User(login, name, password);

        try {
            UserServiceImpl.getInstance((Connection) req.getSession().getAttribute("connection")).createUser(user);
        } catch (DouplicateUserException e) {
            req.setAttribute("message", DUPLICATE_USER);
            req.getRequestDispatcher("/reg.jsp").forward(req, resp);
        }

        resp.sendRedirect("/");
    }
}
