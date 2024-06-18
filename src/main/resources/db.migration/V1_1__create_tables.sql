CREATE TABLE jwt_tokens (
                            id SERIAL PRIMARY KEY,
                            token VARCHAR(255) NOT NULL,
                            expiry_date TIMESTAMP NOT NULL,
                            user_id INT,
                            FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE attachments (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             path VARCHAR(255) NOT NULL,
                             type VARCHAR(255) NOT NULL,
                             extension VARCHAR(255) NOT NULL,
                             name VARCHAR(255) NOT NULL,
                             description TEXT,
                             user_id BIGINT,
                             CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);


CREATE TABLE common_reference_type (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       title VARCHAR(255) NOT NULL,
                                       code VARCHAR(255) NOT NULL
);

CREATE TABLE common_reference (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  title VARCHAR(255) NOT NULL,
                                  code VARCHAR(255) NOT NULL,
                                  type_id BIGINT,
                                  parent_id BIGINT,
                                  CONSTRAINT fk_common_reference_type FOREIGN KEY (type_id) REFERENCES common_reference_type(id) ON DELETE SET NULL,
                                  CONSTRAINT fk_parent_reference FOREIGN KEY (parent_id) REFERENCES common_reference(id) ON DELETE SET NULL
);

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       role VARCHAR(255) NOT NULL,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       passport_serial VARCHAR(255),
                       signup_date TIMESTAMP,
                       inn DECIMAL(30, 0),
                       phone DECIMAL(30, 0),
                       address VARCHAR(255),
                       email VARCHAR(255),
                       region_id BIGINT,
                       district_id BIGINT,
                       CONSTRAINT fk_region FOREIGN KEY (region_id) REFERENCES common_reference(id) ON DELETE SET NULL,
                       CONSTRAINT fk_district FOREIGN KEY (district_id) REFERENCES common_reference(id) ON DELETE SET NULL
);

