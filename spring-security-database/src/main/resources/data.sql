INSERT INTO users(username,password,enabled)
VALUES('maciek','{noop}maciek123',true);

INSERT INTO authorities(username, authority)
VALUES('maciek','ROLE_USER');