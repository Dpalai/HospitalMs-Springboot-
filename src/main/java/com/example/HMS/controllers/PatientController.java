package com.example.HMS.controllers;


import com.example.HMS.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/Patients")
public class PatientController {


    @GetMapping
    public List<Patient> getAllPatient(){
        System.out.println("all Patients");
        return null;
    }

    @PostMapping
    public Patient CreatePatient(@RequestBody Patient patient){
        System.out.println("creating patients");
        return null;
    }

    @GetMapping("/{id}")
    public Patient GetPatintById(@PathVariable Long id){
        System.out.println("get Patint by id");
        return null ;
    }

    @DeleteMapping("/{id}")
    public void deletPatientById(@PathVariable Long id){
        System.out.println("deleting patient by id");

    }

    @PutMapping("/{id}")
    public void updatePatientById(@PathVariable Long id){
        System.out.println("deleting patient by id");

    }

}
