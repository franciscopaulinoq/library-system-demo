CREATE TABLE categories
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE authors
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    birth_date  DATE,
    nationality VARCHAR(100),
    biography   TEXT
);

CREATE TABLE users
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    cpf               VARCHAR(11)  NOT NULL UNIQUE,
    email             VARCHAR(255) NOT NULL UNIQUE,
    phone             VARCHAR(20),
    registration_date DATE         NOT NULL,
    address           VARCHAR(255),
    active            BOOLEAN DEFAULT TRUE
);

CREATE TABLE books
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    isbn               VARCHAR(20)  NOT NULL UNIQUE,
    title              VARCHAR(255) NOT NULL,
    publisher          VARCHAR(100),
    published_year     INT,
    number_pages       INT,
    total_quantity     INT          NOT NULL,
    available_quantity INT          NOT NULL,
    category_id        BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE loans
(
    id                    BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id               BIGINT      NOT NULL,
    loan_date             DATE        NOT NULL,
    expected_return_date  DATE        NOT NULL,
    effective_return_date DATE,
    loan_status           VARCHAR(20) NOT NULL,
    value_fine            DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE loan_items
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    loan_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    FOREIGN KEY (loan_id) REFERENCES loans (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE TABLE books_authors
(
    book_id   BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);