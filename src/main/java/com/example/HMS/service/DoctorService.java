package com.example.HMS.service;

import com.example.HMS.model.Doctor;
import com.example.HMS.model.Patient;
import com.example.HMS.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public Doctor CreateDoctor(Doctor doctor){
        try {
            //System.out.println("create Doctor service");
            return doctorRepository.save(doctor);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Doctor> getAllDoctor(){
        try {
            //System.out.println("get all Doctor service");
            return doctorRepository.findAll();

        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id){
        try {
            //System.out.println("get doctor by id  Service");
             /*

            Optional<Doctor> doctor = doctorRepository.findById(id);
            if (doctor.isPresent()){
                return doctor.get();
            }
            return null;

            */
            // (OR we can Do)
            return doctorRepository.findById(id).orElse(null);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public void  deletDoctorById(Long id){
        try {
            //System.out.println("delet  Doctor  Service");
            doctorRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Doctor updateDoctorById(Long id,Doctor updatedDcoctor){
        try {
            //System.out.println("update doctor by id");
            Optional<Doctor> existingDoctor=doctorRepository.findById(id);
            if (existingDoctor.isPresent()){
                Doctor D = existingDoctor.get();
                D.setName(updatedDcoctor.getName());
                D.setSpecialization(updatedDcoctor.getSpecialization());

                doctorRepository.save(D);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return updatedDcoctor;
    }
}
