package services;

import utils.DB;

public class LoginService {

    // DB...

    public boolean login( String email, String password ) {
        DB db = new DB();
        db.getConn();
        if ( email.equals("ali@mail.com") && password.equals("12345") ) {
            return  true;
        }
        return false;
    }

}
