/*
 Navicat Premium Data Transfer

 Source Server         : ImmortalCultivationPlan
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : 192.168.2.100:3306
 Source Schema         : Icp

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 13/11/2023 23:31:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for immortal
-- ----------------------------
DROP TABLE IF EXISTS `immortal`;
CREATE TABLE `immortal`  (
  `immortal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `immortal_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `immortal_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `immortal_gender` tinyint UNSIGNED NULL DEFAULT 0,
  `immortal_birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `immortal_attribute_hide` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '角色属性隐藏(全局)1',
  `immortal_attribute_content_hide` tinyint NULL DEFAULT NULL COMMENT ' 角色属性值加点说明隐藏 0 不隐藏 1隐藏',
  PRIMARY KEY (`immortal_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of immortal
-- ----------------------------
INSERT INTO `immortal` VALUES ('111', '222', '123', 1, '444', 0, 1);
INSERT INTO `immortal` VALUES ('11111', '111111111', '1111111111', 2, '11111111111', 1, 1);
INSERT INTO `immortal` VALUES ('immortalId_c9c778dd892b', 'immortalName_9bd412cb8d98', '123456', 1, 'immortalBirthday_6ca77f162d83', 1, 1);
INSERT INTO `immortal` VALUES ('immortalId_c9c778dd892C', 'immortalName_9bd412cb8d88', '123456', 1, 'immortalBirthday_6ca77f162d83', 1, 1);

-- ----------------------------
-- Table structure for immortal_attribute
-- ----------------------------
DROP TABLE IF EXISTS `immortal_attribute`;
CREATE TABLE `immortal_attribute`  (
  `immortal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `immortal_attribute_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '属性id',
  `immortal_attribute_value` int NOT NULL COMMENT '属性值',
  `immortal_attribute_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '属性加点说明',
  `immortal_attribute_update_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '属性值更新时间',
  `immortal_attribute_content_hidde` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '属性值说明隐藏'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of immortal_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for immortal_attribute_info
-- ----------------------------
DROP TABLE IF EXISTS `immortal_attribute_info`;
CREATE TABLE `immortal_attribute_info`  (
  `immortal_attribute_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '属性id',
  `immortal_attribute_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '属性名字',
  `immortal_attribute_vlue_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '属性值',
  `immortal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `immortal_attribute_hidde` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '属性隐藏',
  PRIMARY KEY (`immortal_attribute_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of immortal_attribute_info
-- ----------------------------
INSERT INTO `immortal_attribute_info` VALUES ('123', '123', '0', '111', 1);
INSERT INTO `immortal_attribute_info` VALUES ('123213', '123123', '0', '111', 0);

SET FOREIGN_KEY_CHECKS = 1;
