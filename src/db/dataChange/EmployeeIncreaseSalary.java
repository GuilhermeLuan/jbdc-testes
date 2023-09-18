package db.dataChange;

import db.DB;
import db.DbException;
import db.dataInsert.DataInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//"UPDATE seller " +
//        "SET BaseSalary = BaseSalary * ((? /100) + 1) " +
//        "WHERE " +
//        "(Id = ?)"
public class EmployeeIncreaseSalary extends DataChange {

    public static void increaseSalary(Connection connection, Double increasePercentage, Integer employeeId ){
        String sql = "UPDATE seller " +
        "SET BaseSalary = BaseSalary * ((? /100) + 1) " +
        "WHERE " +
        "(Id = ?)";

        DataChange.dataChange(connection, sql, increasePercentage, employeeId);
    }

}
