package db.dataChange;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeIncreaseSalary {
    public static void increaseSalary(double salaryIncreasePercentage, int employeeID){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE seller " +
                    "SET BaseSalary = BaseSalary * ((? /100) + 1) " +
                    "WHERE " +
                    "(Id = ?)");

            preparedStatement.setDouble(1, salaryIncreasePercentage);
            preparedStatement.setInt(2, employeeID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closePreparedStatement(preparedStatement);
        }
    };
}
