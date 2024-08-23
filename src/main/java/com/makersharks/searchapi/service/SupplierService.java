package com.makersharks.searchapi.service;

import com.makersharks.searchapi.model.Supplier;
import com.makersharks.searchapi.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness, Set<String> manufacturingProcesses, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findSuppliersByCriteria(location, natureOfBusiness, manufacturingProcesses, pageable);
    }

    public Page<Supplier> findSuppliersByCompanyName(String companyName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findByCompanyNameContainingIgnoreCase(companyName, pageable);
    }

    public Page<Supplier> findAllSuppliers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findAll(pageable);
    }

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
