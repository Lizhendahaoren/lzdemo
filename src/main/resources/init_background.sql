use guimi;
/************增加两个用户*********************/
insert into tb_cms_user (user_name,real_name,status,email,mobile,password) values ('superadmin','superadmin',1,'superadmin@3ti.us','13312345678','96e79218965eb72c92a549dd5a330112');
insert into tb_cms_user (user_name,real_name,status,email,mobile,password) values ('admin','admin',1,'admin@3ti.us','13312345678','96e79218965eb72c92a549dd5a330112');

/************增加两个角色*********************/
insert into tb_cms_role (role_desc,role_name,status) values ('超级管理员','超级管理员',1);
insert into tb_cms_role (role_desc,role_name,status) values ('普通管理员','普通管理员',1);

/************增加基础资源*********************/
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,null,'首页','/index.html',0,1); 
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,null,'后台管理','',2,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,2,'用户管理','userList.html',2,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,2,'角色管理','role.html',2,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,2,'资源管理','resources.html',2,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,null,'业务办理','',2,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,5,'权限资源','/xaCmsResource',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,5,'资源列表','/xaCmsResource/resource',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,5,'资源关系','/xaCmsResource/showParent',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,5,'资源显示','/xaCmsResource/showResource',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,5,'资源修改','/xaCmsResource/update',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'权限角色','/xaCmsRole',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'角色检查','/xaCmsRole/checkRole',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'角色显示','/xaCmsRole/role',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'角色资源','/xaCmsRole/showResource',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'角色权限','/xaCmsRole/showRole',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'角色所有权限','/xaCmsRole/showRoles',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,4,'角色修改','/xaCmsRole/update',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,3,'系统用户','/xaCmsUser',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,3,'用户增加','/xaCmsUser/addUser',1,1); 
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,3,'用户检查','/xaCmsUser/checkUserName',1,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,3,'用户显示','/xaCmsUser/showCmsUser',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,null,'用户菜单','/xaCmsUser/showMenu',0,1);   
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,3,'用户修改','/xaCmsUser/update',1,1);  
insert into tb_cms_resource (order_num,parent_id,resource_name,resource_url,show_type,status) values (100,3,'用户操作','/xaCmsUser/user',1,1);   

/************增加用户角色关系*********************/
insert into tb_cms_user_role(role_id,user_id) values (1,1);
insert into tb_cms_user_role(role_id,user_id) values (2,2);

insert into tb_cms_role_resource(resource_id,role_id) values(1,1);
insert into tb_cms_role_resource(resource_id,role_id) values(2,1);
insert into tb_cms_role_resource(resource_id,role_id) values(3,1);
insert into tb_cms_role_resource(resource_id,role_id) values(4,1);
insert into tb_cms_role_resource(resource_id,role_id) values(5,1);
insert into tb_cms_role_resource(resource_id,role_id) values(17,1);

insert into tb_cms_role_resource(resource_id,role_id) values(1,2);
insert into tb_cms_role_resource(resource_id,role_id) values(6,2);

