package ng.edu.binghamuni.employeemanagementsystembhu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "adminstaff")
public class AdminStaff extends Employee {

    private String role;


}