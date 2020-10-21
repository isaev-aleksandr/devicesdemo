INSERT INTO projects (name) VALUES
('Iphone'),
('Samsung'),
('Xiaomi');

GO

INSERT INTO devices (project_id, serial_number) VALUES
(4, 'A4LMX'),
(4, 'B4KNW'),
(5, 'C4JOV'),
(5, 'D4IPU'),
(6, 'E4HQT'),
(6, 'F4GRS');

GO

INSERT INTO events (device_id, date, type, is_read) VALUES
(7, '2020-10-22', 'event', false),
(7, '2020-10-22', 'event', true),
(7, '2020-10-22', 'event', true),
(7, '2020-10-22', 'event', false),
(7, '2020-10-22', 'event', true),
(7, '2020-10-22', 'event', true),
(8, '2020-10-22', 'event', false),
(8, '2020-10-22', 'event', true),
(8, '2020-10-22', 'error', true),
(8, '2020-10-22', 'event', false),
(9, '2020-10-22', 'warning', true),
(10, '2020-10-22', 'error', true),
(11, '2020-10-22', 'event', false),
(12, '2020-10-22', 'event', true),
(12, '2020-10-22', 'event', true);

GO