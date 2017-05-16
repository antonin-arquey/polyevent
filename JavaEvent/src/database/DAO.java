package database;

import java.sql.*;

/**
 * Created by Antonin ARQUEY on 15/05/17.
 */
public abstract class DAO<T> {
    public Connection connect = ConnectionMySQL.getInstance();

    public abstract T find(long id) throws DAOException;

    public abstract T create(T obj) throws DAOException;

    public abstract T update(T obj) throws DAOException;

    public abstract void delete(T obj) throws DAOException;

    protected PreparedStatement initializePreparedStatement(String sql, boolean returnGeneratedKeys, Object... objects) throws SQLException {
        PreparedStatement preparedStatement = this.connect.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objects.length; i++ ) {
            preparedStatement.setObject( i + 1, objects[i] );
        }
        return preparedStatement;
    }

    private static void closeStatement(PreparedStatement preparedStatement){
        if (preparedStatement != null){
            try{
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Echec lors de la fermeture du Statement " + e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement preparedStatement){
        closeStatement(preparedStatement);
    }

    public static void close(PreparedStatement preparedStatement, ResultSet resultSet){
        closeStatement(preparedStatement);
        if(resultSet != null){
            try{
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Echec lors de la fermeture du ResultSet " + e.getMessage());
            }
        }
    }
}
