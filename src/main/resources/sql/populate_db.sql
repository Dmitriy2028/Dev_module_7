-- Додавання працівників
INSERT INTO worker (name, birthday, level, salary) VALUES
    ('John Doe', '1990-05-15', 'Trainee', 800),
    ('Jane Smith', '1985-12-20', 'Junior', 1200),
    ('Michael Johnson', '1980-08-10', 'Middle', 3000),
    ('Emily Williams', '1978-03-25', 'Senior', 6000),
    ('David Brown', '1992-07-05', 'Trainee', 900),
    ('Sarah Davis', '1989-11-30', 'Junior', 1400),
    ('Daniel Miller', '1983-09-17', 'Middle', 3500),
    ('Olivia Wilson', '1975-06-12', 'Senior', 7000),
    ('James Taylor', '1995-02-28', 'Trainee', 950),
    ('Emma Martinez', '1987-04-18', 'Junior', 1600);

-- Додавання клієнтів
INSERT INTO client (NAME) VALUES
    ('Acme Corporation'),
    ('Tech Solutions Ltd.'),
    ('Global Innovations Inc.'),
    ('DataWorks LLC'),
    ('Future Enterprises');

-- Додавання проєктів
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
    (1, '2023-01-01', '2023-06-30'),
    (2, '2023-02-15', '2023-08-15'),
    (3, '2023-04-10', '2023-10-20'),
    (4, '2023-06-20', '2024-01-10'),
    (5, '2023-08-05', '2024-03-15'),
    (1, '2023-10-01', '2024-04-30'),
    (2, '2023-11-15', '2024-05-15'),
    (3, '2024-01-10', '2024-07-20'),
    (4, '2024-03-20', '2024-10-10'),
    (5, '2024-05-05', '2024-12-15');

-- Проєкт 1
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 5);
-- Проєкт 2
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (2, 2),
    (2, 4),
    (2, 6);
-- Проєкт 3
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (3, 3),
    (3, 5),
    (3, 7),
    (3, 9);
-- Проєкт 4
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (4, 4),
    (4, 6),
    (4, 8),
    (4, 10);
-- Проєкт 5
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (5, 1),
    (5, 3),
    (5, 5),
    (5, 7),
    (5, 9);
-- Проєкт 6
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (6, 2),
    (6, 4),
    (6, 6);
-- Проєкт 7
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (7, 3),
    (7, 5),
    (7, 7),
    (7, 9);
-- Проєкт 8
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (8, 4),
    (8, 6),
    (8, 8);
-- Проєкт 9
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (9, 1),
    (9, 3),
    (9, 5);
-- Проєкт 10
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (10, 2),
    (10, 4),
    (10, 6),
    (10, 8),
    (10, 10);
