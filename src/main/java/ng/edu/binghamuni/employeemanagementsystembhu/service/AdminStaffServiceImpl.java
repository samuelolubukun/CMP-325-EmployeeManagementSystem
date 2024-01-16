package ng.edu.binghamuni.employeemanagementsystembhu.service;

import java.util.List;
import java.util.Optional;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.AdminStaff;
import ng.edu.binghamuni.employeemanagementsystembhu.repository.AdminStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminStaffServiceImpl implements AdminStaffService {

    @Autowired
    private AdminStaffRepository adminRepo;

    @Override
    public void addAdminStaff(AdminStaff adminStaff) {
        adminRepo.save(adminStaff);
    }

    @Override
    public List<AdminStaff> getAll() {
        return adminRepo.findAll();
    }

    @Override
    public void deleteAdminStaff(Long id) {
        adminRepo.deleteById(id);
    }

    @Override
    public AdminStaff getAdminById(Long id) {
        Optional<AdminStaff> o = adminRepo.findById(id);
        return o.get();
    }

    @Override
    public AdminStaff updateAdmin(AdminStaff adminStaff) {
        return adminRepo.save(adminStaff);
    }
}
