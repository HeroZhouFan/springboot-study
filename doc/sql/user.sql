/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 23/05/2022 01:51:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` char(32) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `age` tinyint unsigned NOT NULL DEFAULT '18' COMMENT '年龄',
  `sex` enum('man','woman','baomi') NOT NULL DEFAULT 'baomi' COMMENT '性别',
  `tel` char(11) NOT NULL COMMENT '电话',
  `addr` varchar(50) NOT NULL DEFAULT 'beijing' COMMENT '地址',
  `card` char(18) NOT NULL COMMENT '身份证号',
  `married` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0代表未结婚，1代表已结婚',
  `salary` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '薪水',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `tel` (`tel`),
  UNIQUE KEY `card` (`card`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (1, '张三', '123456', '123657567@qq.com', 13, 'man', '13583784987', '北京', '123112421423424', 0, 1332.43);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (2, '李四', '2343432', '12567573@qq.com', 46, 'woman', '13689892389', '深圳', '573567367', 0, 435435.44);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (3, '周杰伦', '324324', '12456453@qq.com', 79, 'man', '1359823434', '广州', '24562456', 1, 34534.43);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (4, '张艺兴', '46547', '1233346346@qq.com', 26, 'woman', '13598324347', '成都', '45625626', 0, 34345.43);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (5, '宋丹丹', '575757', '12657653@qq.com', 45, 'man', '1359234987', '厦门', '452625464', 1, 65465.43);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (6, '何炅', '76887', '12768673@qq.com', 43, 'man', '13598233437', '长沙', '3575472547', 0, 56546.43);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `age`, `sex`, `tel`, `addr`, `card`, `married`, `salary`) VALUES (7, '谢娜', '768678', '1678723@qq.com', 90, 'woman', '13512490987', '珠海', '357357347', 1, 577657.44);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
