/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : db_cloud_disk

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-09-17 14:55:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_file_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_file_info`;
CREATE TABLE `tb_file_info` (
  `file_id` int(18) NOT NULL AUTO_INCREMENT,
  `file_user_id` int(18) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_size` double DEFAULT NULL,
  `file_status` int(1) DEFAULT '1' COMMENT '1正常 0回收',
  `file_type` int(1) DEFAULT NULL COMMENT '1图片、2文档、3视频、4音乐、0其他',
  `file_uploadTime` timestamp NULL DEFAULT NULL,
  `folder_id` int(18) DEFAULT NULL,
  `file_transformPDF` varchar(255) DEFAULT NULL COMMENT '文件路径PDF（转换为PDF，针对office文件）',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_file_info
-- ----------------------------
INSERT INTO `tb_file_info` VALUES ('17', '1', 'upload/Java后端开发_周浩.pdf', 'Java后端开发_周浩.pdf', '0.19', '1', '2', '2019-09-09 20:38:24', '13', 'upload/Java后端开发_周浩.pdf');
INSERT INTO `tb_file_info` VALUES ('18', '1', 'upload/pom1.xml', 'pom1.xml', '0', '1', '0', '2019-09-09 20:52:17', '0', 'upload/pom1.xml');
INSERT INTO `tb_file_info` VALUES ('19', '1', 'upload/数据库表.xlsx', '数据库表.xlsx', '0.01', '1', '0', '2019-09-09 20:56:32', '0', 'upload/数据库表.xlsx');
INSERT INTO `tb_file_info` VALUES ('20', '1', 'upload/1568079005027pom1.xml', '1568079005027pom1.xml', '0', '0', '0', '2019-09-10 09:30:05', '0', 'upload/1568079005027pom1.xml');
INSERT INTO `tb_file_info` VALUES ('23', '1', 'upload/timgbb.jpg', 'timgbb.jpg', '0.02', '1', '1', '2019-09-10 13:18:26', '0', 'upload/timgbb.jpg');
INSERT INTO `tb_file_info` VALUES ('24', '1', 'upload/timgcc.jpg', 'timgcc.jpg', '0.38', '0', '1', '2019-09-10 13:21:22', '0', 'upload/timgcc.jpg');
INSERT INTO `tb_file_info` VALUES ('25', '1', 'upload/1568093015423timgbb.jpg', '1568093015423timgbb.jpg', '63.34', '1', '1', '2019-09-10 13:23:35', '9', 'upload/1568093015423timgbb.jpg');
INSERT INTO `tb_file_info` VALUES ('26', '1', 'upload/1568093151838timgbb.jpg', '1568093151838timgbb.jpg', '15.84', '1', '1', '2019-09-10 13:25:51', '0', 'upload/1568093151838timgbb.jpg');
INSERT INTO `tb_file_info` VALUES ('28', '1', 'upload/123.mp3', '123.mp3', '0.009633333333333334', '0', '4', '2019-09-10 13:44:30', '0', 'upload/123.mp3');
INSERT INTO `tb_file_info` VALUES ('29', '1', 'upload/00.wav', '00.wav', '35.77', '0', '3', '2019-09-10 13:56:52', '0', 'upload/00.wav');
INSERT INTO `tb_file_info` VALUES ('30', '1', 'upload/video_20190910_132002.mp4', 'video_20190910_132002.mp4', '9.08', '1', '3', '2019-09-10 13:58:34', '0', 'upload/video_20190910_132002.mp4');
INSERT INTO `tb_file_info` VALUES ('31', '1', 'upload/1568095856142video_20190910_132002.mp4', '1568095856142video_20190910_132002.mp4', '9.08', '1', '3', '2019-09-10 14:10:56', '0', 'upload/1568095856142video_20190910_132002.mp4');
INSERT INTO `tb_file_info` VALUES ('32', '1', 'upload/1568096329488video_20190910_132002.mp4', '1568096329488video_20190910_132002.mp4', '9.08', '1', '3', '2019-09-10 14:18:49', '0', 'upload/1568096329488video_20190910_132002.mp4');
INSERT INTO `tb_file_info` VALUES ('33', '1', 'upload/《软件工程》实验4-序列图 (1).doc', '《软件工程》实验4-序列图 (1).doc', '0.2', '1', '2', '2019-09-10 14:23:51', '0', 'upload/null');
INSERT INTO `tb_file_info` VALUES ('34', '1', 'upload/1568096730720123.mp3', '1568096730720123.mp3', '2.89', '1', '4', '2019-09-10 14:25:30', '0', 'upload/1568096730720123.mp3');
INSERT INTO `tb_file_info` VALUES ('35', '1', 'upload/《软件工程》实验4-序列图 (1).doc', '《软件工程》实验4-序列图 (1).doc', '0.2', '0', '2', '2019-09-10 14:23:51', '11', 'upload/null');
INSERT INTO `tb_file_info` VALUES ('36', '1', 'upload/Java后端开发_周浩.pdf', 'Java后端开发_周浩.pdf', '0.19', '1', '2', '2019-09-09 20:38:24', '10', 'upload/Java后端开发_周浩.pdf');
INSERT INTO `tb_file_info` VALUES ('37', '1', 'upload/礼艺坊系统功能结构图+用例图v1.1.doc', '礼艺坊系统功能结构图+用例图v1.1.doc', '0.14', '1', '2', '2019-09-10 15:12:44', '0', 'upload/null');
INSERT INTO `tb_file_info` VALUES ('38', '1', 'upload/1568099579226timgcc.jpg', '1568099579226timgcc.jpg', '0.01', '1', '1', '2019-09-10 15:12:59', '0', 'upload/1568099579226timgcc.jpg');
INSERT INTO `tb_file_info` VALUES ('39', '1', 'upload/第二次学习总结.doc', '第二次学习总结.doc', '0.01', '1', '2', '2019-09-10 15:12:59', '0', 'upload/null');
INSERT INTO `tb_file_info` VALUES ('40', '1', 'upload/2020届毕业生秋季校招网申信息汇总.xlsx', '2020届毕业生秋季校招网申信息汇总.xlsx', '0.62', '1', '0', '2019-09-10 15:26:04', '0', 'upload/2020届毕业生秋季校招网申信息汇总.xlsx');

