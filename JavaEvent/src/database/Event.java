package database;

import java.sql.Timestamp;
import java.util.HashSet;
/**
 * Created by antonin on 15/05/17.
 */
public class Event {

    private long id;
    private String name;
    private String summary;
    private Timestamp created_at;
    private Timestamp date_event;
    private HashSet<User> participants;
    private User creator;

    public Event(long id, String name, String summary, User creator, Timestamp created_at, Timestamp date_event, HashSet<User> participants) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.summary = summary;
        this.created_at = created_at;
        this.date_event = date_event;
        this.participants = participants;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getDate_event() {
        return date_event;
    }

    public void setDate_event(Timestamp date_event) {
        this.date_event = date_event;
    }

    public HashSet<User> getParticipants() {
        return participants;
    }

    public void setParticipants(HashSet<User> participants) {
        this.participants = participants;
    }

    public void addParticipant(User u){
        this.participants.add(u);
    }
}
