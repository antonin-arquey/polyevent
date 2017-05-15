package database;

/**
 * Created by antonin on 13/05/17.
 */
public class DatabaseInitializer {

    public DatabaseInitializer(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Database driver not working");
        }
    }

}
