package com.makersharks.searchapi.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.makersharks.searchapi.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Page<Supplier> findByCompanyNameContainingIgnoreCase(String companyName, Pageable pageable);

    @Query("SELECT s FROM Supplier s WHERE " +
       "(:location IS NULL OR s.location = :location) AND " +
       "(:natureOfBusiness IS NULL OR s.natureOfBusiness = :natureOfBusiness) AND " +
       "(:manufacturingProcesses IS NULL OR :manufacturingProcesses MEMBER OF s.manufacturingProcesses)")
Page<Supplier> findSuppliersByCriteria(@Param("location") String location,
                                       @Param("natureOfBusiness") String natureOfBusiness,
                                       @Param("manufacturingProcesses") Set<String> manufacturingProcesses,
                                       Pageable pageable);

}
