package database;

/**
 * Created by antonin on 15/05/17.
 */
public class User extends Creator{
    private String email;
    private String firstName;
    private String lastName;
    private String departement;
    private String password;

    public User(long id) {
        super(id);
    }

    public User(long id, String email, String firstName, String lastName, String departement, String password) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departement = departement;
        this.password = password;
    }

    public User(String email, String firstName, String lastName, String departement, String password){
        this.id = -1;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departement = departement;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departement='" + departement + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
