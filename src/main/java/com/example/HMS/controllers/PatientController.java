package com.example.HMS.controllers;


import com.example.HMS.model.Patient;
import com.example.HMS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/Patients")
public class PatientController {

    // connecting with the service layer
    @Autowired
    private PatientService patientService;



    @PostMapping
    public Patient CreatePatient(@RequestBody Patient patient){
        //System.out.println("creating patients");
        return patientService.CreatePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatient(){
        //System.out.println("all Patients");
        return patientService.getAllPatient();
    }


    @GetMapping("/{id}")
    public Patient GetPatintById(@PathVariable Long id){
        System.out.println("get Patint by id");
        return patientService.getPatientById(id) ;
    }

    @DeleteMapping("/{id}")
    public void deletPatientById(@PathVariable Long id){
        //System.out.println("deleting patient by id");
        patientService.deletPatientById(id);

    }

    @PutMapping("/{id}")
    public void updatePatientById(@PathVariable Long id,@RequestBody Patient patient){
        //System.out.println("upadating patient by id");
        patientService.updatePatientById(id,patient);

    }

}
