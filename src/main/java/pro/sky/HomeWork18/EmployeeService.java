package pro.sky.HomeWork18;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName,String lastName);
    void removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName,String lastName);
    Map<String, Employee> getAllEmployees();
}




