package ng.edu.binghamuni.employeemanagementsystembhu.service;

import java.util.List;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.TeachingStaff;

public interface TeachStaffService {

    public void addTeachStaff(TeachingStaff ts);

    public List<TeachingStaff> getAll();

    public void deleteTeachStaff(Long id);

    public TeachingStaff getTeachById(Long id);

    public TeachingStaff updateTeach(TeachingStaff ts);
}
