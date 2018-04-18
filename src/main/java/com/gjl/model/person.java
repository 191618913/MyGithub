package com.gjl.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/21.
 */
@TableName("tb_order")
public  class person extends Model {
    @TableId(value = "id",type = IdType.AUTO)
   private  int id;
    @TableField(value = "user_id")
   private  int user_id;
    @TableField(value = "order_number")
   private  String order_number;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
