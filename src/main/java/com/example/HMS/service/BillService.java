package com.example.HMS.service;

import com.example.HMS.model.Bill;
import com.example.HMS.model.Patient;
import com.example.HMS.repository.BillRepository;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BillService {


    @Autowired
    private BillRepository billRepository;


    public Bill createBill(Bill bill){
        try {
            //System.out.println("create Bill service");
            return billRepository.save(bill);

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
            /*

            Optional<Bill> bill=billRepository.findById(id);
            if (bill.isPresent()){
                return bill.get();
            }
            return null;
            */

            // (OR we can Do)
            return billRepository.findById(id).orElse(null);

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

    public Bill updateBillById(Long id, Bill updateBill){
        try {
            //System.out.println("update  Bill by id   Service");
            Optional<Bill> existingBill=billRepository.findById(id);
            if (existingBill.isPresent()){
                Bill B=existingBill.get();
                B.setAmount(updateBill.getAmount());
                B.setPatientId(updateBill.getPatientId());
                B.setStatus(updateBill.getStatus());

                billRepository.save(B);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateBill;
    }
}
