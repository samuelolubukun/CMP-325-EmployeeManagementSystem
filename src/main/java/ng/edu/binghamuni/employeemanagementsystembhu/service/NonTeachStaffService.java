package ng.edu.binghamuni.employeemanagementsystembhu.service;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.NonTeachingStaff;

import java.util.List;


public interface NonTeachStaffService {

    public void addNonTeachStaff(NonTeachingStaff nt);

    public List<NonTeachingStaff> getAll();

    public void deleteNonTeachStaff(Long id);

    public NonTeachingStaff getNonById(Long id);

    public NonTeachingStaff updateNon(NonTeachingStaff n);
}
