package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private String driver = "org.h2.Driver";
    private String url = "jdbc:h2:file:~/turkcell_ee_2;OLD_INFORMATION_SCHEMA=TRUE";
    private String username = "sa";
    private String password = "sa";

    private Connection conn = null;

    public Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Success");
        }catch (Exception ex) {
            System.err.println("getConn Error : " + ex);
        }
        return conn;
    }


}
