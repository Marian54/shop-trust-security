CREATE TABLE Tire (
    id integer auto_increment,
    name varchar(50),
    company varchar(50),
    diameter int,
    price varchar(50),
    image varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE t_Order (
    id integer auto_increment,
    firstname varchar(50),
    lastname varchar(50),
    address varchar(50),
    tireid integer,
    PRIMARY KEY (id),
    FOREIGN KEY(tireid) references Tire(id)
);

CREATE TABLE t_User (
    id integer auto_increment,
    username varchar(50),
    email varchar(50),
    password varchar(50),
    roles varchar(50),
    PRIMARY KEY (id)
);