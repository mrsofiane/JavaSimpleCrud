import com.mrsofiane.jdbcjavaproject.dao.EmployeeDao;
import com.mrsofiane.jdbcjavaproject.dao.EmployeeDaoImpl;
import com.mrsofiane.jdbcjavaproject.model.Employee;
import com.mrsofiane.jdbcjavaproject.model.EmployeeBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class MyUnitTest {

    EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Test
    public void testCreate() throws Exception {
        Employee employee = new EmployeeBuilder()
                .name("Mr Ahmed")
                .gender(true)
                .salary(1800)
                .build();

        Assert.assertEquals("mr ahmed",employee.getName().toLowerCase());
    }

    @Test
    public void testFindByid() throws Exception {
        Employee employee = employeeDao.findById(1);
        Assert.assertEquals("mr sofiane",employee.getName().toLowerCase());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Employee> employees = employeeDao.findAll();
        Assert.assertEquals(4,employees.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Employee employee = new EmployeeBuilder()
                .id(1)
                .name("Mr soso")
                .gender(true)
                .salary(2500)
                .build();
        Assert.assertEquals("mr soso",employee.getName().toLowerCase());
    }

    @Test
    public void testDeleteById() throws Exception {
        List<Employee> employeesBefore = employeeDao.findAll();
        employeeDao.deleteById(2);
        List<Employee> employeesAfter = employeeDao.findAll();
        Assert.assertNotEquals(employeesBefore.size(),employeesAfter.size());
    }

}
