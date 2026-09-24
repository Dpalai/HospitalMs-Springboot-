package com.example.HMS.service;

import com.example.HMS.model.Bill;
import com.example.HMS.model.Patient;
import com.example.HMS.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BillService {


    @Autowired
    private BillRepository billRepository;


    public Bill CreateBill(Bill bill){
        try {
            //System.out.println("create Bill service");
            billRepository.save(bill);
            return  bill;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Bill> getAllBill(){
        try {
            //System.out.println("get BIll service");
            return billRepository.findAll();
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id){
        try {
            //System.out.println("get bill by id  Service");
            Optional<Bill> bill=billRepository.findById(id);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void  deletBillById(Long id){
        try {
           // System.out.println("delet  BIll by id Service");
            billRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateBillById(Long id,Bill updateBill){
        try {
            //System.out.println("update  Bill by id   Service");
            Optional<Bill> existingBill=billRepository.findById(id);
            if (existingBill.isPresent()){
                Bill B=existingBill.get();
                B.setAmount(updateBill.getAmount());
                B.setPatientId(updateBill.getPatientId());
                B.setStatus(updateBill.getStatus());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
