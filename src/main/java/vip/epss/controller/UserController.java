package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/a_page")
    public String toA(){
        System.out.println("Controller工作了.....");
        return "user/a";
    }
    @RequestMapping(value = "/getUsers")
    public String getUsers(){
        List<User> users = userService.selectAll();
        for(User user:users){
            System.out.println(user);
        }
        return "user/a";
    }
}
