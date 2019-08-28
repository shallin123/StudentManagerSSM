package com.shallin.interceptor;

import com.shallin.entity.User;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录过滤拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url=request.getRequestURI();
        User user=(User)request.getSession().getAttribute("user");
        if (user==null){
            System.out.println("未登录或登录失效"+url);
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                Map<String,String> ret =new HashMap<String, String>();
                ret.put("type","error");
                ret.put("msg","登陆证状态已经失效，请重新登录");
                response.getWriter().write(JSONObject.fromObject(ret).toString());
                return  false;
            }
            response.sendRedirect(request.getContextPath()+"/system/login");
                return  false;
        }
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
