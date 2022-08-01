package servlets;

import services.LoginService;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = { "/login" } )
public class LoginServlet extends HttpServlet {

    final LoginService loginService;
    public LoginServlet() {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean loginStatus = loginService.login(email,password);
        if ( loginStatus ) {
            resp.sendRedirect(Util.base_url+"dashboard.jsp");
        }else {
            req.setAttribute("error", "E-mail or Password Fail");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
            dispatcher.forward(req, resp);
        }

    }

}
