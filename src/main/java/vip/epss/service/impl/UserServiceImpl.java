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
    public List<User> selectAll() { return userMapper.selectAll(); }

    @Override
    public User selectByUid(Integer uid) {
        return userMapper.selectByUid(uid);
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

//    @Override
//    public User selectByUsername(String username) {
//        List<User> users = userMapper.selectAll();
//        for (User user1:users) {
//            if(user1.getUsername().equals(username))
//                return user1;
//        }
//        return null;
//    }
}
