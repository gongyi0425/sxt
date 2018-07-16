/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2018/6/22 17:13:02                           */
/*==============================================================*/


alter table announcement
   drop constraint FK_ANNOUNCE_REFERENCE_EMPLOYEE;

alter table bargain
   drop constraint FK_BARGAIN_REFERENCE_CUSTOMER;

alter table bargain
   drop constraint FK_BARGAIN_REFERENCE_EMPLOYEE;

alter table bargain
   drop constraint FK_BARGAIN_REFERENCE_HOUSE;

alter table customer
   drop constraint FK_CUSTOMER_REFERENCE_TYPE;

alter table customer
   drop constraint FK_CUSTOMER_REFERENCE_STATUS;

alter table customer
   drop constraint FK_CUSTOMER_REFERENCE_SOURCE;

alter table customer
   drop constraint FK_CUSTOMER_REFERENCE_EMPLOYEE;

alter table employee
   drop constraint FK_EMPLOYEE_REFERENCE_JOB;

alter table employee
   drop constraint FK_EMPLOYEE_REFERENCE_EMPLOYEE;

alter table employee
   drop constraint FK_EMPLOYEE_REFERENCE_DEPT;

alter table house
   drop constraint FK_HOUSE_REFERENCE_HOUSETYP;

alter table solicitude
   drop constraint FK_SOLICITU_REFERENCE_EMPLOYEE;

alter table solicitude
   drop constraint FK_SOLICITU_REFERENCE_CUSTOMER;

drop table announcement cascade constraints;

drop table bargain cascade constraints;

drop table customer cascade constraints;

drop table dept cascade constraints;

drop table employee cascade constraints;

drop table house cascade constraints;

drop table housetype cascade constraints;

drop table job cascade constraints;

drop table solicitude cascade constraints;

drop table source cascade constraints;

drop table status cascade constraints;

drop table type cascade constraints;

/*==============================================================*/
/* Table: announcement                                          */
/*==============================================================*/
create table announcement 
(
   annid                NUMBER(10)           not null,
   empid                NUMBER(10),
   anntheme             VARCHAR2(30)         not null,
   anncontent           VARCHAR2(100)        not null,
   anntime              DATE                 not null,
   annendtime           DATE,
   constraint PK_ANNOUNCEMENT primary key (annid)
);

