package ng.edu.binghamuni.employeemanagementsystembhu.service;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.Employee;

import java.util.List;



public interface EmployeeService {

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByDeptid(Department d);

    List<Employee> getAll();
}
