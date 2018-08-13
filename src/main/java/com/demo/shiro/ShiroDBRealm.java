package com.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.bean.User;
import com.demo.bean.UserInf;
import com.demo.service.UserService;

public class ShiroDBRealm extends AuthorizingRealm {

	@Autowired 
    private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Session session = SecurityUtils.getSubject().getSession();
		UserInf userInf  = (UserInf) session.getAttribute(UserInf.USERINF);
		SimpleAuthorizationInfo authorizationInfo = null;
		if(userInf != null){
		    authorizationInfo = new SimpleAuthorizationInfo();
		    authorizationInfo.addStringPermissions(userInf.getPermissions());
		  
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // 把token转换成User对象  
	    UsernamePasswordToken upt = (UsernamePasswordToken)authcToken;
	    String username = upt.getUsername();
        // 验证用户是否可以登录   这里可以根据用户状态 抛出多个异常 然后在login方法里进行捕捉
	    User u = userService.selectByLoginName(username);
        if(u == null) {
            throw new UnknownAccountException("用户不存在");
        }
        //当前 Realm 的 name  
        String realmName = this.getName();  
        //principal 就是用户名
        Object principal = upt.getPrincipal();
        //把用户名当做salt值
        ByteSource salt = ByteSource.Util.bytes(username);
        //会验证密码是否匹配
        return new SimpleAuthenticationInfo(principal, u.getPassword(), salt,realmName);  
	}
	
  

}
