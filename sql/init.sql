/*-----------------------修改数据的安全模式--------------------------*/

SET SQL_SAFE_UPDATES = 0;


/*-----------------------代码类型初始化------------------------------*/

/**
 * date: 2016-09-21
 * author: wangqiang
 * description: 新增血型代码类型
*/
delete from b_xtpz_dmlx where dmlxbh = 10001;
INSERT INTO `b_xtpz_dmlx` (`id`,`dmlxbh`,`ywm`,`zwm`,`p_ywm`,`dmlxms`) VALUES (NULL,10001,'bloodType','血型',NULL,'血型');
delete from b_xtpz_dmlx where dmlxbh = 8;
INSERT INTO `b_xtpz_dmlx` (`id`,`dmlxbh`,`ywm`,`zwm`,`p_ywm`,`dmlxms`) VALUES (NULL,8,'cysf','常用省份',NULL,'常用省份');

/**
 * date: 2017-03-08
 * author: wangqiang
 * description: 新增微信公众号反馈类型
*/
delete from b_xtpz_dmlx where dmlxbh = 20001;
INSERT INTO `b_xtpz_dmlx` (`id`,`dmlxbh`,`ywm`,`zwm`,`p_ywm`,`dmlxms`) VALUES (NULL,20001,'feedbackType','反馈类型',NULL,'微信公众号反馈类型');




/*-----------------------代码项初始化--------------------------------*/

/**
 * date: 2016-09-21
 * author: wangqiang
 * description: 新增血型代码项
*/
delete from b_xtpz_dmx where dmlxbh = 10001;
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','未知','未知','-1',NULL,1,1,1,1,'未知',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','A','A型','1',NULL,1,1,0,2,'A型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','B','B型','2',NULL,1,1,0,3,'B型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','O','O型','3',NULL,1,1,0,4,'O型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','AB','AB型','4',NULL,1,1,0,5,'AB型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','其他','其他','5',NULL,1,1,0,6,'其他',NULL);

/**
 * date: 2017-02-17
 * author: wangyonghui
 * description: 新增省份简称代码项
*/
delete from b_xtpz_dmx where dmlxbh = 8;
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','闽','闽','29',NULL,1,1,0,29,'闽',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','粤','粤','30',NULL,1,1,0,30,'粤',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','琼','琼','31',NULL,1,1,0,31,'琼',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','台','台','32',NULL,1,1,0,32,'台',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','空','空','34',NULL,1,1,0,34,'空',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','海','海','35',NULL,1,1,0,35,'海',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','广','广','38',NULL,1,1,0,38,'广',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','成','成','39',NULL,1,1,0,39,'成',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','兰','兰','41',NULL,1,1,0,41,'兰',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','京','京','0',NULL,1,1,0,0,'京',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','津','津','1',NULL,1,1,0,1,'津',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','沪','沪','2',NULL,1,1,1,2,'沪',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','渝','渝','4',NULL,1,1,0,4,'渝',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','辽','辽','5',NULL,1,1,0,5,'辽',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','吉','吉','6',NULL,1,1,0,6,'吉',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','黑','黑','7',NULL,1,1,0,7,'黑',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','甘','甘','9',NULL,1,1,0,9,'甘',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','新','新','8',NULL,1,1,0,8,'新',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','青','青','10',NULL,1,1,0,10,'青',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','宁','宁','11',NULL,1,1,0,11,'宁',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','蒙','蒙','12',NULL,1,1,0,12,'蒙',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','陕','陕','13',NULL,1,1,0,13,'陕',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','晋','晋','14',NULL,1,1,0,14,'晋',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','冀','冀','15',NULL,1,1,0,15,'冀',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','鲁','鲁','16',NULL,1,1,0,16,'鲁',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','豫','豫','17',NULL,1,1,0,17,'豫',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','苏','苏','18',NULL,1,1,1,18,'苏',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','浙','浙','19',NULL,1,1,0,19,'浙',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','皖','皖','20',NULL,1,1,0,20,'皖',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','湘','湘','21',NULL,1,1,0,21,'湘',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','赣','赣','22',NULL,1,1,0,22,'赣',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','鄂','鄂','23',NULL,1,1,0,23,'鄂',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','川','川','24',NULL,1,1,0,24,'川',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','藏','藏','25',NULL,1,1,0,25,'藏',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','云','云','26',NULL,1,1,0,26,'云',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','贵','贵','27',NULL,1,1,0,27,'贵',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'8','桂','桂','28',NULL,1,1,0,28,'桂',NULL);



/*-----------------------系统配置表初始化--------------------------------*/

delete from b_qj_xtpz where name = 'cysf';
INSERT INTO `b_qj_xtpz` (`id`,`name`,`name_cn`,`val`,`expand`,`description`) VALUES (null,'cysf','常用省份','鲁',null,'用于配置常用省份=---其中id的值是关联dmx中简称省份的id值');
delete from b_qj_xtpz where name = 'wxResource';
INSERT INTO `b_qj_xtpz` (`id`,`name`,`name_cn`,`val`,`expand`,`description`) VALUES (null,'wxResource','微信存储资源路径','http://127.0.0.1:8090/wxfile',null,'微信存储资源路径');

/*新增一个角色用户*/
delete from b_user_account where account = 'hualai';
INSERT INTO `b_user_account` VALUES ('1006', 'hualai', 'ee156d29b3861d2a431ef8050f08b783', null, 'm15551351535@163.com', '2', null, '2', 'o8g4mhqblyxzspyqzqn4c63ua8t1iaet', '1', '2017-02-27 14:50:31');
delete from b_user_info where foreign_account = 'hualai';
INSERT INTO `b_user_info` VALUES ('hualai', '1', null, null, null, null, null, null);

/* 
 * date: 2017-03-30
 * desctiption 意见反馈类型
 */
delete from b_xtpz_dmx where dmlxbh = 20001;
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'20001','系统异常','系统异常','1',NULL,1,1,0,1,'系统异常',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'20001','优化建议','优化建议','2',NULL,1,1,0,2,'优化建议',NULL);
/**
 * 2017-07-25
 * 菜单初始化脚本
 */
INSERT INTO `b_qj_menu` VALUES ('1', 'KCKPGLPT', 'KCKP', '快处快赔', '快处快赔', '2', '1', '0', '0', '0', null, null, null, '0', null);
INSERT INTO `b_qj_menu` VALUES ('2', 'KCKP', 'KCKPGL', '快处快赔管理 ', '快处快赔管理', '3', '1', null, null, '0', null, null, null, '0', 'lose.do');
INSERT INTO `b_qj_menu` VALUES ('3', 'ITS', 'KCKPGLPT', '快处快赔管理平台', '快处快赔管理平台', '1', '1', '0', '0', '0', '', '', '', null, '');
INSERT INTO `b_qj_menu` VALUES ('4', 'KCKP', 'FKYJ', '反馈意见管理', '反馈意见管理', '3', '1', null, null, '1', null, null, null, '0', 'fkyj.do');
INSERT INTO `b_qj_menu` VALUES ('5', 'KCKPGLPT', 'WFJB', '违法举报', '违法举报', '2', '1', '0', '0', '0', null, null, null, '0', null);
INSERT INTO `b_qj_menu` VALUES ('6', 'WFJB', 'WFJBGL', '违法举报管理', '违法举报管理', '3', '1', null, null, '0', null, null, null, '0', 'WFJBGL');