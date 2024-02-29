package com.example.Facultyinfo.service;

import com.example.Facultyinfo.model.Faculty;
import com.example.Facultyinfo.repository.Facultyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Facultyservice {
    @Autowired
    private Facultyrepo repo;

    public Faculty createstudent(Faculty faculty) {
        return repo.save(faculty);
    }


    public List<Faculty> createfaculties(List<Faculty> faculties) {
        return repo.saveAll(faculties);
    }

    public Faculty getfaculty(int id) {
        return repo.findById(id).orElse(null);

    }

    public List<Faculty> getFaculties() {
        return repo.findAll();
    }

    public String deletefaculty(int id) {
        repo.deleteById(id);
        return "faculty data is deleted with  " + id;

    }

    public Faculty updatefaculty(int id, Faculty updatedFaculty) {
        Optional<Faculty> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            Faculty existingFaculty = optionalStudent.get();
            existingFaculty.setName(updatedFaculty.getName());
            existingFaculty.setEmail(updatedFaculty.getEmail());
            existingFaculty.setPhone(updatedFaculty.getPhone());
            existingFaculty.setDepartment(updatedFaculty.getDepartment());
            existingFaculty.setPosition(updatedFaculty.getPosition());
            existingFaculty.setOffice(updatedFaculty.getOffice());
            existingFaculty.setPassword(updatedFaculty.getPassword());
            return repo.save(existingFaculty);
        } else {
            throw new RuntimeException("Student not found with id: " +id);
        }
    }
    }
