package com.example.HMS.service;

import com.example.HMS.model.Bill;
import com.example.HMS.model.Patient;
import com.example.HMS.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillService {


    @Autowired
    private BillRepository billRepository;


    public Bill CreateBill(Bill bill){
        try {
            System.out.println("create Bill service");
            return  null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public List<Bill> getAllBill(){
        try {
            System.out.println("get BIll service");
            return null;
        }catch (Exception e){
            System.out.println("error:"+ e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id){
        try {
            System.out.println("get bill by id  Service");
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void  deletBillById(Long id){
        try {
            System.out.println("delet  BIll by id Service");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateBillById(Long id){
        try {
            System.out.println("update  Bill by id   Service");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
