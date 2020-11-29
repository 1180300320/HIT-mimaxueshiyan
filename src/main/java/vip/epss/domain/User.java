package vip.epss.domain;

import java.io.Serializable;

/**
 * 此处可以使用alt+enter   自动补全
 * 重新构造类或覆写方法    alt+insert
 * 格式化代码             ctrl+alt+L
 * User 的实体类   ,应该符合pojo的约束
 * 便于框架中数据的封装
 * 设计原则  ORM思想
     * 实体类的属性名和字段名相同(如果不同则需要映射)
     * 实体类的属性数据类型应该兼容字段的类型
     * 需要实现序列化接口Serializable
     * [可选]为了能够被框架访问,需要提供空参和全参构造器
     * getter和setter方法
     * [可选]方便测试(控制台输出数据),建议覆写toString()方法
 */
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;

    public User(Integer uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
