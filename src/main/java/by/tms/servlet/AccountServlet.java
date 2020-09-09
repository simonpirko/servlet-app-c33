package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HomeServlet{



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        UserService userService = UserServiceImpl.getInstance((Connection) session.getAttribute("connection"));
        User user =(User) session.getAttribute("user");
        userService.update(new User(user.getId(), req.getParameter("name"), user.getLogin(), req.getParameter("password")));
        resp.sendRedirect("/");
    }
}
