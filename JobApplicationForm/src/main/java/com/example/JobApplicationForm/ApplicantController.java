/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JobApplicationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kalsym
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicantController {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobRespository jobRespository;

    @PostMapping("/applicant")
    public void postApplicant(@RequestBody Applicant applicant) {
        applicantRepository.save(applicant);
    }

//    @PostMapping("/job")
//    public void postJob(@RequestBody Job job) {
//        Department department = job.getDepartment();
//        Location location = job.getLocation();
//        jobRespository.save(job);
//    }
}
