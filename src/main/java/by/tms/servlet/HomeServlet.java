package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }

    //init
    //service
    //destroy

//    @Override
//    public void init() throws ServletException {
//        System.out.println("Init first");
//    }

    //ServletContext
    //Session scope
    //Request scope

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            System.out.println(parameterNames.nextElement());
//        }


//        req.getSession().setAttribute("name", "Hello World!");
//        resp.getWriter().println("Hello");
//        req.setAttribute("name", req.getParameter("name"));
//        getServletContext().getRequestDispatcher("/second").forward(req, resp);
//        HttpSession session = req.getSession();
//        session.setAttribute("name", req.getParameter("name"));

//        String num1 = req.getParameter("num1");
//        String num2 = req.getParameter("num2");
//        String type = req.getParameter("type");
//
//        double result = 0;
//
//        switch (type) {
//            case "sum":
//                result = sum(Double.parseDouble(num1), Double.parseDouble(num2));
//                break;
//        }
//
//        resp.getWriter().println(result);
    }

//    private double sum(double a, double b) {
//        return a + b;
//    }

//    @Override
//    public void destroy() {
//        System.out.println("Destroy");
//    }
}
