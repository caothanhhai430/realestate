use estatejdbc82019;
insert into role(code,name)values('MANAGER','Quản lý');
insert into role(code,name)values('STAFF','Nhân viên');

insert into user(username,password,fullname,status)values('NguyenDucCanh','123456','Nguyễn Đức Cảnh',1);
insert into user(username,password,fullname,status)values('MaiDinhChi','123456','Mai Đinh Chi',1);
insert into user(username,password,fullname,status)values('NguyenAnhVan','123456','Nguyễn Anh Văn',1);
insert into user(username,password,fullname,status)values('CaoThaiSon','123456','Cao Thái Sơn',1);

insert into user_role(userid,roleid)values(1,1);
insert into user_role(userid,roleid)values(2,2);
insert into user_role(userid,roleid)values(3,2);
insert into user_role(userid,roleid)values(4,2);


insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type)values('FCL Buiding',2,500,'QUAN_1','Phường 2','59 Pham Xích Long',15,'15 triệu/m2','Hùng','012345678','TANG_TRIET,NGUYEN_CAN');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type)values('ACM Tower',2,650,'QUAN_2','Phường 4','96 Cao Thắng',18,'18 triệu/m2','Cường','012345678','NGUYEN_CAN');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type)values('Alpha 2 Building',1,200,'QUAN_3','Phường 6','153 Nguyễn Đình Chiểu',20,'20 triệu/m2','Huy','012345678','TANG_TRIET,NGUYEN_CAN,NOI_THAT');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type)values('IDD 1 Building',1,200,'QUAN_4','Phường 7','111 Lý Chính Thắng',12,'12 triệu/m2','Vy','012345678','NOI_THAT');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,createddate,type)values('VINACONEXT',1,150,'QUAN_3','Phường 10','134/1 Cách Mạng Tháng 8',1000,'','Mai','012345678','2019-8-22 10:34:09','NGUYEN_CAN,NOI_THAT');
