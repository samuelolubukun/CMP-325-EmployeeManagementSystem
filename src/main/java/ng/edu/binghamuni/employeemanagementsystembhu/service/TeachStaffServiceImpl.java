package ng.edu.binghamuni.employeemanagementsystembhu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ng.edu.binghamuni.employeemanagementsystembhu.domain.TeachingStaff;
import ng.edu.binghamuni.employeemanagementsystembhu.repository.TeachStaffRepository;

@Service
public class TeachStaffServiceImpl implements TeachStaffService {

    @Autowired
    private TeachStaffRepository tRepo;

    @Override
    public void addTeachStaff(TeachingStaff ts) {
        tRepo.save(ts);
    }

    @Override
    public List<TeachingStaff> getAll() {
        return tRepo.findAll();
    }

    @Override
    public void deleteTeachStaff(Long id) {
        tRepo.deleteById(id);
    }

    @Override
    public TeachingStaff getTeachById(Long id) {
        return tRepo.findById(id).get();
    }

    @Override
    public TeachingStaff updateTeach(TeachingStaff ts) {
        return tRepo.save(ts);
    }

}
