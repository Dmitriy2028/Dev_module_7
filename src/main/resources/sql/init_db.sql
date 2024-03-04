CREATE TABLE worker (
	id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(1000) NOT NULL CHECK (LENGTH(name) > 2),
    birthday date CHECK (YEAR(birthday) > 1900),
    level varchar(20) NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary int CHECK (salary >= 100 AND salary <= 100000)
);

CREATE TABLE client (
	id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(1000) NOT NULL CHECK (LENGTH(name) > 2)
);

CREATE TABLE project (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	client_id bigint,
	start_date date,
	finish_date date
);

CREATE TABLE project_worker (
	project_id bigint,
	worker_id bigint,
	PRIMARY KEY (project_id, worker_id),
	FOREIGN KEY (project_id) REFERENCES project(id),
	FOREIGN KEY (worker_id) REFERENCES worker(id)
);