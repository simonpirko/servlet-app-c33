package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/second", loadOnStartup = 0)
public class SecondServlet extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        System.out.println("Init second");
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = (String) getServletContext().getAttribute("name");
//        String name = (String) req.getSession().getAttribute("name");
//        String name = (String) req.getAttribute("name");
//        resp.getWriter().println(name);
    }
}
