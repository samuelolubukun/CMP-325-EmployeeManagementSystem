package ng.edu.binghamuni.employeemanagementsystembhu.service;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.AdminStaff;

import java.util.List;

public interface AdminStaffService {

    public void addAdminStaff(AdminStaff adminStaff);

    public List<AdminStaff> getAll();

    public void deleteAdminStaff(Long id);

    public AdminStaff getAdminById(Long id);

    public AdminStaff updateAdmin(AdminStaff adminStaff);
}
