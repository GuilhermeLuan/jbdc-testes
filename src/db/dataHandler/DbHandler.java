package db.dataHandler;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHandler  {
    public static ResultSet executeQuery(String sqlQuery) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Connection connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }
}
