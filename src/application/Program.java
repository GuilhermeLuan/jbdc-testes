package application;

import db.DB;
import db.DataHandlerDepartment;
import db.dataHandler.DataHandler;
import db.dataHandler.DataHandlerEmployee;

import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
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
            }

        }
        DB.getConnection();
        sc.close();
    }
}