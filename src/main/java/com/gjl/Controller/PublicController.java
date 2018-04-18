package com.gjl.Controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gjl.mapper.StaffMapper;
import com.gjl.model.Staff;
import com.gjl.model.person;
import com.gjl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/21.
 */
@Controller
@RequestMapping(value = "/public")
public class PublicController {
    @Value("${spring.application.hello}")
    private  String value;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private PersonService PersonService;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String index(Model model){
//        List<person> list=PersonService.findUserInfo();
//        String s= JSON.toJSONString(list.get(0));
        model.addAttribute("name",this.value);
        return  "home";

    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public  String  test(){
        return  "hello";

    }
    @RequestMapping(value = "/userBind",method = RequestMethod.GET)
    public void UserBindImfo(@RequestParam(value = "username") String username,
                               @RequestParam(value = "userNo") String userNo,
                               @RequestParam(value = "openId") String openId){
          Staff staff=new Staff();
          Wrapper<Staff> wrapper=new EntityWrapper<>();
          staff.setUsername(username);
          staff.setWxNo(openId);
          staff.setUserNo(userNo);
          staffMapper.insert(staff);
    }
}
