package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.windows.WPrinterJob;
import vip.epss.domain.Goods;
import vip.epss.domain.User;
import vip.epss.service.GoodsService;
import vip.epss.service.UserService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * User的控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

//    @RequestMapping("/a_page")
//    public String toA(){
//        System.out.println("Controller工作了.....");
//        return "user/a";
//    }
//    @RequestMapping(value = "/getUsers")
//    public String getUsers(){
//        List<User> users = userService.selectAll();
//        for(User user:users){
//            System.out.println(user);
//        }
//        return "user/a";
//    }

//    欢迎页面跳转登录按钮
    @RequestMapping(value = "/login")
    public String login(){
        return "user/login";
    }

//    欢迎页面跳转注册按钮
    @RequestMapping(value = "/register")
    public String register(){
        return "user/register";
    }

//    欢迎页面跳转至管理员界面按钮（已删除）
    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin/admin";
    }

//    欢迎页面跳转至商城界面按钮（已删除）
    @RequestMapping(value = "/shop")
    public String shop(){
        return "shangcheng/shangcheng";
    }

//    管理员界面登出按钮
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }

//    管理员界面用户管理界面添加用户按钮
    @RequestMapping(value = "/addForm")
    public String addForm(){
        return "user/addForm";
    }

//    管理员界面用户管理界面添加用户方法
    @RequestMapping(value = "/add")
    public ModelAndView add(User user){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/userList");
        System.out.println(user);
        userService.insert(user);
        return modelAndView;
    }

//    注册界面注册方法
    @RequestMapping(value = "/registeradd")
    public ModelAndView registeradd(User user){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/login");
        System.out.println(user);
        userService.insert(user);
        return modelAndView;
    }

//    登录方法
    @RequestMapping(value = "/logincompare")
    public ModelAndView compare(User user, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        User getuser = userService.selectByUser(user);
        if(getuser!=null)
        {
            System.out.println("找到用户");
            if(getuser.getUsertype().equals("admin"))
            {
                System.out.println("是admin");
                modelAndView.setViewName("redirect:/user/admin");
            }
            else if (getuser.getUsertype().equals("shopper"))
            {
                System.out.println("是shopper");
                modelAndView.addObject(getuser.getUsername());
                modelAndView.setViewName("redirect:/goods/shangpinguanli");
            }
            else
            {
                System.out.println("是user");
                modelAndView.setViewName("redirect:/goods/shangcheng");
            }
//            modelAndView.addObject("user",getuser);
            session.setAttribute("USER_SESSION",getuser);
            return modelAndView;
        }
        else
        {
            System.out.println("找不到用户");
//            modelAndView.setViewName("shangcheng/shangcheng");
            modelAndView.setViewName("redirect:/user/login");
            return modelAndView;
        }
    }

//    登录即时判断用户名是否合法Ajax（bug不可用）
    @ResponseBody                 //给调用者返回原始数据
    @RequestMapping(value = "/userExistAjax",produces = {"text/html;charset=UTF-8"})
    public String userExistAjax(String username) throws UnsupportedEncodingException {
        URLDecoder.decode(username,"UTF-8");
        User user = userService.selectByUsername(username);
        if(user != null && username.equals(user.getUsername()))
            return "用户已存在！";
        else
            return "用户名可用";
    }

//    登录即时判断用户名和密码是否合法Ajax（bug不可用）
    @ResponseBody                 //给调用者返回原始数据
    @RequestMapping(value = "/userLegallyAjax",produces = {"text/html;charset=UTF-8"})
    public String userLegallyAjax(String username,String password) throws UnsupportedEncodingException {
        URLDecoder.decode(username,"UTF-8");
        URLDecoder.decode(password,"UTF-8");
        System.out.println(username);
        System.out.println(password);
        User user = userService.selectByUsername(username);
        if(user != null && username.equals(user.getUsername()))
            return "用户已存在！";
        else if(username.length()>20||username.length()<5||password.length()>20||password.length()<5)
            return "用户名或密码长度不符合规范！";
        else
            return "用户名可用";
    }
}
