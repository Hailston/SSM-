/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : academy_management_system

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 16/05/2023 20:36:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '课程号',
  `teacher_id` varchar(11) DEFAULT NULL COMMENT '教师号',
  `choose_max` int(11) DEFAULT NULL COMMENT '最大选课人数',
  `choose_cur_num` int(11) unsigned DEFAULT '0' COMMENT '已选人数',
  `room` varchar(50) DEFAULT NULL COMMENT '教室',
  `cour_time` varchar(50) DEFAULT NULL COMMENT '上课时间',
  `cmark` varchar(50) DEFAULT NULL COMMENT '学分',
  `cname` varchar(60) DEFAULT NULL COMMENT '课程名',
  `ctype` tinyint(4) DEFAULT NULL COMMENT '课程类别',
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(50) NOT NULL COMMENT '学号',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `password` varchar(20) DEFAULT '@hngy123' COMMENT '密码',
  `department` varchar(30) DEFAULT NULL COMMENT '院系',
  `jiguan` varchar(60) DEFAULT NULL COMMENT '籍贯',
  `mark` varchar(50) DEFAULT NULL COMMENT '学分',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `image` varchar(255) DEFAULT NULL COMMENT '照片',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `maxClasses` int(11) DEFAULT NULL COMMENT '最大选课数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sno_2` (`sno`),
  KEY `sno` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student_classes
-- ----------------------------
DROP TABLE IF EXISTS `student_classes`;
CREATE TABLE `student_classes` (
  `cscore` int(11) DEFAULT NULL COMMENT '成绩',
  `st_id` varchar(50) NOT NULL COMMENT '学生标识',
  `cs_id` int(11) NOT NULL COMMENT '课程号',
  KEY `cs_id` (`cs_id`),
  KEY `st_id` (`st_id`),
  CONSTRAINT `student_classes_ibfk_2` FOREIGN KEY (`cs_id`) REFERENCES `classes` (`id`),
  CONSTRAINT `student_classes_ibfk_3` FOREIGN KEY (`st_id`) REFERENCES `student` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tno` varchar(11) NOT NULL COMMENT '教师号',
  `tname` varchar(50) NOT NULL COMMENT '教师名',
  `age` int(50) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `password` varchar(50) DEFAULT '@hngy123' COMMENT '教师密码',
  `teaType` varchar(50) DEFAULT NULL COMMENT '教师类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tno_2` (`tno`),
  KEY `tno` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
