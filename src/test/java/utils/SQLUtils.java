package utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class SQLUtils {
    public static ResultSet sqlRequest(String url, String username, String password, String request){
        ResultSet result = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            result = statement.executeQuery(request);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
