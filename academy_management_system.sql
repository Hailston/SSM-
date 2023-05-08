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

 Date: 08/05/2023 09:34:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_classInfo
-- ----------------------------
DROP TABLE IF EXISTS `t_classInfo`;
CREATE TABLE `t_classInfo` (
  `classNumber` varchar(20) NOT NULL COMMENT 'classNumber',
  `className` varchar(20) NOT NULL COMMENT '班级名称',
  `classSpecialFieldNumber` varchar(20) NOT NULL COMMENT '所属专业',
  `classBirthDate` varchar(20) DEFAULT NULL COMMENT '成立日期',
  `classTeacherCharge` varchar(12) DEFAULT NULL COMMENT '班主任',
  `classTelephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `classMemo` varchar(100) DEFAULT NULL COMMENT '附加信息',
  PRIMARY KEY (`classNumber`),
  KEY `classSpecialFieldNumber` (`classSpecialFieldNumber`),
  CONSTRAINT `t_classinfo_ibfk_1` FOREIGN KEY (`classSpecialFieldNumber`) REFERENCES `t_specialFieldInfo` (`specialFieldNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_collegeInfo
-- ----------------------------
DROP TABLE IF EXISTS `t_collegeInfo`;
CREATE TABLE `t_collegeInfo` (
  `collegeNumber` varchar(20) NOT NULL COMMENT 'collegeNumber',
  `collegeName` varchar(20) NOT NULL COMMENT '学院名称',
  `collegeBirthDate` varchar(20) DEFAULT NULL COMMENT '成立日期',
  `collegeMan` varchar(10) DEFAULT NULL COMMENT '院长姓名',
  `collegeTelephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `collegeMemo` varchar(100) DEFAULT NULL COMMENT '附加信息',
  PRIMARY KEY (`collegeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_courseInfo
-- ----------------------------
DROP TABLE IF EXISTS `t_courseInfo`;
CREATE TABLE `t_courseInfo` (
  `courseNumber` varchar(20) NOT NULL COMMENT 'courseNumber',
  `courseName` varchar(20) NOT NULL COMMENT '课程名称',
  `courseTeacher` varchar(20) NOT NULL COMMENT '上课老师',
  `courseTime` varchar(40) DEFAULT NULL COMMENT '上课时间',
  `coursePlace` varchar(40) DEFAULT NULL COMMENT '上课地点',
  `courseScore` float NOT NULL COMMENT '课程学分',
  `courseMemo` varchar(100) DEFAULT NULL COMMENT '附加信息',
  PRIMARY KEY (`courseNumber`),
  KEY `courseTeacher` (`courseTeacher`),
  CONSTRAINT `t_courseinfo_ibfk_1` FOREIGN KEY (`courseTeacher`) REFERENCES `t_teacher` (`teacherNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `newsTitle` varchar(50) NOT NULL COMMENT '新闻标题',
  `newsContent` varchar(500) NOT NULL COMMENT '新闻内容',
  `newsDate` varchar(20) DEFAULT NULL COMMENT '发布日期',
  `newsPhoto` varchar(60) NOT NULL COMMENT '新闻图片',
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_scoreInfo
-- ----------------------------
DROP TABLE IF EXISTS `t_scoreInfo`;
CREATE TABLE `t_scoreInfo` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `studentNumber` varchar(30) NOT NULL COMMENT '学生对象',
  `courseNumber` varchar(20) NOT NULL COMMENT '课程对象',
  `scoreValue` float NOT NULL COMMENT '成绩得分',
  `studentEvaluate` varchar(30) DEFAULT NULL COMMENT '学生评价',
  PRIMARY KEY (`scoreId`),
  KEY `studentNumber` (`studentNumber`),
  KEY `courseNumber` (`courseNumber`),
  CONSTRAINT `t_scoreinfo_ibfk_1` FOREIGN KEY (`studentNumber`) REFERENCES `t_student` (`studentNumber`),
  CONSTRAINT `t_scoreinfo_ibfk_2` FOREIGN KEY (`courseNumber`) REFERENCES `t_courseInfo` (`courseNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_specialFieldInfo
-- ----------------------------
DROP TABLE IF EXISTS `t_specialFieldInfo`;
CREATE TABLE `t_specialFieldInfo` (
  `specialFieldNumber` varchar(20) NOT NULL COMMENT 'specialFieldNumber',
  `specialFieldName` varchar(20) NOT NULL COMMENT '专业名称',
  `specialCollegeNumber` varchar(20) NOT NULL COMMENT '所在学院',
  `specialBirthDate` varchar(20) DEFAULT NULL COMMENT '成立日期',
  `specialMan` varchar(10) DEFAULT NULL COMMENT '联系人',
  `specialTelephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `specialMemo` varchar(100) DEFAULT NULL COMMENT '附加信息',
  PRIMARY KEY (`specialFieldNumber`),
  KEY `specialCollegeNumber` (`specialCollegeNumber`),
  CONSTRAINT `t_specialfieldinfo_ibfk_1` FOREIGN KEY (`specialCollegeNumber`) REFERENCES `t_collegeInfo` (`collegeNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `studentNumber` varchar(30) NOT NULL COMMENT 'studentNumber',
  `studentName` varchar(12) NOT NULL COMMENT '姓名',
  `studentPassword` varchar(30) NOT NULL COMMENT '登录密码',
  `studentSex` varchar(2) NOT NULL COMMENT '性别',
  `studentClassNumber` varchar(20) NOT NULL COMMENT '所在班级',
  `studentBirthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `studentState` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `studentPhoto` varchar(60) NOT NULL COMMENT '学生照片',
  `studentTelephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `studentEmail` varchar(30) DEFAULT NULL COMMENT '学生邮箱',
  `studentQQ` varchar(20) DEFAULT NULL COMMENT '联系qq',
  `studentAddress` varchar(100) DEFAULT NULL COMMENT '家庭地址',
  `studentMemo` varchar(100) DEFAULT NULL COMMENT '附加信息',
  PRIMARY KEY (`studentNumber`),
  KEY `studentClassNumber` (`studentClassNumber`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`studentClassNumber`) REFERENCES `t_classInfo` (`classNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_studentSelectCourseInfo
-- ----------------------------
DROP TABLE IF EXISTS `t_studentSelectCourseInfo`;
CREATE TABLE `t_studentSelectCourseInfo` (
  `selectId` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `studentNumber` varchar(30) NOT NULL COMMENT '学生对象',
  `courseNumber` varchar(20) NOT NULL COMMENT '课程对象',
  PRIMARY KEY (`selectId`),
  KEY `studentNumber` (`studentNumber`),
  KEY `courseNumber` (`courseNumber`),
  CONSTRAINT `t_studentselectcourseinfo_ibfk_1` FOREIGN KEY (`studentNumber`) REFERENCES `t_student` (`studentNumber`),
  CONSTRAINT `t_studentselectcourseinfo_ibfk_2` FOREIGN KEY (`courseNumber`) REFERENCES `t_courseInfo` (`courseNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `teacherNumber` varchar(20) NOT NULL COMMENT 'teacherNumber',
  `teacherName` varchar(12) NOT NULL COMMENT '教师姓名',
  `teacherPassword` varchar(30) DEFAULT NULL COMMENT '登录密码',
  `teacherSex` varchar(2) NOT NULL COMMENT '性别',
  `teacherBirthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `teacherArriveDate` varchar(20) DEFAULT NULL COMMENT '入职日期',
  `teacherCardNumber` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `teacherPhone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `teacherPhoto` varchar(60) NOT NULL COMMENT '教师照片',
  `teacherAddress` varchar(100) DEFAULT NULL COMMENT '家庭地址',
  `teacherMemo` varchar(100) DEFAULT NULL COMMENT '附加信息',
  PRIMARY KEY (`teacherNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
