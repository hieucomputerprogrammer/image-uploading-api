CREATE TABLE image(
    id BIGINT PRIMARY KEY,
    image_as_base64_format BYTEA NOT NULL,
    image_title VARCHAR(255) NOT NULL,
    owner_name VARCHAR(255) NOT NULL,
    owner_phone_number VARCHAR(255),
    owner_email VARCHAR(255)
);