package cn.songhaiqing.autoadmin.entity;

import cn.songhaiqing.autoadmin.base.BaseEntity;

public class SysUserRole extends BaseEntity {
    private Long userId;
    private Long roleId;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}