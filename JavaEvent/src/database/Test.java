package database;

import java.sql.Connection;

/**
 * Created by antonin on 13/05/17.
 */
public class Test {

    public static void main(String[] args){
        UserDAO test = new UserDAO();
        //System.out.println(test.find("jackie@gmail.com"));
        User rene = new User("rene@lol.fr", "René", "Lenc", "INFO", "petitebitedu23");
        test.create(rene);
        System.out.println(rene);
        rene.setDepartement("GAY");
        test.update(rene);
        System.out.println(rene);
        test.delete(rene);
    }
}
