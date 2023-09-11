package db.dataInsert;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataInsertDepartment {
    private PreparedStatement preparedStatement = null;

    public void insertData(Connection connection, String departmentName ) {
        try {

            String sql = "INSERT INTO department (Name) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, departmentName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }
}
