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
            vo.setNickname(user.getNickname());
            vo.setEmail(user.getEmail());
            vo.setStatus(user.getStatus());
            // 状态码 → 中文
            vo.setStatusText(user.getStatus() == 1 ? "正常" : "禁用");
            // 日期格式化
            if (user.getCreateTime() != null) {
                vo.setCreateTime(user.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
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
        vo.setNickname(user.getNickname());
        vo.setEmail(user.getEmail());
        vo.setStatus(user.getStatus());
        vo.setStatusText(user.getStatus() == 1 ? "正常" : "禁用");
        if (user.getCreateTime() != null) {
            vo.setCreateTime(user.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        return vo;
    }
}
