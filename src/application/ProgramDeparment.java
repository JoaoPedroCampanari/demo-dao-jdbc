package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

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
        departmentDao.deleteById(16);
        System.out.println("Delete completed!");

        System.out.println("Teste 4: findById");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("Teste 5: findAll");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

    }
}
