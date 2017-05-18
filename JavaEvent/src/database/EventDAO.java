package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;

/**
 * Created by Antonin ARQUEY on 18/05/17.
 */
public class EventDAO extends DAO<Event>{
    @Override
    public Event find(long id) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Event event = null;
        final String query = "SELECT * FROM Events WHERE id = ?";

        try {
            preparedStatement = initializePreparedStatement(query, false, id);
            result = preparedStatement.executeQuery();

            if(result.next()){
                event = map(result);
            } else {
                throw new DAOException("Impossible de trouver cet evenement");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, result);
        }
        return event;
    }

    @Override
    public Event create(Event obj) throws DAOException {
        return null;
    }

    @Override
    public Event update(Event obj) throws DAOException {
        return null;
    }

    @Override
    public void delete(Event obj) throws DAOException {

    }

    private Event map(ResultSet res) throws SQLException{
        UserDAO userDAO = new UserDAO();
        User creator = userDAO.find(res.getLong("creator_id"));
        String name = res.getString("name");
        String summary = res.getString("summary");
        long id = res.getLong("id");
        Timestamp created_at = res.getTimestamp("created_at");
        Timestamp dateEvent = res.getTimestamp("dateEvent");
        HashSet<User> participants = getParticipants(id);
        return new Event(id, name, summary, creator, created_at, dateEvent, participants);
    }

    private HashSet<User> getParticipants(long id) throws SQLException{
        HashSet<User> participants = new HashSet<>();
        UserDAO userDAO = new UserDAO();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        final String query = "SELECT creator_id, email, password, firstName, lastName, departement FROM User, Events, Participants WHERE Participants.event = ? AND User.creator_id = Participants.user";
        try {
            preparedStatement = initializePreparedStatement(query, false, id);
            result = preparedStatement.executeQuery();
            while(result.next()){
                participants.add(userDAO.map(result));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close(preparedStatement, result);
        }
        return participants;
    }
}
