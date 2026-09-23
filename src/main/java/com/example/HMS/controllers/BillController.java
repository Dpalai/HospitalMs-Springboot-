package com.example.HMS.controllers;

import com.example.HMS.model.Bill;
import com.example.HMS.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/V1/Bills")
public class BillController {


    @Autowired
    private BillService billService;


    @GetMapping
    public List<Bill> getAllBill() {
        System.out.println("all BIlls");
        return null;
    }

    @PostMapping
    public Bill CreateBill(@RequestBody Bill bill) {
        System.out.println("creating Bills");
        return null;
    }

    @GetMapping("/{id}")
    public Bill GetBillById(@PathVariable Long id) {
        System.out.println("get Bill by id");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletBIllById(@PathVariable Long id) {
        System.out.println("deleting Bill by id");

    }

    @PutMapping("/{id}")
    public void updateBillById(@PathVariable Long id) {
        System.out.println("deleting Bill by id");

    }
}
