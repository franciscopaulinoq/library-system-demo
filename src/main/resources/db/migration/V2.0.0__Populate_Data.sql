INSERT INTO categories (name, description)
VALUES ('Ficção Científica', 'Obras de ficção baseadas em avanços científicos.'),
       ('Fantasia', 'Obras com elementos mágicos e sobrenaturais.'),
       ('Não-Ficção', 'Obras baseadas em fatos e informações reais.');

INSERT INTO authors (name, birth_date, nationality, biography)
VALUES ('J.R.R. Tolkien', '1892-01-03', 'Britânico', 'Autor de O Senhor dos Anéis.'),
       ('Isaac Asimov', '1920-01-02', 'Russo-Americano', 'Autor da série Fundação.'),
       ('Yuval Noah Harari', '1976-02-24', 'Israelense', 'Autor de Sapiens.');

INSERT INTO books (isbn, title, publisher, published_year, number_pages, total_quantity, available_quantity, category_id)
SELECT '978-0544003415', 'O Senhor dos Anéis', 'HarperCollins', 1954, 1178, 10, 10, id FROM categories WHERE name = 'Fantasia'
UNION ALL
SELECT '978-0553293357', 'Fundação', 'Doubleday', 1951, 255, 5, 5, id FROM categories WHERE name = 'Ficção Científica'
UNION ALL
SELECT '978-0062316097', 'Sapiens: Uma Breve História da Humanidade', 'Harper', 2011, 443, 8, 8, id FROM categories WHERE name = 'Não-Ficção'
UNION ALL
SELECT '978-0345391803', 'O Guia do Mochileiro das Galáxias', 'Pan Books', 1979, 216, 3, 0, id FROM categories WHERE name = 'Ficção Científica';

INSERT INTO books_authors (book_id, author_id)
SELECT b.id, a.id
FROM books b, authors a
WHERE b.title = 'O Senhor dos Anéis' AND a.name = 'J.R.R. Tolkien'
UNION ALL
SELECT b.id, a.id
FROM books b, authors a
WHERE b.title = 'Fundação' AND a.name = 'Isaac Asimov'
UNION ALL
SELECT b.id, a.id
FROM books b, authors a
WHERE b.title = 'Sapiens: Uma Breve História da Humanidade' AND a.name = 'Yuval Noah Harari';

INSERT INTO users (name, cpf, email, phone, registration_date, address, active)
VALUES ('Ana Silva', '12345678901', 'ana.silva@email.com', '11987654321', '2023-01-15', 'Rua A, 123', TRUE),
       ('Bruno Costa', '98765432109', 'bruno.costa@email.com', '21912345678', '2023-03-22', 'Av. B, 456', TRUE);

WITH new_loan AS (
INSERT INTO loans (user_id, loan_date, expected_return_date, loan_status)
SELECT id, CURRENT_DATE, CURRENT_DATE + INTERVAL '14 day', 'ACTIVE'
FROM users
WHERE name = 'Ana Silva'
    RETURNING id
    )
INSERT INTO loan_items (loan_id, book_id)
SELECT n.id, b.id
FROM new_loan n, books b
WHERE b.title = 'Fundação';

WITH new_loan AS (
INSERT INTO loans (user_id, loan_date, expected_return_date, loan_status)
SELECT id, CURRENT_DATE - INTERVAL '20 day', CURRENT_DATE - INTERVAL '6 day', 'ACTIVE'
FROM users
WHERE name = 'Bruno Costa'
    RETURNING id
    )
INSERT INTO loan_items (loan_id, book_id)
SELECT n.id, b.id
FROM new_loan n, books b
WHERE b.title = 'Sapiens: Uma Breve História da Humanidade';