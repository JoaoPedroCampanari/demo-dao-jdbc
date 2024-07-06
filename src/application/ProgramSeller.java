package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProgramSeller {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSallerDao();

        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment =====");

        List<Seller> list = sellerDao.findByDepartment(new Department(2,"dasdsad"));

        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll =====");

        List<Seller> listAll = sellerDao.findAll();

        listAll.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert =====");

        Seller  seller1 = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.0, new Department(2, null));

        sellerDao.insert(seller1);

        System.out.println("Inserted! new id = "+ seller1.getId());

        System.out.println("\n=== TEST 5: seller update =====");

        seller = sellerDao.findById(1);
        seller.setName("Marta Waine");

        sellerDao.update(seller);

        System.out.println("Update Completed!");

        System.out.println("\n=== TEST 6: seller delete =====");
        System.out.println("Enter id for delete teste: ");
        int id = sc.nextInt();

        sellerDao.deleteById(id);

        System.out.println("Delete completed");

        sc.close();

    }
}
