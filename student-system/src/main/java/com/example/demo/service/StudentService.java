package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = repo.findById(id).orElse(null);
        if(existing != null){
            existing.setName(student.getName());
            existing.setGender(student.getGender());
            existing.setEducation(student.getEducation());
            existing.setCourse(student.getCourse());
            existing.setAddress(student.getAddress());
            existing.setNumber(student.getNumber());
            existing.setCity(student.getCity());
            repo.save(existing);
        }
        return existing;
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
