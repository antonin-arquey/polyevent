package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by antonin on 15/05/17.
 */
public class ConnectionMySQL {

    private static final String url = "jdbc:mysql://localhost:3306/Polytech_Event?autoReconnect=true";

    private static final String user = "java";

    private static final String password = "events";

    private static Connection connection = null;

    /* Constructeur privé */
    private ConnectionMySQL() {};

    public static Connection getInstance() throws DAOConfigurationException{
        if (connection == null){
            try{
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e){
                throw new DAOConfigurationException(e);
            }
        }
        return connection;
    }
}
