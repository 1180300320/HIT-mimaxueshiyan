package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.epss.domain.User;
import vip.epss.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList")
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView("admin/userList");
        List<User> users = userService.selectAll();
        modelAndView.addObject("users",users);
        return modelAndView;
    }
    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam Integer uid){
        userService.delete(uid);
        ModelAndView modelAndView = new ModelAndView("redirect:userList");
        return modelAndView;
    }

    @RequestMapping(value = "/testParam")
    public String testParam(@RequestParam String username,@RequestParam String password){
        System.out.println(username + " - " + password);
        return "admin";//能跳转说明路由没有问题
    }
    /**
     * 如果传递的数据很多,每个字段获取会非常麻烦,可以考虑封装为对象处理
     */
    @RequestMapping(value = "/testObject")
    public String testObject(User user){
        System.out.println(user);
        return "admin";//能跳转说明路由没有问题
    }

    @RequestMapping(value = "/testServletObject")
    public String testServletObject(){
        return "admin";//能跳转说明路由没有问题
    }
}
