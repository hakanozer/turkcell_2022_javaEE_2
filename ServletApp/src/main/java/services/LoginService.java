package services;

public class LoginService {

    // DB...

    public boolean login( String email, String password ) {
        if ( email.equals("ali@mail.com") && password.equals("12345") ) {
            return  true;
        }
        return false;
    }

}
