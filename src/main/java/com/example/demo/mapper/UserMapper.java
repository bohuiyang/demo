package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     */
    List<User> listAll();

    /**
     * 按 ID 查用户
     */
    User getById(Long id);

    /**
     * 按用户名模糊搜索
     */
    List<User> searchByUsername(String keyword);
}
