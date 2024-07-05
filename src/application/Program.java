package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSallerDao();

        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

    }
}
