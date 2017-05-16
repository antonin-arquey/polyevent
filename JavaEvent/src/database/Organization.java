package database;

import java.util.HashSet;

/**
 * Created by Antonin ARQUEY on 15/05/17.
 */
public class Organization extends Creator {

    private String name;
    private User leader;
    private HashSet<User> members;

    public Organization(long id, String name, User leader, HashSet<User> members) {
        super(id);
        this.name = name;
        this.leader = leader;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public HashSet<User> getMembers() {
        return members;
    }

    public void setMembers(HashSet<User> members) {
        this.members = members;
    }

    public void addMember(User u){
        this.members.add(u);
    }

}
