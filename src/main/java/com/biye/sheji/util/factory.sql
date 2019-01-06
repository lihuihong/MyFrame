/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : factory

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2019-01-06 22:34:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for factory_consu
-- ----------------------------
DROP TABLE IF EXISTS `factory_consu`;
CREATE TABLE `factory_consu` (
  `CONSU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONSU_NAME` varchar(100) DEFAULT NULL COMMENT '耗材名称',
  PRIMARY KEY (`CONSU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory_consu
-- ----------------------------

-- ----------------------------
-- Table structure for factory_equ
-- ----------------------------
DROP TABLE IF EXISTS `factory_equ`;
CREATE TABLE `factory_equ` (
  `EQU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EQU_NAME` varchar(1000) DEFAULT NULL COMMENT '设备名称',
  `EQU_MARK` varchar(1000) DEFAULT NULL COMMENT '设备描述',
  `EQU_ISPASS` varchar(1000) DEFAULT NULL COMMENT '设备是否报修(0,未保修 1,已报修)',
  `EQU_ISOK` varchar(1000) DEFAULT NULL COMMENT '设备是否报废(0,未报废 1,已报废)',
  `EQU_CONSU` varchar(1000) DEFAULT NULL COMMENT '设备是否申请耗材(0,未申请 1,已申请)',
  PRIMARY KEY (`EQU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory_equ
-- ----------------------------

-- ----------------------------
-- Table structure for factory_parts
-- ----------------------------
DROP TABLE IF EXISTS `factory_parts`;
CREATE TABLE `factory_parts` (
  `PAETS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EQU_ID` int(11) DEFAULT NULL COMMENT '设备配件所属设备id',
  `PAETS_NAME` varchar(100) DEFAULT NULL COMMENT '设备配件名称',
  PRIMARY KEY (`PAETS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory_parts
-- ----------------------------

-- ----------------------------
-- Table structure for factory_repair
-- ----------------------------
DROP TABLE IF EXISTS `factory_repair`;
CREATE TABLE `factory_repair` (
  `REPAIR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EQU_ID` int(11) NOT NULL COMMENT '维修设备id',
  `PAETS_ID` int(11) NOT NULL COMMENT '维修设备配件id',
  `USER_ID` int(11) NOT NULL COMMENT '维修设备分配用户id',
  `REPAIR_MARK` varchar(30) NOT NULL COMMENT '维修描述',
  `REPAIR_ISPASS` varchar(30) NOT NULL COMMENT '维修是否完成(0，未完成 1，已完成)',
  `REPAIR_START_TIME` datetime NOT NULL COMMENT '维修开始时间',
  `REPAIR_END_TIME` datetime NOT NULL COMMENT '维修完成时间',
  PRIMARY KEY (`REPAIR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory_repair
-- ----------------------------

-- ----------------------------
-- Table structure for factory_user
-- ----------------------------
DROP TABLE IF EXISTS `factory_user`;
CREATE TABLE `factory_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_TYPE` int(11) DEFAULT NULL COMMENT '(用户类型0普通用户，1管理员用户)',
  `USER_USERNAME` varchar(30) DEFAULT NULL,
  `USER_PASSWORD` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory_user
-- ----------------------------
INSERT INTO `factory_user` VALUES ('1', '0', 'admin', 'e10adc3949ba59abbe56e057f20f883e');
