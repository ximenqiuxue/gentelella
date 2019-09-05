-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.13 - MySQL Community Server - GPL
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for gentelella
DROP DATABASE IF EXISTS `gentelella`;
CREATE DATABASE IF NOT EXISTS `gentelella` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gentelella`;

-- Dumping structure for table gentelella.department
DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
                                            `id` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
                                            `name` varchar(20) DEFAULT NULL COMMENT '名称',
                                            `desc` varchar(50) DEFAULT NULL COMMENT '描述',
                                            `pid` int(11) DEFAULT NULL COMMENT '父id',
                                            PRIMARY KEY (`id`),
                                            KEY `department_department__fk` (`pid`),
                                            CONSTRAINT `department_department__fk` FOREIGN KEY (`pid`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- Dumping data for table gentelella.department: ~10 rows (大约)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `name`, `desc`, `pid`) VALUES
(1, '综合部', '综合管理', NULL),
(2, '质量部', '质量管理', NULL),
(3, '采购部', '采购管理', NULL),
(4, '研发部', '项目研发', NULL),
(5, '生产部', '生产事项', NULL),
(6, '营销部', '市场营销', NULL),
(7, '行政部', '行政管理', 1),
(8, '人事部', '人事管理', 1),
(9, '财务部', '财务管理', 1),
(10, '保密办', '涉密事宜', 1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table gentelella.menu
DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
                                      `id` int(11) NOT NULL DEFAULT '0' COMMENT '主键',
                                      `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                      `url` varchar(100) DEFAULT NULL COMMENT '路径',
                                      `icon` varchar(50) DEFAULT NULL,
                                      `pid` int(11) DEFAULT NULL COMMENT '父级id',
                                      PRIMARY KEY (`id`),
                                      KEY `menu_menu__fk` (`pid`),
                                      CONSTRAINT `menu_menu__fk` FOREIGN KEY (`pid`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- Dumping data for table gentelella.menu: ~16 rows (大约)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `name`, `url`, `icon`, `pid`) VALUES
(1, '主页', NULL, 'fa fa-home', NULL),
(2, '系统管理', NULL, 'fa fa-cog', NULL),
(3, '部门管理', NULL, 'fa fa-sitemap', NULL),
(4, '员工管理', NULL, 'fa fa-user', NULL),
(5, '项目管理', NULL, 'fa fa-paperclip', NULL),
(6, '控制台', '/common/index.do', NULL, 1),
(7, '菜单管理', '/menu/index.do', NULL, 2),
(8, '角色管理', '/role/index.do', NULL, 2),
(9, '权限管理', '/perm/index.do', NULL, 2),
(10, '用户管理', '/user/index.do', NULL, 2),
(11, '角色菜单', '/role_menu/index.do', NULL, 2),
(12, '角色权限', '/role_perm/index.do', NULL, 2),
(13, '部门信息', '/depart/index.do', NULL, 3),
(14, '员工信息', '/employ/index.do', NULL, 4),
(15, '测试1', '', NULL, 5),
(16, '测试2', '/menu/list.do', NULL, 15);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Dumping structure for table gentelella.permission
DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
                                            `id` int(11) NOT NULL AUTO_INCREMENT,
                                            `name` varchar(100) DEFAULT NULL,
                                            `desc` varchar(100) DEFAULT NULL,
                                            `url` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table gentelella.permission: ~6 rows (大约)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`, `name`, `desc`, `url`) VALUES
(1, 'addUser', '新增', '/user/addUser.do'),
(2, 'updateUser', '修改', '/user/updateUser.do'),
(3, 'deleteUser', '删除', '/user/deleteUser.do'),
(4, 'toUpdateUser', '待修改', '/user/toUpdateUser.do'),
(5, 'userList', '查看', '/user/index.do'),
(6, 'roleList', '查看', '/role/index.do');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- Dumping structure for table gentelella.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `name` varchar(100) DEFAULT NULL,
                                      `desc` varchar(100) DEFAULT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table gentelella.role: ~2 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `desc`) VALUES
(1, 'admin', '超级管理员'),
(2, 'user', '普通用户');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table gentelella.role_menu
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE IF NOT EXISTS `role_menu` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                           `rid` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
                                           `mid` int(11) NOT NULL DEFAULT '0' COMMENT '菜单id',
                                           PRIMARY KEY (`id`),
                                           KEY `role_menu_role__fk` (`rid`),
                                           KEY `role_menu_menu__fk` (`mid`),
                                           CONSTRAINT `role_menu_menu__fk` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                           CONSTRAINT `role_menu_role__fk` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- Dumping data for table gentelella.role_menu: ~14 rows (大约)
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` (`id`, `rid`, `mid`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 101),
(6, 1, 201),
(7, 1, 202),
(8, 1, 203),
(9, 1, 204),
(10, 1, 205),
(11, 1, 301),
(12, 1, 401),
(13, 2, 301),
(14, 2, 401);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;

