package db.dataInsert;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsert {
    private static PreparedStatement preparedStatement = null;

    public static void insertData(Connection connection, String sql, Object... params){
        try {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closePreparedStatement(preparedStatement);
        }

    }
}
