insert into role (role_Id, role_Name)
values (1, 'ROLE_ADMIN')
ON DUPLICATE KEY UPDATE role_Id = 1;

insert into role (role_Id, role_Name)
values (2, 'ROLE_USER')
ON DUPLICATE KEY UPDATE role_Id = 2;
insert into user (user_Id, username, password, email,enable)
values (2, 'dat', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu','dat@gmail.com', 1)
ON DUPLICATE KEY
    UPDATE user_Id=2;
    
insert into user (user_Id, username, password, email,enable)
values (1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu','admin@gmail.com', 1)
ON DUPLICATE KEY
    UPDATE user_Id=1;
    
insert into user_role (ur_Id, user_Id, role_Id)
values (1, 1, 1)
ON DUPLICATE KEY UPDATE ur_Id = 1;
 
insert into user_role (ur_Id, user_Id, role_Id)
values (2, 2, 2)
ON DUPLICATE KEY UPDATE ur_Id = 2;