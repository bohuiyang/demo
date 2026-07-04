package com.example.demo.entity;

/**
 * 部门实体 —— 对应 t_dept 表
 */
public class Dept {
    private Long id;
    private String deptName;
    private Long parentId;
    private Integer sortOrder;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
}
