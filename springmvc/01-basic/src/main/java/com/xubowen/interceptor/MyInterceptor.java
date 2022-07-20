package com.xubowen.interceptor;

import com.xubowen.controller.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author XuBowen
 * @date 2022/2/27 21:58
 */
public class MyInterceptor implements HandlerInterceptor {
    // 声明控制器类属性
    @Autowired
    private TestInterceptor interceptor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        // 获取请求单元方法的方法对象
        Method method = hm.getMethod();
        method.invoke(interceptor,null);
        System.out.println("MyInterceptor.preHandle");
        // true/false控制是否放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 对单元方法返回后的数据进行处理，然后再交给视图解析器进行处理
        String viewName = modelAndView.getViewName();
        System.out.println("单元方法响应资源路径"+viewName);
        modelAndView.setViewName("/index.jsp");
        System.out.println("MyInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
