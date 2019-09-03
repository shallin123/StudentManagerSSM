package com.shallin.controller;


import com.mysql.cj.util.StringUtils;
import com.shallin.entity.User;
import com.shallin.service.UserService;
import com.shallin.util.CpachaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/system")
@Controller
public class SystemController {
@Autowired
    private UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public  ModelAndView index(ModelAndView model){
            model.setViewName("system/index");
            return model;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model) {
        model.setViewName("system/login");
        return model;
    }

    @RequestMapping(value = "/get_cpacha", method = RequestMethod.GET)
    public void getCpacha(HttpServletRequest request,
                          @RequestParam(value = "vl", defaultValue = "4", required = false) Integer vl,
                          @RequestParam(value = "w", defaultValue = "98", required = false) Integer w,
                          @RequestParam(value = "h", defaultValue = "33", required = false) Integer h,
                          HttpServletResponse response) {
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("loginCpacha", generatorVCode);//j����session�Ự
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());//�õ������
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(
            @RequestParam(value ="username",required = true) String username,
            @RequestParam(value = "password",required =true) String password,
            @RequestParam(value = "vcode",required = true)String vcode,
            @RequestParam(value="type",required = true) int type,
            HttpServletRequest request
    ) {

        Map<String, String> ret = new HashMap<String, String>();
        if (StringUtils.isEmptyOrWhitespaceOnly(username)){
            ret.put("type","error");
            ret.put("msg","用户名不能为空");
            return ret;
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(password)){
            ret.put("type","error");
            ret.put("msg","密码不能为空");
            return ret;
        }
        String loginCpacha = (String)request.getSession().getAttribute("loginCpacha");
        if (StringUtils.isEmptyOrWhitespaceOnly(password)){
            ret.put("type","error");
            ret.put("msg","长时间未操作，会话已经失效");
            return ret;
        }
        if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
            ret.put("type","error");
            ret.put("msg","验证码错误");
            return ret;
        }
        request.getSession().setAttribute("loginCpacha",null);
if(type==1) {
    User user = userService.findByUserName(username);
    if (user == null) {
        ret.put("type", "error");
        ret.put("msg", "不存在该用户");
        return ret;
    }
    if(!password.equals(user.getPassword())){
        ret.put("type","error");
        ret.put("msg","密码错误");
        return  ret;
    }
    request.getSession().setAttribute("user",user);
}
if (type==2){

}
        ret.put("type","success");
        ret.put("msg","登陆成功");
        return ret;
    }
}