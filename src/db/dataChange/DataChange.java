package db.dataChange;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

public class DataChange {
    private static PreparedStatement preparedStatement = null;

    public static void dataChange(Connection connection, String sql, Object... params){
        try {
            preparedStatement = connection.prepareStatement(sql);
        }

    }

}
