package db.dataDelete;

import db.dataChange.DataChange;

import java.sql.Connection;

public class DataDeleteEmployee extends DataChange {
    public static void deleteEmployee(Connection connection, Integer employeeId){
        String sql = "DELETE FROM seller " +
                "WHERE " +
                "Id = ?";

        dataChange(connection, sql, employeeId);
    }
}
