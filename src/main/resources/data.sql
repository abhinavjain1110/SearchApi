-- Insert suppliers
INSERT INTO SUPPLIER (company_name, website, location, nature_of_business) VALUES
('Small Scale Manufacturer', 'http://smallscale.com', 'India', 'small_scale'),
('Medium Scale Manufacturer', 'http://mediumscale.com', 'India', 'medium_scale'),
('Large Scale Manufacturer', 'http://largescale.com', 'India', 'large_scale');

-- Insert manufacturing processes
INSERT INTO SUPPLIER_MANUFACTURING_PROCESSES (supplier_id, process) VALUES
(1, '3d_printing'),
(2, 'casting'),
(3, 'moulding'),
(3, 'coating');
