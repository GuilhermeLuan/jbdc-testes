package db.dataInsert;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataInsertDepartment extends DataInsert{
    private static PreparedStatement preparedStatement = null;

    public static void insertData(Connection connection, String departmentName ) {
            String sql = "INSERT INTO department (Name) VALUES (?)";
            DataInsert.insertData(connection, sql, departmentName);

    }
}
