package daoInter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {

    public static Connection connection() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/task_exchange_rate";
        String username = "root";
        String password = "Joker02";
        return DriverManager.getConnection(url, username, password);
    }

}
