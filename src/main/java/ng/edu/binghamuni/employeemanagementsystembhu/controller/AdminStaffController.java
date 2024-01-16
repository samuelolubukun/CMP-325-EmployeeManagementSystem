package ng.edu.binghamuni.employeemanagementsystembhu.controller;
import java.util.List;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.AdminStaff;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;
import ng.edu.binghamuni.employeemanagementsystembhu.service.AdminStaffService;
import ng.edu.binghamuni.employeemanagementsystembhu.service.DepartmentServiceImpl;
import ng.edu.binghamuni.employeemanagementsystembhu.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AdminStaffController {

    @Autowired
    private AdminStaffService adminService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/admin-form")
    public String addAdminPage(ModelMap departmentModel) {
        List<Department> list = departmentService.getDepartments();
        departmentModel.addAttribute("departmentlist", list);

        return "adminform";
    }

    @PostMapping("/asave-emp")
    public String addEmployee(@RequestParam(value = "ename", required = true) String ename,
                              @RequestParam(value = "email", required = true) String uemail,
                              @RequestParam(value = "salary", required = true) Double salary,
                              @RequestParam(value = "role", required = true) String role,
                              @RequestParam(value = "dno", required = true) Long dno, ModelMap employeeModel) {

        AdminStaff adminStaff = new AdminStaff();

        adminStaff.setName(ename);
        adminStaff.setEmail(uemail);
        adminStaff.setSalary(salary);
        adminStaff.setRole(role);

        Department department = departmentService.getDepartment(dno);
        adminStaff.setDepartment(department);

        adminService.addAdminStaff(adminStaff);

        return "redirect:/alladmin";
    }

    @GetMapping("/alladmin")
    public String allAdmin(ModelMap adminModel) {
        List<AdminStaff> adminList = adminService.getAll();
        adminModel.addAttribute("adminList", adminList);

        return "alladmin";
    }

    // Delete Employee
    @GetMapping("/delete-admin/{id}")
    public String deleteAdmin(@PathVariable Long id) {

        adminService.deleteAdminStaff(id);

        return "redirect:/alladmin";
    }

    @GetMapping("/edit-admin/{id}")
    public String updatePage(@PathVariable("id") Long id, ModelMap adminModel) {
        adminModel.addAttribute("id", id);
        AdminStaff adminStaff = adminService.getAdminById(id);

        List<Department> list = departmentService.getDepartments();

        adminModel.addAttribute("departmentlist", list);

        adminModel.addAttribute("admin", adminStaff);

        return "updateadmin";
    }

    @PostMapping("/updated-admin")
    public String updateAdmin(@RequestParam(value = "id") Long id,
                              @RequestParam(value = "ename", required = true) String ename,
                              @RequestParam(value = "email", required = true) String uemail,
                              @RequestParam(value = "salary", required = true) Double salary,
                              @RequestParam(value = "role", required = true) String role,
                              @RequestParam(value = "dno", required = true) Long dno,

                              ModelMap departmentModel) {

        Department department = departmentService.getDepartment(dno);

        AdminStaff adminStaff = adminService.getAdminById(id);
        adminStaff.setName(ename);
        adminStaff.setEmail(uemail);
        adminStaff.setSalary(salary);
        adminStaff.setRole(role);
        adminStaff.setDepartment(department);
        adminStaff = adminService.updateAdmin(adminStaff);

        return "redirect:/alladmin";
    }

}

