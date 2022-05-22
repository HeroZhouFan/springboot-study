drop table if exists logger;
CREATE TABLE `logger`
(
    `id`                 int(11)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `client_ip`          varchar(1000) COMMENT '客户端请求IP',
    `uri`                varchar(1000) COMMENT '请求路径',
    `type`               varchar(50) COMMENT '终端请求方式（普通请求， ajax）',
    `method`             varchar(10) COMMENT '请求方式（get,post）',
    `param_data`         longtext COMMENT '请求数据',
    `user_id`            varchar(1000) COMMENT '用户标识',
    `time`               datetime COMMENT '请求时间',
    `return_time`        datetime COMMENT '响应时间',
    `return_data`        longtext COMMENT '响应数据',
    `http_status_code`   varchar(10) COMMENT 'http响应码',
    `system_status_code` varchar(10) COMMENT '服务器响应码',
    `time_consuming`     int(8) COMMENT '响应耗时',
    `error`              longtext COMMENT '异常信息',
    `cookie`             varchar(3000) COMMENT 'cookie',
    `is_valid`           int(1)         DEFAULT 1 COMMENT '是否有效 1：有效 0：无效',
    `created_time`       datetime  NOT NULL,
    `modified_time`      timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='日志';