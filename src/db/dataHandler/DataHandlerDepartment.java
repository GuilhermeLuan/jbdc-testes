package db;

import db.dataHandler.DataHandler;
import db.dataHandler.DbHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataHandlerDepartment implements DataHandler {
    @Override
    public void getData(String dbTable) {
        String sqlQuery = "SELECT * FROM " + dbTable;
        ResultSet resultSet = DbHandler.executeQuery(sqlQuery);



        try {
            System.out.println("Informações do Departamento: \n");
            while (resultSet.next()){
                int departmentId = resultSet.getInt("Id");
                String name = resultSet.getString("Name");

                System.out.println("Id do departamento: " + departmentId);
                System.out.println("Nome do departamento: " + name);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeConnection();
        }

    }
}

