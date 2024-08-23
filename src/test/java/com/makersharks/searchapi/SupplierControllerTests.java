package com.makersharks.searchapi;

import com.makersharks.searchapi.controller.SupplierController;
import com.makersharks.searchapi.model.Supplier;
import com.makersharks.searchapi.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SupplierControllerTests {

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    @Test
    public void testQuerySuppliers() {
        // Arrange
        Supplier supplier = new Supplier();
        supplier.setSupplierId(1L);
        supplier.setCompanyName("Small Scale Manufacturer");
        supplier.setWebsite("https://smallscale.com");
        supplier.setLocation("India");
        supplier.setNatureOfBusiness("small_scale");
        supplier.setManufacturingProcesses(Set.of("3d_printing"));

        Page<Supplier> supplierPage = new PageImpl<>(List.of(supplier), PageRequest.of(0, 10), 1);

        // Mock the service method call
        when(supplierService.searchSuppliers("India", "small_scale", Set.of("3d_printing"), 0, 10))
                .thenReturn(supplierPage);

        // Act
        ResponseEntity<Page<Supplier>> response = supplierController.querySuppliers("India", "small_scale", Set.of("3d_printing"), 0, 10);

        // Assert
        assertNotNull(response, "Response should not be null");
        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(1, response.getBody().getTotalElements());
        assertEquals("Small Scale Manufacturer", response.getBody().getContent().get(0).getCompanyName());
        assertEquals("India", response.getBody().getContent().get(0).getLocation());
        assertEquals(Set.of("3d_printing"), response.getBody().getContent().get(0).getManufacturingProcesses());
    }
}
