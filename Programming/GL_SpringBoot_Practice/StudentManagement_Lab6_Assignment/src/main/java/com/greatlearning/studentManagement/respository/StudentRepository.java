package com.greatlearning.studentManagement.respository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentManagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
