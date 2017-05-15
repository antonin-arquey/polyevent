package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by antonin on 13/05/17.
 */
public class UserService {
    Connection cn;
    String url = "jdbc:mysql://localhost:3306/Polytech_Event";
    String utilisateur = "java";
    String password = "events";

    public void getOne(){
        try{
            cn = DriverManager.getConnection(url, utilisateur, password);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(cn != null){
                try {
                    cn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
