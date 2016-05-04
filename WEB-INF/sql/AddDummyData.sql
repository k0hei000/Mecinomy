insert into usertable (user_id,user_name,password,user_image,description,address,is_delete)values ('C0002', '��^�܂��Ђ�', 'password', 'test', 'test', 'masahiro.oroku@gmail.com',0);
insert into usertable (user_id,user_name,password,user_image,description,address,is_delete)values ('rrrr2', '��^�܂���', 'password', 'test', 'test', 'masahiro.oroku2@gmail.com',0);
insert into usertable (user_id,user_name,password,user_image,description,address,is_delete)values ('rrrr', '��^�܂���', 'password', 'test', 'test', 'masahiro.oroku2@gmail.com',0);
insert into usertable (user_id,user_name,password,user_image,description,address,is_delete)values ('1111', '��^�܂�', 'password', 'test', 'test', 'masahiro.oroku3@gmail.com',0);
insert into usertable (user_id,user_name,password,user_image,description,address,is_delete)values ('aaaa', '��^', 'password', 'test', 'test', 'masahiro.oroku4@gmail.com',0);

insert into grouptable (group_name,group_image,description,is_delete)values ('teamA','url','�����ō��h�����Ă��܂�',0);
insert into grouptable (group_name,group_image,description,is_delete)values ('teamB','url','����2�ō��h�����Ă��܂�',0);
insert into grouptable (group_name,group_image,description,is_delete)values ('teamC','url','����3�ō��h�����Ă��܂�',1);

insert into post (post_id,user_id,purpose,time_start,time_end)values (seq_post_id.nextval,'aaaa','00001','1800','2000');
insert into post (post_id,user_id,purpose,time_start,time_end)values (seq_post_id.nextval,'1111','00002','1800','2000');
insert into post (post_id,user_id,purpose,time_start,time_end)values (seq_post_id.nextval,'rrrr','00002','1900','2100');
insert into post (post_id,user_id,purpose,time_start,time_end)values (seq_post_id.nextval,'rrrr2','00002','1900','2100');

insert into matching values (seq_matching_id.nextval,'1900',1,0);
insert into matching values (seq_matching_id.nextval,'1930',0,1);
insert into matching values (seq_matching_id.nextval,'1930',0,1);

insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'C0002','teamA',0);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'rrrr2','teamB',0);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'rrrr2','teamC',1);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'rrrr','teamA',0);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'rrrr','teamB',0);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'1111','teamC',1);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'aaaa','teamA',1);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'aaaa','teamB',1);
insert into usergroup (user_group_id,user_id,group_name,is_ignore)values (seq_user_group_id.nextval,'aaaa','teamC',1);

commit;
