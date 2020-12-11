package vip.epss.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.epss.domain.User;
import vip.epss.service.UserService;

import java.util.List;

public class SpringTest {
    @Test
    public void userServiceTest01(){
        //1 加载配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 从spring的IOC容器中获取已经注入的bean
//        User newuser = classPathXmlApplicationContext.getBean("newUser", User.class);
//        System.out.println(newuser);
        UserService userService = classPathXmlApplicationContext.getBean("userService", UserService.class);
        List<User> users = userService.selectAll();

        for(User user:users){
            System.out.println(user);
        }
    }
}
