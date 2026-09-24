package com.example.HMS.service;

import com.example.HMS.model.Patient;
import com.example.HMS.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Patient CreatePatient(Patient patient){
        try {
            //System.out.println("create pateint service");
            return patientRepository.save(patient);
            //return  patient;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Patient> getAllPatient(){
        try {
            //System.out.println("gell patient service");
            return patientRepository.findAll();
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id){
        try {
            //System.out.println("getpatientService");
          /*

            Optional<Patient> patient = patientRepository.findById(id);
            if (patient.isPresent()){
                return patient.get();
            }
            return null;

            */
            // (OR we can Do)
            return patientRepository.findById(id).orElse(null);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public void  deletPatientById(Long id){
        try {
           // System.out.println("getpatientService");
            patientRepository.deleteById(id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Patient updatePatientById(Long id,Patient upadetpatient){
        try {
            //System.out.println("getpatientService");
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if (existingPatient.isPresent()){
                Patient p = existingPatient.get();
                p.setName(upadetpatient.getName());
                p.setAge(upadetpatient.getAge());
                p.setGender(upadetpatient.getGender());
                patientRepository.save(p);

            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return upadetpatient;
    }



}
