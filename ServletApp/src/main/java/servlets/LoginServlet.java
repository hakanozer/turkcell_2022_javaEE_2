package servlets;

import props.Admin;
import services.LoginService;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = { "/login", "/logout" } )
public class LoginServlet extends HttpServlet {

    final LoginService loginService;
    public LoginServlet() {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Remember
        String remember = req.getParameter("remember");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Admin admin = loginService.login(email,password);
        if ( admin != null ) {
            // create Session
            req.getSession().setAttribute("user", admin);

            // Remember Control and Cookie Create
            if ( "on".equals(remember) ) {
                Cookie cookie = new Cookie("user", Util.sifrele(""+admin.getAid(), 3) );
                cookie.setMaxAge(60 * 60);
                resp.addCookie(cookie);
            }

            resp.sendRedirect(Util.base_url+"dashboard.jsp");
        }else {
            req.setAttribute("error", "E-mail or Password Fail");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
            dispatcher.forward(req, resp);
        }

    }


    // logout
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session  remove
        req.getSession().removeAttribute("user");

        // cookie delete
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        resp.sendRedirect(Util.base_url);
    }
}
