/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : toutiao

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-09-20 11:46:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `uid` int(10) NOT NULL,
  `lid` int(10) NOT NULL DEFAULT '0' COMMENT '赞同数目',
  `is_collect` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0表示已经收藏，1表示未收藏',
  `collect_time` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_collect
-- ----------------------------

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `link_id` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  `context` text,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_exclusive
-- ----------------------------
DROP TABLE IF EXISTS `t_exclusive`;
CREATE TABLE `t_exclusive` (
  `eid` int(10) NOT NULL,
  `excl_name` varchar(100) NOT NULL,
  `creater_name` varchar(50) NOT NULL,
  `share` int(10) NOT NULL DEFAULT '0',
  `subscriber` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='独家';

-- ----------------------------
-- Records of t_exclusive
-- ----------------------------

-- ----------------------------
-- Table structure for t_link
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `lid` int(10) NOT NULL AUTO_INCREMENT,
  `excl_name` varchar(100) NOT NULL COMMENT '独家号',
  `title` varchar(100) NOT NULL,
  `url` varchar(100) NOT NULL,
  `create_time` int(10) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享';

-- ----------------------------
-- Records of t_link
-- ----------------------------

-- ----------------------------
-- Table structure for t_subscribe
-- ----------------------------
DROP TABLE IF EXISTS `t_subscribe`;
CREATE TABLE `t_subscribe` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `excl_name` varchar(100) NOT NULL COMMENT '独家号名称',
  `subscriber` varchar(100) NOT NULL COMMENT '订阅者',
  `is_sub` int(2) NOT NULL DEFAULT '0' COMMENT '0表示未订阅，1表示订阅',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订阅';

-- ----------------------------
-- Records of t_subscribe
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) NOT NULL,
  `pass_word` varchar(32) NOT NULL DEFAULT '',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) NOT NULL,
  `create_time` int(10) NOT NULL COMMENT '创建时间',
  `update_time` int(10) NOT NULL COMMENT '最后一次登录时间',
  `role_id` tinyint(2) DEFAULT '5' COMMENT '5:普通用户 2:管理员 1:系统管理员',
  `share` int(10) NOT NULL DEFAULT '0' COMMENT '分享数目',
  `
attention` int(10) NOT NULL DEFAULT '0' COMMENT '关注数目',
  `fans` int(10) NOT NULL DEFAULT '0' COMMENT '粉丝数目',
  `IO` double(7,1) NOT NULL DEFAULT '0.0' COMMENT 'IO币',
  `excl_name` varchar(100) NOT NULL COMMENT '独家号名称',
  `sub` int(10) NOT NULL DEFAULT '0' COMMENT '订阅者数目',
  `collect` int(10) NOT NULL DEFAULT '0',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0:待激活 1:正常 2：删除',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '111', '111', null, '111', '0', '0', '5', '0', '0', '0', '0.0', '', '0', '0', '1');
INSERT INTO `t_user` VALUES ('2', '222', '222', null, '', '0', '0', '5', '0', '0', '0', '0.0', '', '0', '0', '1');

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `uid` int(10) NOT NULL,
  `nick_name` varchar(50) NOT NULL,
  `city` varchar(100) DEFAULT NULL,
  `instructions` text,
  `care_field` text COMMENT '关注领域',
  `blog` varchar(50) DEFAULT NULL,
  `github` varchar(20) DEFAULT NULL,
  `weixin` varchar(50) DEFAULT NULL,
  `jobs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_userlog
-- ----------------------------
DROP TABLE IF EXISTS `t_userlog`;
CREATE TABLE `t_userlog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `action` varchar(100) NOT NULL,
  `content` text,
  `ip_addr` varchar(50) DEFAULT NULL,
  `create_time` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userlog
-- ----------------------------
