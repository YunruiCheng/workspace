-- 创建 User 表
CREATE TABLE t_user (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(20),
                        password VARCHAR(20),
                        age INT,
                        sex CHAR,
                        email VARCHAR(20)
);

-- 创建 employee 表
-- 内嵌java类Emp的字段数据did、deptName，当成普通字段创建即可
CREATE TABLE t_emp (
                       eid INT PRIMARY KEY AUTO_INCREMENT,
                       emp_name VARCHAR(20),
                       age INT,
                       sex CHAR,
                       email VARCHAR(20),
                       did INT,
                       dept_name VARCHAR(20)
);

-- 创建 departure 表
CREATE TABLE t_dept (
                        did INT PRIMARY KEY AUTO_INCREMENT,
                        dept_name VARCHAR(20)
);