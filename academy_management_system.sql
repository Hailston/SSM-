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

 Date: 16/05/2023 10:39:17
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
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`id`, `username`, `password`) VALUES (1, 'a', 'a');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
BEGIN;
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (1, '1002', 90, 0, '10-320', '1,3-17周/2节', '10', 'JavaEE', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (2, '1002', 90, 0, '10-320', NULL, '10', 'Java EA', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (3, '1002', 90, 0, NULL, NULL, '10', 'Java EB', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (4, '1002', 90, 0, NULL, NULL, '10', 'Java EC', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (5, '1002', 90, 0, NULL, NULL, '10', 'Java ED', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (6, '1002', 90, 0, NULL, NULL, '10', 'Java EE', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (7, '1002', 90, 0, NULL, NULL, '10', 'Java EF', 1);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (8, '1002', 90, 0, '10-320', NULL, '10', 'Java EA', 2);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (9, '1002', 90, 0, NULL, NULL, '10', 'Java EB', 2);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (10, '1002', 90, 0, NULL, NULL, '10', 'Java EC', 2);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (11, '1002', 90, 0, NULL, NULL, '10', 'Java ED', 2);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (12, '1002', 90, 0, NULL, NULL, '10', 'Java EE', 2);
INSERT INTO `classes` (`id`, `teacher_id`, `choose_max`, `choose_cur_num`, `room`, `cour_time`, `cmark`, `cname`, `ctype`) VALUES (13, '1002', 90, 0, NULL, NULL, '10', 'Java EF', 2);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (1, '1001', '刘文选', '男', '@hngy123', '信息工程学院', '北京', '10', '2523760784@qq.com', NULL, '17674128515', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (2, '1002', '杨定康', '男', '@hngy', '信息工程学院', '北京', '10', 'test@qq.com', NULL, '17674128515', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (3, '1003', '伍允文', '男', '@hngy', '信息工程学院', '北京', '10', 'test@qq.com', NULL, '17674128515', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (4, '1004', '彭源1', '男', '@hngy123', '信息工程学院', '湖南', '10', 'test1@qq.com', NULL, '17611111111', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (5, '1005', '彭源2', '男', '@hngy124', '信息工程学院', '湖南', '10', 'test2@qq.com', NULL, '17611111112', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (6, '1006', '彭源3', '男', '@hngy125', '信息工程学院', '湖南', '10', 'test3@qq.com', NULL, '17611111113', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (7, '1007', '彭源4', '男', '@hngy126', '信息工程学院', '湖南', '10', 'test4@qq.com', NULL, '17611111114', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (8, '1008', '彭源5', '男', '@hngy127', '信息工程学院', '湖南', '10', 'test5@qq.com', NULL, '17611111115', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (9, '1009', '彭源6', '男', '@hngy128', '信息工程学院', '湖南', '10', 'test6@qq.com', NULL, '17611111116', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (10, '1010', '彭源7', '男', '@hngy129', '信息工程学院', '湖南', '10', 'test7@qq.com', NULL, '17611111117', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (11, '1011', '彭源8', '男', '@hngy130', '信息工程学院', '湖南', '10', 'test8@qq.com', NULL, '17611111118', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (61, '1012', '伍允文2', '男', '@hngy124', '信息工程学院', '湖南', '10', 'test10@qq.com', NULL, '17611111119', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (62, '1013', '伍允文3', '男', '@hngy125', '信息工程学院', '湖南', '10', 'test11@qq.com', NULL, '17611111120', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (63, '1014', '伍允文4', '男', '@hngy126', '信息工程学院', '湖南', '10', 'test12@qq.com', NULL, '17611111121', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (64, '1015', '伍允文5', '男', '@hngy127', '信息工程学院', '湖南', '10', 'test13@qq.com', NULL, '17611111122', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (65, '1016', '伍允文6', '男', '@hngy128', '信息工程学院', '湖南', '10', 'test14@qq.com', NULL, '17611111123', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (66, '1017', '伍允文7', '男', '@hngy129', '信息工程学院', '湖南', '10', 'test15@qq.com', NULL, '17611111124', 10);
INSERT INTO `student` (`id`, `sno`, `username`, `sex`, `password`, `department`, `jiguan`, `mark`, `email`, `image`, `tel`, `maxClasses`) VALUES (67, '1018', '伍允文8', '男', '@hngy130', '信息工程学院', '湖南', '10', 'test16@qq.com', NULL, '17611111125', 10);
COMMIT;

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
-- Records of student_classes
-- ----------------------------
BEGIN;
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (100, '1001', 1);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (100, '1002', 1);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (100, '1003', 1);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (100, '1001', 8);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (100, '1002', 8);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (100, '1003', 8);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (NULL, '1001', 9);
INSERT INTO `student_classes` (`cscore`, `st_id`, `cs_id`) VALUES (NULL, '1001', 10);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (1, '1001', '刘文选', 20, '', '17674128515', '123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (2, '1002', '彭源1', 20, 'test1@qq.com', '17674121111', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (3, '1003', '彭源2', 21, 'test2@qq.com', '17674121112', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (4, '1004', '彭源3', 22, 'test3@qq.com', '17674121113', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (5, '1005', '彭源4', 23, 'test4@qq.com', '17674121114', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (6, '1006', '彭源5', 24, 'test5@qq.com', '17674121115', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (7, '1007', '彭源6', 25, 'test6@qq.com', '17674121116', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (8, '1008', '彭源7', 26, 'test7@qq.com', '17674121117', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (9, '1009', '彭源8', 27, 'test8@qq.com', '17674121118', '@hngy123', '教授');
INSERT INTO `teacher` (`id`, `tno`, `tname`, `age`, `email`, `tel`, `password`, `teaType`) VALUES (10, '1010', '彭源9', 28, 'test9@qq.com', '17674121119', '@hngy123', '教授');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
