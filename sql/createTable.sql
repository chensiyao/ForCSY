-- 先整理数据库
drop database if exists  `csy`;
create database `csy`;
use `csy`;

-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: csy
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `b_user_account`
--

DROP TABLE IF EXISTS `b_user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长主键从1000开始',
  `account` varchar(16) NOT NULL COMMENT '帐号名称',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(16) DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `emailStatue` tinyint(4) DEFAULT '2' COMMENT '邮箱是否激活1:正常、2:未激活',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `phoneStatue` tinyint(4) DEFAULT '2' COMMENT '手机是否激活1:正常、2:未激活',
  `safeKey` varchar(128) NOT NULL COMMENT '安全密钥',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态1:正常、2:封号',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COMMENT='用户帐号管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_user_filestore`
--

DROP TABLE IF EXISTS `b_user_filestore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user_filestore` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `foreign_account` varchar(16) NOT NULL COMMENT '外键帐号',
  `fileType` varchar(64) NOT NULL COMMENT '文件类型',
  `tags` varchar(128) DEFAULT NULL COMMENT '标签',
  `fileName` varchar(512) NOT NULL COMMENT '文件名称',
  `fileSize` bigint(16) NOT NULL COMMENT '文件大小',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(128) DEFAULT NULL COMMENT '文件描述信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 COMMENT='文件存储信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_user_info`
--

DROP TABLE IF EXISTS `b_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_user_info` (
  `foreign_account` varchar(16) NOT NULL COMMENT '外键帐号',
  `gender` tinyint(4) DEFAULT '1' COMMENT '性别(1:男、0:女)  默认为男性',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `signature` varchar(32) DEFAULT NULL COMMENT '个性签名',
  `favicon` varchar(512) DEFAULT NULL COMMENT '头像地址',
  `blood` int(2) DEFAULT NULL COMMENT '血型',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `tag` varchar(128) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`foreign_account`),
  UNIQUE KEY `foreign_account_UNIQUE` (`foreign_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_xtpz_dmlx`
--

DROP TABLE IF EXISTS `b_xtpz_dmlx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_xtpz_dmlx` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dmlxbh` int(10) NOT NULL COMMENT '代码类型编号',
  `ywm` varchar(32) NOT NULL COMMENT '代码类型英文名',
  `zwm` varchar(32) NOT NULL COMMENT '代码类型中文名',
  `p_ywm` varchar(32) DEFAULT NULL COMMENT '父代码类型英文名',
  `dmlxms` varchar(128) DEFAULT NULL COMMENT '代码类型描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dmlxywm_UNIQUE` (`ywm`),
  UNIQUE KEY `dmlxzwm_UNIQUE` (`zwm`),
  UNIQUE KEY `dmlxbh_UNIQUE` (`dmlxbh`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='代码类型管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `b_xtpz_dmx`
--

DROP TABLE IF EXISTS `b_xtpz_dmx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_xtpz_dmx` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dmlxbh` int(10) NOT NULL COMMENT '外键 代码类型英文名',
  `dmxywm` varchar(32) NOT NULL COMMENT '代码项英文名',
  `dmxzwm` varchar(32) NOT NULL COMMENT '代码项中文名',
  `dmxz` varchar(128) NOT NULL COMMENT '值',
  `p_dmxywm` varchar(32) DEFAULT NULL COMMENT '父代码项英文名',
  `sfxs` int(2) DEFAULT '1' COMMENT '是否显示(1:显示,其他:不显示)',
  `sfky` int(2) DEFAULT '1' COMMENT '是否可用(1:可用,其他:不可用)',
  `sfmr` int(2) DEFAULT '0' COMMENT '是否默认(1:是,其他:否)',
  `xssx` int(4) DEFAULT NULL COMMENT '显示顺序',
  `dmxms` varchar(128) DEFAULT NULL COMMENT '代码项描述',
  `dmxkz` varchar(128) DEFAULT NULL COMMENT '代码项拓展(每个代码项可能有各自的拓展功能)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码项管理';
/*!40101 SET character_set_client = @saved_cs_client */;

-- ----------------------------
-- Table structure for `b_xtpz`
-- ----------------------------
DROP TABLE IF EXISTS `b_qj_xtpz`;
CREATE TABLE `b_qj_xtpz` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '变量名',
  `name_cn` varchar(32) DEFAULT NULL COMMENT '变量中文名',
  `val` varchar(128) DEFAULT NULL COMMENT '变量对应的配置值',
  `expand` varchar(128) DEFAULT NULL COMMENT '代码项扩展',
  `description` varchar(256) DEFAULT NULL COMMENT '代码项描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `b_wx_user`
--

DROP TABLE IF EXISTS `b_wx_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_wx_user` (
  `openid` varchar(64) NOT NULL COMMENT 'openid',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别(0:未知,1:男性,2:女性)',
  `province` varchar(32) DEFAULT NULL COMMENT '省份',
  `city` varchar(32) DEFAULT NULL,
  `country` varchar(32) DEFAULT NULL,
  `headimgurl` varchar(256) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效',
  `privilege` varchar(128) DEFAULT NULL COMMENT '用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  `unionid` varchar(64) DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用户存储表';
/*!40101 SET character_set_client = @saved_cs_client */;


-- ----------------------------
-- Table structure for `b_accident_driver`
-- ----------------------------
DROP TABLE IF EXISTS `b_accident_driver`;
CREATE TABLE `b_accident_driver` (
  `id` varchar(64) NOT NULL COMMENT '事件id 关联事件表',
  `fk_driver_id` varchar(64) DEFAULT NULL COMMENT '驾驶员id 关联驾驶员表',
  `duty` varchar(32) DEFAULT NULL COMMENT '责任类型(1代表全员)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件关联表';


-- ----------------------------
-- Table structure for `b_driver_info`
-- ----------------------------
DROP TABLE IF EXISTS `b_driver_info`;
CREATE TABLE `b_driver_info` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `name` varchar(32) DEFAULT NULL COMMENT '驾驶员姓名',
  `IDCard` varchar(18) DEFAULT NULL COMMENT '驾驶证证号(身份证号)',
  `vehicleLicense` varchar(32) DEFAULT NULL COMMENT '车辆行驶证号',
  `hphm` varchar(32) DEFAULT NULL COMMENT '号牌号码',
  `IDCardImage` varchar(256) DEFAULT NULL COMMENT '驾驶证图片，多个图片用逗号隔开',
  `vehicleLicenseImage` varchar(256) DEFAULT NULL COMMENT '车辆行驶证图片，多张图片以逗号隔开',
  `contact` varchar(32) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件联系人信息';


-- ----------------------------
-- Table structure for `b_accident_info`
-- ----------------------------
DROP TABLE IF EXISTS `b_accident_info`;
CREATE TABLE `b_accident_info` (
  `id` varchar(64) NOT NULL COMMENT '事故id',
  `fk_wx_openid` varchar(64) NOT NULL COMMENT '上传者微信openID',
  `occurrence_time` datetime DEFAULT NULL COMMENT '事故发生的时间',
  `longitude` varchar(128) DEFAULT NULL COMMENT '事故发生的地点的经度',
  `latitude` varchar(128) DEFAULT NULL COMMENT '事故发生地点的纬度',
  `duty` varchar(32) DEFAULT NULL COMMENT '事故责任',
  `live_image` varchar(1024) DEFAULT NULL COMMENT '现场拍照的事故图片，多个以逗号隔开，目前最多支持10张',
  `live_voice` varchar(1024) DEFAULT NULL COMMENT '现场拍照的事故录音，多个以逗号隔开，目前最多支持3个录音',
  `upload_time` datetime DEFAULT NULL COMMENT '事故上传时间',
  `description` varchar(256) DEFAULT NULL COMMENT '事故描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事故信息表';


-- ----------------------------
-- Table structure for `b_wx_fkyj`
-- ----------------------------
DROP TABLE IF EXISTS `b_wx_fkyj`;
CREATE TABLE `csy`.`b_wx_fkyj` (
  `id` VARCHAR(64) NOT NULL COMMENT '主键Key',
  `openid` VARCHAR(64) NOT NULL COMMENT '微信用户ID',
  `type` INT(10) NULL COMMENT '反馈类型',
  `image` VARCHAR(1024) NULL COMMENT '错误图例 (多张图片以分隔符,隔开)',
  `description` VARCHAR(128) NULL COMMENT '描述信息',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '反馈意见表';


/*
 * 2017-05-03
 * Add column for 'b_accident_info';
*/
ALTER TABLE csy.b_accident_info ADD imgReUpload_index varchar(64) default NULL COMMENT '图片重传序号,多个以逗号分割(,)';
/*
 * 2017-05-09
 * Add column for 'b_accident_info';
 */
ALTER TABLE csy.b_accident_info modify imgReUpload_index varchar(1024) default NULL COMMENT '重传图片，多个以逗号分割';
ALTER TABLE csy.b_accident_info ADD imgReUploaded_index varchar(1024) default NULL COMMENT '已重传图片，多个以逗号分割';

/**
 * 2017-07-19
 * 违法举报表单
 */
CREATE TABLE `csy`.`b_illegal_tipoff` (
  `id` VARCHAR(64) NOT NULL COMMENT '主键',
  `fk_wx_openid` VARCHAR(64) NOT NULL COMMENT '微信openID',
  `plate_number` VARCHAR(16) NULL COMMENT '违法车牌号',
  `longitude` VARCHAR(128) NULL DEFAULT NULL COMMENT '事故发生的地点的经度',
  `latitude` VARCHAR(128) NULL DEFAULT NULL COMMENT '事故发生的地点的纬度',
  `illegal_position` VARCHAR(128) NULL COMMENT '违法地点描述',
  `illegal_act` VARCHAR(128) NULL DEFAULT NULL COMMENT '违法行为',
  `illegal_images` VARCHAR(1024) NULL DEFAULT NULL COMMENT '违法抓拍图片',
  `occurrence_time` DATETIME NULL COMMENT '违法时间',
  `status` VARCHAR(16) NULL DEFAULT 0 COMMENT '记录状态(0:初始状态)',
  `name` VARCHAR(16) NULL COMMENT '举报人',
  `idcard` VARCHAR(32) NULL COMMENT '身份证号',
  `phone` VARCHAR(16) NULL COMMENT '联系电话',
  PRIMARY KEY (`id`))
COMMENT = '违法举报(随手抓拍)';
----新增菜单表2017-07-25
DROP TABLE IF EXISTS `b_qj_menu`;
CREATE TABLE `b_qj_menu` (
  `XH` varchar(32) NOT NULL COMMENT '序号',
  `FJD` varchar(32) NOT NULL COMMENT '父节点',
  `JDYWM` varchar(32) NOT NULL COMMENT '节点英文名',
  `JDZWM` varchar(256) NOT NULL COMMENT '节点中文名',
  `JDZWMQC` varchar(256) DEFAULT NULL COMMENT '节点中文名全称',
  `JDJB` int(2) NOT NULL COMMENT '节点类型 0:系统 1:子系统 2:一级菜单 3:二级菜单',
  `SFXS` int(2) DEFAULT NULL COMMENT '是否显示 0:菜单不显示 1:菜单显示',
  `SFXTSY` int(2) DEFAULT NULL COMMENT '是否系统首页0:否 1:是',
  `SFMKSY` int(2) DEFAULT NULL COMMENT '是否模块首页0:否 1:是',
  `XSSX` int(2) DEFAULT NULL COMMENT '显示顺序',
  `YLZD1` varchar(128) DEFAULT NULL,
  `YLZD2` varchar(128) DEFAULT NULL,
  `YLZD3` varchar(128) DEFAULT NULL,
  `SFTC` int(2) DEFAULT NULL COMMENT '是否弹出 1：弹出 0或其他：不弹出',
  `LJYMMC` varchar(32) DEFAULT NULL COMMENT '节点参数',
  PRIMARY KEY (`XH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

----操作日志表2017-08-28
CREATE TABLE `csy`.`b_qj_log` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `f_account` VARCHAR(16) NULL COMMENT '操作账户',
  `ip` VARCHAR(16) NULL COMMENT 'ip地址',
  `model` VARCHAR(8) NULL COMMENT '模块',
  `oper_type` VARCHAR(8) NULL COMMENT '操作类型',
  `oper_rst` VARCHAR(8) NULL COMMENT '操作结果(自行定义)',
  `description` VARCHAR(128) NULL COMMENT '操作描述',
  `createtime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`))
COMMENT = '全局日志操作表';

----设备故障上报表2017-9-1
DROP TABLE IF EXISTS `b_failure_report`;
CREATE TABLE `b_failure_report` (
  `id` varchar(64) NOT NULL COMMENT '故障id',
  `fk_wx_openid` varchar(64) NOT NULL DEFAULT '微信openid',
  `phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `upload_position` varchar(128) DEFAULT NULL COMMENT '上传地点',
  `longitude` varchar(128) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(128) DEFAULT NULL COMMENT '纬度',
  `fault_description` varchar(128) DEFAULT NULL COMMENT '故障描述',
  `fault_images` varchar(1024) DEFAULT NULL COMMENT '故障图片',
  `audit_status` varchar(16) DEFAULT NULL COMMENT '审核状态',
  `process_status` varchar(16) DEFAULT NULL COMMENT '处理状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
----事故表增加字段（代表事故的有效性）
Alter table b_accident_info add COLUMN isvalid VARCHAR(1);