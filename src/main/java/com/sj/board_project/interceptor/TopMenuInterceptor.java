package com.sj.board_project.interceptor;

import com.sj.board_project.service.TopMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class TopMenuInterceptor implements HandlerInterceptor {

    private final TopMenuService topMenuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("topMenuList", topMenuService.getTopMenuList());
        return true;
    }

}
