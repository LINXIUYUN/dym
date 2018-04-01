create database dym default charset utf8;

use dym;

create table user_authentic(
 id int not null primary key auto_increment comment 'id',
 username varchar(10) not null comment '用户名',
 password varchar(32) not null comment '密码(MD5)',
 user_type int(2) not null comment '用户类型 0:普通用户,1:管理员',
 unique index unique_username_index (username) comment '用户鉴权信息表 用户名索引'
)engine = InnoDB comment '用户鉴权信息表';


create table user_info(
 id int not null primary key auto_increment comment 'ID',
 user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
 name varchar(10) not null comment '姓名',
 birthday date not null comment '出生时间',
 join_cyl_time date comment '入团时间',
 nation varchar(15) not null comment '民族',
 province varchar (10) not null comment '省份',
 city varchar(10) not null comment '市',
 district varchar(10) not null comment '县/区',
 marital_status int(2) comment '婚姻状态 0:未婚,1:已婚,2:离异',
 id_no varchar(20) not null comment '身份证号',
 education int(2) not null comment '学历 0:本科 1:硕士研究生 2:博士研究生 3:其他',
 major_and_class varchar(20) not null comment '专业班级',
 is_party_member int(2) not null comment '是否是党员，0:是,1:否',
 party_time date comment '入党时间',
 party_province varchar (10) comment '入党党支部所属省份',
 party_city varchar(10) comment '入党党支部所属市',
 party_district varchar(10) comment '入党党支部所属县/区',
 remarks varchar(100) comment '备注',
 index name_index (name) comment '用户信息表 姓名索引',
 unique index idno_index(id_no) comment '用户信息表 身份证号索引',
 unique index user_account_index(user_authentic_id) comment '用户信息表 账号ID索引'
 )engine = InnoDB comment '用户信息表';
 
 alter table user_info add gender int(2) not null comment '性别 0:男,1:女';
 
 create table award_and_punishment(
  id int not null primary key auto_increment comment 'id',
  user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
  title varchar(20) not null comment '惩奖信息标题',
  description varchar(200) not null comment '惩奖信息详情',
  voucher_file_url varchar(500) comment '凭证文件路径' 
 )engine = InnoDB comment '惩奖信息表';
 
 create table join_party_apply(
  id int not null primary key auto_increment comment 'id',
  user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
  degree_or_title varchar(20) comment '学位或职称',
  join_work_date date comment '参见工作时间',
  birth_place varchar(30) not null comment '出生地',
  workpalce_and_occupation varchar(30) comment '单位、职务或职业',
  residential_address varchar(50) not null comment '现居住地',
  first_join_party_time varchar(20) not null comment '第一次申请入党时间',
  opinion_of_enthusiast varchar(200) comment '确定入党积极分子意见',
  cultivator varchar(10) not null comment '负责培养联系人',
  cultivator_duties varchar(20) not null comment '培养人党内职务',
  opinion_of_cultivator varchar(200) not null comment '培养联系人意见',
  opinion_of_branch varchar(200) not null comment '党支部意见',
  application_file_url varchar(50) not null comment '申请书文件路径',
  unique index jap_user_account_index(user_authentic_id) comment '入党申请表 账号ID索引'
 )engine = InnoDB comment '入党申请表';
 
 create table organizational_relationship(
  id int not null primary key auto_increment comment 'id',
  user_authentic_id int not null comment '用户账户鉴权信息表关联ID',


  mobile varchar(11) not null comment '联系电话',
  address varchar(40) not null comment '家庭住址',
  permanent_address varchar(40) not null comment '户籍地址',
  fulltime_education varchar(10) comment '全日制教育学历或学位',
  fulltime_university varchar(30) comment '全日制教育院校及专业',
  onjob_education varchar(10) comment '在职教育学历或学位',
  onjob_university varchar(30) comment '在职教育院校及专业',
  inner_party_suites varchar(20) comment '党内职务',
  join_branch varchar(20) comment '入党时所在党支部',
  join_work_date varchar(20) comment '参加工作时间',
  work_palce_and_suites varchar(50) comment '现工作单位及职务',
  material_status varchar(2) comment '入党资料是否齐全 ',
  material_remark varchar(50) comment '入党资料情况备注',
  have_voluntary_book varchar(2) comment '是否有入党志愿书 ',
  voluntary_book_remark varchar(50) comment '入党志愿书情况备注',
  info_real_staus varchar(2) comment '入党信息是否真实准确 ',
  info_real_remark varchar(2) comment '入党信息是否真实准确 ',
  have_illegal_record varchar(2) comment '是否存在违规入党或假党员情况',
  illegal_record_remark varchar(50) comment '违规记录备注',
  is_flow_member varchar(2) comment '是否是流动党员 ',
  flow_date varchar(20) comment '流出时间',
  is_out_contact varchar(2) comment '是否属于失联党员',
  out_contact_date varchar(20) comment '失联时间',
  trun_out_province varchar(10) comment '组织关系转出所在省',
  trun_out_city varchar(10) comment '组织关系转出所在市',
  trun_out_county varchar(10) comment '组织关系转出所在区/县',
  remarks varchar(200) comment '备注',
  unique index rel_user_account_index(user_authentic_id) comment '组织关系表 账号ID索引',
  index rel_mdn_index (mobile) comment '组织关系表 手机号索引'
)engine = InnoDB comment '组织关系表';


