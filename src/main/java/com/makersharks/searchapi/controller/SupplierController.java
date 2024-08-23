package com.makersharks.searchapi.controller;

import com.makersharks.searchapi.model.Supplier;
import com.makersharks.searchapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@RestController
@RequestMapping("/api/supplier")
@Validated
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam @NotBlank @Size(min = 2, max = 100) String location,
            @RequestParam @NotBlank String natureOfBusiness,
            @RequestParam @NotNull Set<@NotBlank String> manufacturingProcesses,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size) {
        
        Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, manufacturingProcesses, page, size);
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping
    public ResponseEntity<Page<Supplier>> getSuppliers(
            @RequestParam(required = false) @Size(min = 2, max = 100) String companyName,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size) {
        
        Page<Supplier> suppliers;
        if (companyName != null) {
            suppliers = supplierService.findSuppliersByCompanyName(companyName, page, size);
        } else {
            suppliers = supplierService.findAllSuppliers(page, size);
        }
        return ResponseEntity.ok(suppliers);
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody @Valid Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }
}
