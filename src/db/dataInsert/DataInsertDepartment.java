package db.dataInsert;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataInsertDepartment extends DataInsert{
    private static PreparedStatement preparedStatement = null;

    public static void insertData(Connection connection, String departmentName ) {
            String sql = "INSERT INTO department (Name) VALUES (?)";
            DataInsert.insertData(connection, sql, departmentName);

    }
}
