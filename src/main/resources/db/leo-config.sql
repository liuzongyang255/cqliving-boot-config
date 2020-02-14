/*
 Navicat Premium Data Transfer

 Source Server         : local-root
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : 127.0.0.1:3306
 Source Schema         : leo-config

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 14/02/2020 21:28:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for env
-- ----------------------------
DROP TABLE IF EXISTS `env`;
CREATE TABLE `env`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `env_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '环境名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '所有配置',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '环境配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of env
-- ----------------------------
INSERT INTO `env` VALUES (1, 'dev', '# dev\r\nspring.mvc.view.prefix=/WEB-INF/jsp/\r\nspring.mvc.view.suffix=.jsp\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\nserver.port=8970\r\nserver.servlet.jsp.init-parameters.development=true\r\nspring.mvc.favicon.enable=false\r\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\r\nlogging.pattern.file=${logging.pattern.console}\r\nlogging.file=/var/www/logs/leo-boot-config/all.log\r\nlogging.level.web=TRACE\r\nlogging.level.com.leo.boot.config=DEBUG\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\n', 2);
INSERT INTO `env` VALUES (2, 'test', '# test\r\nspring.mvc.view.prefix=/WEB-INF/jsp/\r\nspring.mvc.view.suffix=.jsp\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\nserver.port=8970\r\nserver.servlet.jsp.init-parameters.development=true\r\nspring.mvc.favicon.enable=false\r\n# 日志\r\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\r\nlogging.pattern.file=${logging.pattern.console}\r\nlogging.file=/var/www/logs/leo-boot-config/all.log\r\nlogging.level.web=TRACE\r\nlogging.level.com.leo.boot.config=DEBUG\r\n', 2);
INSERT INTO `env` VALUES (3, 'dev', 'mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\r\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\r\nmybatis.configuration.auto-mapping-behavior=FULL\r\n# 开启自动下划线转驼峰命名规则\r\nmybatis.configuration.map-underscore-to-camel-case=true\r\nspring.mvc.view.prefix=/WEB-INF/jsp/\r\nspring.mvc.view.suffix=.jsp\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-spider\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\nlogging.level.com.leo.boot.spider.dal=DEBUG\r\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\r\nlogging.level.web=TRACE\r\nserver.port=8989\r\nimgDir=/developer/service/ZFL/images/\r\nvideoDir=/developer/service/SHT/\r\nvideo.save.path=/developer/service/SHT/video/\r\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\r\nserver.servlet.jsp.init-parameters.development=true\r\nspring.mvc.favicon.enable=false\r\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\r\nlogging.pattern.file=${logging.pattern.console}\r\nlogging.file=/var/www/logs/leo-boot-spider/all.log\r\nprop.url=localhost:8970\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\n', 1);
INSERT INTO `env` VALUES (4, NULL, '1=1\r\n', NULL);
INSERT INTO `env` VALUES (5, 'prod', 'mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\r\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\r\nmybatis.configuration.auto-mapping-behavior=FULL\r\n# 开启自动下划线转驼峰命名规则\r\nmybatis.configuration.map-underscore-to-camel-case=true\r\nspring.mvc.view.prefix=/WEB-INF/jsp/\r\nspring.mvc.view.suffix=.jsp\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\nlogging.level.com.leo.boot.spider.dal=DEBUG\r\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\r\nlogging.level.web=TRACE\r\nserver.port=8989\r\nimgDir=/developer/service/ZFL/images/\r\nvideoDir=/developer/service/SHT/\r\nvideo.save.path=/developer/service/SHT/video/\r\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\r\nserver.servlet.jsp.init-parameters.development=true\r\nspring.mvc.favicon.enable=false\r\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\r\nlogging.pattern.file=${logging.pattern.console}\r\nlogging.file=/var/www/logs/leo-boot-spider/all.log\r\nprop.url=localhost:8970\r\nprop.url=localhost:8970\r\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\n', 2);
INSERT INTO `env` VALUES (7, NULL, NULL, NULL);
INSERT INTO `env` VALUES (8, NULL, NULL, NULL);
INSERT INTO `env` VALUES (9, NULL, NULL, NULL);
INSERT INTO `env` VALUES (10, NULL, NULL, NULL);
INSERT INTO `env` VALUES (11, NULL, NULL, NULL);
INSERT INTO `env` VALUES (12, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for env_common
-- ----------------------------
DROP TABLE IF EXISTS `env_common`;
CREATE TABLE `env_common`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `env_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '环境名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '配置文档',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '公共配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of env_common
-- ----------------------------
INSERT INTO `env_common` VALUES (1, '配置中心', 'prop.url=localhost:8970\r\n');
INSERT INTO `env_common` VALUES (2, '测试数据库', 'spring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\r\nspring.datasource.username=leo-config\r\nspring.datasource.password=cxz1991423\r\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\r\n');

-- ----------------------------
-- Table structure for env_common_ref
-- ----------------------------
DROP TABLE IF EXISTS `env_common_ref`;
CREATE TABLE `env_common_ref`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `common_id` bigint(20) NOT NULL COMMENT '公共配置id',
  `env_id` bigint(20) NOT NULL COMMENT '环境id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '环境公共配置多对多关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of env_common_ref
-- ----------------------------
INSERT INTO `env_common_ref` VALUES (3, 1, 2);
INSERT INTO `env_common_ref` VALUES (6, 1, 5);
INSERT INTO `env_common_ref` VALUES (7, 2, 5);
INSERT INTO `env_common_ref` VALUES (8, 1, 3);
INSERT INTO `env_common_ref` VALUES (9, 2, 3);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '项目管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, 'leo-boot-spider', 1, '爬虫');
INSERT INTO `project` VALUES (2, 'test', 1, '测试');
INSERT INTO `project` VALUES (3, '测试', 1, '测试');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_pass` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `user_salt` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '盐值',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮件地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_uds`(`user_name`) USING BTREE COMMENT '用户名唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'fdc29cd3b9febbe5d0c74a2e03a9b280', '92873c88c6914b57b90fdbd9e0495990', 'leo', NULL);
INSERT INTO `user` VALUES (2, 'admin1', 'd2563d35ce84ed22aa8b92963e0d2a81', '906ac737fdb84c77be27270b8bdd2ad0', 'admin1', NULL);

-- ----------------------------
-- Table structure for user_act_log
-- ----------------------------
DROP TABLE IF EXISTS `user_act_log`;
CREATE TABLE `user_act_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户表id',
  `api_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'api名',
  `api_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'api路径',
  `params` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '参数',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_act_log
-- ----------------------------
INSERT INTO `user_act_log` VALUES (1, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:14:01');
INSERT INTO `user_act_log` VALUES (2, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:15:01');
INSERT INTO `user_act_log` VALUES (3, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:16:01');
INSERT INTO `user_act_log` VALUES (4, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:17:01');
INSERT INTO `user_act_log` VALUES (5, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:18:01');
INSERT INTO `user_act_log` VALUES (6, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:19:01');
INSERT INTO `user_act_log` VALUES (7, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:20:01');
INSERT INTO `user_act_log` VALUES (8, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:21:01');
INSERT INTO `user_act_log` VALUES (9, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:22:01');
INSERT INTO `user_act_log` VALUES (10, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:23:01');
INSERT INTO `user_act_log` VALUES (11, 1, '新增用户', '/user/add', '{\"userName\":\"admin1\"}', '2020-02-10 23:24:01');
INSERT INTO `user_act_log` VALUES (12, 2, '新增用户', 'login/add', '[{\"realName\":\"admin1\",\"userName\":\"admin1\",\"userPass\":\"admin1\"}]', '2020-02-10 23:57:46');
INSERT INTO `user_act_log` VALUES (13, 1, '保存项目', 'project/save', '[{\"collect\":false,\"name\":\"leo-boot-spider\",\"remark\":\"爬虫\"}]', '2020-02-11 14:59:38');
INSERT INTO `user_act_log` VALUES (14, 1, '保存项目', 'project/save', '[{\"collect\":false,\"id\":1,\"name\":\"leo-boot-spider1\",\"remark\":\"爬虫\"}]', '2020-02-11 15:06:07');
INSERT INTO `user_act_log` VALUES (15, 1, '保存项目', 'project/save', '[{\"collect\":false,\"id\":1,\"name\":\"leo-boot-spider\",\"remark\":\"爬虫\"}]', '2020-02-11 15:06:19');
INSERT INTO `user_act_log` VALUES (16, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 17:01:57');
INSERT INTO `user_act_log` VALUES (17, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 17:02:09');
INSERT INTO `user_act_log` VALUES (18, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 17:02:28');
INSERT INTO `user_act_log` VALUES (19, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 17:02:38');
INSERT INTO `user_act_log` VALUES (20, 1, '保存项目', 'project/save', '[{\"collect\":false,\"name\":\"test\",\"remark\":\"测试\"}]', '2020-02-11 17:02:51');
INSERT INTO `user_act_log` VALUES (21, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 17:02:54');
INSERT INTO `user_act_log` VALUES (22, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 17:02:57');
INSERT INTO `user_act_log` VALUES (23, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 17:02:59');
INSERT INTO `user_act_log` VALUES (24, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 17:03:01');
INSERT INTO `user_act_log` VALUES (25, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 17:03:02');
INSERT INTO `user_act_log` VALUES (26, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 17:03:04');
INSERT INTO `user_act_log` VALUES (27, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 17:09:12');
INSERT INTO `user_act_log` VALUES (28, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 17:09:13');
INSERT INTO `user_act_log` VALUES (29, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 17:09:14');
INSERT INTO `user_act_log` VALUES (30, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 17:09:14');
INSERT INTO `user_act_log` VALUES (31, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 22:41:35');
INSERT INTO `user_act_log` VALUES (32, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 22:41:37');
INSERT INTO `user_act_log` VALUES (33, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:45:28');
INSERT INTO `user_act_log` VALUES (34, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:45:29');
INSERT INTO `user_act_log` VALUES (35, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:45:31');
INSERT INTO `user_act_log` VALUES (36, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 22:45:32');
INSERT INTO `user_act_log` VALUES (37, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:49:23');
INSERT INTO `user_act_log` VALUES (38, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:49:24');
INSERT INTO `user_act_log` VALUES (39, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 22:49:25');
INSERT INTO `user_act_log` VALUES (40, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 22:49:25');
INSERT INTO `user_act_log` VALUES (41, 1, '收藏项目', 'collect/add', '[1, false]', '2020-02-11 22:49:26');
INSERT INTO `user_act_log` VALUES (42, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:49:26');
INSERT INTO `user_act_log` VALUES (43, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:49:26');
INSERT INTO `user_act_log` VALUES (44, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:49:27');
INSERT INTO `user_act_log` VALUES (45, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:49:27');
INSERT INTO `user_act_log` VALUES (46, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:49:27');
INSERT INTO `user_act_log` VALUES (47, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:49:27');
INSERT INTO `user_act_log` VALUES (48, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:49:27');
INSERT INTO `user_act_log` VALUES (49, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:49:27');
INSERT INTO `user_act_log` VALUES (50, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-11 22:49:28');
INSERT INTO `user_act_log` VALUES (51, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-11 22:49:29');
INSERT INTO `user_act_log` VALUES (52, 1, '收藏项目', 'collect/add', '[1, true]', '2020-02-11 22:49:30');
INSERT INTO `user_act_log` VALUES (53, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"dev\",\"projectId\":1}]', '2020-02-12 16:37:03');
INSERT INTO `user_act_log` VALUES (54, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"spring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\n# logging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\nlogging.level.com.leo.boot.config.dal.mapper.EnvDAO=ERROR\\r\\n\",\"id\":3}]', '2020-02-12 17:28:28');
INSERT INTO `user_act_log` VALUES (55, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）mybatis.configuration.auto-mapping-behavior=FULL# 开启自动下划线转驼峰命名规则mybatis.configuration.map-underscore-to-camel-case=truespring.mvc.view.prefix=/WEB-INF/jsp/spring.mvc.view.suffix=.jspspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=truespring.datasource.username=leo-spiderspring.datasource.password=cxz1991423spring.datasource.driver-class-name=com.mysql.jdbc.Driverlogging.level.com.leo.boot.spider.dal=DEBUGlogging.level.com.leo.boot.spider.dal.sari=ERRORlogging.level.web=TRACEserver.port=8989imgDir=/developer/service/ZFL/images/videoDir=/developer/service/SHT/video.save.path=/developer/service/SHT/video/spring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},server.servlet.jsp.init-parameters.development=truespring.mvc.favicon.enable=falselogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%nlogging.pattern.file=${logging.pattern.console}logging.file=/var/www/logs/leo-boot-spider/all.log\\r\\nmybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-spider\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\n\",\"id\":3}]', '2020-02-12 17:29:09');
INSERT INTO `user_act_log` VALUES (56, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-spider\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\n\",\"id\":3}]', '2020-02-12 17:29:14');
INSERT INTO `user_act_log` VALUES (57, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-spider\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\n\",\"id\":3}]', '2020-02-12 18:14:42');
INSERT INTO `user_act_log` VALUES (58, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# test\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":2}]', '2020-02-12 18:27:50');
INSERT INTO `user_act_log` VALUES (59, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# dev\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config1\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":1}]', '2020-02-12 19:02:34');
INSERT INTO `user_act_log` VALUES (60, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"配置中心\"}]', '2020-02-12 23:26:42');
INSERT INTO `user_act_log` VALUES (61, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# test\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\n# 日志\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":2}]', '2020-02-12 23:32:11');
INSERT INTO `user_act_log` VALUES (62, 1, '保存公共配置', 'common-env/save', '[{\"content\":\"prop.url=localhost:8970\\r\\n\",\"id\":1}]', '2020-02-12 23:52:00');
INSERT INTO `user_act_log` VALUES (63, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"测试数据库\"}]', '2020-02-12 23:52:18');
INSERT INTO `user_act_log` VALUES (64, 1, '保存公共配置', 'common-env/save', '[{\"content\":\"spring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\n\",\"id\":2}]', '2020-02-12 23:52:50');
INSERT INTO `user_act_log` VALUES (65, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"test1\",\"id\":2,\"projectId\":2}]', '2020-02-12 23:56:12');
INSERT INTO `user_act_log` VALUES (66, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"test\",\"id\":2,\"projectId\":2}]', '2020-02-12 23:56:15');
INSERT INTO `user_act_log` VALUES (67, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"测试数据库1\",\"id\":2}]', '2020-02-12 23:56:50');
INSERT INTO `user_act_log` VALUES (68, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"测试数据库\",\"id\":2}]', '2020-02-12 23:56:52');
INSERT INTO `user_act_log` VALUES (69, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"测试\"}]', '2020-02-12 23:59:30');
INSERT INTO `user_act_log` VALUES (70, 1, '删除公共配置', 'common-env/del', '[3]', '2020-02-13 00:01:51');
INSERT INTO `user_act_log` VALUES (71, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"测试\"}]', '2020-02-13 00:02:25');
INSERT INTO `user_act_log` VALUES (72, 1, '删除公共配置', 'common-env/del', '[4]', '2020-02-13 00:02:28');
INSERT INTO `user_act_log` VALUES (73, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# dev\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config1\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=89701\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":1}]', '2020-02-13 00:48:47');
INSERT INTO `user_act_log` VALUES (74, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# dev\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config1\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":1}]', '2020-02-13 00:48:55');
INSERT INTO `user_act_log` VALUES (75, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# dev\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":1}]', '2020-02-13 00:49:02');
INSERT INTO `user_act_log` VALUES (76, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"test1\",\"id\":2,\"projectId\":2}]', '2020-02-13 10:31:27');
INSERT INTO `user_act_log` VALUES (77, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"test\",\"id\":2,\"projectId\":2}]', '2020-02-13 10:31:30');
INSERT INTO `user_act_log` VALUES (78, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# test\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\n# 日志\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":2}]', '2020-02-13 10:43:09');
INSERT INTO `user_act_log` VALUES (79, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# test\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\n# 日志\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":2}]', '2020-02-13 10:43:11');
INSERT INTO `user_act_log` VALUES (80, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"# dev\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nserver.port=8970\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-config/all.log\\r\\nlogging.level.web=TRACE\\r\\nlogging.level.com.leo.boot.config=DEBUG\\r\\n\",\"id\":1}]', '2020-02-13 10:43:13');
INSERT INTO `user_act_log` VALUES (81, 1, '保存环境配置', 'project/env/save', '[{\"content\":\"1=1\\r\\n\"}]', '2020-02-13 10:44:29');
INSERT INTO `user_act_log` VALUES (82, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"prod\",\"projectId\":2}]', '2020-02-13 10:44:57');
INSERT INTO `user_act_log` VALUES (83, 1, '保存公共配置', 'common-env/save', '[{\"envName\":\"123\"}]', '2020-02-13 11:36:38');
INSERT INTO `user_act_log` VALUES (84, 1, '删除公共配置', 'common-env/del', '[3]', '2020-02-13 11:36:41');
INSERT INTO `user_act_log` VALUES (85, 1, '保存项目', 'project/save', '[{\"collect\":false,\"name\":\"test\",\"remark\":\"测试\"}]', '2020-02-13 16:16:54');
INSERT INTO `user_act_log` VALUES (86, 1, '保存项目', 'project/save', '[{\"collect\":false,\"id\":3,\"name\":\"测试\",\"remark\":\"测试\"}]', '2020-02-13 16:17:17');
INSERT INTO `user_act_log` VALUES (87, 2, '收藏项目', 'collect/add', '[3, true]', '2020-02-13 16:29:43');
INSERT INTO `user_act_log` VALUES (88, 2, '收藏项目', 'collect/add', '[3, true]', '2020-02-13 16:31:14');
INSERT INTO `user_act_log` VALUES (89, 2, '收藏项目', 'collect/add', '[3, true]', '2020-02-13 16:34:28');
INSERT INTO `user_act_log` VALUES (90, 2, '收藏项目', 'collect/add', '[3, false]', '2020-02-13 16:34:42');
INSERT INTO `user_act_log` VALUES (91, 2, '收藏项目', 'collect/add', '[3, true]', '2020-02-13 16:34:42');
INSERT INTO `user_act_log` VALUES (92, 2, '收藏项目', 'collect/add', '[3, true]', '2020-02-13 16:34:47');
INSERT INTO `user_act_log` VALUES (93, 2, '收藏项目', 'collect/add', '[3, false]', '2020-02-13 16:35:05');
INSERT INTO `user_act_log` VALUES (94, 2, '收藏项目', 'collect/add', '[3, true]', '2020-02-13 16:35:19');
INSERT INTO `user_act_log` VALUES (95, 1, '收藏项目', 'collect/add', '[2, true]', '2020-02-13 17:44:42');
INSERT INTO `user_act_log` VALUES (96, 1, '收藏项目', 'collect/add', '[2, false]', '2020-02-13 17:44:49');
INSERT INTO `user_act_log` VALUES (97, 2, '收藏项目', 'collect/add', '[3, false]', '2020-02-13 17:45:01');
INSERT INTO `user_act_log` VALUES (98, 2, '收藏项目', 'collect/add', '[2, true]', '2020-02-13 17:45:02');
INSERT INTO `user_act_log` VALUES (99, 2, '保存环境配置', 'project/env/save', '[{\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-spider\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\n\",\"id\":5}]', '2020-02-13 17:45:40');
INSERT INTO `user_act_log` VALUES (100, 1, '保存环境配置', 'project/env/save', '[{\"commonIds\":\"2\",\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-spider\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\n\",\"id\":5}]', '2020-02-13 20:18:38');
INSERT INTO `user_act_log` VALUES (101, 1, '保存环境配置', 'project/env/save', '[{\"commonIds\":\"1\",\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\nprop.url=localhost:8970\\r\\n\",\"id\":5}]', '2020-02-13 20:18:55');
INSERT INTO `user_act_log` VALUES (102, 1, '保存环境配置', 'project/env/save', '[{\"commonIds\":\"1,2\",\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\nprop.url=localhost:8970\\r\\nprop.url=localhost:8970\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\n\",\"id\":5}]', '2020-02-13 20:32:00');
INSERT INTO `user_act_log` VALUES (103, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"111\",\"projectId\":2}]', '2020-02-13 20:32:07');
INSERT INTO `user_act_log` VALUES (104, 1, '删除环境配置', 'project/env/del', '[6]', '2020-02-13 20:32:10');
INSERT INTO `user_act_log` VALUES (105, 1, '保存项目', 'project/save', '[{\"collect\":false,\"name\":\"测试2\",\"remark\":\"测试2\"}]', '2020-02-13 22:56:51');
INSERT INTO `user_act_log` VALUES (106, 1, '保存环境配置', 'project/env/save', '[{\"commonIds\":\"1,2\",\"content\":\"mybatis.mapper-locations=classpath*:/mybatis/**/*.xml\\r\\n# 指定 MyBatis 应如何自动映射列到字段或属性 ,FULL 会自动映射任意复杂的结果集（无论是否嵌套）\\r\\nmybatis.configuration.auto-mapping-behavior=FULL\\r\\n# 开启自动下划线转驼峰命名规则\\r\\nmybatis.configuration.map-underscore-to-camel-case=true\\r\\nspring.mvc.view.prefix=/WEB-INF/jsp/\\r\\nspring.mvc.view.suffix=.jsp\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-spider?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-spider\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\nlogging.level.com.leo.boot.spider.dal=DEBUG\\r\\nlogging.level.com.leo.boot.spider.dal.sari=ERROR\\r\\nlogging.level.web=TRACE\\r\\nserver.port=8989\\r\\nimgDir=/developer/service/ZFL/images/\\r\\nvideoDir=/developer/service/SHT/\\r\\nvideo.save.path=/developer/service/SHT/video/\\r\\nspring.resources.static-locations=file:${imgDir},classpath:/static/,${imgDir},/opt/env/,file:${videoDir},\\r\\nserver.servlet.jsp.init-parameters.development=true\\r\\nspring.mvc.favicon.enable=false\\r\\nlogging.pattern.console=%d -%5p ${PID} - [%t] %-40.40logger{39}[%file:%line] : %m%n\\r\\nlogging.pattern.file=${logging.pattern.console}\\r\\nlogging.file=/var/www/logs/leo-boot-spider/all.log\\r\\nprop.url=localhost:8970\\r\\nspring.datasource.url=jdbc:mysql://localhost:3306/leo-config?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&autoReconnect=true\\r\\nspring.datasource.username=leo-config\\r\\nspring.datasource.password=cxz1991423\\r\\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\\r\\n\",\"id\":3}]', '2020-02-13 22:57:29');
INSERT INTO `user_act_log` VALUES (107, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"dev1\",\"id\":3,\"projectId\":1}]', '2020-02-13 22:57:37');
INSERT INTO `user_act_log` VALUES (108, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"dev\",\"id\":3,\"projectId\":1}]', '2020-02-13 22:57:41');
INSERT INTO `user_act_log` VALUES (109, 1, '保存项目', 'project/save', '[{\"collect\":false,\"name\":\"测试22\",\"remark\":\"sss\"}]', '2020-02-13 23:07:45');
INSERT INTO `user_act_log` VALUES (110, 1, '保存环境配置', 'project/env/save', '[{}]', '2020-02-14 12:33:47');
INSERT INTO `user_act_log` VALUES (111, 1, '保存环境配置', 'project/env/save', '[{}]', '2020-02-14 12:33:52');
INSERT INTO `user_act_log` VALUES (112, 1, '保存环境配置', 'project/env/save', '[{}]', '2020-02-14 12:34:15');
INSERT INTO `user_act_log` VALUES (113, 1, '保存环境配置', 'project/env/save', '[{}]', '2020-02-14 12:34:36');
INSERT INTO `user_act_log` VALUES (114, 1, '保存环境配置', 'project/env/save', '[{}]', '2020-02-14 12:36:30');
INSERT INTO `user_act_log` VALUES (115, 1, '保存环境配置', 'project/env/save', '[{}]', '2020-02-14 12:37:40');
INSERT INTO `user_act_log` VALUES (116, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"prod1\",\"id\":5,\"projectId\":2}]', '2020-02-14 12:38:28');
INSERT INTO `user_act_log` VALUES (117, 1, '保存环境配置', 'project/env/save', '[{\"envName\":\"prod\",\"id\":5,\"projectId\":2}]', '2020-02-14 15:44:13');

-- ----------------------------
-- Table structure for user_project_collect
-- ----------------------------
DROP TABLE IF EXISTS `user_project_collect`;
CREATE TABLE `user_project_collect`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_project_udx`(`user_id`, `project_id`) USING BTREE COMMENT '用户收藏联合唯一键'
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_project_collect
-- ----------------------------
INSERT INTO `user_project_collect` VALUES (35, 1, 1);
INSERT INTO `user_project_collect` VALUES (36, 1, 2);
INSERT INTO `user_project_collect` VALUES (34, 1, 5);
INSERT INTO `user_project_collect` VALUES (27, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
