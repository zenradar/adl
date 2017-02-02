CREATE TABLE users (
  id	INTEGER PRIMARY KEY,
  name 	VARCHAR(50),
  phone	VARCHAR(12),
  email	VARCHAR(50)
);

CREATE TABLE books (
  id		INTEGER PRIMARY KEY,
  title 	VARCHAR(80),
  author	VARCHAR(50),
  isbn		VARCHAR(13)
);

CREATE TABLE borrowed (
  user_id INTEGER NOT NULL,
  book_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, book_id),
  FOREIGN KEY (user_id) references users(id),
  FOREIGN KEY (book_id) references books(id)
);