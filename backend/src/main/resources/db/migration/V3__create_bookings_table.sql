CREATE TABLE bookings (
    id BIGSERIAL PRIMARY KEY,

    resource_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,

    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,

    status VARCHAR(50) NOT NULL,

    CONSTRAINT fk_booking_resource
        FOREIGN KEY (resource_id)
        REFERENCES resources(id),

    CONSTRAINT fk_booking_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);