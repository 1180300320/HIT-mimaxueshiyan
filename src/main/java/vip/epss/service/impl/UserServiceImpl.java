package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.service.UserService;

import java.util.List;

/**
 * User的service实现类
 */
@Service(value = "userService")
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer delete(Integer uid) {
        return userMapper.delete(uid);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> selectAll() {
        System.out.println("Service 层的selectAll()方法执行了.......");
        return userMapper.selectAll();
    }

    @Override
    public User selectByUid(Integer uid) {
        return userMapper.selectByUid(uid);
    }

//    @Override
//    public User selectByUsername(String username) {
//        return userMapper.selectByUsername(username);
//    }
}
