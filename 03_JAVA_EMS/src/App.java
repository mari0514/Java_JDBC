import java.util.List;

import dto.Employee;
import service.EmployeeService;
import service.EmployeeServiceimpl;

public class App {
    public static void main(String[] args) throws Exception {
        EmployeeService employeeService = new EmployeeServiceimpl();

        Employee employee1 = 
            new Employee(
                1, 
                "Kubilay", 
                "WMAD instructor", 
                0, 
                50000
            );

        Employee employee2 = 
            new Employee(
                2, 
                "Francois", 
                "WMAD instructor", 
                0, 
                60000
            );

        Employee employee3 = 
            new Employee(
                2, 
                "test", 
                "test", 
                0, 
                0
            );
        
        Employee employee4 = 
            new Employee(
                2, 
                "Mari", 
                "WMAD", 
                0, 
                0
            );
        


        // employeeService.addEmployee(employee1);
        // employeeService.addEmployee(employee2);
        // employeeService.addEmployee(employee3);
        // employeeService.deleteEmployee(1);
        // employeeService.deleteEmployee(2);
        // employeeService.deleteEmployee(3);
        // System.out.println(employeeService.findEmployee(2));

        employeeService.updateEmployee(employee4);

        List<Employee> employees = employeeService.findAllEmployees();

        for (Employee employee : employees) {
            System.out.println(
                "Employee ID: " + employee.getId() +
                " | Employee Name: " + employee.getName() +
                " | Employee Department: " + employee.getDepartment() +
                " | DayAbsent: " + employee.getDayAbsent()
            );
        }

        
    }
}
