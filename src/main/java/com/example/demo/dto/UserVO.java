package com.example.demo.dto;

/**
 * 返回给前端的用户信息 —— 故意比 Entity 少一些字段
 *
 * ⚠️ 注意：当前没有 phone 字段 —— M3 模块的练习就是加上它
 */
public class UserVO {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private Integer status;
    private String statusText;   // 状态中文描述（不是数据库字段，是 Service 里拼的）
    private String createTime;   // 格式化成字符串，方便前端显示

    // === getter / setter ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public String getStatusText() { return statusText; }
    public void setStatusText(String statusText) { this.statusText = statusText; }

    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
}
