package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.windows.WPrinterJob;
import vip.epss.domain.User;
import vip.epss.service.UserService;

import java.util.List;

/**
 * User的控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/login")
    public String login(){

        return "user/login";
    }

    @RequestMapping(value = "/register")
    public String register(){

        return "user/register";
    }

    @RequestMapping(value = "/admin")
    public String admin(){

        return "admin/admin";
    }

    @RequestMapping(value = "/shop")
    public String shop(){

        return "shangcheng/shangcheng";
    }

    @RequestMapping(value = "/logout")
    public String logout(){

        return "index";
    }

    @RequestMapping(value = "/addForm")
    public String addForm(){
        return "user/addForm";
    }
//不会正确跳转到带内容的user list++++++++++++++++++++++++++++++++++++++++++++++++++
    @RequestMapping(value = "/add")
    public ModelAndView add(User user){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/userList");
        System.out.println(user);
        userService.insert(user);
        return modelAndView;
    }
    @RequestMapping(value = "/logincompare")
    public ModelAndView compare(User user){
        ModelAndView modelAndView = new ModelAndView();
//        System.out.println(user);
        User getuser = userService.selectByUsername(user.getUsername());
        System.out.println(getuser);
        if(getuser == null)
        {
            System.out.println("没找到");
            modelAndView.setViewName("shangcheng/shangcheng");
            return modelAndView;
        }
        if(getuser.getUsername().equals(user.getUsername()) && getuser.getPassword().equals(user.getPassword()))
        {
            System.out.println("密码对");
            if(getuser.getUsertype().equals("admin"))
            {
                System.out.println("是admin");
                modelAndView.setViewName("user/admin");
            }
            else if (getuser.getUsertype().equals("shopper"))
            {
                System.out.println("是shopper");
                modelAndView.setViewName("shangcheng/shangpinguanli");
            }
            else
            {
                System.out.println("是user");
                modelAndView.setViewName("shangcheng/shangcheng");
            }
            modelAndView.addObject(getuser);
            return modelAndView;
        }
        else
        {
            System.out.println("密码不对");
            modelAndView.setViewName("shangcheng/shangcheng");
            return modelAndView;
        }
    }
}
