/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : gentelella

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-09-01 22:16:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `desc` varchar(50) DEFAULT NULL COMMENT '描述',
  `pid` bigint(20) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`),
  KEY `department_department__fk` (`pid`),
  CONSTRAINT `department_department__fk` FOREIGN KEY (`pid`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('10', '综合部', '综合管理', null);
INSERT INTO `department` VALUES ('20', '质量部', '质量管理', null);
INSERT INTO `department` VALUES ('30', '采购部', '采购管理', null);
INSERT INTO `department` VALUES ('40', '研发部', '项目研发', null);
INSERT INTO `department` VALUES ('50', '生产部', '生产事项', null);
INSERT INTO `department` VALUES ('60', '营销部', '市场营销', null);
INSERT INTO `department` VALUES ('101', '行政部', '行政管理', '10');
INSERT INTO `department` VALUES ('102', '人事部', '人事管理', '10');
INSERT INTO `department` VALUES ('103', '财务部', '财务管理', '10');
INSERT INTO `department` VALUES ('104', '保密办', '涉密事宜', '10');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `url` varchar(100) DEFAULT NULL COMMENT '路径',
  `icon` varchar(50) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`),
  KEY `menu_menu__fk` (`pid`),
  CONSTRAINT `menu_menu__fk` FOREIGN KEY (`pid`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '主页', null, 'fa fa-home', null);
INSERT INTO `menu` VALUES ('2', '系统管理', null, 'fa fa-cog', null);
INSERT INTO `menu` VALUES ('3', '部门管理', null, 'fa fa-sitemap', null);
INSERT INTO `menu` VALUES ('4', '员工管理', null, 'fa fa-user', null);
INSERT INTO `menu` VALUES ('5', '项目管理', null, 'fa fa-paperclip', null);
INSERT INTO `menu` VALUES ('101', '控制台', '/common/index.do', null, '1');
INSERT INTO `menu` VALUES ('201', '菜单', '/menu/index.do', null, '2');
INSERT INTO `menu` VALUES ('202', '角色', '/role/index.do', null, '2');
INSERT INTO `menu` VALUES ('203', '权限', '/perm/index.do', null, '2');
INSERT INTO `menu` VALUES ('204', '角色菜单', '/role_menu/index.do', null, '2');
INSERT INTO `menu` VALUES ('205', '角色权限', '/role_perm/index.do', null, '2');
INSERT INTO `menu` VALUES ('301', '部门信息', '/depart/index.do', null, '3');
INSERT INTO `menu` VALUES ('401', '员工信息', '/employ/index.do', null, '4');
INSERT INTO `menu` VALUES ('501', '测试1', '', null, '5');
INSERT INTO `menu` VALUES ('50101', '测试2', '/menu/list.do', null, '501');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'addUser', '新增', '/user/addUser.do');
INSERT INTO `permission` VALUES ('2', 'updateUser', '修改', '/user/updateUser.do');
INSERT INTO `permission` VALUES ('3', 'deleteUser', '删除', '/user/deleteUser.do');
INSERT INTO `permission` VALUES ('4', 'toUpdateUser', '待修改', '/user/toUpdateUser.do');
INSERT INTO `permission` VALUES ('5', 'userList', '查看', '/user/index.do');
INSERT INTO `permission` VALUES ('6', 'roleList', '查看', '/role/index.do');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `role` VALUES ('2', 'user', '普通用户');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `mid` bigint(20) NOT NULL DEFAULT '0' COMMENT '菜单id',
  PRIMARY KEY (`id`),
  KEY `role_menu_role__fk` (`rid`),
  KEY `role_menu_menu__fk` (`mid`),
  CONSTRAINT `role_menu_menu__fk` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_menu_role__fk` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '1', '2');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('4', '1', '4');
INSERT INTO `role_menu` VALUES ('5', '1', '101');
INSERT INTO `role_menu` VALUES ('6', '1', '201');
INSERT INTO `role_menu` VALUES ('7', '1', '202');
INSERT INTO `role_menu` VALUES ('8', '1', '203');
INSERT INTO `role_menu` VALUES ('9', '1', '204');
INSERT INTO `role_menu` VALUES ('10', '1', '205');
INSERT INTO `role_menu` VALUES ('11', '1', '301');
INSERT INTO `role_menu` VALUES ('12', '1', '401');
INSERT INTO `role_menu` VALUES ('13', '2', '301');
INSERT INTO `role_menu` VALUES ('14', '2', '401');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_permission_permission__fk` (`pid`),
  KEY `role_permission_role__fk` (`rid`),
  CONSTRAINT `role_permission_permission__fk` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`) ON DELETE CASCADE,
  CONSTRAINT `role_permission_role__fk` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');
INSERT INTO `role_permission` VALUES ('4', '1', '4');
INSERT INTO `role_permission` VALUES ('5', '1', '5');
INSERT INTO `role_permission` VALUES ('6', '2', '5');
INSERT INTO `role_permission` VALUES ('7', '1', '6');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT '主键',
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `remember_me` varchar(10) DEFAULT 'false',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `gender` varchar(50) DEFAULT 'male' COMMENT '性别',
  `telephone` varchar(50) DEFAULT '' COMMENT '联系方式',
  `salt` varchar(100) DEFAULT '' COMMENT '加密字符',
  `create_time` varchar(50) DEFAULT NULL COMMENT '设立时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ximen', 'a7d59dfc5332749cb801f86a24f5f590', 'false', '1403473722@qq.com', 'male', '18503817798', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-08-24 10:25');
INSERT INTO `user` VALUES ('2', 'dongsheng', '43e28304197b9216e45ab1ce8dac831b', 'false', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25');

-- ----------------------------
-- Table structure for user_dept
-- ----------------------------
DROP TABLE IF EXISTS `user_dept`;
CREATE TABLE `user_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门id',
  PRIMARY KEY (`id`),
  KEY `user_dept_department__fk` (`dept_id`),
  KEY `user_dept_user__fk` (`uid`),
  CONSTRAINT `user_dept_department__fk` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_dept_user__fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户部门表';

-- ----------------------------
-- Records of user_dept
-- ----------------------------
INSERT INTO `user_dept` VALUES ('1', '1', '101');
INSERT INTO `user_dept` VALUES ('2', '2', '40');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_user__fk` (`uid`),
  KEY `user_role_role__fk` (`rid`),
  CONSTRAINT `user_role_role__fk` FOREIGN KEY (`rid`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_user__fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