/*==============================================================*/
/* Table: bargain                                               */
/*==============================================================*/
create table bargain 
(
   barid                NUMBER(10)           not null,
   cusid                NUMBER(10),
   empid                NUMBER(10),
   houseid              NUMBER(10),
   houseaddress         VARCHAR2(100)        not null,
   typename             VARCHAR2(15)         not null,
   barprice             NUMBER(9,2)          not null,
   fixturedate          DATE,
   constraint PK_BARGAIN primary key (barid)
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer 
(
   cusid                NUMBER(10)           not null,
   empid                NUMBER(10),
   staid                NUMBER(10),
   typeid               NUMBER(10),
   souid                NUMBER(10),
   cusnema              VARCHAR2(12),
   cussex               VARCHAR2(3),
   birthday             DATE                 not null,
   cuscompany           VARCHAR2(33),
   cusjob               VARCHAR2(15),
   cusaddress           VARCHAR2(50),
   cusphone             NUMBER(11),
   cusplane             NUMBER(8),
   cusQQ                NUMBER(11),
   email                VARCHAR2(25),
   fouder               VARCHAR2(12),
   addtime              DATE,
   changeman            VARCHAR2(12),
   remark               VARCHAR2(100),
   Modifytime           DATE,
   constraint PK_CUSTOMER primary key (cusid)
);

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept 
(
   deptid               NUMBER(10)           not null,
   deptname             VARCHAR2(15),
   deptdescription      VARCHAR2(100),
   constraint PK_DEPT primary key (deptid)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee 
(
   empid                NUMBER(10)           not null,
   password             VARCHAR2(15)         not null,
   jobid                NUMBER(10),
   mgrid                NUMBER(10),
   deptid               NUMBER(10),
   empname              VARCHAR2(12)         not null,
   empage               NUMBER(3)            not null,
   empsex               VARCHAR2(3)          not null,
   empeducation         VARCHAR2(15)         not null,
   IDnumber             NUMBER(18)           not null,
   nation               VARCHAR2(15),
   marry                VARCHAR2(6),
   phone                NUMBER(11)           not null,
   QQ                   NUMBER(15),
   address              VARCHAR2(100)        not null,
   email                VARCHAR2(50),
   grade                NUMBER(5),
   brithdate            DATE,
   boarddate            DATE,
   wagesnum             NUMBER(18),
   constraint PK_EMPLOYEE primary key (empid)
);

/*==============================================================*/
/* Table: house                                                 */
/*==============================================================*/
create table house 
(
   houseid              NUMBER(10)           not null,
   typeid               NUMBER(10),
   housetype            VARCHAR2(30)         not null,
   houseaddress         VARCHAR2(100)        not null,
   houseprice           NUMBER(9,2)          not null,
   houseenvironment     VARCHAR2(100),
   housestate           VARCHAR2(10),
   floorspace           NUMBER(5,2),
   constraint PK_HOUSE primary key (houseid)
);

/*==============================================================*/
/* Table: housetype                                             */
/*==============================================================*/
create table housetype 
(
   typeid               NUMBER(10)           not null,
   typename             VARCHAR2(15)         not null,
   "desc"               VARCHAR2(100),
   constraint PK_HOUSETYPE primary key (typeid)
);

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job 
(
   jobid                NUMBER(10)           not null,
   jobname              VARCHAR2(15)         not null,
   description          VARCHAR2(100),
   constraint PK_JOB primary key (jobid)
);

/*==============================================================*/
/* Table: solicitude                                            */
/*==============================================================*/
create table solicitude 
(
   solid                NUMBER(10)           not null,
   empid                NUMBER(10),
   cusid                NUMBER(10),
   soltheme             VARCHAR2(30),
   solway               VARCHAR2(30)         not null,
   soltime              DATE                 not null,
   solnexttime          DATE,
   solremark            VARCHAR2(100),
   constraint PK_SOLICITUDE primary key (solid)
);

/*==============================================================*/
/* Table: source                                                */
/*==============================================================*/
create table source 
(
   souid                NUMBER(10)           not null,
   cussource            VARCHAR2(30)         not null,
   "desc"               VARCHAR2(100),
   constraint PK_SOURCE primary key (souid)
);

/*==============================================================*/
/* Table: status                                                */
/*==============================================================*/
create table status 
(
   staid                NUMBER(10)           not null,
   cusstatus            VARCHAR2(27)         not null,
   stadescription       VARCHAR2(100),
   constraint PK_STATUS primary key (staid)
);

/*==============================================================*/
/* Table: type                                                  */
/*==============================================================*/
create table type 
(
   typeid               NUMBER(10)           not null,
   custype              VARCHAR2(25)         not null,
   typedesc             VARCHAR2(100),
   constraint PK_TYPE primary key (typeid)
);

alter table announcement
   add constraint FK_ANNOUNCE_REFERENCE_EMPLOYEE foreign key (empid)
      references employee (empid);

alter table bargain
   add constraint FK_BARGAIN_REFERENCE_CUSTOMER foreign key (cusid)
      references customer (cusid);

alter table bargain
   add constraint FK_BARGAIN_REFERENCE_EMPLOYEE foreign key (empid)
      references employee (empid);

alter table bargain
   add constraint FK_BARGAIN_REFERENCE_HOUSE foreign key (houseid)
      references house (houseid);

alter table customer
   add constraint FK_CUSTOMER_REFERENCE_TYPE foreign key (typeid)
      references type (typeid);

alter table customer
   add constraint FK_CUSTOMER_REFERENCE_STATUS foreign key (staid)
      references status (staid);

alter table customer
   add constraint FK_CUSTOMER_REFERENCE_SOURCE foreign key (souid)
      references source (souid);

alter table customer
   add constraint FK_CUSTOMER_REFERENCE_EMPLOYEE foreign key (empid)
      references employee (empid);

alter table employee
   add constraint FK_EMPLOYEE_REFERENCE_JOB foreign key (jobid)
      references job (jobid);

alter table employee
   add constraint FK_EMPLOYEE_REFERENCE_EMPLOYEE foreign key (mgrid)
      references employee (empid);

alter table employee
   add constraint FK_EMPLOYEE_REFERENCE_DEPT foreign key (deptid)
      references dept (deptid);

alter table house
   add constraint FK_HOUSE_REFERENCE_HOUSETYP foreign key (typeid)
      references housetype (typeid);

alter table solicitude
   add constraint FK_SOLICITU_REFERENCE_EMPLOYEE foreign key (empid)
      references employee (empid);

alter table solicitude
   add constraint FK_SOLICITU_REFERENCE_CUSTOMER foreign key (cusid)
      references customer (cusid);

