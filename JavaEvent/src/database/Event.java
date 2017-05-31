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
    private int max_participants;
    private Timestamp created_at;
    private Timestamp date_event;
    private HashSet<User> participants;
    private User creator;
    private String lieu;
    private boolean idChanged;

    public Event(String name, String summary, String lieu, User creator, Timestamp date_event, int max_participants) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.summary = summary;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.date_event = date_event;
        this.participants = new HashSet<>();
        this.lieu = lieu;
        this.max_participants = max_participants;
        idChanged = true;
    }

    public Event(long id, String name, String summary, String lieu, User creator, Timestamp date_event, HashSet<User> participants, int nb_participants) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.summary = summary;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.date_event = date_event;
        this.participants = participants;
        this.lieu = lieu;
        this.max_participants = nb_participants;
        idChanged = false;
    }

    public Event(long id, String name, String summary, String lieu, User creator, Timestamp created_at, Timestamp date_event, HashSet<User> participants, int nb_participants) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.summary = summary;
        this.created_at = created_at;
        this.date_event = date_event;
        this.participants = participants;
        this.lieu = lieu;
        this.max_participants = nb_participants;
        idChanged = false;
    }

    public Event(String name, String summary, String lieu, User creator, Timestamp created_at, Timestamp date_event, int nb_participants) {
        this.id = -1;
        this.name = name;
        this.creator = creator;
        this.summary = summary;
        this.created_at = created_at;
        this.date_event = date_event;
        this.lieu = lieu;
        this.max_participants = nb_participants;
        this.idChanged = true;
    }

    public User getCreator() {
        return creator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (idChanged) {
            this.id = id;
            idChanged = false;
        }
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
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

    public int getMax_participants() {
		return max_participants;
	}

	public void setMax_participants(int nb_participants) {
		this.max_participants = nb_participants;
	}

	public void setParticipants(HashSet<User> participants) {
        this.participants = participants;
    }

    public void addParticipant(User u){
        if (!this.participants.contains(u))
            this.participants.add(u);
    }

    public void removeParticipants(User u){
        this.participants.remove(u);
    }
}
