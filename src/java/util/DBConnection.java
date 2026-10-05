package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USER =
            System.getenv("AUTOCARE_DB_USER");

    private static final String PASSWORD =
            System.getenv("AUTOCARE_DB_PASSWORD");

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println(
                    "Database Connected Successfully!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}