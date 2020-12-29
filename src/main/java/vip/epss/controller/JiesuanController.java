package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vip.epss.domain.Goods;
import vip.epss.domain.Gouwuche;
import vip.epss.domain.Gouwuchexianshi;
import vip.epss.service.GoodsService;
import vip.epss.service.GouwucheService;
import vip.epss.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jiesuan")
public class JiesuanController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GouwucheService gouwucheService;
    @Autowired
    private UserService userService;

//    显示结算界面的信息
    @RequestMapping(value = "/jiesuanjiemian")
    public ModelAndView gouwuche(Integer uid){
        ModelAndView modelAndView = new ModelAndView("shangcheng/gouwuche");
        List<Gouwuche> gouwuche = gouwucheService.selectByUid(uid);
        List<Goods> goods = new ArrayList<>();
        List<Gouwuchexianshi> gouwuchexianshi = new ArrayList<>();
        Goods tempgood = new Goods();
        for(Gouwuche a : gouwuche)
        {
//            goods.add(goodsService.selectByItemid(a.getItemid()));
            tempgood = goodsService.selectByItemid(a.getItemid());
            gouwuchexianshi.add(new Gouwuchexianshi(null,a.getGouwucheid(),a.getItemid(),a.getUid(),tempgood.getItemname(),tempgood.getItemprice(),tempgood.getOwner(), a.getItemnum()));
        }

        modelAndView.addObject("gouwuchexianshi",gouwuchexianshi);
        return modelAndView;
    }
    @RequestMapping(value = "/tijiaoyinhang")
    public ModelAndView gouwuche(Integer uid ,float num)
    {
        System.out.println(uid);
        System.out.println(num);
        String herf="http://172.20.85.224:8080/mall_pay/?";
        Date date=new Date();
        long time=date.getTime();
        String parameter="uid="+"1"+"&card="+"2"+"&amount="+num;
//        ModelAndView modelAndView = new ModelAndView("shangcheng/gouwuche?dingdanhao="+ dingdanhao +"&money="+money+"shangjiaid=2");
        ModelAndView modelAndView = new ModelAndView("redirect:" + herf + parameter);
//        ModelAndView modelAndView = new ModelAndView("redirect:http://172.20.114.172:8080/ceshi2_war_exploded/");
//        ModelAndView modelAndView = new ModelAndView("redirect:http://172.20.85.224:8080/mall_pay/?uid=1&card=2&amount=20");

        return modelAndView;
        //http://172.20.112.209:8001/herf?parameter=订单号===价格*100===2
    }
}

