-- 初始测试数据
INSERT INTO t_user (username, nickname, phone, email, status, dept_id) VALUES
('zhangsan', '张三', '13800001111', 'zhangsan@example.com', 1, 1),
('lisi',     '李四', '13800002222', 'lisi@example.com',     1, 1),
('wangwu',   '王五', '13800003333', 'wangwu@example.com',   0, 2),
('zhaoliu',  '赵六', '13800004444', 'zhaoliu@example.com',  1, 2),
('sunqi',    NULL,   '13800005555', 'sunqi@example.com',    1, 3);

INSERT INTO t_dept (dept_name, parent_id, sort_order) VALUES
('技术部', 0, 1),
('产品部', 0, 2),
('运营部', 0, 3);
