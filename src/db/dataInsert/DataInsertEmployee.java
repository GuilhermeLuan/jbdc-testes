package db.dataInsert;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataInsertEmployee{
    private static PreparedStatement preparedStatement = null;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void insertData(Connection connection, String employeeName, String employeeEmail, String birthDate, Double salary, int departmentId) {
        String sql = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES ( ?, ?, ?, ?, ?)";
        java.sql.Date birthDateSQL;

        try {
            birthDateSQL = new java.sql.Date(simpleDateFormat.parse(birthDate).getTime());
        } catch (ParseException e) {
            throw new DbException(e.getMessage());
        }

        DataInsert.insertData(connection, sql, employeeName, employeeEmail, birthDateSQL, salary, departmentId);
    }
}
