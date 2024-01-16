package ng.edu.binghamuni.employeemanagementsystembhu.repository;

import java.util.List;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List <Employee> findByDepartment(Department d);


}
