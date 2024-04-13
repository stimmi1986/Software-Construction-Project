INSERT INTO authors (name) VALUES ('Mike Hemingway');
INSERT INTO authors (name) VALUES ('Jack Red');
INSERT INTO authors (name) VALUES ('Samantha Bloom');
INSERT INTO authors (name) VALUES ('Annabelle Sweets');
INSERT INTO authors (name) VALUES ('Leo Fitzpatrick');

INSERT INTO books (title) VALUES ('Journeys of the Mind');
INSERT INTO books (title) VALUES ('The Final Sunset');
INSERT INTO books (title) VALUES ('Code Complete');
INSERT INTO books (title) VALUES ('Artificial Dreams');
INSERT INTO books (title) VALUES ('The Healthy Programmer');
INSERT INTO books (title) VALUES ('Silent Depths');
INSERT INTO books (title) VALUES ('Gardens of Mars');
INSERT INTO books (title) VALUES ('The Innovator');
INSERT INTO books (title) VALUES ('A Guide to the Stars');
INSERT INTO books (title) VALUES ('Philosophy of Code');

INSERT INTO users (name, fee_paid) VALUES ('John Doe', true);
INSERT INTO users (name, fee_paid) VALUES ('Jane Smith', false);
INSERT INTO users (name, fee_paid) VALUES ('Emily Stone', true);

INSERT INTO users (name, department) VALUES ('Professor Anderson', 'Computer Science');

INSERT INTO book_authors (book_id, author_id) VALUES (1, 1);
INSERT INTO book_authors (book_id, author_id) VALUES (2, 2);
INSERT INTO book_authors (book_id, author_id) VALUES (3, 3);
INSERT INTO book_authors (book_id, author_id) VALUES (4, 4);
INSERT INTO book_authors (book_id, author_id) VALUES (5, 5);
INSERT INTO book_authors (book_id, author_id) VALUES (6, 1);
INSERT INTO book_authors (book_id, author_id) VALUES (7, 2);
INSERT INTO book_authors (book_id, author_id) VALUES (8, 3);
INSERT INTO book_authors (book_id, author_id) VALUES (9, 4);
INSERT INTO book_authors (book_id, author_id) VALUES (10, 5);
