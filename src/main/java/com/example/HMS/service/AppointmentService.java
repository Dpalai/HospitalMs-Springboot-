package com.example.HMS.service;

import com.example.HMS.model.Appointment;
import com.example.HMS.model.Bill;
import com.example.HMS.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment CreateBill(Appointment appointment){
        try {
            System.out.println("create Appointment service");
            return  null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Appointment> getAllAppointment(){
        try {
            System.out.println("get Appointment  service");
            return null;
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id){
        try {
            System.out.println("get Appointment by id  Service");
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void  deletAppointmentById(Long id){
        try {
            System.out.println("delet  Appointment by id Service");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateAppointmentById(Long id){
        try {
            System.out.println("update  Appointment by id   Service");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
