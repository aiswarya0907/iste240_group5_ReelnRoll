DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        genre VARCHAR(100),
                        language VARCHAR(50),
                        rating VARCHAR(10),
                        duration INT,
                        description TEXT
);

INSERT INTO movies (id, title, genre, language, rating, duration, description) VALUES
                                                                                          (1, 'Inception', 'Sci-Fi', 'English', 'PG-13', 148, 'A thief who steals corporate secrets through dream-sharing technology.'),
                                                                                          (2, 'The Dark Knight', 'Action', 'English', 'PG-13', 152, 'Batman faces the Joker, a criminal mastermind.'),
                                                                                          (3, 'Interstellar', 'Sci-Fi', 'English', 'PG-13', 169, 'A team of explorers travel through a wormhole in space.'),
                                                                                          (4, 'John Wick', 'Action', 'English', 'R', 101, 'A former hitman comes out of retirement to seek revenge.'),
                                                                                          (5, 'Toy Story', 'Animation', 'English', 'G', 81, 'A cowboy doll is jealous of a new space ranger toy.'),
                                                                                          (6, 'The Matrix', 'Sci-Fi', 'English', 'R', 136, 'A computer hacker learns about the true nature of reality.');

ALTER TABLE movies AUTO_INCREMENT = 7;