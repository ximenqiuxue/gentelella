package com.shoulder.realm;

import com.shoulder.model.User;
import com.shoulder.service.PermissionService;
import com.shoulder.service.RoleService;
import com.shoulder.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    private static final Logger log = Logger.getLogger(ShiroRealm.class);

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //能进入到这里，表示账号已经通过验证了
        String username = (String) principalCollection.getPrimaryPrincipal();
        //授权对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            //通过service获取角色和权限
            Set<String> permissions = permissionService.getPermissionName(username);
            Set<String> roles = roleService.getRoleName(username);
            log.info("permissions : " + permissions);
            log.info("roles : " + roles);
            //把通过service获取到的角色和权限放进授权对象
            simpleAuthorizationInfo.setStringPermissions(permissions);
            simpleAuthorizationInfo.setRoles(roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取账号密码
        String username = authenticationToken.getPrincipal().toString();
        //获取数据库中的密码
        User user = userService.findUserByName(username);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        //认证信息里存放账号密码，getName()是当前Realm的继承方法,通常返回当前类名：ShiroRealm
        //通过spring-shiro.xml里配置的HashedCredentialsMatcher进行自动校验
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,passwordInDB, ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }
}
