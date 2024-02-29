package com.example.Facultyinfo.controller;

import com.example.Facultyinfo.model.Faculty;
import com.example.Facultyinfo.service.Facultyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/madhu")

public class Facultycontroller {
    @Autowired
    private Facultyservice service;

    @PostMapping ("/addfaculties")
    public List<Faculty> addfacutlties(@RequestBody List<Faculty> students){
        return service.createfaculties(students);
    }
    @GetMapping("/faculties")
    public List<Faculty> getfacuties(){
        return service.getFaculties();
    }
    @GetMapping("/faculty/{id}")
    public Faculty getfaculty(@PathVariable int id){
        return service.getfaculty(id);
    }
    @DeleteMapping("/faculty/{id}")
    public String deletestudent(@PathVariable int id){
        return service.deletefaculty(id);
    }
    @PutMapping("/faculty/{id}")
    public Faculty updatefaculty(@PathVariable int id,@RequestBody Faculty student){
        return service.updatefaculty(id, student);
    }


}