DROP TABLE IF EXISTS authorities;
drop table if exists users;

create table users(
    username VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(45) NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1,
    primary key (username)
);

create table authorities(
    user_role_id int(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL UNIQUE,
    authority varchar(45) NOT NULL,
    PRIMARY KEY (user_role_id),
    unique KEY (authority,username),
    key fk_username_idx(username),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users(username));

