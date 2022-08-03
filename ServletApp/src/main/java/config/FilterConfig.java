package config;

import org.hibernate.SessionFactory;
import props.Admin;
import services.LoginService;
import utils.Util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class FilterConfig implements Filter {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

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

            cookieControl( req, res );

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

    private void cookieControl(HttpServletRequest req, HttpServletResponse res) {
        if ( req.getCookies() != null ) {
            Cookie[] cookies = req.getCookies();
            for ( Cookie item : cookies ) {
                if ( item.getName().equals("user") ) {
                    try {
                        String val = Util.sifreCoz(item.getValue(), 3);
                        int aid  = Integer.parseInt(val);
                        LoginService service = new LoginService();
                        Admin admin = service.single( aid );
                        req.getSession().setAttribute("user", admin);
                    }catch (Exception ex) {
                        Cookie cookie = new Cookie("user", "");
                        cookie.setMaxAge(0);
                        res.addCookie(cookie);
                    }
                }
            }
        }
    }

}
