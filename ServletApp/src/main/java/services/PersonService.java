package services;

import config.HibernateUtil;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import props.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PersonService {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    public List<Person> allPerson(HttpServletRequest request) {
        Session sesi = sf.openSession();
        Admin admin = (Admin) request.getAttribute("admin");
        List<Person> ls = sesi
                .createQuery("from Person where aid = ?1")
                .setParameter(1, admin.getAid())
                .list();
        return ls;
    }

}