-- ----------------------------
-- Table structure for tb_file_share
-- ----------------------------
DROP TABLE IF EXISTS `tb_file_share`;
CREATE TABLE `tb_file_share` (
  `share_id` int(18) NOT NULL AUTO_INCREMENT,
  `user_id` int(18) DEFAULT NULL,
  `file_id` int(18) DEFAULT NULL,
  `share_link` varchar(255) DEFAULT NULL COMMENT '分享链接，由后端生成',
  `share_code` varchar(4) DEFAULT NULL COMMENT '提取码 没有加密就没有',
  `share_status` int(1) DEFAULT NULL COMMENT '1公开 0加密',
  `share_viewNumber` int(18) DEFAULT NULL,
  `share_downloadNumber` int(18) DEFAULT NULL,
  `share_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`share_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_file_share
-- ----------------------------
INSERT INTO `tb_file_share` VALUES ('1', null, null, null, null, null, null, null, null);
INSERT INTO `tb_file_share` VALUES ('38', '1', '29', 'J7IVX8FR', '8875', '0', '1', '1', '2019-09-10 15:08:27');

-- ----------------------------
-- Table structure for tb_file_transfer
-- ----------------------------
DROP TABLE IF EXISTS `tb_file_transfer`;
CREATE TABLE `tb_file_transfer` (
  `transfer_id` int(18) NOT NULL AUTO_INCREMENT,
  `user_id` int(18) DEFAULT NULL,
  `file_id` int(18) DEFAULT NULL,
  `transfer_progress` int(18) DEFAULT NULL,
  `transfer_status` int(1) DEFAULT NULL,
  `transfer_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `transfer_upload_and_download_flag` int(1) DEFAULT NULL,
  `transfer_file_size` double DEFAULT NULL,
  `transfer_file_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`transfer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_file_transfer
-- ----------------------------
INSERT INTO `tb_file_transfer` VALUES ('105', '1', '29', '100', '2', '2019-09-10 15:08:52', '2', '35.77', '00.wav');
INSERT INTO `tb_file_transfer` VALUES ('106', '1', '0', '100', '2', '2019-09-10 15:11:21', '2', '-1', 'Java后端开发_周浩.pdf pom1.xml 数据库表.xlsx');
INSERT INTO `tb_file_transfer` VALUES ('107', '1', '37', '100', '2', '2019-09-10 15:12:44', '1', '0.14', '礼艺坊系统功能结构图+用例图v1.1.doc');
INSERT INTO `tb_file_transfer` VALUES ('108', '1', '38', '100', '2', '2019-09-10 15:12:59', '1', '0.01', '1568099579226timgcc.jpg');
INSERT INTO `tb_file_transfer` VALUES ('109', '1', '39', '100', '2', '2019-09-10 15:12:59', '1', '0.01', '第二次学习总结.doc');
INSERT INTO `tb_file_transfer` VALUES ('110', '1', '40', '100', '2', '2019-09-10 15:26:04', '1', '0.62', '2020届毕业生秋季校招网申信息汇总.xlsx');
INSERT INTO `tb_file_transfer` VALUES ('111', '1', '0', '100', '2', '2019-09-10 15:26:12', '2', '-1', '第二次学习总结.doc 2020届毕业生秋季校招网申信息汇总.xlsx');

-- ----------------------------
-- Table structure for tb_folder_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_folder_info`;
CREATE TABLE `tb_folder_info` (
  `folder_id` int(18) NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(255) DEFAULT NULL,
  `user_id` int(18) DEFAULT NULL COMMENT '上一级目录id',
  `folder_parentFolderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_folder_info
-- ----------------------------
INSERT INTO `tb_folder_info` VALUES ('1', '吴亦凡', '2', '0');
INSERT INTO `tb_folder_info` VALUES ('2', '猪八戒', '1', '1');
INSERT INTO `tb_folder_info` VALUES ('3', '金元宝', '1', '0');
INSERT INTO `tb_folder_info` VALUES ('4', '王八蛋大大', '1', '0');
INSERT INTO `tb_folder_info` VALUES ('5', '白龙马', '1', '2');
INSERT INTO `tb_folder_info` VALUES ('6', '哪咤hh', '1', '3');
INSERT INTO `tb_folder_info` VALUES ('7', '黄眉大王', '1', '4');
INSERT INTO `tb_folder_info` VALUES ('8', '玉帝', '1', '6');
INSERT INTO `tb_folder_info` VALUES ('9', '王八蛋小小', '1', '0');
INSERT INTO `tb_folder_info` VALUES ('10', '小小', '1', '0');
INSERT INTO `tb_folder_info` VALUES ('11', '大大', '1', '0');
INSERT INTO `tb_folder_info` VALUES ('12', '大厦', '5', '0');
INSERT INTO `tb_folder_info` VALUES ('13', '周浩', '1', '0');

-- ----------------------------
-- Table structure for tb_member_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_info`;
CREATE TABLE `tb_member_info` (
  `member_id` int(18) NOT NULL AUTO_INCREMENT,
  `user_id` int(18) DEFAULT NULL,
  `member_status` int(1) DEFAULT '0' COMMENT '（0普通用户， 1会员用户）',
  `member_startTime` timestamp NULL DEFAULT NULL,
  `member_endTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_member_info
-- ----------------------------
INSERT INTO `tb_member_info` VALUES ('1', '3', '0', '2019-09-10 09:20:10', '2019-10-10 09:20:10');
INSERT INTO `tb_member_info` VALUES ('2', '4', '0', '2019-09-10 10:07:56', '2019-10-10 10:07:56');
INSERT INTO `tb_member_info` VALUES ('3', '1', '1', '2019-09-10 11:41:00', '2020-01-07 03:14:22');
INSERT INTO `tb_member_info` VALUES ('4', '5', '1', '2019-09-10 11:56:16', '2019-12-09 02:37:41');
INSERT INTO `tb_member_info` VALUES ('5', '6', '0', '2019-09-10 14:56:09', '2019-10-10 02:56:09');
INSERT INTO `tb_member_info` VALUES ('6', '8', '0', '2019-09-10 15:02:31', '2019-10-10 03:02:31');

-- ----------------------------
-- Table structure for tb_recycle
-- ----------------------------
DROP TABLE IF EXISTS `tb_recycle`;
CREATE TABLE `tb_recycle` (
  `recycle_id` int(18) NOT NULL AUTO_INCREMENT,
  `file_id` int(18) DEFAULT NULL,
  `recycle_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(18) DEFAULT NULL,
  PRIMARY KEY (`recycle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_recycle
-- ----------------------------
INSERT INTO `tb_recycle` VALUES ('24', '28', '2019-09-10 13:49:07', '1');
INSERT INTO `tb_recycle` VALUES ('25', '20', '2019-09-10 13:51:34', '1');
INSERT INTO `tb_recycle` VALUES ('27', '24', '2019-09-10 14:33:49', '1');
INSERT INTO `tb_recycle` VALUES ('28', '35', '2019-09-10 14:52:43', '1');
INSERT INTO `tb_recycle` VALUES ('29', '29', '2019-09-10 15:09:19', '1');

-- ----------------------------
-- Table structure for tb_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_info`;
CREATE TABLE `tb_user_info` (
  `user_id` int(18) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(18) DEFAULT NULL,
  `user_password` varchar(18) DEFAULT NULL,
  `user_email` varchar(36) DEFAULT NULL,
  `user_registerTime` timestamp NULL DEFAULT NULL,
  `user_usedSpace` double DEFAULT NULL,
  `user_totalSpace` double DEFAULT NULL,
  `user_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_info
-- ----------------------------
INSERT INTO `tb_user_info` VALUES ('1', 'yang', '1334', '2625744@qq.com', '2019-08-28 19:28:11', '1480.5917', '2048', 'aaa/timgaa.jpg');
INSERT INTO `tb_user_info` VALUES ('2', '123', '123', null, null, null, null, null);
INSERT INTO `tb_user_info` VALUES ('3', 'xiaoxinxin', 'yh1334', '245175@qq.com', '2019-09-10 09:20:10', '0', '10240', 'aaa/timg.jpg');
INSERT INTO `tb_user_info` VALUES ('4', 'xiaohong', '123456', '2606961@qq.com', '2019-09-10 10:07:56', '0', '10240', 'aaa/timg.jpg');
INSERT INTO `tb_user_info` VALUES ('5', 'ttt', '111111', '848949106@qq.com', '2019-09-10 11:56:16', '0', '2048', 'aaa/timg.jpg');
INSERT INTO `tb_user_info` VALUES ('6', 'ctdsads', 'dsaddsasdsa', '4545@qq.com', '2019-09-10 14:56:09', '0', '10240', 'aaa/timg.jpg');
INSERT INTO `tb_user_info` VALUES ('7', 'ctdsads', 'dsaddsasdsa', '4545@qq.com', '2019-09-10 14:56:19', '0', '10240', 'aaa/timg.jpg');
INSERT INTO `tb_user_info` VALUES ('8', 'yangyang', '123456', '2606961811@qq.com', '2019-09-10 15:02:31', '0', '10240', 'aaa/timg.jpg');
SET FOREIGN_KEY_CHECKS=1;
