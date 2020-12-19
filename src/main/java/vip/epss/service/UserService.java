package vip.epss.service;

import vip.epss.domain.User;

import java.util.List;

/**
 * User的service层接口
 * 定义规范
 */
public interface UserService {
    //根据传入的用户对象,向数据库插入一条记录
    public Integer insert(User user);
    //删除记录,根据主键uid删除一条记录
    public Integer delete(Integer uid);
    //修改记录
    public Integer update(User user);
    //查询所有记录
    public List<User> selectAll();
    //查询一条记录,根据主键查询
    public User selectByUid(Integer uid);
    //查询一条记录,根据用户名查询
    public User selectByUsername(String username);
}
