package authorization;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * shiro认证测试
 *
 * @author JasonWong
 */
public class AuthorizationTest {

    /**
     * SimpleAccountRealm认证
     */
    @Test
    public void testSimpleAccountRealm() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("admin", "123456");
        DefaultSecurityManager securityManager = new DefaultSecurityManager(simpleAccountRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        subject.login(token);
        System.out.println("登陆后认证结果：" + subject.isAuthenticated());
        subject.logout();
        System.out.println("退出后认证结果：" + subject.isAuthenticated());
    }
}
