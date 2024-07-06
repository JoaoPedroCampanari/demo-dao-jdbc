package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDeparment {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("Test 1: insert department");
        departmentDao.insert(new Department(null,"Moto"));
        System.out.println("Insert completed!");

        System.out.println("Test 2: update department");
        departmentDao.update(new Department(10,"Carros"));
        System.out.println("Update completed!");

        System.out.println("Test 3: delete deparment");
        departmentDao.deleteById(15);
        System.out.println("Delete completed!");

        System.out.println("Teste 4: findById");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

    }
}
