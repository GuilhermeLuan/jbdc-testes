package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static Connection getConnection(){
           if(connection == null){
               try {
                   Properties properties = loadProperties();
                   String url = properties.getProperty("dburl");
                   connection = DriverManager.getConnection(url, properties);
               }
               catch (SQLException e){
                   throw new DbException(e.getMessage());
               }
           }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Properties loadProperties(){
        try(FileInputStream file = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(file);
            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
