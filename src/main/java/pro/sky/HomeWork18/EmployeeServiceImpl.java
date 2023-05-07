package pro.sky.HomeWork18;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18.exception.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18.exception.EmployeeNotFoundException;
import pro.sky.HomeWork18.exception.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYESS_STORAGE_SIZE=5;
    private final Map<String,Employee> employees=new HashMap<>();




    @Override
    public Employee addEmployee(String firstName, String lastName) {
        String employeeKey=getEmployeeKey(firstName,lastName);
        if(employees.containsKey(employeeKey)){
            throw new EmployeeAlreadyAddedException();
        }
        if(employees.size()==EMPLOYESS_STORAGE_SIZE){
            throw new EmployeeStorageIsFullException();
        }
        employees.put
                (employeeKey,
                 new Employee(firstName, lastName));


        return employees.get(employeeKey);

    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey=getEmployeeKey(firstName,lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employeeKey);



    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey=getEmployeeKey(firstName,lastName);
        if (!employees.containsKey(employeeKey)){
            throw new EmployeeNotFoundException();
        }
        return employees.get(employeeKey);


    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }
    private String getEmployeeKey(String firstName, String lastName){
        return firstName+lastName;
    }
}



