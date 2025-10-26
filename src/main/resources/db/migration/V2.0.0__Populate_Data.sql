INSERT INTO categories (name, description)
VALUES ('Ficção Científica', 'Obras de ficção baseadas em avanços científicos.'),
       ('Fantasia', 'Obras com elementos mágicos e sobrenaturais.'),
       ('Não-Ficção', 'Obras baseadas em fatos e informações reais.');

INSERT INTO authors (name, birth_date, nationality, biography)
VALUES ('J.R.R. Tolkien', '1892-01-03', 'Britânico', 'Autor de O Senhor dos Anéis.'),
       ('Isaac Asimov', '1920-01-02', 'Russo-Americano', 'Autor da série Fundação.'),
       ('Yuval Noah Harari', '1976-02-24', 'Israelense', 'Autor de Sapiens.');

INSERT INTO books (isbn, title, publisher, published_year, number_pages, total_quantity, available_quantity,
                   category_id)
VALUES ('978-0544003415', 'O Senhor dos Anéis', 'HarperCollins', 1954, 1178, 10, 10,
        (SELECT id FROM categories WHERE name = 'Fantasia')),
       ('978-0553293357', 'Fundação', 'Doubleday', 1951, 255, 5, 5,
        (SELECT id FROM categories WHERE name = 'Ficção Científica')),
       ('978-0062316097', 'Sapiens: Uma Breve História da Humanidade', 'Harper', 2011, 443, 8, 8,
        (SELECT id FROM categories WHERE name = 'Não-Ficção')),
       ('978-0345391803', 'O Guia do Mochileiro das Galáxias', 'Pan Books', 1979, 216, 3, 0,
        (SELECT id FROM categories WHERE name = 'Ficção Científica'));

INSERT INTO books_authors (book_id, author_id)
VALUES ((SELECT id FROM books WHERE title = 'O Senhor dos Anéis'),
        (SELECT id FROM authors WHERE name = 'J.R.R. Tolkien')),
       ((SELECT id FROM books WHERE title = 'Fundação'), (SELECT id FROM authors WHERE name = 'Isaac Asimov')),
       ((SELECT id FROM books WHERE title = 'Sapiens: Uma Breve História da Humanidade'),
        (SELECT id FROM authors WHERE name = 'Yuval Noah Harari'));

INSERT INTO users (name, cpf, email, phone, registration_date, address, active)
VALUES ('Ana Silva', '12345678901', 'ana.silva@email.com', '11987654321', '2023-01-15', 'Rua A, 123', TRUE),
       ('Bruno Costa', '98765432109', 'bruno.costa@email.com', '21912345678', '2023-03-22', 'Av. B, 456', TRUE);

INSERT INTO loans (usuario_id, loanDate, expected_return_date, loan_status)
VALUES ((SELECT id FROM users WHERE name = 'Ana Silva'), CURRENT_DATE(), DATEADD('DAY', 14, CURRENT_DATE()),
        'ACTIVE');

SET
@last_loan_id_1 =
SELECT MAX(id)
FROM loans;
INSERT INTO loan_items (loan_id, book_id)
VALUES (@last_loan_id_1, (SELECT id FROM books WHERE title = 'Fundação'));

INSERT INTO loans (user_id, loan_date, expected_return_date, loan_status)
VALUES ((SELECT id FROM users WHERE name = 'Bruno Costa'), DATEADD('DAY', -20, CURRENT_DATE()),
        DATEADD('DAY', -6, CURRENT_DATE()), 'ACTIVE');

SET
@last_loan_id_2 =
SELECT MAX(id)
FROM loans;
INSERT INTO loan_items (loan_id, book_id)
VALUES (@last_loan_id_2, (SELECT id FROM books WHERE title = 'Sapiens: Uma Breve História da Humanidade'));