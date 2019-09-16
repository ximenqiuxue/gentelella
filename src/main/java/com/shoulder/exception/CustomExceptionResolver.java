package com.shoulder.exception;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        CustomException customException = null;
        // 预期错误
        if(e instanceof CustomException) {
            customException = (CustomException) e;
        }else{
            // 非预期错误
            customException = new CustomException(e.getMessage());
        }

        String message = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();

        // 判断是否json请求
        HandlerMethod method = (HandlerMethod) o;

        ResponseBody responseBody = method.getMethod().getAnnotation(ResponseBody.class);

        if(responseBody != null) {
            Map<String, Object> responseMap = new HashMap<String, Object>();
            responseMap.put("code", 0);
            responseMap.put("msg", message);
            String json= JSON.toJSONString(responseMap);
            httpServletResponse.setContentType("UTF-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            try {
                httpServletResponse.getWriter().write(json);
                httpServletResponse.getWriter().flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return modelAndView;
        }else {
            modelAndView.addObject("message", message);
            //不是json数据,携带message到跳转到错误页面
            modelAndView.setViewName("error/page-error");
            return modelAndView;
        }
    }
}
