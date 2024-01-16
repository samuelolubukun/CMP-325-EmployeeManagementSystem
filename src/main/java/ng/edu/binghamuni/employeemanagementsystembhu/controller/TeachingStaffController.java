package ng.edu.binghamuni.employeemanagementsystembhu.controller;

import java.util.List;

import ng.edu.binghamuni.employeemanagementsystembhu.service.TeachStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.Department;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.TeachingStaff;
import ng.edu.binghamuni.employeemanagementsystembhu.service.DepartmentService;

@Controller
public class TeachingStaffController {

    @Autowired
    private TeachStaffService tService;

    @Autowired
    private DepartmentService dService;

    @GetMapping("/teach-form")
    public String addTeachPage(ModelMap departmentModel) {
        List<Department> list = dService.getDepartments();
        departmentModel.addAttribute("departmentlist", list);

        return "teachform";
    }

    @PostMapping("/save-emp")
    public String addEmployee(@RequestParam(value = "ename", required = true) String ename,
                              @RequestParam(value = "email", required = true) String uemail,
                              @RequestParam(value = "salary", required = true) Double salary,
                              @RequestParam(value = "subject", required = true) String subject,
                              @RequestParam(value = "dno", required = true) Long dno, ModelMap emloyeeModel) {

        TeachingStaff ts = new TeachingStaff();

        ts.setName(ename);
        ts.setEmail(uemail);
        ts.setSalary(salary);
        ts.setSubject(subject);

        Department d = dService.getDepartment(dno);
        ts.setDepartment(d);

        tService.addTeachStaff(ts);

        return "redirect:/allteach";
    }

    @GetMapping("/allteach")
    public String allteach(ModelMap teachModel){
        List<TeachingStaff> tlist = tService.getAll();
        teachModel.addAttribute("tlist", tlist);

        return "allteach";
    }

    @GetMapping("/delete-teach/{id}")
    public String deleteTeach(@PathVariable Long id){

        tService.deleteTeachStaff(id);

        return "redirect:/allteach";
    }


    @GetMapping("/edit-teach/{id}")
    public String updatePage(@PathVariable("id") Long id, ModelMap TeachModel) {
        TeachModel.addAttribute("id", id);
        TeachingStaff te = tService.getTeachById(id);

        List<Department> list = dService.getDepartments();

        TeachModel.addAttribute("departmentlist", list);

        TeachModel.addAttribute("teach", te);


        return "updateteach";
    }


    @PostMapping("/updated-teach")
    public String updateTeach(@RequestParam(value = "id") Long id,
                              @RequestParam(value = "ename", required = true) String ename,
                              @RequestParam(value = "email", required = true) String uemail,
                              @RequestParam(value = "salary", required = true) Double salary,
                              @RequestParam(value = "subject", required = true) String subject,
                              @RequestParam(value = "dno", required = true) Long dno,

                              ModelMap departmentModel) {

        Department d = dService.getDepartment(dno);

        TeachingStaff te = tService.getTeachById(id);
        te.setName(ename);
        te.setEmail(uemail);
        te.setSalary(salary);
        te.setSubject(subject);
        te.setDepartment(d);
        te = tService.updateTeach(te);

        return "redirect:/allteach";
    }


}
