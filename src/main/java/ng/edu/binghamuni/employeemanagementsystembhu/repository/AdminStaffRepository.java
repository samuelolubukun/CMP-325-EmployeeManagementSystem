package ng.edu.binghamuni.employeemanagementsystembhu.repository;

import ng.edu.binghamuni.employeemanagementsystembhu.domain.AdminStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStaffRepository extends JpaRepository<AdminStaff, Long> {
}
