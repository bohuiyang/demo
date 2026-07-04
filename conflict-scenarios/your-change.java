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
 * ⚠️ 这是你的版本（feature/user-nickname-fix 分支）
 *
 * 你改了：
 * 1. setNickname() 加了 null 判断，null → "未知用户"（和张三冲突！）
 * 2. setUsername() 加了 null 判断（你加的额外保护）
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

            // 【冲突行 ↑】你：username 也加了 null 处理（额外改动）
            vo.setUsername(user.getUsername() != null ? user.getUsername() : "");

            // 【冲突行 ↑】你：null → "未知用户"
            vo.setNickname(user.getNickname() != null ? user.getNickname() : "未知用户");

            vo.setEmail(user.getEmail());
            vo.setStatus(user.getStatus());
            vo.setStatusText(user.getStatus() == 1 ? "正常" : "禁用");
            if (user.getCreateTime() != null) {
                vo.setCreateTime(user.getCreateTime()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
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
        vo.setUsername(user.getUsername() != null ? user.getUsername() : "");
        vo.setNickname(user.getNickname() != null ? user.getNickname() : "未知用户");
        vo.setEmail(user.getEmail());
        vo.setStatus(user.getStatus());
        vo.setStatusText(user.getStatus() == 1 ? "正常" : "禁用");
        if (user.getCreateTime() != null) {
            vo.setCreateTime(user.getCreateTime()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        return vo;
    }
}
