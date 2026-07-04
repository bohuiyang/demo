-- 用户表
CREATE TABLE IF NOT EXISTS t_user (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(50)  NOT NULL COMMENT '用户名',
    nickname    VARCHAR(50)  DEFAULT '' COMMENT '昵称',
    phone       VARCHAR(20)  DEFAULT '' COMMENT '手机号',
    email       VARCHAR(100) DEFAULT '' COMMENT '邮箱',
    status      TINYINT      DEFAULT 1 COMMENT '状态: 1=正常, 0=禁用',
    dept_id     BIGINT       DEFAULT 0 COMMENT '部门ID',
    create_time DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 部门表（M3 改接口时用）
CREATE TABLE IF NOT EXISTS t_dept (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    dept_name   VARCHAR(50) NOT NULL COMMENT '部门名称',
    parent_id   BIGINT DEFAULT 0 COMMENT '上级部门ID',
    sort_order  INT    DEFAULT 0 COMMENT '排序'
);
