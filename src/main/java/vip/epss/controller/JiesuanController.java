package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.epss.service.GoodsService;
import vip.epss.service.GouwucheService;
import vip.epss.service.UserService;

@Controller
@RequestMapping("/jiesuan")
public class JiesuanController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GouwucheService gouwucheService;
    @Autowired
    private UserService userService;


}
