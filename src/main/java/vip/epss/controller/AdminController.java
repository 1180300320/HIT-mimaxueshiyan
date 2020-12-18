package vip.epss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
