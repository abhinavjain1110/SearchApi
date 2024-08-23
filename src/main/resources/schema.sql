CREATE TABLE IF NOT EXISTS SUPPLIER (
    supplier_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255),
    website VARCHAR(255),
    location VARCHAR(255),
    nature_of_business VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS SUPPLIER_MANUFACTURING_PROCESSES (
    supplier_id BIGINT,
    process VARCHAR(255),
    PRIMARY KEY (supplier_id, process),
    FOREIGN KEY (supplier_id) REFERENCES SUPPLIER(supplier_id)
);
