package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.model.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student create(Student s) {
        if (s.getEmail() != null && repo.existsByEmail(s.getEmail())) {
            throw new RuntimeException("Email already exists: " + s.getEmail());
        }
        return repo.save(s);
    }

    public Student update(Long id, Student s) {
        Student existing = getById(id);
        existing.setFirstName(s.getFirstName());
        existing.setLastName(s.getLastName());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
