package by.tms.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalcServlet")
public class CalcFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
//            Cookie[] cookies = req.getCookies();
//            Cookie cookie = cookies[0];
//            res.addCookie(new Cookie());
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/google");
        }
    }
}
