CREATE TABLE Product (
    code INTEGER NOT NULL,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(500) NOT NULL,
    price FLOAT NOT NULL,
    category VARCHAR(20) NOT NULL,
    PRIMARY KEY(code)
);