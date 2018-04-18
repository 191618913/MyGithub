package com.gjl.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
@TableName("staff")
public class Staff  extends Model{
    @Override
    protected Serializable pkVal() {
        return null;
    }

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;

    @TableField(value = "user_no")
    private String userNo;

    @TableField(value = "user_name")
    private String username;

    @TableField(value = "wxno")
    private String wxNo;

    @TableField(value = "user_pwd")
    private String userPwd;

    @TableField(value = "user_role")
    private Integer userRole;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
