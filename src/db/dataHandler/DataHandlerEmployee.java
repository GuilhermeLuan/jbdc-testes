package db.dataHandler;

import db.DB;
import db.DbException;

import java.sql.*;

import static db.DB.*;

public class DataHandlerEmployee implements DataHandler {
    @Override
    public void getData(String dbTable){
        String sqlQuery = "SELECT * FROM " + dbTable;
        ResultSet resultSet = DbHandler.executeQuery(sqlQuery);


        try {
            DB.getConnection();
            System.out.println("Informações dos funcionarios: \n");

            while (resultSet.next()){

                int id = resultSet.getInt("Id");

                String nome = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                String date = resultSet.getString("BirthDate");
                double salary = resultSet.getDouble("BaseSalary");
                int departmentId = resultSet.getInt("DepartmentId");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("Date: " + date);
                System.out.println("Salary: " + salary);
                System.out.println("Department Id: " + departmentId);
                System.out.println("-------------------------");

            }
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            closeResultSet(resultSet);
        }
    }



}
