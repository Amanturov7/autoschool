CREATE TABLE lessons (
                         id SERIAL PRIMARY KEY,
                         created_at TIMESTAMP NOT NULL,
                         updated_at TIMESTAMP NOT NULL,
                         name VARCHAR(255) NOT NULL,
                         employee_id BIGINT,
                         description TEXT,
                         is_archived BOOLEAN,
                         time_remain TIMESTAMP,
                         CONSTRAINT fk_employee
                             FOREIGN KEY(employee_id)
                                 REFERENCES employee(id)
);



insert into common_reference_type(title,code) values('область', '001');
insert into common_reference_type(title,code) values('районы', '002');

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Чуй',001);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Нарын',002);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Талас',003);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Баткен',004);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Ош',005);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Джалал-Абад',006);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '001' ),'Ыссык-куль',007);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Аламудунский',001);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Беловодское',002);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Жайылский',003);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Кеминский',004);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Московский',005);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Панфиловский',006);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Чуйский',007);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ысык-Атинский',008);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ак-Талинский',009);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ат-Башинский',010);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Жумгальский',011);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Кочкорский',012);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Нарынский',013);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Бакай-Атинский',014);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Кара-Бууринский',015);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Манасский',016);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Таласский',017);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Алайский',018);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Кара-Кулджинский',019);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Кара-Суйский',020);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ноокатский',021);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Узгенский',022);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Чон-Алайский',023);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Араванский',024);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Аксыйский',025);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ала-Букинский',026);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Базар-Коргонский',027);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ноокенский',028);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Сузакский',029);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Тогуз-Тороуский',030);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Токтогульский',031);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Чаткальский',032);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Баткенский',033);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Кадамжайский',034);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Лейлекский',035);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Иссык-кульский',036);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ак-Суйский',037);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Джети-Огузский',038);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Тонский',039);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Тюпский',040);

insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Бишкек',041);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Ош',042);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Токмок',043);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Балыкчы',044);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Нарын',045);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Талас',046);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Баткен',047);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Каракол',048);
insert into common_reference(type_id,title,code) values((select id from common_reference_type where code = '002' ),'Джалал-Абад',049);




--Chui
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='1';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='2';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='3';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='4';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='5';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='6';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='7';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='8';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='41';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='43';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '1') where type_id = (select id from common_reference_type where code = '002') and code ='50';

--Naryn
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '2') where type_id = (select id from common_reference_type where code = '002') and code ='9';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '2') where type_id = (select id from common_reference_type where code = '002') and code ='10';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '2') where type_id = (select id from common_reference_type where code = '002') and code ='11';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '2') where type_id = (select id from common_reference_type where code = '002') and code ='12';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '2') where type_id = (select id from common_reference_type where code = '002') and code ='13';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '2') where type_id = (select id from common_reference_type where code = '002') and code ='45';

--Talas
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '3') where type_id = (select id from common_reference_type where code = '002') and code ='14';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '3') where type_id = (select id from common_reference_type where code = '002') and code ='15';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '3') where type_id = (select id from common_reference_type where code = '002') and code ='16';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '3') where type_id = (select id from common_reference_type where code = '002') and code ='17';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '3') where type_id = (select id from common_reference_type where code = '002') and code ='46';


--Batken
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '4') where type_id = (select id from common_reference_type where code = '002') and code ='33';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '4') where type_id = (select id from common_reference_type where code = '002') and code ='34';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '4') where type_id = (select id from common_reference_type where code = '002') and code ='35';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '4') where type_id = (select id from common_reference_type where code = '002') and code ='47';

--Osh
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='18';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='19';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='20';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='21';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='22';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='23';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='24';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '5') where type_id = (select id from common_reference_type where code = '002') and code ='42';

--J-A
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='25';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='26';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='27';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='28';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='29';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='30';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='31';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='32';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '6') where type_id = (select id from common_reference_type where code = '002') and code ='49';


--IK
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='36';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='37';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='38';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='39';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='40';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='44';
update common_reference set parent_id =  (select id from common_reference where type_id = (select id from common_reference_type where code = '001') and code = '7') where type_id = (select id from common_reference_type where code = '002') and code ='48';



