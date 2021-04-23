/*
 Navicat Premium Data Transfer

 Source Server         : jason
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : sanquan

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 15/04/2021 02:33:14
*/
/*CREATE DATABASE sanquan;
USE DATABASE sanquan;*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `ADMIN_ID` int NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `LOGIN_ID` int NOT NULL COMMENT '登录ID',
  `ADMIN_PASSWORD` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '管理员密码',
  `SALT` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '盐值',
  `ADMIN_NAME` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `ADMIN_MOBILE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `ADMIN_CHARACTOR` int NULL DEFAULT NULL COMMENT '角色，1:’超级管理员‘，2:’普通管理员‘',
  `ADMIN_STATUS` int NOT NULL DEFAULT 0 COMMENT '管理员账号状态,\'0\'可用， ‘1’禁用，‘2’ 注销',
  `CREATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `DELETED` int NULL DEFAULT NULL COMMENT '逻辑删除，0：未删除，：删除',
  PRIMARY KEY (`ADMIN_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `ROOM_ID` int NOT NULL AUTO_INCREMENT COMMENT '研讨室ID',
  `ROOM_NAME` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '房间号',
  `ROOM_CAPACITY` int NULL DEFAULT NULL COMMENT '教室容量',
  `ROOM_CAMPUS` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '校区，\"海甸校区\"，\"城西校区\"',
  `ROOM_DORM` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在宿舍楼',
  `ROOM_STATUS` int NULL DEFAULT 1 COMMENT '房间状态，1：’可预订‘，2：’不可预订‘',
  `CREATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `DELETED` int NULL DEFAULT NULL COMMENT '逻辑删除，0：未删除，：删除',
  PRIMARY KEY (`ROOM_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '10-001', 6, '海甸校区', '10栋宿舍', 1, '2021-04-13 22:19:28', '2021-04-13 22:22:33', NULL);
INSERT INTO `room` VALUES (3, '10-003', 10, '海甸校区', '10栋宿舍', 1, '2021-04-13 22:19:58', '2021-04-13 22:22:29', NULL);
INSERT INTO `room` VALUES (4, '10-004', 12, '海甸校区', '10栋宿舍', 1, '2021-04-13 22:20:20', '2021-04-13 22:22:28', NULL);
INSERT INTO `room` VALUES (5, '10-005', 14, '海甸校区', '10栋宿舍', 1, '2021-04-13 22:20:44', '2021-04-13 22:22:26', NULL);
INSERT INTO `room` VALUES (6, '10-006', 16, '海甸校区', '10栋宿舍', 1, '2021-04-13 22:20:58', '2021-04-13 22:22:24', NULL);
INSERT INTO `room` VALUES (7, '8-001', 4, '海甸校区', '8栋宿舍', 1, '2021-04-13 22:21:28', '2021-04-13 22:22:21', NULL);
INSERT INTO `room` VALUES (8, '8-002', 6, '海甸校区', '8栋宿舍', 1, '2021-04-13 22:21:55', '2021-04-13 22:22:20', NULL);
INSERT INTO `room` VALUES (9, '8-003', 8, '海甸校区', '8栋宿舍', 1, '2021-04-13 22:22:17', '2021-04-13 22:22:37', NULL);
INSERT INTO `room` VALUES (10, '8-004', 10, '海甸校区', '8栋宿舍', 1, '2021-04-13 22:22:54', '2021-04-13 22:22:54', NULL);
INSERT INTO `room` VALUES (11, 'cx-001', 4, '城西校区', '2栋宿舍', 1, '2021-04-13 22:23:26', '2021-04-13 22:23:26', NULL);
INSERT INTO `room` VALUES (12, 'cx-002', 6, '城西校区', '2栋宿舍', 1, '2021-04-13 22:23:42', '2021-04-13 22:23:42', NULL);
INSERT INTO `room` VALUES (13, 'cx-003', 8, '城西校区', '2栋宿舍', 1, '2021-04-13 22:23:55', '2021-04-13 22:23:55', NULL);
INSERT INTO `room` VALUES (14, 'cx-004', 10, '城西校区', '2栋宿舍', 1, '2021-04-13 22:24:15', '2021-04-13 22:24:15', NULL);
INSERT INTO `room` VALUES (15, 'cx-005', 12, '城西校区', '2栋宿舍', 1, '2021-04-13 22:24:37', '2021-04-13 22:24:37', NULL);
INSERT INTO `room` VALUES (16, '10-001', 45, '海甸校区', '10栋宿舍', 1, '2021-04-13 22:41:08', '2021-04-14 10:15:07', NULL);
INSERT INTO `room` VALUES (17, '10-002', 8, '海甸校区', '10栋宿舍', 1, '2021-04-14 10:15:03', '2021-04-14 10:15:15', NULL);

-- ----------------------------
-- Table structure for room_order
-- ----------------------------
DROP TABLE IF EXISTS `room_order`;
CREATE TABLE `room_order`  (
  `ORDER_ID` int NOT NULL AUTO_INCREMENT COMMENT '预约订单号',
  `ORDER_GOAL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '预约目的',
  `ORDER_PEOPLE_NUM` int NOT NULL DEFAULT 0 COMMENT '预约人数',
  `ORDER_START_TIME` datetime NOT NULL COMMENT '预约开始时间',
  `ORDER_END_TIME` datetime NOT NULL COMMENT '预约结束时间',
  `ORDER_STATUS` int NULL DEFAULT 1 COMMENT '预约状态，1：‘待审核’，2：’待使用’，3：‘使用中’，4：‘已结束’，5：’已取消‘，6：’审核失败‘',
  `USER_ID` int NOT NULL COMMENT '用户ID',
  `ROOM_ID` int NOT NULL COMMENT '房间ID',
  `CREATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `VERSION` int NULL DEFAULT NULL COMMENT '乐观锁',
  `DELETED` int NULL DEFAULT NULL COMMENT '逻辑删除，0：未删除，1：删除',
  PRIMARY KEY (`ORDER_ID`) USING BTREE,
  INDEX `fk_room_order_user_1`(`USER_ID`) USING BTREE,
  INDEX `fk_room_order_room_1`(`ROOM_ID`) USING BTREE,
  CONSTRAINT `fk_room_order_room_1` FOREIGN KEY (`ROOM_ID`) REFERENCES `room` (`ROOM_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_room_order_user_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_order
-- ----------------------------
INSERT INTO `room_order` VALUES (1, '辅导', 5, '2021-04-16 10:00:00', '2021-04-16 12:00:00', 1, 1, 1, '2021-04-13 22:27:49', '2021-04-13 22:37:56', NULL, NULL);
INSERT INTO `room_order` VALUES (2, '创新创业比赛小组讨论', 10, '2021-04-15 11:00:00', '2021-04-15 13:00:00', 2, 2, 15, '2021-04-13 22:33:53', '2021-04-14 16:03:42', NULL, NULL);
INSERT INTO `room_order` VALUES (3, '软件开发小组会议', 9, '2021-04-15 12:00:00', '2021-04-15 13:00:00', 3, 3, 3, '2021-04-13 22:35:35', '2021-04-14 16:04:15', NULL, NULL);
INSERT INTO `room_order` VALUES (4, '班干部会议', 9, '2021-04-11 20:00:00', '2021-04-11 21:00:00', 4, 1, 10, '2021-04-13 22:40:25', '2021-04-14 16:01:04', NULL, NULL);
INSERT INTO `room_order` VALUES (5, '考研分享讲座', 30, '2021-04-15 16:00:00', '2021-04-16 18:00:00', 5, 4, 16, '2021-04-13 22:45:00', '2021-04-13 22:45:00', NULL, NULL);
INSERT INTO `room_order` VALUES (6, '开发小组会议', 3, '2021-04-17 13:00:00', '2021-04-17 15:00:00', 6, 2, 7, '2021-04-13 22:55:49', '2021-04-13 22:55:49', NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `USER_ID` int NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `USER_LOGIN_ID` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户登录ID',
  `PASSWORD` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `STUDENT_ID` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号',
  `USER_NAME` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '用户姓名',
  `USER_COLLEGE` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学院',
  `USER_MAJOR` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专业',
  `USER_CLASS` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级',
  `USER_EVIDENCE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生认证',
  `USER_DESCRIBE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '个人描述',
  `WEIXIN_OPENID` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '微信登录openID',
  `USER_CREDIT` float NULL DEFAULT 0 COMMENT '信誉分',
  `USER_SCORE` int NULL DEFAULT 0 COMMENT '三全分',
  `USER_NICKNAME` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户昵称或网络名称',
  `USER_MOBILE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户手机号',
  `USER_AVATAR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户头像图片',
  `USER_STATUS` int NOT NULL DEFAULT 1 COMMENT '用户账号状态,\'1\'可用， ‘2’禁用，‘3’ 注销',
  `IS_WELL_STU` int NOT NULL DEFAULT 2 COMMENT '是否是学霸，1：是学霸，2：不是学霸',
  `CREATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `DELETED` int NULL DEFAULT NULL COMMENT '逻辑删除，0：未删除，：删除',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'jason', '123456', '20181620310190', '杨子硕', '计算机学院', '软件工程', '2018-4班', NULL, NULL, '', 100, 10, 'YD-YF', '15263526059', '', 1, 2, '2021-04-13 22:18:59', '2021-04-13 22:18:59', NULL);
INSERT INTO `user` VALUES (2, 'xiaowang', '121212', '20181620310188', '小王', '计算机学院', '软件工程', '2019-2班', NULL, NULL, '', 98, 1, 'Xw', '18273837284', '', 1, 2, '2021-04-13 22:29:18', '2021-04-13 22:29:18', NULL);
INSERT INTO `user` VALUES (3, 'xiaoming', '123123', '20181620310199', '小明', '外国语学院', '旅游英语', '2020-3班', NULL, NULL, '', 100, 0, 'Xm', '17283739382', '', 1, 2, '2021-04-13 22:30:45', '2021-04-13 22:30:45', NULL);
INSERT INTO `user` VALUES (4, 'wangmeng', '12341234', '2018172637283', '王猛', '管理学院', '工商管理', '2019-4班', NULL, NULL, '', 100, 1, 'Wm', '19283748374', '', 1, 2, '2021-04-13 22:32:11', '2021-04-13 22:32:11', NULL);

SET FOREIGN_KEY_CHECKS = 1;
