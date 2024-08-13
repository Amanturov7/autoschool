CREATE TABLE tickets (
                       id SERIAL PRIMARY KEY,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       question VARCHAR(255),
                       ticket_number BIGINT,
                       correct_answer VARCHAR(255),
                       option1 VARCHAR(255),
                       option2 VARCHAR(255),
                       option3 VARCHAR(255),
                       option4 VARCHAR(255),
                       employeeId BIGINT,
                       CONSTRAINT fk_user_diary FOREIGN KEY (employeeId) REFERENCES employee(id)
);
