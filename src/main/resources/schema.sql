CREATE TABLE layout_configuration (
	color VARCHAR(255)
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2),
    created_at DATE,
    updated_at DATE,
    available BOOLEAN
);