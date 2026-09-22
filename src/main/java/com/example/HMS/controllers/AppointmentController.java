package com.example.HMS.controllers;

import com.example.HMS.model.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/V1/Appointments")
public class AppointmentController {

    @GetMapping
    public List<Appointment> getAllAppointment() {
        System.out.println("all Appointments");
        return null;
    }

    @PostMapping
    public Appointment CreateAppointment(@RequestBody Appointment appointment) {
        System.out.println("creating Appointment");
        return null;
    }

    @GetMapping("/{id}")
    public Appointment GetAppointmentById(@PathVariable Long id) {
        System.out.println("get Appointment by id");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletAppointmentById(@PathVariable Long id) {
        System.out.println("deleting Appointment by id");

    }

    @PutMapping("/{id}")
    public void updateAppointmentById(@PathVariable Long id) {
        System.out.println("deleting Appointment by id");

    }
}
