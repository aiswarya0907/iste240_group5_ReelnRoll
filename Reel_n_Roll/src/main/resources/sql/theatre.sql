CREATE TABLE IF NOT EXISTS theatre (
                                       theatre_id BIGINT PRIMARY KEY AUTO_INCEREMENT,
                                       theatre_name VARCHAR(100),
    location VARCHAR(100),
    total_screens INT
    );

INSERT INTO theatre (theatre_id, theatre_name, location, total_screens)
VALUES (1, 'VOX CINEMA', 'Dubai Mall', 12);

INSERT INTO theatre (theatre_id, theatre_name, location, total_screens)
VALUES (2, 'NOVO CINEMA', 'Sharjah', 8);

INSERT INTO theatre (theatre_id, theatre_name, location, total_screens)
VALUES (3, 'REEL CINEMA', 'Abu Dhabi', 10);