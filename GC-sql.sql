create table staff(
		s_id int not null primary key,
		s_name varchar(50) not null,
		s_pwd varchar(50) not null,
		s_age int not null,
		s_type int not null,
		s_phone varchar(50) not null,
		s_entrytime date not null
)
insert into staff(s_id,s_name,s_pwd,s_age,s_type,s_phone,s_entrytime) values(1001,'付金鑫','123456',20,1,'17666274585',now())
insert into staff(s_id,s_name,s_pwd,s_age,s_type,s_phone,s_entrytime) values(1002,'付金鑫','123456',20,1,'17666274585',now()),
(1003,'付金鑫','123456',20,1,'17666274585',now()),
(1004,'付金鑫','123456',20,1,'17666274585',now()),
(1005,'付金鑫','123456',20,1,'17666274585',now()),
(1006,'付金鑫','123456',20,1,'17666274585',now()),
(1007,'付金鑫','123456',20,1,'17666274585',now()),
(1008,'付金鑫','123456',20,1,'17666274585',now()),
(1009,'付金鑫','123456',20,1,'17666274585',now())

select * from staff

create table stafftype(
		st_id int primary key not null auto_increment,
		st_message varchar(50) not null,
		st_type varchar(50) not null
)
insert into stafftype(st_message,st_type) values('管理员',1)
insert into stafftype(st_message,st_type) values('垃圾处理员',2)
insert into stafftype(st_message,st_type) values('垃圾信息记录员',3)
select * from stafftype

create table urbangarbageinformation(
	 gi_id int not null primary key,
	 gi_city varchar(50) not null,
	 gi_total decimal(16,2) not null,
	 gi_harmful decimal(16,2) not null,
	 gi_recyclable decimal(16,2) not null,
	 gi_kitchenwaste decimal(16,2) not null,
	 gi_other decimal(16,2) not null,
	 gi_intodate date not null,
	 gi_staff varchar(50) not null
)

insert into urbangarbageinformation(gi_id,gi_city,gi_total,gi_harmful,gi_recyclable,gi_kitchenwaste,gi_other,gi_intodate,gi_staff)
values(1001,"珠海",20.43,3.1,10.43,3.4,4,now(),'付四金'),
(1002,"深圳",32.36,12,23.43,2.4,32.14,now(),'张三'),
(1003,"珠海",42.3,13,23.43,14.5,63.14,now(),'李四'),
(1004,"广州",12.36,11.55,23.43,24.1,64.14,now(),'王五'),
(1005,"上海",45.31,12.45,26.23,21.45,35.14,now(),'周六'),
(1006,"北京",36.14,4.2,22.83,32.14,36.24,now(),'付仙女'),
(1007,"赣州",32.54,4.13,22.73,21.11,14.23,now(),'李顺'),
(1008,"广州",36.23,34.12,24.73,12.36,56.12,now(),'官威'),
(1009,"深圳",32.14,3.15,23,11.36,64.12,now(),'谭国平'),
(1010,"珠海",39.64,6.45,11,23.13,28.14,now(),'宾华安'),
(1011,"澳门",66.33,6.32,2,12.11,34.65,now(),'李杰峰'),
(1012,"香港",17.25,6.42,5,14,71.12,now(),'马乐言'),
(1013,"台湾",63.21,6.14,21,5,66.33,now(),'龙年'),
(1014,"澳门",34.12,6.42,23,15,55.14,now(),'盖伦'),
(1015,"珠海",12.15,7.32,11.95,16,43.64,now(),'王亮'),
(1016,"佛山",45.39,8.32,21.52,21,24.33,now(),'陈前进'),
(1017,"襄阳",15.36,9.12,14.56,25,32,now(),'易翔'),
(1018,"荆州",32.14,11.21,12.84,31,45,now(),'陈伟瀚'),
(1019,"中山",26.95,14.14,12.03,32,11,now(),'刘杰'),
(1020,"上海",24.85,11.11,24.21,24.22,43,now(),'张家杰'),
(1021,"广州",34.15,13.21,11.35,32,11,now(),'熊越明'),
(1022,"深圳",24.76,10.21,12.23,7,2,now(),'杨俊杰')


delete from urbangarbageinformation
select * from urbangarbageinformation
select count(*) from (select distinct gi_city from urbangarbageinformation) a
select sum(gi_kitchenwaste) from urbangarbageinformation

create table stafftype(
	 st_id int not null primary key,
	 st_message varchar(20) not null
)

create table garbagetype(
	 gt_id int not null primary key,
	 gt_message varchar(20) not null
)
insert into garbagetype(gt_id,gt_message)
values(1,'有害垃圾'),
(2,'可回收垃圾'),
(3,'厨余垃圾'),
(4,'其他垃圾')
select * from garbagetype

create table garbagehandle(
	 gh_id int not null primary key,
	 gh_city varchar(50) not null,
	 gh_type int not null,
	 gh_total decimal(16,2) not null,
	 gh_time date not null,
	 gh_staff varchar(50) not null,
	 gh_mode int not null
)
insert into garbagehandle(gh_id,gh_city,gh_type,gh_total,gh_time,gh_staff,gh_mode)
values(1001,'珠海',1,20.1,now(),'付四金',1)
select gh_id,gh_city,gt_message,gh_total,gh_time,gh_staff,ht.ht_message from garbagehandle gh 
left join garbagetype gt on gh.gh_type=gt.gt_id 
left join handletype ht on gh.gh_mode=ht.ht_id

select * from garbagehandle

create table handletype(
	 s_id int not null primary key,
	 ht_message varchar(20) not null
)

insert into handletype(ht_id,ht_message)
values(1,'焚烧'),
(2,'填埋'),
(3,'回收利用'),
(4,'堆肥')
select * from handletype


