insert into category values(1,'����');
insert into category values(2,'���');
insert into category values(3,'ķ��');
insert into category values(4,'�Խ�Ʈ�Ͽ콺');
insert into category values(5,'��Ÿ');
insert into category values(11,'�����');
insert into category values(111,'���������');
insert into category values(55,'���Ҹ���');
insert into category values(555,'���ҵ�����');

insert into user_info values('ck','1234','�׽�Ʈ','bronze','tjdwlrwk3123@naver.com','�����','01074253618',1,2200,1);

insert into accom_info values(1,1,'���� ȣ��\n�Դϴ�.\n���̵� ���ּ���','��ä���\n
�� �����̺��� ���ǿ��� ����ϴ� �����̳� ģ���� �Բ� �ູ�� ã�ƺ�����.\n
����\n
�� �Ƶ�,���� ���� �� ������ �����Ͻñ� �ٶ��ϴ�.\n
��ä����\n
�� �����̺��� ���ǿ��� ����ϴ� �����̳� ģ���� �Բ� �ູ�� ã�ƺ�����.\n
�� ��ä ����: ��ġ����, �볪����, ��������, �ø��굿, ���ɵ�','���ǻ���','üũ��/üũ�ƿ��ð�üũ','�ٺ�ť��,������,ī��,������','wifi,���ļ���');
insert into accom_info values(2,2,'bȣ������ȣ��','ȣ�ڼҰ�?','���ǻ���','üũ��/üũ�ƿ��ð�üũ','������,��õ,Ź����','wifi,�ݿ�,�������');
insert into accom_info values(3,3,'cȣ����','ȣ�ڼҰ�?','���ǻ���','üũ��/üũ�ƿ��ð�üũ','���ƽü�,Ź����,��ȸ��','wifi,�ݷ���������,��������');

insert into accom_service values(1,2,'���ȫ','aȣ��','����� ��õ�� ������9��');
insert into accom_service values(2,2,'��','bȣ��','�λ걤����');
insert into accom_service values(3,2,'ȫ','cȣ��','���ֵ�');

--���� ���� ������ �ִٰ� �����ϰ� ����
insert into accom_option values(1,1,'����Ʈ��',1,4,40000,null);
insert into accom_option values(2,1,'�Ϲݽ�',1,4,20000,null);
insert into accom_option values(3,1,'����Ͻ�',1,4,30000,null);
insert into accom_option values(4,2,'����Ʈ��',2,5,80000,null);
insert into accom_option values(6,2,'����Ͻ�',2,5,45000,null);
insert into accom_option values(7,3,'�Ϲ�',1,3,22000,null);
insert into accom_option values(8,3,'���',1,3,40000,null);

insert into accom_option values(9,1,'����Ʈ��',1,4,40000,null);
insert into accom_option values(10,1,'�Ϲݽ�',1,4,20000,null);
insert into accom_option values(11,1,'����Ͻ�',1,4,30000,null);
insert into accom_option values(12,2,'����Ʈ��',2,5,80000,null);
insert into accom_option values(13,2,'����Ͻ�',2,5,45000,null);
insert into accom_option values(14,3,'�Ϲ�',1,3,22000,null);
insert into accom_option values(15,3,'���',1,3,40000,null);

insert into accom_option values(16,1,'����Ʈ��',1,4,40000,null);
insert into accom_option values(17,1,'�Ϲݽ�',1,4,20000,null);
insert into accom_option values(18,1,'����Ͻ�',1,4,30000,null);
insert into accom_option values(19,2,'����Ʈ��',2,5,80000,null);
insert into accom_option values(20,2,'����Ͻ�',2,5,45000,null);
insert into accom_option values(21,3,'�Ϲ�',1,3,22000,null);
insert into accom_option values(22,3,'���',1,3,40000,null);

insert into accom_book values(1,'aa',1,'aȣ��','2021-02-04','2021-02-05',null,null,null,null,null);
insert into accom_book values(2,'bb',2,'aȣ��','2021-02-05','2021-02-08',null,null,null,null,null);
insert into accom_book values(3,'aa',2,'aȣ��','2021-02-08','2021-02-09',null,null,null,null,null);
insert into accom_book values(4,'cc',9,'aȣ��','2021-02-04','2021-02-07',null,null,null,null,null);
insert into accom_book values(5,'dd',4,'bȣ��','2021-02-09','2021-02-10',null,null,null,null,null);
insert into accom_book values(6,'ck',8,'cȣ��','2021/02/18','2021/02/20','�����Ϸ�',40000,3000,null,null);


update accom_book set payment_condition='�����Ϸ�';
update accom_book set payment_condition='�������' where accom_book_number=5;

insert into review values(1,'dd',2,4,'��','1.png',null,2);
insert into review values(2,'ee',2,5,'�±�','2.png',null,2);
insert into review values(3,'ff',2,1,'����','1.png',null,2);
insert into review values(4,'dd',2,4,'��','1.png',null,2);

insert into image values(1,'aa.png','123123de3131as23 aa.png',1,2);
insert into image values(2,'bb.png','123123de3131as23 bb.png',1,2);
insert into image values(3,'cc.png','123123de3131as23 cc.png',1,2);

insert into image values(4,'dd.png','232e3ar331dx34xa dd.png',4,555);
insert into image values(5,'aa.png','232e3ar331dx34xa aa.png',4,555);
insert into image values(6,'bb.png','232e3ar331dx34xa bb.png',4,555);
insert into image values(7,'kk.png','23xeae32ze3131 aa.png',6,555);
insert into image values(8,'zz.png','23xeae32ze3131 zz.png',6,555);
insert into image values(9,'aa.jpg','23xeae32ze3131 aa.jpg',6,555);

update accom_info set accom_how='��ä���\n�� �����̺��� ���ǿ��� ����ϴ� �����̳� ģ���� �Բ� �ູ�� ã�ƺ�����.\n����\n�� �Ƶ�,���� ���� �� ������ �����Ͻñ� �ٶ��ϴ�.\n��ä����\n�� �����̺��� ���ǿ��� ����ϴ� �����̳� ģ���� �Բ� �ູ�� ã�ƺ�����.\n�� ��ä ����: ��ġ����, �볪����, ��������, �ø��굿, ���ɵ�' where accom_info_number=1;
update accom_info set accom_info_content='���� ȣ��\n�Դϴ�.\n���̵� ���ּ���' where accom_info_number=1;
update accom_info set accom_rule='- üũ�� 6�� �� : ��� ������ ����\n
- üũ�� 5�� �� : ��� ������ 10%\n
- üũ�� 4�� �� : ��� ������ 20%\n
- üũ�� 3�� �� : ��� ������ 30%\n
- üũ�� 2�� �� : ��� ������ 50%\n
- üũ�� 1�� �� : ��� ������ 70%\n
- üũ�� ���� : ��� ������ 100%\n
'
where accom_service_number=1;



Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (41,'1.png','1.png',1,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (42,'2.png','2.png',2,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (43,'3.png','3.png',2,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (44,'4.png','4.png',3,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (45,'5.png','5.png',4,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (46,'6.png','6.png',5,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (47,'7.png','7.png',6,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (48,'8.png','8.png',6,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (49,'9.png','9.png',7,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (10,'10.png','10.png',8,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (11,'11.png','11.png',9,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (12,'12.png','12.png',10,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (13,'1.png','1.png',1,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (14,'2.png','2.png',1,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (15,'3.png','3.png',1,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (16,'4.png','4.png',2,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (17,'5.png','5.png',2,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (18,'6.png','6.png',2,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (19,'7.png','7.png',3,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (20,'8.png','8.png',3,11);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (21,'����1.PNG','����1.PNG',1,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (22,'002.jpg','002.jpg',2,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (23,'003.jpg','003.jpg',2,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (24,'004.jpg','004.jpg',2,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (25,'005.jpg','005.jpg',2,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (26,'006.jpg','006.jpg',2,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (27,'007.jpg','007.jpg',3,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (28,'008.jpg','008.jpg',3,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (32,'3.png','3.png',1,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (29,'����2.PNG','����2.PNG',1,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (30,'����3.PNG','����3.PNG',1,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (31,'2.png','2.png',1,1);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (33,'����4.PNG','����4.PNG',1,111);
Insert into FINAL.IMAGE (IMG_NUM,IMGORGNAME,IMGSAVENAME,GENERAL_NUMBER,CATE_NUMBER) values (34,'����5.PNG','����5.PNG',1,111);

Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (41,'kaka',1,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (42,'kaka',2,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (43,'kaka',3,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (44,'kaka',4,1,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (5,'kaka',5,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (6,'ethan',1,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (7,'ethan',2,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (8,'ethan',3,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (9,'ethan',4,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (10,'ethan',5,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (11,'test',1,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (12,'test',2,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (13,'test',3,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (14,'test',4,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (15,'test',5,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (16,'test',1,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (17,'test',6,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (18,'test',7,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (19,'test',8,2,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (20,'test',9,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (21,'test',10,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (22,'admin',6,4,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (23,'admin',6,1,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (24,'admin',7,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (25,'admin',8,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (26,'admin',9,1,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (27,'admin',10,3,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (28,'admin',5,1,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (29,'admin',3,5,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (30,'admin',5,1,'���ָ���',null,1);
Insert into FINAL.REVIEW (REVIEW_NUMBER,USER_ID,SERVICE_NUMBER,STAR_POINT,REVIEW_CONTENT,REVIEW_COMMENT,CATE_NUMBER) values (31,'admin',5,1,'���ָ���',null,1);

Insert into FINAL.TOUR_BOOK (TOUR_BOOK_NUMBER,USER_ID,SERVICE_NUMBER,SERVICE_NAME,TOUR_STARTDATE,TOUR_ENDDATE,PAYMENT_CONDITION,TOTAL_PRICE,POINT_USEAMOUNT,COUPON_USECONDITION,PAYMENT_METHOD,BOOKERNAME,BOOKERPHONE) values (1,'ck',1,'����Ÿ������',to_date('21/02/16','RR/MM/DD'),to_date('21/02/16','RR/MM/DD'),'�����Ϸ�',15000,0,null,null,null,null);
Insert into FINAL.TOUR_BOOK (TOUR_BOOK_NUMBER,USER_ID,SERVICE_NUMBER,SERVICE_NAME,TOUR_STARTDATE,TOUR_ENDDATE,PAYMENT_CONDITION,TOTAL_PRICE,POINT_USEAMOUNT,COUPON_USECONDITION,PAYMENT_METHOD,BOOKERNAME,BOOKERPHONE) values (2,'ck',1,'����Ÿ������',to_date('21/02/17','RR/MM/DD'),to_date('21/03/05','RR/MM/DD'),'�����Ϸ�',59779,4221,null,'������ü','������','01095199039');

Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (2,1,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/03/05','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (3,2,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/22','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (4,3,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/19','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (5,4,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/04/01','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (6,5,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/03/05','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (7,6,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/04','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (8,7,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/10','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (9,8,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/15','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (10,9,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/18','RR/MM/DD'));
Insert into FINAL.TOUR_INFO (TOUR_INFO_NUMBER,SERVICE_NUMBER,TOUR_CONTENT,TOUR_HOW,TOUR_RULE,TOUR_EXPIRE) values (11,10,'���� ����<br>[�ɼ� ����]<br>A. Ŭ���̹� ü���<br>- Ŭ���̹� ���� ����<br>A-1. Ŭ���̹� 1�� ü���<br>B. Ŭ���̹� ������<br>- Ŭ���̹� ���� ����<br>B-1. Ŭ���̹� 1�� ������','1. Ƽ�ϱ��� (SMS ������ Ƽ��)<br>2. ��ǰ���� �� ��ȭ���� �ʼ� (tel: 02-552-2532)<br>3. ����湮�Ͽ� ���� �̸�/��ȭ��ȣ ��4�ڸ� Ȯ�� �� �̿�<br>�� ������ ����� �湮�� ���幮��','- �̻��Ƽ�� ȯ�� ����<br>- ��ȿ�Ⱓ ���� �̻��Ƽ�� ȯ�� ����<br>- ����� Ƽ�� ȯ�� �Ұ�',to_date('21/02/19','RR/MM/DD'));

Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (1,1,1,'��Ȧ�� ����',10000,100,10);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (2,1,2,'������ ����',8000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (3,2,1,'��Ȧ�� ����',14000,0,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (4,2,2,'ģ���� ����',24000,10,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (5,3,1,'��Ȧ�� ����',25000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (6,4,1,'ȥ���� ����',3000,0,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (7,5,1,'Ȧ�� �ܷ��� ����',25000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (8,5,2,'���� ������ ����',20000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (9,5,3,'���� �̰߰� ���',3000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (10,6,1,'�׳� ���',3000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (11,6,2,'�ų��� ���',20000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (12,6,3,'���� ������ ó�� ���',100000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (13,7,1,'�׳� �ȱ�',1000,50,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (14,7,2,'����� �ȱ�',1000,20,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (15,7,3,'������ ����',50000,10,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (17,8,1,'��� ����',5000,5,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (18,8,2,'�پ� ����',3000,5,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (19,9,1,'Ŭ���̹�',6000,11,null);
Insert into FINAL.TOUR_OPTION (TOUR_OPTION_NUMBER,SERVICE_NUMBER,TOUR_OPTION_INDEX,TOUR_OPTION,TOUR_PRICE,TOUR_AMOUNT,DISCOUNT) values (20,9,2,'�������',8000,25,null);


Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (1,1,'test','����Ÿ������','Ƽ��/�н�');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (2,1,'test','�溹�ñ���','�׸���ũ');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (3,1,'test','��������','���/Ŭ����');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (4,1,'test','�Ѱ�����','����');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (5,1,'test','���ѻ걸��','Ƽ��/�н�');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (6,1,'test','63��������','Ƽ��/�н�');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (7,1,'test','�Ͼǽ�ī�̿��̱���','�׸���ũ');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (8,1,'test','�ź��걸��','���/Ŭ����');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (9,1,'test','���翪����','����');
Insert into FINAL.TOUR_SERVICE (SERVICE_NUMBER,CATE_NUMBER,USER_ID,TOUR_NAME,TOUR_TYPE) values (10,1,'test','����������','Ƽ��/�н�');

Insert into FINAL.USER_INFO (USER_ID,USER_PASS,USER_NAME,USER_GRADE,USER_EMAIL,USER_ADDR,USER_PHONE,USER_CONDITION,USER_POINT) values ('test','1234','�׽�Ʈ','SILVER','test@me.com','������','010121121122','Great',0);
Insert into FINAL.USER_INFO (USER_ID,USER_PASS,USER_NAME,USER_GRADE,USER_EMAIL,USER_ADDR,USER_PHONE,USER_CONDITION,USER_POINT) values ('kaka','1234','īī','DIAMOND','kaka@me.com','������','01099998888','Great',10000000);
Insert into FINAL.USER_INFO (USER_ID,USER_PASS,USER_NAME,USER_GRADE,USER_EMAIL,USER_ADDR,USER_PHONE,USER_CONDITION,USER_POINT) values ('admin','1234','������','MANAGER','admin@me.com','������','01011112222','Great',100000);


commit;

select * from accom_option;


-- ��¥�ߺ�,�ο��� üũ
select * from accom_option left join accom_book 
on accom_option.accom_option_number = accom_book.accom_option_number
where not (accom_startdate < '2021-02-06'
AND accom_enddate > '2021-02-04') or (accom_startdate is null and accom_enddate is null)
and accom_max_people>=4;

-- �ü�,���� üũ
select * from accom_service
where accom_service_number in(
select accom_service_number from accom_service join facilities on accom_service_number=facilities.service_number and 
accom_service.cate_number=facilities.cate_number where facility in('������','�ٺ�ť��')
)and accom_service_number in(
select accom_service_number from accom_service join convenience on accom_service_number=convenience.service_number and 
accom_service.cate_number=convenience.cate_number where conven='wifi'
);

-- ��¥,�ο���,�ü�,���� ��� üũ

select * from accom_service where 
accom_service_number in(
select accom_service_number from accom_option left join accom_book 
on accom_option.accom_option_number = accom_book.accom_option_number
where not (accom_startdate < '2021-02-06'
AND accom_enddate > '2021-02-04')
or (accom_startdate is null and accom_enddate is null)
and accom_max_people>=4
)
and accom_service_number in(
select accom_service_number from accom_service join facilities on accom_service_number=facilities.service_number and 
accom_service.cate_number=facilities.cate_number where facility in('������','�ٺ�ť��')
)
and accom_service_number in(
select accom_service_number from accom_service join convenience on accom_service_number=convenience.service_number and 
accom_service.cate_number=convenience.cate_number where conven='wifi'
);

--���̺� ����
select * from accom_service natural join accom_info 
where facility like '%������%' and facility like '%�ٺ�ť��%';


update accom_book set accom_startdate='2021/02/18',accom_enddate='2021/02/20',
payment_condition='�����Ϸ�',total_price=40000,point_useamount=3000,coupon_usecondition='ȯ������'
where accom_book_number=6;


-- �� �������� ���� ������ �ּ� �氪�� ���ϱ�
select accom_service_number snum,min(accom_price) minp from accom_option group by accom_service_number
having accom_service_number in(1,2,3);

select min(accom_price) minP from accom_option group by accom_service_number
		having accom_service_number=2;

 


