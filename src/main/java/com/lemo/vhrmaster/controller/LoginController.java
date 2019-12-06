package com.lemo.vhrmaster.controller;

import com.lemo.vhrmaster.bean.Hr;
import com.lemo.vhrmaster.service.HrService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/System/config")
public class LoginController {

    @Autowired
    private HrService hrService;

    @RequestMapping("/login")
    public  @ResponseBody Object Login(@RequestBody Hr hr){   //返回类型不需要磁轭成jsonobject  ,因为spring会将其转换为JSON并返回。
//        CustomRealm customerRealm = new CustomRealm();
//
//        DefaultSecurityManager defaultSecurityManager= new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(customerRealm);
//        //主体提交认证请求
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Map<String, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        String username= hr.getUsername();
        String password = hr.getPassword();
        UsernamePasswordToken token =new UsernamePasswordToken(username,DigestUtils
                .md5Hex(password).toLowerCase());
        try{
            subject.login(token);
            map.put("token",subject.getSession().getId());
            map.put("msg","登录成功");
        }catch (IncorrectCredentialsException e){
            map.put("msg","密码错误");
        }catch (LockedAccountException e) {
            map.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            map.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
