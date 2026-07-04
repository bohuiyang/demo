package com.example.demo.controller;

import com.example.demo.dto.UserVO;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * GET /user/list
     * 查询所有用户（M3 练习：加 status 筛选参数）
     */
    @GetMapping("/list")
    public Map<String, Object> list() {
        List<UserVO> users = userService.listUsers();
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "成功");
        result.put("data", users);
        return result;
    }

    /**
     * GET /user/detail?id=1
     * 查单个用户
     */
    @GetMapping("/detail")
    public Map<String, Object> detail(Long id) {
        UserVO user = userService.getUserById(id);
        Map<String, Object> result = new HashMap<>();
        if (user == null) {
            result.put("code", 404);
            result.put("msg", "用户不存在");
            return result;
        }
        result.put("code", 200);
        result.put("msg", "成功");
        result.put("data", user);
        return result;
    }
}