create table staffrde(
	 s_type int not null,
	 st_type int not null
)
insert into staffrde(s_type,st_type) values(1,1),(2,2),(3,3),(4,4)

create table staffAuthority(
	 sa_id int not null,
	 sa_Authority varchar(50) not null,
	 sa_message varchar(50) not null
)
insert into staffAuthority(sa_id,sa_Authority,sa_message) values (3,"/logins","登录")


(1,"/getStaffMenu","动态菜单"),
(1,"/ghList","查询垃圾处理信息"),
(1,"/insertGhInfo","添加垃圾处理信息"),
(1,"/updateGhInfo","修改垃圾处理信息"),
(1,"/deleteGhInfo","删除垃圾处理信息"),

(1,"/giList","查询垃圾信息"),
(1,"/insertGiInfo","添加垃圾信息"),
(1,"/updateGiInfo","修改垃圾信息"),
(1,"/deleteGiInfo","删除垃圾信息"),
(1,"/getTotal","垃圾总量信息"),
(1,"/getCityNum","监控城市数量"),
(1,"/getHarmful","有害垃圾信息"),
(1,"/getRecyclable","可回收垃圾信息"),
(1,"/getGiOther","其他垃圾信息"),
(1,"/getKitchenWaste","厨余垃圾信息"),
(1,"/getGiListByCity","搜索城市"),


(1,"/sList","职员信息"),
(1,"/getsListById","查询职员"),
(1,"/insertStaff","添加职员信息"),
(1,"/updateStaff","修改职员信息"),
(1,"/deleteStaff","删除职员信息"),
(1,"/updateStaffType","修改权限"),
(1,"/getStaff","获取职员信息"),

(1,"/GarbageDisposal.html","垃圾处理信息界面"),
(1,"/GarbageDisposalEdit.html","编辑垃圾处理信息界面"),
(1,"/GarbageInfo.html","垃圾信息界面"),
(1,"/GarbageInfoEdit.html","编辑垃圾信息界面"),
(1,"/Staff.html","职员管理界面"),
(1,"/gchome.html","主界面"),
(1,"/500.html","异常界面"),
(1,"/login.html","登录界面"),
(1,"/logins","登录")

insert into staffAuthority(sa_id,sa_Authority,sa_message)
(2,"/getStaffMenu","动态菜单"),
(2,"/ghList","查询垃圾处理信息"),
(2,"/insertGhInfo","添加垃圾处理信息"),
(2,"/updateGhInfo","修改垃圾处理信息"),
(2,"/deleteGhInfo","删除垃圾处理信息"),

(2,"/giList","查询垃圾信息"),
(2,"/getTotal","垃圾总量信息"),
(2,"/getCityNum","监控城市数量"),
(2,"/getHarmful","有害垃圾信息"),
(2,"/getRecyclable","可回收垃圾信息"),
(2,"/getGiOther","其他垃圾信息"),
(2,"/getKitchenWaste","厨余垃圾信息"),
(2,"/getGiListByCity","搜索城市"),


(2,"/getStaff","获取职员信息"),

(2,"/GarbageDisposal.html","垃圾处理信息界面"),
(2,"/GarbageDisposalEdit.html","编辑垃圾处理信息界面"),
(2,"/gchome.html","主界面"),
(2,"/500.html","异常界面"),
(2,"/login.html","登录界面")


insert into staffAuthority(sa_id,sa_Authority,sa_message) values
(3,"/getStaffMenu","动态菜单"),
(3,"/giList","查询垃圾信息"),
(3,"/insertGiInfo","添加垃圾信息"),
(3,"/updateGiInfo","修改垃圾信息"),
(3,"/deleteGiInfo","删除垃圾信息"),
(3,"/getTotal","垃圾总量信息"),
(3,"/getCityNum","监控城市数量"),
(3,"/getHarmful","有害垃圾信息"),
(3,"/getRecyclable","可回收垃圾信息"),
(3,"/getGiOther","其他垃圾信息"),
(3,"/getKitchenWaste","厨余垃圾信息"),
(3,"/getGiListByCity","搜索城市"),

(3,"/getStaff","获取职员信息"),

(3,"/GarbageInfo.html","垃圾信息界面"),
(3,"/GarbageInfoEdit.html","编辑垃圾信息界面"),
(3,"/gchome.html","主界面"),
(3,"/500.html","异常界面"),
(3,"/login.html","登录界面")






create table staffAuth(
	 st_type int not null,
	 sa_id int not null
)
insert into staffAuth(st_type,sa_id) values(1,1),(2,2),(3,3),(4,4)



select sm_Authority from staff s 
left join stafftype st on s.s_type=st.st_type
left join staffMenu sm on st.st_type = sm.sm_id
where s_id = 1002 and s_pwd = "123123"


create table staffMenu(
	 sm_id int not null,
	 sm_Authority varchar(50) not null,
	 sm_message varchar(50) not null
)

insert into staffMenu(sm_id,sm_Authority,sm_message) values
(1,"GarbageDisposal","垃圾处理信息界面"),
(1,"GarbageInfo","编辑垃圾信息界面"),
(1,"Staff","职员管理界面"),
(1,"gchome","主界面"),
(1,"login","登录界面")

insert into staffMenu(sm_id,sm_Authority,sm_message) values
(2,"GarbageDisposal","垃圾处理信息界面"),
(2,"gchome","主界面"),
(2,"login","登录界面")

insert into staffMenu(sm_id,sm_Authority,sm_message) values
(3,"GarbageInfo","垃圾信息界面"),
(3,"gchome","主界面"),
(3,"login","登录界面")


