package com.example.demo.entity;

import java.time.LocalDateTime;

/**
 * 用户实体 —— 对应 t_user 表
 */
public class User {
    private Long id;
    private String username;
    private String nickname;   // ⚠️ 注意：数据库中 sunqi 的 nickname 是 NULL
    private String phone;
    private String email;
    private Integer status;    // 1=正常, 0=禁用
    private Long deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // === getter / setter ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }
}
