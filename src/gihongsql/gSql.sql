insert into category values(1,'����');
insert into category values(2,'ȣ��');
insert into category values(3,'���');
insert into category values(4,'��Ÿ');
insert into category values(5,'����');

insert into accom_info values(1,1,'����ȣ��','ȣ�ڼҰ�?','���ǻ���','üũ��/üũ�ƿ��ð�üũ');

insert into accom_service values(1,2,'���ȫ','aȣ��','�����');
insert into accom_service values(2,2,'��','bȣ��','�λ걤����');
insert into accom_service values(3,2,'ȫ','cȣ��','���ֵ�');

--���� ���� ������ �ִٰ� �����ϰ� ����
insert into accom_option values(1,1,'����Ʈ��',1,4,40000);
insert into accom_option values(2,1,'�Ϲݽ�',1,4,20000);
insert into accom_option values(3,1,'����Ͻ�',1,4,30000);
insert into accom_option values(4,2,'����Ʈ��',2,5,80000);
insert into accom_option values(6,2,'����Ͻ�',2,5,45000);
insert into accom_option values(7,3,'�Ϲ�',1,3,22000);
insert into accom_option values(8,3,'���',1,3,40000);

insert into accom_option values(9,1,'����Ʈ��',1,4,40000);
insert into accom_option values(10,1,'�Ϲݽ�',1,4,20000);
insert into accom_option values(11,1,'����Ͻ�',1,4,30000);
insert into accom_option values(12,2,'����Ʈ��',2,5,80000);
insert into accom_option values(13,2,'����Ͻ�',2,5,45000);
insert into accom_option values(14,3,'�Ϲ�',1,3,22000);
insert into accom_option values(15,3,'���',1,3,40000);

insert into accom_option values(16,1,'����Ʈ��',1,4,40000);
insert into accom_option values(17,1,'�Ϲݽ�',1,4,20000);
insert into accom_option values(18,1,'����Ͻ�',1,4,30000);
insert into accom_option values(19,2,'����Ʈ��',2,5,80000);
insert into accom_option values(20,2,'����Ͻ�',2,5,45000);
insert into accom_option values(21,3,'�Ϲ�',1,3,22000);
insert into accom_option values(22,3,'���',1,3,40000);


insert into facilities values(1,2,1,'�ٺ�ť��');
insert into facilities values(2,2,1,'������');
insert into facilities values(3,2,1,'���ƽü�');
insert into facilities values(4,2,1,'������');
insert into facilities values(5,2,2,'������');

insert into convenience values(1,2,1,'���ļ���');
insert into convenience values(2,2,1,'��������');
insert into convenience values(3,2,1,'wifi');

commit;

select * from accom_option;

select * from accom_service
where accom_service_number in(
select accom_service_number from accom_service join facilities on accom_service_number=facilities.service_number and 
accom_service.cate_number=facilities.cate_number where facility in('������','�ٺ�ť��')
)and accom_service_number in(
select accom_service_number from accom_service join convenience on accom_service_number=convenience.service_number and 
accom_service.cate_number=convenience.cate_number where conven='wifi'
);

select accom_service_number snum,min(accom_price) minp from accom_option group by accom_service_number
having accom_service_number in(1,2,3);

select min(accom_price) minP from accom_option group by accom_service_number
		having accom_service_number=2;

 

select min(accom_price) from accom_option group by accom_service_number
having accom_service_number in(
select accom_service_number from accom_service join facilities on accom_service_number=facilities.service_number and 
accom_service.cate_number=facilities.cate_number where facility='������'
) and accom_service_number in(
select accom_service_number from accom_service join convenience on accom_service_number=convenience.service_number and 
accom_service.cate_number=convenience.cate_number where conven='wifi'
);



select * from accom_service join facilities on accom_service_number=facilities.service_number and 
accom_service.cate_number=facilities.cate_number where facility='������';

select * from accom_service join convenience on accom_service_number=convenience.service_number and 
accom_service.cate_number=convenience.cate_number;
