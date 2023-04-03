package com.example.qristina.youtubespringtutorial.repositories;

import com.example.qristina.youtubespringtutorial.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
