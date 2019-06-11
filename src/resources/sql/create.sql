use mydb;

drop table if exists `project`;

create table `project`
(
  id           int          not null auto_increment primary key,
  project_name nvarchar(50) not null,
  status       int,
  create_time  datetime     not null,
  creator_id   int          not null,
  principal_id int          not null,
  acceptor_id  int          not null,
  start_time   datetime     not null,
  end_time     datetime,
  details      text default null
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;



drop table if exists `status`;

create table `status`
(
  id          int          not null primary key,
  status_name nvarchar(50) not null
) engine = InnoDB
  default charset = utf8;



drop table if exists `users`;

create table `users`
(
  id         int          not null auto_increment primary key,
  user_id    nvarchar(10) not null,
  user_name  nvarchar(50) not null,
  department nvarchar(50) not null
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;



drop table if exists `project_users`;

create table `project_users`
(
  id         int auto_increment not null primary key,
  project_id int                not null,
  user_id    int                not null,
  role       int                not null
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;



drop table if exists `role`;

create table `role`
(
  id        int          not null primary key,
  role_name nvarchar(50) not null
) engine = InnoDB
  default charset = utf8;



insert into `project`(project_name, status, create_time, creator_id, principal_id, acceptor_id, start_time, end_time,
                    details)
values ('project1', 1, '2019-08-10 01:00:00', 1, 2, 3, '2019-08-11 01:00:00', '2019-08-15 01:00:00', 'this is a book');

insert into `status`
values (1, 'completed');
insert into `status`
values (2, 'incomplete');

insert into `users`(empno, user_name, department)
values ('0001', 'zhao', 'human resource department');
insert into `users`(empno, user_name, department)
values ('0002', 'qian', 'executive department');
insert into `users`(empno, user_name, department)
values ('0003', 'zhao', 'sales department');

insert into `project_users`(project_id, user_id, role)
values (1, 1, 1);
insert into `project_users`(project_id, user_id, role)
VALUES (1, 2, 2);
insert into `project_users`(project_id, user_id, role)
VALUES (1, 3, 3);


insert into `role`
values (1, 'creator');
insert into `role`
values (2, 'principal');
insert into `role`
values (3, 'acceptor');