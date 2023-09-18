package db.dataDelete;

import db.dataChange.DataChange;

import java.sql.Connection;

public class DataDeleteDepartment extends DataChange {
    public static void deleteDepartment(Connection connection, Integer departmentId){
        String sql = "DELETE FROM department " +
                "WHERE " +
                "Id = ?";

        dataChange(connection, sql, departmentId);

    }
}
