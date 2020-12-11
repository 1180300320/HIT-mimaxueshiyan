package vip.epss.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.service.UserService;

import java.util.List;

/**
 * 通过spring的ioc容器拿到bean,然后调用相应的方法
 * sprint-test
 */
//指定使用的单元测试模块
@RunWith(SpringJUnit4ClassRunner.class)
//指定测试所需要的配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTestWithIoc {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testUserMapperIoc(){
        List<User> users = userMapper.selectAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testUserServiceIoc(){
        User user = userService.selectByUid(11);
        System.out.println(user);
    }

    @Test
    public void test01(){
        userService.insert(new User(null,"lisi5","111"));
        System.out.println("insert 执行了");
//        System.out.println(0/0);
        userService.delete(16);
        System.out.println("delete 执行了");
    }

//    @Test
//    public void testTx(){
//        userService.sampleTx();
//    }
}
