package pro.sky.HomeWork18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork18.Employee;
import pro.sky.HomeWork18.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);

    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {


        return employeeService.findEmployee(firstName,lastName);
    }

    @GetMapping
    public Map<String, Employee> getAllEmployees() {
        return   employeeService.getAllEmployees();

    }

    Map<String, Integer> numbersMap = new HashMap<>();

    {
        numbersMap.put("один", 1);
        numbersMap.put("два",2);
        System.out.println(numbersMap);

        System.out.println(numbersMap.get("один"));
        System.out.println(numbersMap.size());
        System.out.println("numbersMap.toString() = " + numbersMap.toString());

    }
    @GetMapping("/nameadd")
  public String getProffesion(){
    return "вася";}
}
