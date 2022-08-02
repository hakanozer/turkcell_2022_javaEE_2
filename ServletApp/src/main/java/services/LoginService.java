package services;

import utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginService {

    // DB...

    public boolean login( String email, String password ) {
        DB db = new DB();
        boolean status = false;
        try {
            String sql = "select * from admin where email = ? and password = ?";
            //String sql = " select * from admin where email = '"+email+"' and password = '"+password+"' ";
            // select * from admin where email = 'a@a.com' and password = '' or 1 = 1 --'
            // Statement st = db.getConn().createStatement();
            PreparedStatement st = db.getConn().prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            status = rs.next();
            if ( status ) {
                System.out.println("Giriş Başarılı");
            }else {
                System.out.println("Kullanıcı bilgileri hatalı!");
            }
        }catch (Exception ex) {
            System.err.println("login Error : " + ex);
        }
        return status;
    }

}
