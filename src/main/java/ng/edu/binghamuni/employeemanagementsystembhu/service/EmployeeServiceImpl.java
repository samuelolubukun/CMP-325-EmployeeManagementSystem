package ng.edu.binghamuni.employeemanagementsystembhu.service;

import java.util.List;
import java.util.Optional;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.Employee;
import ng.edu.binghamuni.employeemanagementsystembhu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepo;

    @Override
    public List<Employee> getEmployeeByDeptid(Department d){

        return eRepo.findByDepartment(d);
    }

    @Override
    public Employee getEmployeeById(Long id) {

        Optional<Employee> ob = eRepo.findById(id);

        return ob.get();
    }

    @Override
    public List<Employee> getAll() {
        return eRepo.findAll();
    }



}
