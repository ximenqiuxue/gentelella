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
                                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                            `name` varchar(20) DEFAULT NULL COMMENT '名称',
                                            `description` varchar(50) DEFAULT NULL COMMENT '描述',
                                            `pid` int(11) DEFAULT NULL COMMENT '父id',
                                            PRIMARY KEY (`id`),
                                            KEY `d_d_self` (`pid`),
                                            CONSTRAINT `d_d_self` FOREIGN KEY (`pid`) REFERENCES `department` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='部门';

-- Dumping data for table gentelella.department: ~10 rows (大约)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `name`, `description`, `pid`) VALUES
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
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                      `url` varchar(100) DEFAULT NULL COMMENT '路径',
                                      `icon` varchar(50) DEFAULT NULL,
                                      `pid` int(11) DEFAULT NULL COMMENT '父级id',
                                      PRIMARY KEY (`id`),
                                      KEY `m_m_self` (`pid`),
                                      CONSTRAINT `m_m_self` FOREIGN KEY (`pid`) REFERENCES `menu` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='菜单表';

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
(9, '权限管理', '/permission/index.do', '', 2),
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
                                            `description` varchar(100) DEFAULT NULL,
                                            `url` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Dumping data for table gentelella.permission: ~19 rows (大约)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`, `name`, `description`, `url`) VALUES
(1, 'user_save', '用户修改或新增', '/user/saveUser.do'),
(2, 'user_to_update', '新增或修改初始化', '/user/toAddOrUpdate.do'),
(3, 'user_delete', '用户删除', '/user/deleteUser.do'),
(5, 'user_index', '用户页面跳转', '/user/index.do'),
(6, 'role_index', '角色页面跳转与数据加载', '/role/index.do'),
(16, 'user_list', '用户页面table数据读取', '/user/list.do'),
(17, 'role_add', '角色新增保存', '/role/addRole.do'),
(18, 'role_get', '获取单个角色', '/role/getRole.do'),
(19, 'role_update', '角色修改保存', '/role/updateRole.do'),
(20, 'role_delete', '角色删除', '/role/deleteRole.do'),
(21, 'menu_index', '菜单页面跳转和数据获取', '/menu/index.do'),
(22, 'menu_list', '获取页面需要赋值域，例如select', '/menu/list.do'),
(23, 'menu_get', '获取单个菜单', '/menu/getMenu.do'),
(24, 'menu_add', '菜单新增保存', '/menu/addMenu.do'),
(25, 'menu_update', '菜单修改保存', '/menu/updateMenu.do'),
(26, 'menu_delete', '菜单删除', '/menu/deleteMenu.do'),
(27, 'permission_index', '资源页面跳转和数据初始化', '/permission/index.do'),
(28, 'permission_get', '获取单个权限', '/permission/getPermission.do'),
(29, 'permission_add', '新增资源保存', '/permission/addPermission.do');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- Dumping structure for table gentelella.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `name` varchar(100) DEFAULT NULL,
                                      `description` varchar(100) DEFAULT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table gentelella.role: ~6 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `description`) VALUES
(1, '系统管理员', '超级管理员'),
(2, '普通用户', '普通用户'),
(5, '研发经理', '管理研发工作'),
(6, '产品经理', '产品推广应用以及新产品定义'),
(7, '人事经理', '员工绩效考核，人员变动安排以及培训'),
(8, '行政经理', '负责公司行政，对外宣传工作');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table gentelella.role_menu
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE IF NOT EXISTS `role_menu` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                           `rid` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
                                           `mid` int(11) NOT NULL DEFAULT '0' COMMENT '菜单id',
                                           PRIMARY KEY (`id`),
                                           KEY `r_m_rid` (`rid`),
                                           KEY `r_m_mid` (`mid`),
                                           CONSTRAINT `r_m_mid` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE CASCADE,
                                           CONSTRAINT `r_m_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- Dumping data for table gentelella.role_menu: ~18 rows (大约)
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` (`id`, `rid`, `mid`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 1, 13),
(14, 1, 14),
(15, 1, 15),
(16, 1, 16),
(17, 2, 1),
(18, 2, 2);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;

-- Dumping structure for table gentelella.role_permission
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE IF NOT EXISTS `role_permission` (
                                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                                 `rid` int(11) NOT NULL,
                                                 `pid` int(11) NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 KEY `r_p_rid` (`rid`),
                                                 KEY `r_p_pid` (`pid`),
                                                 CONSTRAINT `r_p_pid` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`) ON DELETE CASCADE,
                                                 CONSTRAINT `r_p_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- Dumping data for table gentelella.role_permission: ~18 rows (大约)
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`id`, `rid`, `pid`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(5, 1, 5),
(6, 1, 6),
(7, 2, 5),
(8, 1, 16),
(9, 1, 17),
(10, 1, 18),
(11, 1, 19),
(12, 1, 20),
(13, 1, 21),
(14, 1, 22),
(15, 1, 23),
(16, 1, 24),
(17, 1, 25),
(18, 1, 26),
(19, 1, 27);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

-- Dumping structure for table gentelella.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `username` varchar(50) DEFAULT '' COMMENT '用户名',
                                      `password` varchar(50) DEFAULT '' COMMENT '密码',
                                      `email` varchar(50) DEFAULT '' COMMENT '邮箱',
                                      `gender` varchar(50) DEFAULT 'male' COMMENT '性别',
                                      `telephone` varchar(50) DEFAULT '' COMMENT '联系方式',
                                      `salt` varchar(100) DEFAULT '' COMMENT '加密字符',
                                      `create_time` varchar(50) DEFAULT NULL COMMENT '设立时间',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- Dumping data for table gentelella.user: ~25 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `gender`, `telephone`, `salt`, `create_time`) VALUES
(1, 'ximen', 'a7d59dfc5332749cb801f86a24f5f590', 'ximen@163.com', 'male', '18236887931', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-09-16 15:28'),
(2, 'yuxiaoxi', '', '625320456@qq.com', 'female', '17335798837', '', '2019-09-16 15:16'),
(3, 'changyonghui', '', 'changyonghui@163.com', 'male', '18236887931', '', '2019-09-16 15:16'),
(4, 'liuduan', 'a7d59dfc5332749cb801f86a24f5f590', 'liuduan@163.com', 'female', '18236887931', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-09-16 15:17'),
(5, 'yangqichao', '', 'yangqichao@163.com', 'male', '18236887931', '', '2019-09-16 15:21'),
(6, 'zhangqiongfang', '', '854440931@qq.com', 'female', '19937109080', '', '2019-09-16 15:57'),
(7, 'zhangsiyuan', '', 'zhangsiyuan@qq.com', 'female', '18236887931', '', '2019-09-16 15:24'),
(8, 'wuguangheng', '', 'wuguangheng@163.com', 'male', '18236887931', '', '2019-09-16 15:25'),
(9, 'chenghuoqing', '', 'chenghuoqing@163.com', 'male', '18236887931', '', '2019-09-16 15:31'),
(10, 'xuman', 'a7d59dfc5332749cb801f86a24f5f590', '2466381931@qq.com', 'female', '15803828717', 'e5ykFiNwShfCXvBRPr3wXg==', '2019-09-16 15:32'),
(11, 'songzhongling', '', 'songzhongling@qq.com', 'female', '15803821029', '', '2019-09-16 15:32'),
(12, 'zhanglulu', '', '382945893@qq.com', 'female', '17513318095', '', '2019-09-16 15:38'),
(13, 'sunrongyou', '', 'srydwhy@163.com', 'female', '15637153072', '', '2019-09-16 15:34'),
(14, 'mazhengyu', '', '804132285@qq.com', 'female', '15890123263', '', '2019-09-16 15:46'),
(15, 'cuijie', '', '362641790@qq.com', 'male', '15516160309', '', '2019-09-16 15:49'),
(16, 'hujiyong', '', '504981561@qq.com', 'male', '13673640127', '', '2019-09-16 15:51'),
(17, 'guoruidong', '', '307260894@qq.com', 'male', '18537181742', '', '2019-09-16 16:05'),
(18, 'liuruiling', '', '502478011@qq.com', 'female', '17737150201', '', '2019-09-16 16:06'),
(19, 'shamanding', '', '502579565@qq.com', 'male', '13539961627', '', '2019-09-16 16:07'),
(20, 'zhangbo', '', '383109300@qq.com', 'female', '17537135185', '', '2019-09-16 16:08'),
(21, 'liuwei', '', '13676985508@163.com', 'female', '13676985508', '', '2019-09-16 16:08'),
(22, 'shixiaodong', '', '875970653@qq.com', 'male', '18538528180', '', '2019-09-16 16:09'),
(23, 'xiongzhenzhen', '', 'zhenxin180@126.com', 'female', '15938770293', '', '2019-09-16 16:10'),
(24, 'guoding', '', '674672170@qq.com', 'female', '13613846355', '', '2019-09-16 16:23'),
(25, 'qinxiaoyang', '', '898499397@qq.com', 'male', '18538101871', '', '2019-09-16 16:23');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table gentelella.user_dept
DROP TABLE IF EXISTS `user_dept`;
CREATE TABLE IF NOT EXISTS `user_dept` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                           `uid` int(11) NOT NULL COMMENT '用户id',
                                           `dept_id` int(11) NOT NULL COMMENT '部门id',
                                           PRIMARY KEY (`id`),
                                           KEY `u_d_uid` (`uid`),
                                           KEY `u_d_dept_id` (`dept_id`),
                                           CONSTRAINT `u_d_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE CASCADE,
                                           CONSTRAINT `u_d_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='用户部门表';

-- Dumping data for table gentelella.user_dept: ~25 rows (大约)
/*!40000 ALTER TABLE `user_dept` DISABLE KEYS */;
INSERT INTO `user_dept` (`id`, `uid`, `dept_id`) VALUES
(1, 1, 4),
(2, 2, 9),
(3, 3, 4),
(4, 4, 4),
(5, 5, 4),
(6, 6, 5),
(7, 7, 4),
(8, 8, 4),
(9, 9, 4),
(10, 10, 8),
(11, 11, 7),
(12, 12, 1),
(13, 13, 7),
(14, 14, 4),
(15, 15, 4),
(16, 16, 4),
(17, 17, 4),
(18, 18, 5),
(19, 19, 5),
(20, 20, 5),
(21, 21, 3),
(22, 22, 4),
(23, 23, 9),
(24, 24, 6),
(25, 25, 6);
/*!40000 ALTER TABLE `user_dept` ENABLE KEYS */;

-- Dumping structure for table gentelella.user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT,
                                           `uid` int(11) DEFAULT NULL,
                                           `rid` int(11) DEFAULT NULL,
                                           PRIMARY KEY (`id`),
                                           KEY `u_r_uid` (`uid`),
                                           KEY `u_r_rid` (`rid`),
                                           CONSTRAINT `u_r_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE CASCADE,
                                           CONSTRAINT `u_r_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table gentelella.user_role: ~25 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `uid`, `rid`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 2),
(4, 4, 2),
(5, 5, 2),
(6, 6, 2),
(7, 7, 2),
(8, 8, 2),
(9, 9, 2),
(10, 10, 7),
(11, 11, 8),
(12, 12, 2),
(13, 13, 2),
(14, 14, 2),
(15, 15, 2),
(16, 16, 2),
(17, 17, 2),
(18, 18, 2),
(19, 19, 2),
(20, 20, 2),
(21, 21, 2),
(22, 22, 2),
(23, 23, 2),
(24, 24, 2),
(25, 25, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;