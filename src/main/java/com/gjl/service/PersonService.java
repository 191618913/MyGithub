package com.gjl.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjl.mapper.seachermapper;
import com.gjl.model.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
@Service
public class PersonService extends ServiceImpl<seachermapper,person>{
    @Autowired
    private seachermapper sh;
    public List<person> findUserInfo(){
        Wrapper<person> wrapper=new EntityWrapper<person>();
        List<person> list=sh.selectList(wrapper);
       return  list;
    }
}
