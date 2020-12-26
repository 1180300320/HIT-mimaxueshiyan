# 创建数据库
drop database if exists hitssm;
create database if not exists hitssm;

# 手动提交
commit;

use hitssm;

#创建数据表
drop table if exists user;
create table if not exists user(
    uid integer auto_increment comment '用户id', # 自动增长
    username varchar(20) not null comment '用户登录名',  # 不能为空
    password varchar(32) not null comment '登陆密码',  # 加密后的 32位
    usertype varchar(7) not null comment '用户类型',  # 用户：user 商家:shopper 管理员：admin
    primary key (`uid`) # 将uid设置为主键
)comment '用户登陆表';

commit;
# 插入测试数据
insert into user (username, password,usertype) values ('wsf','111','admin');
insert into user (uid, username, password,usertype) values (null, 'zhangsan','11233','user');
insert into user (uid, username, password,usertype) values (14, 'aaa','443','user');
insert into user (uid, username, password,usertype) values (7, 'lisi','8883','user');
insert into user (uid, username, password,usertype) values (8, 'li8','444','shopper');
insert into user (uid, username, password,usertype) values (null, 'admin','789','admin');
commit;



#创建货物数据表
drop table if exists goods;
    create table if not exists goods(
    itemid integer auto_increment comment '商品id', # 自动增长
    itemname varchar(20) not null comment '商品名',  # 不能为空
    itemprice float(10,3) not null comment '商品单价',  # 不能为空
    owner varchar(32) not null comment '所属者',  # 必须属于user列表中的某个商家
    number bigint not null comment '货物剩余数量',  # >0
    primary key (`itemid`) # 将uid设置为主键
)comment '货物登记表';
commit;

# 插入测试数据
insert into goods (itemname, itemprice, owner,number) values ('mb',10.2,'35',2);
insert into goods (itemid, itemname, itemprice, owner, number) values (null, 'naicha',3.0,'11233',6);
insert into goods (itemid, itemname, itemprice, owner, number) values (14, 'aaa',46.7,'wzf',76);
insert into goods (itemid, itemname, itemprice, owner, number) values (7, 'lisi',666,'lisi',78);
insert into goods (itemid, itemname, itemprice, owner, number) values (8, 'li8',97779.45,'444',90);
insert into goods (itemid, itemname, itemprice, owner, number) values (null, 'admin',7.3,'789',90);
insert into goods (itemid, itemname, itemprice, owner, number) values (null, '王五',56,'789',90);
commit;
