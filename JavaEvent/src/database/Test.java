package database;

import java.sql.Connection;
import java.sql.Timestamp;

/**
 * Created by antonin on 13/05/17.
 */
public class Test {

    public static void main(String[] args){
        UserDAO userDAO = new UserDAO();
        OrganizationDAO organizationDAO = new OrganizationDAO();
        EventDAO eventDAO = new EventDAO();

        User rene = new User("rene@lol.fr", "René", "Lenc", "INFO", "petitebitedu23");
        userDAO.create(rene);

        Event gouter = new Event("Gouter chez rene", "Petit gouter chez moi avec des gateaux", "2 rue des coquelicots", rene, new Timestamp(System.currentTimeMillis() + 1000000));
        eventDAO.create(gouter);

        Organization idesys = new Organization("Idesys", rene);
        organizationDAO.create(idesys);
    }
}
