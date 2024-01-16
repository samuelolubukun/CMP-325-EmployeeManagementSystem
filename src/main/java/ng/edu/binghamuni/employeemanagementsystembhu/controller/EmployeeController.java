package ng.edu.binghamuni.employeemanagementsystembhu.controller;

import java.util.List;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.Employee;
import ng.edu.binghamuni.employeemanagementsystembhu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @GetMapping("/employees")
    public String getEmployees(ModelMap employeeModel) {
        List<Employee> el = eService.getAll();

        for(Employee e:el) {
            System.out.println("emp" + e);
        }
        employeeModel.addAttribute("elist",el);
        return "employees";
    }
}
