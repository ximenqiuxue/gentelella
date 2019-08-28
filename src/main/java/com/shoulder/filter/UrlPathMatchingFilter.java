package com.shoulder.filter;

import com.shoulder.service.PermissionService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;


public class UrlPathMatchingFilter extends PathMatchingFilter {

    private static final Logger log = Logger.getLogger(UrlPathMatchingFilter.class);

    @Autowired
    private PermissionService permissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String requestUrl = getPathWithinApplication(request);
        log.info("requestUrl:" + requestUrl);
        Subject subject = SecurityUtils.getSubject();
        //没有登陆,就跳转到登陆页面
        if(!subject.isAuthenticated()) {
            log.info("没有登陆,跳转登陆页面...........................");
            WebUtils.issueRedirect(request, response, "/login.do");
            return false;
        }
        //判断路径权限里有没有维护，没有维护，一律放行(也可以改为一律不放行)
        boolean needInterceptor = permissionService.needInterceptor(requestUrl);
        if (!needInterceptor) {
            log.info("不需要needInterceptor,自行跳转页面...........................");
            return true;
        }else {
            boolean hasPermission = false;
            String username = subject.getPrincipal().toString();
            Set<String> permissionUrls = permissionService.getPermissionUrls(username);
            log.info("permissionUrls..........................." + permissionUrls);
            for (String url : permissionUrls) {
                if(url.equals(requestUrl)){
                    hasPermission = true;
                    break;
                }
            }
            if (hasPermission) {
                return true;
            }else{
                log.info("UnauthorizedException,跳转到登陆页面...........................");
                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径" + requestUrl + "的权限");
                subject.getSession().setAttribute("error", ex);
                WebUtils.issueRedirect(request, response, "/common/unauthorized.do");
                return false;
            }
        }
    }
}
