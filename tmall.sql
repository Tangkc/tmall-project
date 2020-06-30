
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户id',
	`usm_member_state` int(10) NOT NULL COMMENT '0:不可用 1:可用',
  `member_level_id` bigint(20) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `status` int(1) DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `gender` int(1) DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `city` varchar(64) DEFAULT NULL COMMENT '所做城市',
  `job` varchar(100) DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `source_type` int(1) DEFAULT NULL COMMENT '用户来源',
  `integration` int(11) DEFAULT NULL COMMENT '积分',
  `growth` int(11) DEFAULT NULL COMMENT '成长值',
  `luckey_count` int(11) DEFAULT NULL COMMENT '剩余抽奖次数',
  `history_integration` int(11) DEFAULT NULL COMMENT '历史积分数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`),
	UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='会员表';




DROP TABLE IF EXISTS `goods_details`;
CREATE TABLE `goods_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	`goods_name` varchar(1000) NOT NULL COMMENT '商品名称',
	`goods_description` varchar(500) NOT NULL COMMENT '商品描述',
	`goods_image_url` varchar(200) NOT NULL COMMENT '商品图片url',
	`goods_price` int(32) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='商品表';


create table if not exists `tmall_user`(
 user_id long  AUTO_INCREMENT,
 user_name varchar(64) not null comment '用户姓名',
 user_age TINYINT(4) default 0 comment '用户年龄'
 user_phone varchar(16) not null comment '用户手机号',
 user_sex int not null comment '用户性别 0:女 1男',
 create_time DATE comment '创建日期',
 PRIMARY KEY(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `store_info`;
CREATE TABLE `store_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
	`store_name` varchar(100) NOT NULL COMMENT '商店名称',
	`store_description` varchar(500) NOT NULL COMMENT '商店描述',
	`store_business_license` varchar(1000) NOT NULL COMMENT '营业执照base64',
	`store_business_license_id` varchar(1000) NOT NULL COMMENT '营业执照id',
	`store_manager_name` int(32) NOT NULL COMMENT '店长姓名',
	`store_manager_phone` int(32) NOT NULL COMMENT '店长电话',
	`store_manager_idcard` int(18) NOT NULL COMMENT '店长身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='店表';