create table apply_record_his(
 id int not null primary key auto_increment comment 'id',
 user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
 join_party_apply_id int not null comment '申请表ID',
 apply_date date comment '申请时间',
 examine_date date comment '审核时间',
 examine_user_id int comment '审核人ID' ,
 is_examine int(2) not null comment '是否审核 0:是,1:否'
)engine = InnoDB comment '入党申请记录历史信息表';

create table apply_record(
id int not null primary key auto_increment comment 'id',
 user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
 join_party_apply_id int not null comment '申请表ID',
 apply_date date comment '申请时间',
 examine_date date comment '审核时间',
 examine_user_id int comment '审核人ID' ,
 is_examine int(2) not null comment '是否审核 0:是,1:否'
)engine = InnoDB comment '入党申请记录信息表';

create table apply_result(
id int not null primary key auto_increment comment 'id',
user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
apply_date date comment '申请时间',
examine_date date comment '审核时间',
is_agree int(2) not null comment '是否通过审核 0:是,1:否',
examine_user_id int not null comment '审核人ID' ,
remark varchar(50) comment '备注'
)engine = InnoDB comment '入党申请结果表';

create table apply_award_and_punish(
id int not null primary key auto_increment comment 'id',
user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
calss_info varchar(10) not null comment '专业班级',
apply_table_id int not null comment '惩奖信息表ID',
apply_date date not null comment '申请时间',
examine_date date comment '审核时间',
is_apply int(2) not null comment '是否审核 0:是,1:否',
is_agree int(2) comment '是否通过审核 0:是,1:否',
examine_user_id int comment '审核人ID' ,
remark varchar(50) comment '备注'
)engine = InnoDB comment '惩奖信息申请表';


create table apply_transfer(
id int not null primary key auto_increment comment 'id',
user_authentic_id int not null comment '用户账户鉴权信息表关联ID',
calss_info varchar(10) not null comment '专业班级',
component varchar(10) not null comment '成分',
transfer_area varchar(10) not null comment '转向地区',
apply_date date comment '申请时间',
examine_date date comment '审核时间',
is_apply int(2) not null comment '是否审核 0:是,1:否',
is_agree int(2) comment '是否通过审核 0:是,1:否',
examine_user_id int not null comment '审核人ID' ,
remark varchar(50) comment '备注'
)engine = InnoDB comment '组织关系调动申请表';

insert into user_authentic(username,password,user_type)value('test','098F6BCD4621D373CADE4E832627B4F6',0);

select * from user_authentic;

drop table user_info;





