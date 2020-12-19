package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.epss.service.UserService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/gouwuche")
    public String gouwuche(){
        return "shangcheng/gouwuche";
    }

    @RequestMapping(value = "/shangcheng")
    public String shangcheng(){
        return "shangcheng/shangcheng";
    }

    @RequestMapping(value = "/shangpinguanli")
    public String shangpinguanli(){
        return "shangcheng/shangpinguanli";
    }


}
