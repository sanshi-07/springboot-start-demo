package com.example.springbootinterceptorstartjar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的RUi:去除http:localhost:8080这部分剩下的
               String uri = request.getRequestURI();
                 //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
                 // 这里第三方系统可以配置白名单路径，
                if (uri.indexOf("/login") >= 0) {
                       return true;
                    }
                //获取session 这里用户名从cookie中获得
                // Cookie[] cookies = request.getCookies();
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("USER_NAME");
                Voucher voucher = new Voucher();
                voucher.setUsername(username);
                voucher.setResource(uri);
                voucher.setAppCode("xxxx");
                //判断session中是否有用户数据，如果有，则返回true，继续向下执行
                if (voucher != null) {
                       // 调用我们第三方接口鉴权
                        System.out.println("鉴权"+voucher.toString());
                        //成功与否调用记日志接口   这里有疑惑每次鉴权都做？
                        return true;
                }
                 //不符合条件的给出提示信息
                request.setAttribute("msg", "没有权限！");
                return false;
    }

}
