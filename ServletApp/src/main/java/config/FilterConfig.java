package config;

import props.Admin;
import utils.Util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        url = url.replace(Util.sub_url, "");
        System.out.println("url : " + url);

        boolean loginStatus = false;
        String[] pages = { "/", "/login", "/login.jsp" };
        for ( String item : pages ) {
            if ( url.equals( item ) ) {
               loginStatus = true;
               break;
            }
        }

        if ( !loginStatus ) {
            // session control
            boolean sessionStatus = req.getSession().getAttribute("user") == null;
            if ( sessionStatus ) {
                res.sendRedirect(Util.base_url);
            }else {
                Admin admin = (Admin) req.getSession().getAttribute("user");
                req.setAttribute("admin", admin);
            }
        }

        filterChain.doFilter(req, res);
    }

}
