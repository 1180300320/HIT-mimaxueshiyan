package vip.epss.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试mybatis 能否正确的工作
 */
public class MyBatisTest {
    @Test
    public void UserTest01() throws IOException {
        //1.加载mybatis的配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.获取对应的SqlSession对象,相当于jdbc编程中的connection对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置为自动提交
        //4. 获取对应的mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //5.调用接口中定义的方法
        Integer num = userMapper.insert(new User(null, "lxs", "300","user"));
        System.out.println("插入了" + num + "条数据");
//        sqlSession.commit();//手动提交
        //6. 关闭资源
        sqlSession.close();
        resourceAsStream.close();
    }
}
