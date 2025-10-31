/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50720 (5.7.20)
 Source Host           : localhost:3306
 Source Schema         : department

 Target Server Type    : MySQL
 Target Server Version : 50720 (5.7.20)
 File Encoding         : 65001

 Date: 31/10/2025 09:41:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(11) NOT NULL COMMENT '活动id',
  `time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动时间',
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '活动主题',
  `intr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '活动内容介绍',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '活动地址',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '活动费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, '2022-11-20 17:19:21', '相亲', '单身青年相亲', '同乐公园', 100.00);

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '合同号',
  `hid` int(11) NULL DEFAULT NULL COMMENT '关联房屋id',
  `lid` int(11) NULL DEFAULT NULL COMMENT '关联租户id',
  `time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '合同签订时间',
  `startTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '合同生效起始时间',
  `endTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '合同失效时间',
  `totalMoney` double(255, 0) NULL DEFAULT NULL COMMENT '合同总金额',
  `payType` int(11) NULL DEFAULT NULL COMMENT '1月付 2半年付 3年付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '合同表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '2022112001', 1, 1, '2022-11-20 16:49:00', '2022-11-21 16:49:02', '2022-11-22 16:49:05', 180, 1);

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '房屋地址',
  `floor` int(11) NULL DEFAULT NULL COMMENT '楼层',
  `roomNum` int(11) NULL DEFAULT NULL COMMENT '房间号',
  `area` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '面积',
  `dir` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '朝向',
  `deco` int(11) NULL DEFAULT NULL COMMENT '装修类型 1毛坯 2精装',
  `air` int(11) NULL DEFAULT NULL COMMENT '是否双气 1是 2否',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `rentStatus` int(11) NULL DEFAULT NULL COMMENT '出租状态 1已出租 2未出租 3停止出租',
  `addTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `updateTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '房屋状态 1正常 2已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '房屋表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES (1, '老代庄10号', 1, 102, '30平', '南', 1, 1, 1980.00, 2, '2022-11-23 00:00:00', '2025-09-24 16:04:27', 1);
INSERT INTO `house` VALUES (2, '航海路60号', 2, 209, '65平', '西', 2, 2, 2000.00, 3, '2022-11-23 10:48:44', '2022-11-23 00:00:00', 1);
INSERT INTO `house` VALUES (3, '二七万达', 1, 3, '56平', '东', 3, 1, 13000.00, 1, '2022-11-25 16:13:16', '2022-11-25 16:13:16', 1);
INSERT INTO `house` VALUES (4, '海为科技园', 1, 3, '200平', '北', 1, 2, 300.00, 3, '2022-11-25 16:13:13', '2022-11-25 16:13:13', 1);
INSERT INTO `house` VALUES (5, '台胞小区', 1, 8, '90平', '东北', 2, 1, 40.00, 1, '2022-11-25 16:13:12', '2022-11-25 16:13:12', 1);
INSERT INTO `house` VALUES (6, '重邮', 1, 105, '50平', '南', 1, 1, 2222.20, 1, '2025-09-24 23:15:48', '2025-09-24 23:15:48', 2);
INSERT INTO `house` VALUES (8, '宁静', 1, 105, '60平', '南', 2, 2, 1100.00, 1, '2025-09-24 23:15:48', '2025-09-24 23:15:48', 2);
INSERT INTO `house` VALUES (12, '成都', 23, 509, '700平', '南', 1, 1, 67890.00, 2, '2025-09-24 23:00:42', '2025-09-24 23:00:42', 2);
INSERT INTO `house` VALUES (13, '天兰', 2, 231, '20000平', '北', 0, 0, 124124.00, 0, '2025-09-24 22:59:27', '2025-09-24 22:59:27', 2);
INSERT INTO `house` VALUES (14, 'wqe', 1, 1, '1', '1', 0, 0, 1.00, 1, '2004-06-06 00:00:00', NULL, 1);
INSERT INTO `house` VALUES (15, 'weq', 2, 2, '2', '2', 0, 0, 2.00, 0, '2056-09-05 00:00:00', NULL, 1);

-- ----------------------------
-- Table structure for lessee
-- ----------------------------
DROP TABLE IF EXISTS `lessee`;
CREATE TABLE `lessee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '租户姓名',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别 1男 2女',
  `np` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '籍贯',
  `idCard` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '身份证号码',
  `addTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lessee
-- ----------------------------
INSERT INTO `lessee` VALUES (1, '张三', '110', 1, '郑州', '4101010110101', '2022-11-20 16:38:15');

-- ----------------------------
-- Table structure for logi
-- ----------------------------
DROP TABLE IF EXISTS `logi`;
CREATE TABLE `logi`  (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '后勤人员姓名',
  `idCard` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '后勤人员身份证号',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '后勤人员手机',
  `sex` int(11) NULL DEFAULT NULL COMMENT '1男 2女',
  `addTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `salary` double(10, 2) NULL DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后勤人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logi
-- ----------------------------

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NULL DEFAULT NULL COMMENT '关联房屋id',
  `loid` int(11) NULL DEFAULT NULL COMMENT '关联后勤人员id',
  `time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '维修时间',
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '维修结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '维修表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain
-- ----------------------------

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NULL DEFAULT NULL COMMENT '关联房屋id',
  `lid` int(11) NULL DEFAULT NULL COMMENT '关联租户id',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '缴纳房租',
  `payTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '房租表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rent
-- ----------------------------
INSERT INTO `rent` VALUES (1, 1, 1, 180.00, '2022-11-20 16:56:02');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL COMMENT '1男 2女',
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '真实姓名',
  `hiredate` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '入职时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '1正常 2离职',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 1, '邱世举', '2022-11-22 16:22:54', 1);
INSERT INTO `user` VALUES (2, 'zs', '123456', 2, '张三', '2022-11-22 16:23:12', 1);
INSERT INTO `user` VALUES (3, 'ls', '123456', 2, '李四', '2022-11-22 16:23:30', 1);
INSERT INTO `user` VALUES (4, 'lb', '666', 1, '程雨遥', '2025-07-16 17:08:24', 1);

SET FOREIGN_KEY_CHECKS = 1;
