package application;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {



        Department obj = new Department(1,"Books");

        Seller seller = new Seller(1, "Joao", "Joao@gmail.com", LocalDate.parse("03/02/2004",Seller.formatter), 6000.0, obj);

        System.out.println(seller);

    }
}
