package application;

import db.DB;
import db.DataHandlerDepartment;
import db.DbException;
import db.dataHandler.DataHandler;
import db.dataHandler.DataHandlerEmployee;
import db.dataInsert.DataInsert;
import db.dataInsert.DataInsertDepartment;
import db.dataInsert.DataInsertEmployee;

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
        Scanner sc = new Scanner(System.in);
        int dbTable = 0;

        while (dbTable != 5) {
            System.out.print("----------- Bancos de dados -----------\n" +
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

                System.out.println("Insira os dados do novo Funcionario:");
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

                DataInsertEmployee dataInsertEmployee = new DataInsertEmployee();
                dataInsertEmployee.insertData(connection, employeeName, employeeEmail, birtDate, salary, departmentId);
            } else if (Objects.equals(dbTable, 4)) {
                Connection connection = DB.getConnection();

                System.out.println("Insira os dados do novo Departamento: ");

                System.out.print("Nome do departamento: ");
                String departmentName = sc.next();

                DataInsertDepartment dataInsertDepartment = new DataInsertDepartment();
                dataInsertDepartment.insertData(connection, departmentName);
            }

        }
        DB.getConnection();
        sc.close();
    }
}