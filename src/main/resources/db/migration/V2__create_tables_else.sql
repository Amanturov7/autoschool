CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          created_at TIMESTAMP,
                          updated_at TIMESTAMP,
                          name VARCHAR(255),
                          date_of_birth DATE,
                          number VARCHAR(50),
                          email VARCHAR(255),
                          whats_up VARCHAR(255),
                          telegram VARCHAR(255),
                          skills TEXT,
                          employee_type BIGINT,
                          CONSTRAINT fk_employee_type FOREIGN KEY(employee_type) REFERENCES common_reference(id)
);

CREATE TABLE groups (
                        id SERIAL PRIMARY KEY,
                        created_at TIMESTAMP,
                        updated_at TIMESTAMP,
                        name VARCHAR(255),
                        type_study_id BIGINT,
                        category_id BIGINT,
                        employee_id BIGINT,
                        CONSTRAINT fk_type_study FOREIGN KEY (type_study_id) REFERENCES common_reference(id) ON DELETE SET NULL,
                        CONSTRAINT fk_category_groups FOREIGN KEY (category_id) REFERENCES common_reference(id) ON DELETE SET NULL,
                        CONSTRAINT fk_employee_groups FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE SET NULL
);
ALTER TABLE users
    ADD COLUMN created_at TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP,
    ADD COLUMN name VARCHAR(255),
    ADD COLUMN surname VARCHAR(255),
    ADD COLUMN last_name VARCHAR(255),
    ADD COLUMN date_of_birth DATE,
    ADD COLUMN telegram VARCHAR(255),
    ADD COLUMN whats_up VARCHAR(255),
    ADD COLUMN agree BOOLEAN,
    ADD COLUMN group_id BIGINT,
    ADD COLUMN employee_id BIGINT;

ALTER TABLE users
    ADD CONSTRAINT fk_group FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE SET NULL,
    ADD CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE SET NULL;

CREATE TABLE diary (
                       id SERIAL PRIMARY KEY,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       title_skill_id BIGINT,
                       mark INTEGER,
                       category_id BIGINT,
                       user_id BIGINT,
                       CONSTRAINT fk_title_skill FOREIGN KEY (title_skill_id) REFERENCES common_reference(id) ON DELETE SET NULL,
                       CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES common_reference(id) ON DELETE SET NULL,
                       CONSTRAINT fk_user_diary FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);
CREATE TABLE certificate (
                             id SERIAL PRIMARY KEY,
                             created_at TIMESTAMP,
                             updated_at TIMESTAMP,
                             name VARCHAR(255),
                             user_id BIGINT,
                             CONSTRAINT fk_user_certificate FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE cars (
                      id SERIAL PRIMARY KEY,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      name VARCHAR(255),
                      model VARCHAR(255),
                      color VARCHAR(255),
                      engine FLOAT,
                      year INTEGER,
                      difficulty_level INTEGER,
                      employee_id BIGINT,
                      CONSTRAINT fk_employee_cars FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE SET NULL
);

CREATE TABLE journal (
                         id SERIAL PRIMARY KEY,
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP,
                         name VARCHAR(255)
);



CREATE TABLE schedule (
                          id SERIAL PRIMARY KEY,
                          created_at TIMESTAMP,
                          updated_at TIMESTAMP,
                          date TIMESTAMP,
                          name VARCHAR(255),
                          group_id BIGINT,
                          CONSTRAINT fk_group_schedule FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE SET NULL
);