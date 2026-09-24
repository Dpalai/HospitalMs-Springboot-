package com.example.HMS.service;

import com.example.HMS.model.Appointment;
import com.example.HMS.model.Bill;
import com.example.HMS.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment createAppoinment(Appointment appointment){
        try {
            //System.out.println("create Appointment service");
            return appointmentRepository.save(appointment);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Appointment> getAllAppointment(){
        try {
            //System.out.println("get Appointment  service");
            return appointmentRepository.findAll();
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id){
        try {
            //System.out.println("get Appointment by id  Service");
            /*

            Optional<Appointment> appointment=appointmentRepository.findById(id);
            if (appointment.isPresent()){
                return appointment.get();
            }
            return null;
            */

            // (OR we can Do)
            return appointmentRepository.findById(id).orElse(null);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public void  deletAppointmentById(Long id){
        try {
            //System.out.println("delet  Appointment by id Service");
            appointmentRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Appointment updateAppointmentById(Long id,Appointment updateAppointment){
        try {
           // System.out.println("update  Appointment by id   Service");
            Optional<Appointment> existingAppointment=appointmentRepository.findById(id);
            if (existingAppointment.isPresent()){
                Appointment A=existingAppointment.get();
                A.setDate(updateAppointment.getDate());
                A.setDoctorId(updateAppointment.getDoctorId());
                A.setPatientId(updateAppointment.getPatientId());

                appointmentRepository.save(A);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  updateAppointment;
    }
}
