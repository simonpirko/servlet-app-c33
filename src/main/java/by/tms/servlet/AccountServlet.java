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
    private static final String INVALID_NAME_FIELD = "short name field!";
    private static final String INVALID_PASSWORD_FIELD = "short password field";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        UserService userService = UserServiceImpl.getInstance((Connection) session.getAttribute("connection"));
        User user =(User) session.getAttribute("user");
        String value = req.getParameter("value");

        if (req.getParameter("field").equals("name")) {
            if (checkField(value)){
                user.setName(value);
            }else{
                req.setAttribute("message", INVALID_NAME_FIELD);
                req.getRequestDispatcher("/account.jsp").forward(req, resp);
                return;
            }
        }
        if (req.getParameter("field").equals("password")) {
            if (checkField(value)){
                user.setPassword(value);
            }else{
                req.setAttribute("message", INVALID_PASSWORD_FIELD);
                req.getRequestDispatcher("/account.jsp").forward(req, resp);
                return;
            }
        }
        userService.update(user);
        resp.sendRedirect("/");
    }

    private boolean checkField(String field) {
        return field.length() > 5;
    }
}
