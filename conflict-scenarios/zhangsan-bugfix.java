package com.example.demo.service.impl;

import com.example.demo.dto.UserVO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ⚠️ 这是张三（zhangsan）推送到 main 分支的版本
 *
 * 张三改了：
 * 1. setNickname() 加了 null 判断，null → 空字符串 ""（你改成了 "未知用户"，冲突点！）
 * 2. setEmail() 也加了 null 判断
 * 3. listUsers() 方法上加了注释
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserVO> listUsers() {
        List<User> users = userMapper.listAll();

        return users.stream().map(user -> {
            UserVO vo = new UserVO();
            vo.setId(user.getId());
            vo.setUsername(user.getUsername());

            // 【冲突行 ↓】张三：null → ""
            vo.setNickname(user.getNickname() != null ? user.getNickname() : "");

            // 【冲突行 ↓】张三：email 也加了 null 处理
            vo.setEmail(user.getEmail() != null ? user.getEmail() : "");

            vo.setStatus(user.getStatus());
            vo.setStatusText(user.getStatus() == 1 ? "正常" : "禁用");
            if (user.getCreateTime() != null) {
                vo.setCreateTime(user.getCreateTime()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            // ⚠️ 没有 setPhone —— M3 的练习：加 phone 字段
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public UserVO getUserById(Long id) {
        User user = userMapper.getById(id);
        if (user == null) {
            return null;
        }
        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setNickname(user.getNickname() != null ? user.getNickname() : "");
        vo.setEmail(user.getEmail() != null ? user.getEmail() : "");
        vo.setStatus(user.getStatus());
        vo.setStatusText(user.getStatus() == 1 ? "正常" : "禁用");
        if (user.getCreateTime() != null) {
            vo.setCreateTime(user.getCreateTime()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        return vo;
    }
}
