package com.example.HMS.service;

import com.example.HMS.model.Doctor;
import com.example.HMS.model.Patient;
import com.example.HMS.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public Doctor CreateDoctor(Doctor doctor){
        try {
            System.out.println("create Doctor service");
            return  null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Doctor> getAllDoctor(){
        try {
            System.out.println("gell Doctor service");
            return null;
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id){
        try {
            System.out.println("get doctor by id  Service");
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void  deletDoctorById(Long id){
        try {
            System.out.println("delet  Doctor  Service");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateDoctorById(Long id){
        try {
            System.out.println("update doctor by id");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
