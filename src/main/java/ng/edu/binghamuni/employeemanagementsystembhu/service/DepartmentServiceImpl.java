package ng.edu.binghamuni.employeemanagementsystembhu.service;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;
import ng.edu.binghamuni.employeemanagementsystembhu.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository dRepo;

    @Override
    public void addDepartment(Department department) {
        dRepo.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return dRepo.findAll();
    }

    @Override
    public void deleteDepartment(Long id) {
        dRepo.deleteById(id);
    }

    @Override
    public Department getDepartment(Long id) {
        return dRepo.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Department d) {
        return dRepo.save(d);
    }
}
