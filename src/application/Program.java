package application;

import db.DB;
import db.DataHandlerDepartment;
import db.DbException;
import db.dataHandler.DataHandler;
import db.dataHandler.DataHandlerEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        int dbTable = 0;

        while (dbTable != 5) {
            System.out.println("----------- Bancos de dados -----------\n" +
                    "Operação:\n" +
                    "[1] Consultar Funcionarios \n" +
                    "[2] Consultar Departamentos\n" +
                    "[3] Adicionar novo Funcionario\n" +
                    "[4] Adicionar novo Novo Departamento\n" +
                    "[5] Sair\n" +
                    "Opção: ");

            dbTable = sc.nextInt();


            if (Objects.equals(dbTable, 1)) {
                DataHandler dataHandlerEmployee = new DataHandlerEmployee();
                dataHandlerEmployee.getData("seller");
            } else if(Objects.equals(dbTable, 2)) {
                DataHandler dataHandlerDepartment = new DataHandlerDepartment();
                dataHandlerDepartment.getData("department");
            } else if (Objects.equals(dbTable, 3)) {

                System.out.println("Insira os dados dos Funcionario:");
                System.out.print("Nome: ");
                String employeeName = sc.next();
                //sc.nextLine();
                System.out.print("Email: ");
                String employeeEmail = sc.next();
                System.out.print("BirtDate: ");
                String birtDate = sc.next();
                System.out.print("BaseSalary: ");
                double salary = sc.nextDouble();
                System.out.print("Department Id: ");
                int departmentId = sc.nextInt();

                Connection connection = DB.getConnection();
                PreparedStatement preparedStatement = null;
                try {

                    String sql = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES ( ?, ?, ?, ?, ?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, employeeName);
                    preparedStatement.setString(2, employeeEmail);
                    preparedStatement.setDate(3, new java.sql.Date((simpleDateFormat.parse(birtDate).getTime())));
                    preparedStatement.setDouble(4, salary);
                    preparedStatement.setInt(5, departmentId);
                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    throw new DbException(e.getMessage());
                } finally {
                    DB.closePreparedStatement(preparedStatement);
                }
            }

        }
        DB.getConnection();
        sc.close();
    }
}