create database sanquan;
use sanquan;
create table admin_user
(
    admin_id    int unsigned auto_increment
        primary key,
    admin_name  varchar(30)  null,
    login_id    varchar(255) null,
    password    varchar(255) null,
    salt        varchar(36)  null,
    update_time datetime     null,
    create_time datetime     null,
    constraint admin_user_login_id_uindex
        unique (login_id)
);