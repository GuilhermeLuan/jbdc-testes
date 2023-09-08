package application;

import db.DataHandlerDepartment;
import db.dataHandler.DataHandler;
import db.dataHandler.DataHandlerEmployee;

import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Qual tabela do banco de dados quer consultar? (department/seller) ");
        String dbTable = sc.next().toLowerCase();


        if(Objects.equals(dbTable, "seller")){
            DataHandler dataHandlerEmployee = new DataHandlerEmployee();
            dataHandlerEmployee.getData(dbTable);
        }
        else {
            DataHandler dataHandlerDepartment = new DataHandlerDepartment();
            dataHandlerDepartment.getData(dbTable);
        }

        sc.close();
    }
}