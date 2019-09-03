package com.shallin.controller;

import com.mysql.cj.util.StringUtils;
import com.shallin.entity.User;
import com.shallin.page.Page;
import com.shallin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理员控制器
 * @author shallin
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    public UserService userService;

    /**
     * 用户管理列表页
     * @param model
     * @return
     */
    @RequestMapping(value ="/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model){
        model.setViewName("user/user_list");
        return model;
    }

    /**
     * 获取用户列表
     * @param username
     * @param page
     * @return
     */
    @RequestMapping(value = "/get_list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(
            @RequestParam(value = "username",required = false,defaultValue ="") String username,
            Page page
            ) {
        Map<String, Object> ret = new HashMap<String, Object>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("username","%"+username+"%");
        queryMap.put("offset",page.getOffset());
        queryMap.put("pageSize",page.getRows());
        ret.put("rows",userService.findList(queryMap));
        ret.put("total",10);
        return ret;
    }

    /**
     * 添加用户操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(User user){
        Map<String,String> ret =new HashMap<String, String>();
        if(user==null){
            ret.put("type","error");
            ret.put("msg","数据绑定出错，请联系开发作者");
            return ret;
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(user.getUsername())){
            ret.put("type","error");
            ret.put("msg","用户名不能为空");
            return  ret;
        }
        if(StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())){
            ret.put("type","error");
            ret.put("msg","密码不能为空");
            return  ret;
        }
        User existUser = userService.findByUserName(user.getUsername());
        if(existUser!=null){
            ret.put("type","error");
            ret.put("msg","该用户名已经存在");
            return  ret;
        }
        if (userService.add(user)<=0){
            ret.put("type","error");
            ret.put("msg","添加失败");
            return  ret;
        }
        ret.put("type","success");
        ret.put("msg","添加成功");
        return  ret;
    }
}
