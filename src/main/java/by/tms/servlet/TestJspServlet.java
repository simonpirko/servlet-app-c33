package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/jsp")
public class TestJspServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        req.setAttribute("name", name);

        List<String> list = new ArrayList<>();

        list.add("Hello 1");
        list.add("Hello 2");
        list.add("Hello 3");
        list.add("Hello 4");

        req.setAttribute("list", list);

        req.setAttribute("flag", true);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
