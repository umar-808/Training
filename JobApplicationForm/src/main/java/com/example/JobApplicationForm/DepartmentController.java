/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JobApplicationForm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kalsym
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/department")
    public List<Department> get() {
        return repository.findAll();
    }

    @PostMapping("/department")
    public void add(@RequestBody Department department) {

        repository.save(department);

//        repository.save(department);
    }

}