-- Dumping structure for table gentelella.role_permission
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE IF NOT EXISTS `role_permission` (
                                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                                 `rid` int(11) NOT NULL,
                                                 `pid` int(11) NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 KEY `role_permission_permission__fk` (`pid`),
                                                 KEY `role_permission_role__fk` (`rid`),
                                                 CONSTRAINT `role_permission_permission__fk` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`) ON DELETE CASCADE,
                                                 CONSTRAINT `role_permission_role__fk` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- Dumping data for table gentelella.role_permission: ~7 rows (大约)
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`id`, `rid`, `pid`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 2, 5),
(7, 1, 6);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

-- Dumping structure for table gentelella.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` int(11) NOT NULL COMMENT '主键',
                                      `username` varchar(50) DEFAULT '' COMMENT '用户名',
                                      `password` varchar(50) DEFAULT '' COMMENT '密码',
                                      `email` varchar(50) DEFAULT '' COMMENT '邮箱',
                                      `gender` varchar(50) DEFAULT 'male' COMMENT '性别',
                                      `telephone` varchar(50) DEFAULT '' COMMENT '联系方式',
                                      `salt` varchar(100) DEFAULT '' COMMENT '加密字符',
                                      `create_time` varchar(50) DEFAULT NULL COMMENT '设立时间',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- Dumping data for table gentelella.user: ~55 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `gender`, `telephone`, `salt`, `create_time`) VALUES
(1, 'ximen', 'a7d59dfc5332749cb801f86a24f5f590', '1403473722@qq.com', 'male', '18503817798', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-08-24 10:25'),
(2, 'dongsheng', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(3, 'ximen1', 'a7d59dfc5332749cb801f86a24f5f590', '1403473722@qq.com', 'male', '18503817798', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-08-24 10:25'),
(4, 'ximen2', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(5, 'ximen3', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(6, 'ximen4', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(7, 'ximen5', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(8, 'ximen6', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(9, 'ximen7', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(10, 'ximen8', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(11, 'ximen9', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(12, 'ximen10', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(13, 'ximen11', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(14, 'ximen12', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(15, 'ximen13', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(16, 'ximen14', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(17, 'ximen15', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(18, 'ximen16', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(19, 'ximen17', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(20, 'ximen18', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(21, 'ximen19', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(22, 'ximen20', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(23, 'ximen21', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(24, 'ximen22', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(25, 'ximen23', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(26, 'ximen24', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(27, 'ximen25', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(28, 'ximen26', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(29, 'ximen27', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(30, 'ximen28', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(31, 'ximen29', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(32, 'ximen30', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(33, 'ximen31', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(34, 'ximen32', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(35, 'ximen33', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(36, 'ximen34', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(37, 'ximen35', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(38, 'ximen36', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(39, 'ximen37', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(40, 'ximen38', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(41, 'ximen39', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(42, 'ximen40', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(43, 'ximen41', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(44, 'ximen42', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(45, 'ximen43', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(46, 'ximen44', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(47, 'ximen45', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(48, 'ximen46', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(49, 'ximen47', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(50, 'ximen48', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(51, 'ximen49', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(52, 'ximen50', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(53, 'ximen51', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(54, 'ximen52', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25'),
(55, 'ximen53', '43e28304197b9216e45ab1ce8dac831b', '18503817798@163.com', 'female', '18236887931', 'jPz19y7arvYIGhuUjsb6sQ==', '2019-08-24 10:25');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table gentelella.user_dept
DROP TABLE IF EXISTS `user_dept`;
CREATE TABLE IF NOT EXISTS `user_dept` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                           `uid` int(11) NOT NULL COMMENT '用户id',
                                           `dept_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id',
                                           PRIMARY KEY (`id`),
                                           KEY `user_dept_department__fk` (`dept_id`),
                                           KEY `user_dept_user__fk` (`uid`),
                                           CONSTRAINT `user_dept_department__fk` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                           CONSTRAINT `user_dept_user__fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户部门表';

-- Dumping data for table gentelella.user_dept: ~2 rows (大约)
/*!40000 ALTER TABLE `user_dept` DISABLE KEYS */;
INSERT INTO `user_dept` (`id`, `uid`, `dept_id`) VALUES
(1, 1, 101),
(2, 2, 4);
/*!40000 ALTER TABLE `user_dept` ENABLE KEYS */;

-- Dumping structure for table gentelella.user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
                                           `id` int(11) NOT NULL DEFAULT '0',
                                           `uid` int(11) DEFAULT NULL,
                                           `rid` int(11) DEFAULT NULL,
                                           PRIMARY KEY (`id`),
                                           KEY `user_role_user__fk` (`uid`),
                                           KEY `user_role_role__fk` (`rid`),
                                           CONSTRAINT `user_role_role__fk` FOREIGN KEY (`rid`) REFERENCES `role` (`id`),
                                           CONSTRAINT `user_role_user__fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table gentelella.user_role: ~2 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `uid`, `rid`) VALUES
(1, 1, 1),
(2, 2, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
