package by.tms.servlet;

import by.tms.dao.UserDao;
import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {
    private static final String INVALID_LOGIN = "Invalid login!";
    private static final String INVALID_PASSWORD = "Invalid password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService userService = UserServiceImpl.getInstance((Connection) req.getSession().getAttribute("connection"));
        User user;
        if (userService.containUserByLogin(login)) {
            user = userService.getUserByLogin(login);
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/");
                return;
            }else{
                req.setAttribute("message", INVALID_PASSWORD);
            }
        }else{
            req.setAttribute("message", INVALID_LOGIN);
        }
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }
}
