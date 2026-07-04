package com.example.demo.service;

import com.example.demo.dto.UserVO;
import java.util.List;

public interface UserService {

    /**
     * 获取用户列表
     */
    List<UserVO> listUsers();

    /**
     * 按 ID 查用户（M3 验收任务会用）
     */
    UserVO getUserById(Long id);
}
