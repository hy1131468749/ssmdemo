package com.demo.component;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 处理全局异常
 * @author Administrator
 *
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        ex.printStackTrace();
        if(ex instanceof AuthorizationException){
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            writer.println("没有该权限！");
            writer.close();
            return null;
        }else{
            return new ModelAndView();
        }
         
    }
}


