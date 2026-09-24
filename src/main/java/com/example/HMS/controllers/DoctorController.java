package com.example.HMS.controllers;

import com.example.HMS.model.Doctor;
import com.example.HMS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/V1/Doctors")
    public class DoctorController {

        @Autowired
        private DoctorService doctorService;

        @GetMapping
        public List<Doctor> getAllDoctor() {
            System.out.println("all Doctors");
            return null;
        }

        @PostMapping
        public Doctor CreateDoctor(@RequestBody Doctor doctor) {
            System.out.println("creating Doctors");
            return null;
        }

        @GetMapping("/{id}")
        public Doctor GetDoctorById(@PathVariable Long id) {
            System.out.println("get Doctor by id");
            return null;
        }

        @DeleteMapping("/{id}")
        public void deletDoctorById(@PathVariable Long id) {
            System.out.println("deleting Doctor by id");

        }

        @PutMapping("/{id}")
        public void updateDoctorById(@PathVariable Long id,@RequestBody Doctor doctor) {
            System.out.println("deleting Doctor by id");

        }
    }

