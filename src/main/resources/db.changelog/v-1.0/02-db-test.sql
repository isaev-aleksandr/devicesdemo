INSERT INTO projects (name) VALUES
('Project_1'),
('Project_2'),
('Project_3');

GO

INSERT INTO devices (project_id, serial_number) VALUES
(1, 'A4LMX'),
(2, 'B4KNW'),
(2, 'C4JOV'),
(3, 'D4IPU'),
(3, 'E4HQT'),
(3, 'F4GRS');

GO

INSERT INTO events (device_id, date, type, is_read) VALUES
(1, '2019-08-14', 'event', false),
(1, '1998-03-24', 'warning', true),
(1, '1996-04-24', 'error', true),
(2, '1999-01-14', 'event', false),
(2, '1993-02-24', 'warning', true),
(2, '1992-03-24', 'error', true),
(3, '1923-04-14', 'event', false),
(3, '1934-05-24', 'warning', true),
(4, '1993-06-24', 'error', true),
(5, '1923-07-14', 'event', false),
(5, '1912-08-24', 'warning', true),
(5, '1994-09-24', 'error', true),
(5, '2000-04-14', 'event', false),
(5, '1943-01-24', 'warning', true),
(6, '1922-02-24', 'error', true);

GO