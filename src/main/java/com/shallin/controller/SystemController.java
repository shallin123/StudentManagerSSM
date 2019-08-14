package com.shallin.controller;


import com.shallin.util.CpachaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RequestMapping("/system")
@Controller
public class SystemController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model){
        model.setViewName("system/login");
       return model;
    }

    @RequestMapping(value = "/get_cpacha",method = RequestMethod.GET)
    public void getCpacha(HttpServletRequest request,
                          @RequestParam (value = "vl",defaultValue = "4",required = false) Integer vl,
                          @RequestParam (value ="w",defaultValue = "98",required = false) Integer w,
                          @RequestParam (value = "h",defaultValue = "33",required = false) Integer h,
                          HttpServletResponse response){
                            CpachaUtil cpachaUtil = new CpachaUtil(vl,w,h);
                            String generatorVCode=cpachaUtil.generatorVCode();
                            request.getSession().setAttribute("loginCpacha",generatorVCode);//j加入session会话
                            BufferedImage  generatorRotateVCodeImage=cpachaUtil.generatorRotateVCodeImage(generatorVCode,true);
                            try {
                                ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());//得到输出流
                            }
                            catch (IOException e){
                                e.printStackTrace();
                            }

    }
}
