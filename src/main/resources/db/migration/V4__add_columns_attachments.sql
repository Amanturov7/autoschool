ALTER TABLE attachments
    ADD COLUMN groups_id BIGINT;

ALTER TABLE attachments
    ADD COLUMN cars_id BIGINT;

ALTER TABLE attachments
    ADD CONSTRAINT fk_groups
        FOREIGN KEY (groups_id) REFERENCES groups(id);

ALTER TABLE attachments
    ADD CONSTRAINT fk_cars
        FOREIGN KEY (cars_id) REFERENCES cars(id);
