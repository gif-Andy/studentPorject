/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : skydisk

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-06-25 11:57:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `adid` int(11) NOT NULL auto_increment,
  `adowner` varchar(255) NOT NULL,
  `adcompany` varchar(255) NOT NULL,
  `adphone` varchar(255) NOT NULL,
  `ademail` varchar(255) NOT NULL,
  `adname` varchar(255) NOT NULL,
  `adurl` varchar(255) NOT NULL,
  PRIMARY KEY  (`adid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES ('1', 'ardans', 'ardans', '13456', 'qwe', 'asd', 'C:\\Users\\阿单\\Desktop\\url-icon.png');
INSERT INTO `ad` VALUES ('9', 'qwe', 'da', '15975631481', '123@qq.com', 'jkl', 'C:\\Users\\阿单\\Desktop\\url-icon.png');
INSERT INTO `ad` VALUES ('10', 'zxc', 'zxc', '15975631642', 'we@qq.com', 'aasd', 'C:\\Users\\阿单\\Desktop\\company.png');
INSERT INTO `ad` VALUES ('11', 'nice', 'nice', '15975631648', '789@qq.com', '456', 'C:\\Users\\阿单\\Desktop\\play.png');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` varchar(30) character set utf8 NOT NULL,
  `adminname` varchar(30) character set utf8 NOT NULL,
  `adminpassword` varchar(30) character set utf8 NOT NULL,
  PRIMARY KEY  (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('101', 'yjy', '123');
INSERT INTO `admin` VALUES ('102', 'qaa', '123');
INSERT INTO `admin` VALUES ('admin', 'admin', 'admin');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `fileid` int(30) NOT NULL auto_increment,
  `filename` varchar(30) character set utf8 NOT NULL,
  `filesize` varchar(255) character set utf8 NOT NULL,
  `filetype` varchar(30) character set utf8 NOT NULL,
  `filecomment` varchar(255) character set utf8 default NULL,
  `filedate` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1043', '地铁经济对广州市经济发展的影响-邓洁', '2513718', 'pdf', null, '2018-06-05 23:26:19');
INSERT INTO `file` VALUES ('1044', 'upload', '303', 'php', null, '2018-06-06 00:06:38');
INSERT INTO `file` VALUES ('1045', 'delete', '645', 'png', null, '2018-06-06 01:15:11');
INSERT INTO `file` VALUES ('1046', 'play', '8725', 'png', null, '2018-06-06 01:22:09');
INSERT INTO `file` VALUES ('1047', 'UserFrame', '238080', 'doc', null, '2018-06-06 01:23:51');
INSERT INTO `file` VALUES ('1048', 'Music总结', '198', 'txt', null, '2018-06-06 01:27:00');
INSERT INTO `file` VALUES ('1049', 'FtpClientUtil', '6160', 'java', null, '2018-06-06 11:41:38');
INSERT INTO `file` VALUES ('1084', '123', '0', 'Directory', null, '2018-06-09 15:32:40');
INSERT INTO `file` VALUES ('1086', 'url-icon', '743', 'png', null, '2018-06-11 08:13:43');
INSERT INTO `file` VALUES ('1087', '新建文本文档 (4)', '0', 'txt', null, '2018-06-11 08:40:18');
INSERT INTO `file` VALUES ('1089', 'icon', '5211', 'jpg', null, '2018-06-20 11:07:11');
INSERT INTO `file` VALUES ('1090', 'java', '111', 'txt', null, '2018-06-20 11:07:26');
INSERT INTO `file` VALUES ('1091', '新建 XLS 工作表', '6656', 'xls', null, '2018-06-20 11:15:54');
INSERT INTO `file` VALUES ('1092', 'b', '73976', 'jpg', null, '2018-12-10 13:40:25');
INSERT INTO `file` VALUES ('1093', 'package', '3000', 'json', null, '2018-12-10 16:43:10');
INSERT INTO `file` VALUES ('1094', 'package', '1981', 'json', null, '2018-12-15 15:15:19');
INSERT INTO `file` VALUES ('1095', 'index', '273', 'html', null, '2018-12-15 15:16:03');
INSERT INTO `file` VALUES ('1096', 'db', '157', 'json', null, '2018-12-15 15:35:13');
INSERT INTO `file` VALUES ('1097', 'test', '0', 'Directory', null, '2018-12-15 15:44:05');
INSERT INTO `file` VALUES ('1098', 'test2', '0', 'Directory', null, '2018-12-15 15:46:43');
INSERT INTO `file` VALUES ('1099', 'icon', '482884', 'png', null, '2018-12-22 13:25:00');
INSERT INTO `file` VALUES ('1100', 'electron', '189', 'txt', null, '2018-12-24 11:00:35');
INSERT INTO `file` VALUES ('1101', '具体抢课安排', '12329', 'xlsx', null, '2018-12-24 11:00:44');
INSERT INTO `file` VALUES ('1102', '261814376734529783', '94634', 'jpg', null, '2018-12-24 11:01:52');
INSERT INTO `file` VALUES ('1103', '网站设计2018-9-18', '9224218', 'pptx', null, '2018-12-24 11:02:23');
INSERT INTO `file` VALUES ('1104', 'aa', '0', 'txt', null, '2018-12-24 11:04:08');

-- ----------------------------
-- Table structure for imgurl
-- ----------------------------
DROP TABLE IF EXISTS `imgurl`;
CREATE TABLE `imgurl` (
  `imgname` varchar(11) NOT NULL,
  `noticefirst` varchar(255) default NULL,
  `noticesecond` varchar(255) default NULL,
  `noticethird` varchar(255) default NULL,
  PRIMARY KEY  (`imgname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imgurl
-- ----------------------------
INSERT INTO `imgurl` VALUES ('11.png', '欢迎使用SkyDisk云盘服务', '此版本为内测版', '升级会员享双重好礼');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeid` int(11) NOT NULL auto_increment,
  `noticefirst` varchar(255) NOT NULL,
  `noticesecond` varchar(255) NOT NULL,
  `noticethird` varchar(255) default NULL,
  PRIMARY KEY  (`noticeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', 'qwe', 'qwe', 'qwe');
INSERT INTO `notice` VALUES ('2', 'zxc', 'zxc', 'zxc');
INSERT INTO `notice` VALUES ('3', '欢迎使用SkyDisk云盘服务', '此版本为内测版', '升级会员享双重好礼');

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `userid` varchar(30) NOT NULL,
  `fileid` int(30) NOT NULL,
  PRIMARY KEY  (`fileid`,`userid`),
  KEY `userid` (`userid`),
  KEY `fileid` USING BTREE (`fileid`),
  CONSTRAINT `fileid` FOREIGN KEY (`fileid`) REFERENCES `file` (`fileid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('16200001', '1043');
INSERT INTO `result` VALUES ('162011108', '1043');
INSERT INTO `result` VALUES ('123456', '1044');
INSERT INTO `result` VALUES ('162011108', '1044');
INSERT INTO `result` VALUES ('123456', '1045');
INSERT INTO `result` VALUES ('16200001', '1045');
INSERT INTO `result` VALUES ('16200001', '1046');
INSERT INTO `result` VALUES ('16200001', '1047');
INSERT INTO `result` VALUES ('162011108', '1047');
INSERT INTO `result` VALUES ('162011108', '1048');
INSERT INTO `result` VALUES ('162011108', '1084');
INSERT INTO `result` VALUES ('162011108', '1086');
INSERT INTO `result` VALUES ('162011108', '1090');
INSERT INTO `result` VALUES ('162011110', '1091');
INSERT INTO `result` VALUES ('162011108', '1092');
INSERT INTO `result` VALUES ('162011108', '1093');
INSERT INTO `result` VALUES ('162011108', '1094');
INSERT INTO `result` VALUES ('162011108', '1095');
INSERT INTO `result` VALUES ('162011108', '1096');
INSERT INTO `result` VALUES ('162011108', '1097');
INSERT INTO `result` VALUES ('162011108', '1098');
INSERT INTO `result` VALUES ('162011108', '1099');
INSERT INTO `result` VALUES ('162011108', '1100');
INSERT INTO `result` VALUES ('162011108', '1101');
INSERT INTO `result` VALUES ('162011108', '1102');
INSERT INTO `result` VALUES ('162011108', '1103');
INSERT INTO `result` VALUES ('162011108', '1104');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `fileid` int(30) NOT NULL auto_increment,
  `filename` varchar(30) character set utf8 NOT NULL,
  `filesize` varchar(255) character set utf8 NOT NULL,
  `filetype` varchar(30) character set utf8 NOT NULL,
  `filecomment` varchar(255) character set utf8 default NULL,
  `filedate` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of share
-- ----------------------------
INSERT INTO `share` VALUES ('1028', '1', '134848', 'docx', null, '2018-06-08 15:28:02');
INSERT INTO `share` VALUES ('1029', 'download', '678', 'png', null, '2018-06-08 15:28:15');
INSERT INTO `share` VALUES ('1030', 'FtpClientUtil', '6160', 'java', null, '2018-06-08 15:28:37');
INSERT INTO `share` VALUES ('1031', 'login', '642', 'php', null, '2018-06-08 15:28:48');
INSERT INTO `share` VALUES ('1032', 'advert', '75067', 'jpg', null, '2018-06-11 08:41:19');
INSERT INTO `share` VALUES ('1033', 'icon', '5211', 'jpg', null, '2018-06-20 11:08:25');
INSERT INTO `share` VALUES ('1034', '课表', '26112', 'doc', null, '2018-06-20 11:11:49');
INSERT INTO `share` VALUES ('1035', 'js', '2937', 'txt', null, '2018-12-22 14:34:33');

-- ----------------------------
-- Table structure for share_result
-- ----------------------------
DROP TABLE IF EXISTS `share_result`;
CREATE TABLE `share_result` (
  `userid` varchar(30) NOT NULL,
  `fileid` int(30) NOT NULL,
  PRIMARY KEY  (`fileid`,`userid`),
  KEY `userid` (`userid`),
  CONSTRAINT `share_fileid` FOREIGN KEY (`fileid`) REFERENCES `share` (`fileid`),
  CONSTRAINT `share_result_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`userid`) REFER `skydisk/user`(`useri';

-- ----------------------------
-- Records of share_result
-- ----------------------------
INSERT INTO `share_result` VALUES ('16200001', '1030');
INSERT INTO `share_result` VALUES ('16200001', '1031');
INSERT INTO `share_result` VALUES ('162011108', '1028');
INSERT INTO `share_result` VALUES ('162011108', '1029');
INSERT INTO `share_result` VALUES ('162011108', '1032');
INSERT INTO `share_result` VALUES ('162011108', '1033');
INSERT INTO `share_result` VALUES ('162011108', '1035');
INSERT INTO `share_result` VALUES ('162011110', '1034');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(30) character set utf8 NOT NULL,
  `username` varchar(30) character set utf8 NOT NULL,
  `userpassword` varchar(30) character set utf8 NOT NULL,
  `memory` varchar(30) character set utf8 NOT NULL default '1079000400',
  `phone` varchar(30) character set utf8 default NULL,
  `email` varchar(255) character set utf8 default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', 'public', '123456', '1079000400', '15975631646', 'public@qq.com');
INSERT INTO `user` VALUES ('16200001', 'xiaoming', '456', '1079000400', '15975631648', '123123@qq.com');
INSERT INTO `user` VALUES ('162011108', 'ardanss', '123123', '209715200', '', '');
INSERT INTO `user` VALUES ('162011110', 'Ardans', '123123', '1079000400', '15975631649', 'ardans@163.com');
INSERT INTO `user` VALUES ('162011189', '端哥', '123123', '1079000400', '15975631648', '719481334@qq.com');
INSERT INTO `user` VALUES ('162011190', 'dv666', '123123', '1079000400', '15975631548', 'dv666@qq.com');
