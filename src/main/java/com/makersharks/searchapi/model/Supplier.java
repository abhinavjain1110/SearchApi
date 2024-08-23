package com.makersharks.searchapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @NotBlank
    @Size(min = 2, max = 100)
    private String companyName;

    private String website;

    @NotBlank
    @Size(min = 2, max = 100)
    private String location;

    @NotBlank
    private String natureOfBusiness;

    @NotNull
    @ElementCollection
    @CollectionTable(name = "supplier_manufacturing_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "process")
    private Set<String> manufacturingProcesses;

    // Default Constructor
    public Supplier() {
    }

    // Parameterized Constructor
    public Supplier(String companyName, String website, String location, String natureOfBusiness, Set<String> manufacturingProcesses) {
        this.companyName = companyName;
        this.website = website;
        this.location = location;
        this.natureOfBusiness = natureOfBusiness;
        this.manufacturingProcesses = manufacturingProcesses;
    }

    // Getters and Setters
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public Set<String> getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(Set<String> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }

    // Override equals and hashCode based on supplierId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierId, supplier.supplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId);
    }

    // Override toString for easy debugging
    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", companyName='" + companyName + '\'' +
                ", website='" + website + '\'' +
                ", location='" + location + '\'' +
                ", natureOfBusiness='" + natureOfBusiness + '\'' +
                ", manufacturingProcesses=" + manufacturingProcesses +
                '}';
    }
}
