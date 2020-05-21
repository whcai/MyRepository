

mssql
-----------------------------------------------------------------------------

if exists (select 1
            from  sysobjects
           where  id = object_id('t_user')
            and   type = 'U')
   drop table t_user
go

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user (
   id                   int                  identity,
   userid               int                  not null,
   username             varchar(20)          not null,
   password             varchar(50)          not null,
   sex                  int                  null,
   roleid               int                  not null,
   cdate                datetime             not null,
   telphone             int                  null,
   deptid               int                  null,
   note                 varchar(100)         null,
   constraint PK_T_USER primary key (id)
)
go

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student (
   id                   int                  identity,
   sno                  int                  not null,
   name                 varchar(20)          not null,
   sex                  int                  null,
   mz                   varchar(10)          null,
   sid                  varchar(20)          null,
   telphone             int                  not null,
   college              varchar(20)          not null,
   profession           varchar(20)          not null,
   class                varchar(5)           null,
   rdate                datetime             null,
   bdate                datetime             null,
   other                varchar(100)         null,
   constraint PK_STUDENT primary key (id)
)
go




mysql
----------------------------------------------------------------------------------
drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment,
   userid               varchar(20) not null,
   username             varchar(50) not null,
   password             varchar(100) not null,
   roleid               int not null,
   createtime           time,
   lasttime             time,
   note                 varchar(500),
   primary key (id)
)engine=InnoDB,charset=utf8;

------------------------------------------------------------
查看表结构
desc t_user;

----------------------------------------------------------------------------
更改表结构
alter table t_user modify username varchar(50) not null;

----------------------------------------------------------------------------
插入字段（如果报1306错误，一般为插入字段与创建表格字段编码冲突）
insert into t_user(userid,username,password,roleid) values('admin','管理员','123',1);
insert into t_user(userid,username,password,roleid) values('whc','管理员','123',1);


------------------------------------------------------------------------------
drop table if exists t_module;

/*==============================================================*/
/* Table: t_module                                              */
/*==============================================================*/
create table t_module
(
   moduleid             varchar(10) not null,
   modulename           varchar(20),
   execfile             varchar(255),
   ifleaf               varchar(10),
   pos                  varchar(10),
   parentid             varchar(10),
   rel                  varchar(50),
   flag                 int,
   primary key (moduleid)
)engine=InnoDB charset=utf8;


insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100','教务系统','','0','1','','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100100','学生管理','','1','2','100','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100100100','学生信息','smanager/list','2','3','100100','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100150','班级管理','','1','2','100','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100150100','班级信息','bmanager/list','2','3','100150','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100200','学院管理','','1','2','100','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100200100','学院信息','cmanager/list','2','3','100200','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100250','年级管理','','1','2','100','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100250100','年级信息','gmanager/list','2','3','100250','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100300','专业管理','','1','2','100','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('100300100','专业信息','pmanager/list','2','3','100300','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('150','系统管理','','0','1','','');

insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('150100','用户管理','','1','2','150','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('150100100','职工信息','sysconfig/list','2','3','150100','');
insert into t_module(moduleid,modulename,execfile,ifleaf,pos,parentid,rel) values('150100150','权限设置','sysconfig/authority','2','3','150100','');

update t_module set rel='' where moduleid='100100100';
update t_module set rel='' where moduleid='100150100';
update t_module set rel='' where moduleid='100200100';
update t_module set rel='' where moduleid='100250100';
update t_module set rel='' where moduleid='100300100';
update t_module set rel='' where moduleid='150100100';
update t_module set rel='' where moduleid='150100150';

----------------------------------------------------------------------------------
drop table if exists student;

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   id                   int not null auto_increment,
   sno                  int not null,
   name                 varchar(50) not null,
   cardid               varchar(18) not null,
   sex                  int,
   cid 					int,
   pid        			int,
   bid					int,
   gid             		int,
   note                 varchar(100),
   primary key (id)
)engine=InnoDB  default charset=utf8;

insert into student(sno,name,cardid,sex,cid,pid,bid,gid) values(20200001,'张三','36250200000001',1,1,1,);


----------------------------------------------------------------------------------
drop table if exists college;

/*==============================================================*/
/* Table: college                                                */
/*==============================================================*/
create table college
(
   cid         			int not null auto_increment,
   cname             	varchar(20) not null,  
   editdate             time,
   note                 varchar(500),
   primary key (cid)
)engine=InnoDB,charset=utf8;

insert into college(cname) values("信工");

----------------------------------------------------------------------------------
drop table if exists profession;

/*==============================================================*/
/* Table: profession                                                */
/*==============================================================*/
create table profession
(
   pid         			int not null auto_increment,
   pname             	varchar(20) not null,  
   editdate             time,
   note                 varchar(500),
   primary key (pid)
)engine=InnoDB,charset=utf8;

insert into profession(pname) values('计算机');

----------------------------------------------------------------------------------
drop table if exists banji;

/*==============================================================*/
/* Table: banji                                                */
/*==============================================================*/
create table banji
(
   bid                   int not null auto_increment,
   bname            	varchar(20) not null, 
   editdate             time,
   note                 varchar(500),
   primary key (bid)
)engine=InnoDB,charset=utf8;

insert into banji(bname) values('计算机(一)班');

----------------------------------------------------------------------------------
drop table if exists grade;

/*==============================================================*/
/* Table: grade                                                */
/*==============================================================*/
create table grade
(
   gid                  int not null auto_increment,   
   gname            	varchar(20) not null,
   xz            		int,  
   note                 varchar(500),
   primary key (gid)
)engine=InnoDB,charset=utf8;

insert into grade(gname,xz) values('2020级',4);

----------------------------------------------------------------------------------
drop table if exists c_user;

/*==============================================================*/
/* Table: c_user                                                */
/*==============================================================*/
create table c_user
(
   id                   int not null auto_increment,
   userid               varchar(20) not null,
   username             varchar(20) not null,
   password             varchar(100) not null,   
   editdate             time,
   note                 varchar(500),
   primary key (id)
)engine=InnoDB,charset=utf8;

insert into c_user(userid,username,password) values('test1','客户1','123');
insert into c_user(userid,username,password) values('test2','客户2','123');

plsql



