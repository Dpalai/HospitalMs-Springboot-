package com.example.HMS.service;

import com.example.HMS.model.Patient;
import com.example.HMS.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
// import java.util.logging.Logger;


@Service
@Slf4j   // Lombok annnotation to use the Log4j2 looger
public class PatientService {

    // instade of the bellow line we can also use the annotation @Slf4j ,beacuse we use Lombok in this project.

   //private static final Logger logger= LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;


    public Patient CreatePatient(Patient patient){
        try {
            // console output
             System.out.println("into pateint service layer");
             // when we use Slf4j --> Log4J2
             log.info("service:into Create Pateint Service Layer");
            return patientRepository.save(patient);
            //return  patient;
        }catch (Exception e){
            // consol output
            System.out.println("Error message:" + e.getMessage());
                 //logger msg  if we use the object of Logger

           //  logger.error("An Error Occured While Creating Patients: {}",e.getMessage()  );

                // if we use Lombok annotation
            log.error("An Error Occured While Creating Patients: {}",e.getMessage()  );


            e.printStackTrace();
            return null;
        }

    }


    // public List<Patient> getAllPatient(){
    // paggiination
    public Page<Patient> getAllPatient(int page, int size){
        try {
            //System.out.println("gell patient service");
            log.info("service:into Get All Pateint Service Layer");
            Pageable pageable = PageRequest.of(page, size);
            return patientRepository.findAll(pageable);
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            log.error("An Error Occured While Fetching All Patients: {}",e.getMessage()  );
            return Page.empty();
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
            log.info("service:into GET Patient By Id Service Layer");
            return patientRepository.findById(id).orElse(null);

        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            log.error("An Error Occured While Getting Patient by id {} Patients: {}",id,e.getMessage()  );
            return null;
        }

    }

    public void  deletPatientById(Long id){
        try {
           // System.out.println("getpatientService");
            patientRepository.deleteById(id);
            log.info("service:into Delet Patient By Id Pateint Service Layer");

        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            log.error("An Error Occured While Deleting  Patient bY id {} : {}",id,e.getMessage()  );
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

                log.info("service:into Update Patient By Id Pateint Service Layer");

            }

        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            log.error("An Error Occured While Updating  Patient by id {} : {}",id,e.getMessage()  );
            e.printStackTrace();

        }
        return upadetpatient;
    }



}
