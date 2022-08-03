package servlets;

import config.HibernateUtil;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import props.Admin;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "personServlet", value = { "/parsonSave" })
public class PersonServlet extends HttpServlet {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Admin admin = (Admin) req.getAttribute("admin");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String stAge = req.getParameter("age");
        String phone = req.getParameter("phone");
        int age = Integer.parseInt(stAge);

        Person person = new Person();
        person.setAid( admin.getAid() );
        person.setEmail(email);
        person.setName(name);
        person.setAge(age);
        person.setPhone(phone);

        Session sesi = sf.openSession();
        Transaction tr = sesi.beginTransaction();

        sesi.save(person);
        tr.commit();
        sesi.close();

        resp.sendRedirect(Util.base_url+"dashboard.jsp");

    }
}
