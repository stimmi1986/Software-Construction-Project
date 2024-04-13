CREATE TABLE users (
    user_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fee_paid BOOLEAN DEFAULT false,
    department VARCHAR(255)
);

CREATE TABLE authors (
    author_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    book_id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE book_authors (
    book_id INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (book_id),
    FOREIGN KEY (author_id) REFERENCES authors (author_id)
);

CREATE TABLE lendings (
    lending_id serial PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books (book_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);
