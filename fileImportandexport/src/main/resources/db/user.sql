/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 28/04/2019 15:01:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `sex` tinyint(1) DEFAULT NULL,
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', 1, '啦啦啦', 15);
INSERT INTO `user` VALUES (2, '张三', 1, '啦啦啦', 15);
INSERT INTO `user` VALUES (3, '张三', 1, '啦啦啦', 16);
INSERT INTO `user` VALUES (4, '张三', 1, '啦啦啦', 17);
INSERT INTO `user` VALUES (5, '张三', 1, '啦啦啦', 18);
INSERT INTO `user` VALUES (6, '张三', 2, '啦啦啦', 19);
INSERT INTO `user` VALUES (7, '张三', 1, '啦啦啦', 20);
INSERT INTO `user` VALUES (8, '张三', 1, '啦啦啦', 21);
INSERT INTO `user` VALUES (9, '张三', 1, '啦啦啦', 22);
INSERT INTO `user` VALUES (10, '张三', 1, '啦啦啦', 23);
INSERT INTO `user` VALUES (11, '张三', 1, '啦啦啦', 24);
INSERT INTO `user` VALUES (12, '张三', 1, '啦啦啦', 25);
INSERT INTO `user` VALUES (13, '张三', 1, '啦啦啦', 26);
INSERT INTO `user` VALUES (14, '张三', 4, '啦啦啦', 27);
INSERT INTO `user` VALUES (15, '张三', 1, '啦啦啦', 28);
INSERT INTO `user` VALUES (16, '张三', 1, '啦啦啦', 29);
INSERT INTO `user` VALUES (17, '张三', 1, '啦啦啦', 30);
INSERT INTO `user` VALUES (18, '张三', 1, '啦啦啦', 31);
INSERT INTO `user` VALUES (19, '张三', 1, '啦啦啦', 32);
INSERT INTO `user` VALUES (20, '张三', 1, '啦啦啦', 33);
INSERT INTO `user` VALUES (21, '张三', 1, '啦啦啦', 34);

SET FOREIGN_KEY_CHECKS = 1;
