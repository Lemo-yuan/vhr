package com.lemo.vhrmaster.controller;

import com.lemo.vhrmaster.service.HrService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private HrService hrService;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从主体传过来的用户名中获得信息
        String username = (String) authenticationToken.getPrincipal();

        //通过用户名去数据库或者缓存中获得凭证
        String passowrd = hrService.getPasswordByUserName(username);
        if(passowrd == null)
            return null;

        SimpleAuthenticationInfo authorizationInfo  = new SimpleAuthenticationInfo(username,passowrd,getName());

        return authorizationInfo;
    }
}
