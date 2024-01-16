package ng.edu.binghamuni.employeemanagementsystembhu.service;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;

import java.util.List;


public interface DepartmentService {

    public void addDepartment(Department department);
    public Department getDepartment(Long id);

    public List<Department> getDepartments();
    public void deleteDepartment(Long id);
    public Department updateDepartment(Department d);
}
