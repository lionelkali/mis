package com.shicheng.mis.shiro;


import com.shicheng.mis.entity.User;
import com.shicheng.mis.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权");
        return null;
    }

    //执行认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证");

        //从数据库取数据
/*        String name="admin";
        String password="111";*/
        UsernamePasswordToken UpToken = (UsernamePasswordToken) token;

        User user = userService.findByName(UpToken.getUsername());

        //判断用户名密码是否正确
        //UsernamePasswordToken UpToken= (UsernamePasswordToken) token;
        if (user==null){
            //用户名不存在

            return null; //返回null,shiro底层会抛出UnknownAccountException
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("", user.getPassword(), "");

        return info;
    }
}
