package com.example.HMS.controllers;


import com.example.HMS.model.Patient;
import com.example.HMS.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/Patients")
@Slf4j
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
    // public List<Patient> getAllPatient(){

    // for Paggination @RequestParam....      //   we can remove default values but we
                                              // need to type the url for page and size,
                                              //  ** if we don't want to write that url then we
                                              // must explicitly set required = false and -->
                                              // @RequestParam(required = false) Integer page,
                                              // @RequestParam(required = false) Integer size
                                              // we must switch the parameter types to the object wrapper Integer
    public Page<Patient> getAllPatient(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size) {
      // ** // int pageNumber = (page != null) ? page : 0;
            // int pageSize = (size != null) ? size : 10;
        System.out.println("all Patients");
        log.info("Controller : GEt all Patients");
        return patientService.getAllPatient(page,size);
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
