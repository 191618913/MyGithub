package com.gjl.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gjl.model.person;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
public interface seachermapper extends BaseMapper<person> {
     List<person> findUserInfo();
}
