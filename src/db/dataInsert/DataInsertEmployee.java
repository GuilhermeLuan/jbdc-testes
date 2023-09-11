package db.dataInsert;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataInsertEmployee{
    private PreparedStatement preparedStatement = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void insertData(Connection connection, String employeeName, String employeeEmail, String birtDate, Double salary, int departmentId) {
        try {

            String sql = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES ( ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeName);
            preparedStatement.setString(2, employeeEmail);
            preparedStatement.setDate(3, new java.sql.Date((simpleDateFormat.parse(birtDate).getTime())));
            preparedStatement.setDouble(4, salary);
            preparedStatement.setInt(5, departmentId);
            preparedStatement.executeUpdate();

        } catch (SQLException | ParseException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }
}
