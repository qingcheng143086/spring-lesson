/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 127.0.0.1:3306
 Source Schema         : bootdb

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 12/10/2020 11:21:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_1991
-- ----------------------------
DROP TABLE IF EXISTS `order_1991`;
CREATE TABLE `order_1991`  (
  `order_id` int(0) NOT NULL,
  `order_money` double(10, 2) NULL DEFAULT NULL,
  `order_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_1991
-- ----------------------------
INSERT INTO `order_1991` VALUES (1, 100.00, '北京');
INSERT INTO `order_1991` VALUES (2, 100.00, '上海');
INSERT INTO `order_1991` VALUES (111, 3333.00, 'dkd');
INSERT INTO `order_1991` VALUES (222, 3333.00, 'dkd');
INSERT INTO `order_1991` VALUES (333, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (444, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (555, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (666, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (777, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1001, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1002, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1003, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1004, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1005, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1006, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (1008, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (10010, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (10106, 443.20, '重庆');
INSERT INTO `order_1991` VALUES (111010, 3333.00, 'dkd');

SET FOREIGN_KEY_CHECKS = 1;
