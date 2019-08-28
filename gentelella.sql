create table menu
(
    id   bigint default 0 not null comment '主键'
        primary key,
    name varchar(50)      null comment '名称',
    url  varchar(100)     null comment '路径',
    pid  bigint           null comment '父级id'
)
    comment '菜单表';

INSERT INTO gentelella.menu (id, name, url, pid) VALUES (1, '主页', null, 0);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (2, '系统管理', null, 0);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (3, '部门管理', null, 0);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (4, '员工管理', null, 0);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (101, '控制台', '/common/index.do', 1);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (201, '菜单', '/menu/index.do', 2);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (202, '角色', '/role/index.do', 2);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (203, '权限', '/perm/index.do', 2);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (204, '角色菜单', '/role_menu/index.do', 2);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (205, '角色权限', '/role_perm/index.do', 2);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (301, '部门信息', '/depart/index.do', 3);
INSERT INTO gentelella.menu (id, name, url, pid) VALUES (401, '员工信息', '/employ/index.do', 4);
create table permission
(
    id     bigint auto_increment
        primary key,
    name   varchar(100) null,
    `desc` varchar(100) null,
    url    varchar(100) null
);

INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (1, 'addProduct', '增加产品', '/addProduct');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (2, 'deleteProduct', '删除产品', '/deleteProduct');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (3, 'editeProduct', '编辑产品', '/editeProduct');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (4, 'updateProduct', '修改产品', '/updateProduct');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (5, 'listProduct', '查看产品', '/listProduct');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (6, 'addOrder', '增加订单', '/addOrder');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (7, 'deleteOrder', '删除订单', '/deleteOrder');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (8, 'editeOrder', '编辑订单', '/editeOrder');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (9, 'updateOrder', '修改订单', '/updateOrder');
INSERT INTO gentelella.permission (id, name, `desc`, url) VALUES (10, 'listOrder', '查看订单', '/listOrder');
create table role
(
    id     bigint auto_increment
        primary key,
    name   varchar(100) null,
    `desc` varchar(100) null
);

INSERT INTO gentelella.role (id, name, `desc`) VALUES (1, 'admin', '超级管理员');
INSERT INTO gentelella.role (id, name, `desc`) VALUES (2, 'productManager', '产品管理员');
INSERT INTO gentelella.role (id, name, `desc`) VALUES (3, 'orderManager', '订单管理员');
INSERT INTO gentelella.role (id, name, `desc`) VALUES (4, 'user', '用户');
create table role_menu
(
    id  int auto_increment comment '主键'
        primary key,
    rid int default 0 not null comment '角色id',
    mid int default 0 not null comment '菜单id'
)
    comment '角色菜单表';

create index mid
    on role_menu (mid);

create index rid
    on role_menu (rid);


create table role_permission
(
    id  bigint auto_increment
        primary key,
    rid bigint null,
    pid bigint null
);

INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (1, 1, 1);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (2, 1, 2);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (3, 1, 3);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (4, 1, 4);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (5, 1, 5);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (6, 1, 6);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (7, 1, 7);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (8, 1, 8);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (9, 1, 9);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (10, 1, 10);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (11, 2, 1);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (12, 2, 2);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (13, 2, 3);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (14, 2, 4);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (15, 2, 5);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (50, 3, 10);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (51, 3, 9);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (52, 3, 8);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (53, 3, 7);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (54, 3, 6);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (55, 3, 1);
INSERT INTO gentelella.role_permission (id, rid, pid) VALUES (56, 5, 11);
create table user
(
    id          int                          not null comment '主键'
        primary key,
    username    varchar(50)  default ''      null comment '用户名',
    password    varchar(50)  default ''      null comment '密码',
    remember_me varchar(10)  default 'false' null,
    email       varchar(50)  default ''      null comment '邮箱',
    gender      varchar(50)  default 'male'  null comment '性别',
    telephone   varchar(50)  default ''      null comment '联系方式',
    salt        varchar(100) default ''      null comment '加密字符',
    create_time varchar(50)                  null comment '设立时间'
);

INSERT INTO gentelella.user (id, username, password, remember_me, email, gender, telephone, salt, create_time) VALUES (1, 'ximen', 'a7d59dfc5332749cb801f86a24f5f590', 'false', '1403473722@qq.com', 'male', '18503817798', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-08-24 10:25');
INSERT INTO gentelella.user (id, username, password, remember_me, email, gender, telephone, salt, create_time) VALUES (2, 'dongsheng', '43e28304197b9216e45ab1ce8dac831b', 'false', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25');
create table user_role
(
    id  bigint auto_increment
        primary key,
    uid bigint null,
    rid bigint null
);

INSERT INTO gentelella.user_role (id, uid, rid) VALUES (43, 2, 2);
INSERT INTO gentelella.user_role (id, uid, rid) VALUES (45, 1, 1);