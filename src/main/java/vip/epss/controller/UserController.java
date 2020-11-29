package vip.epss.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;

import java.io.IOException;
import java.io.InputStream;
//import vip.epss.dao.UserMapper;


/**
 * User的控制器
 */
public class UserController {
    public void add(String name, String passwd) throws IOException {
        //1.加载mybatis的配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.获取对应的SqlSession对象,相当于jdbc编程中的connection对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置为自动提交
        //4. 获取对应的mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //5.调用接口中定义的方法
        Integer num = userMapper.insert(new User(null, name, passwd));
        System.out.println("插入了" + num + "条数据");
//        sqlSession.commit();//手动提交
        //6. 关闭资源
        sqlSession.close();
        resourceAsStream.close();
    }

}
