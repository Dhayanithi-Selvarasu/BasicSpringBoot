package com.student_registration.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.student_registration.demo.Model.Student;
import com.student_registration.demo.Repository.StudentRepository;
import com.student_registration.demo.Exception.StudentNotFoundException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository repository) {
        this.studentRepository = repository;
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public java.util.List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() ->
            new StudentNotFoundException("Student not found with ID: " + studentId));
    }

    public String deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);
        studentRepository.delete(student);
        return "Student registration deleted successfully";
    }
}
