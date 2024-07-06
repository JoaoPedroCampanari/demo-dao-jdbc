package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDeparment {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("Test 1: insert department");
        departmentDao.insert(new Department(null,"Vendas"));
        System.out.println("Insert completed!");

        System.out.println("Test 2: update department");
        departmentDao.update(new Department(10,"Carros"));
        System.out.println("Update completed!");

    }
}
