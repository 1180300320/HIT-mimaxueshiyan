package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.epss.domain.Goods;
import vip.epss.domain.Gouwuche;
import vip.epss.service.GoodsService;
import vip.epss.service.GouwucheService;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GouwucheService gouwucheService;


    @RequestMapping(value = "/gouwuche")
    public ModelAndView gouwuche(Integer uid){
        ModelAndView modelAndView = new ModelAndView("shangcheng/gouwuche");
        System.out.println(uid);
        List<Gouwuche> gouwuche = gouwucheService.selectByUid(uid);
        System.out.println(gouwuche);
        List<Goods> goods = null;
        for(Gouwuche a : gouwuche)
        {
            goods.add(goodsService.selectByItemid(a.getItemid()));
        }
        modelAndView.addObject("goods",goods);
        modelAndView.addObject("gouwuche",gouwuche);
        System.out.println(goods);
//        System.out.println(gouwuche);
        return modelAndView;
    }

    @RequestMapping(value = "/shangcheng")
    public ModelAndView shangcheng()
    {
        ModelAndView modelAndView = new ModelAndView("shangcheng/shangcheng");
        List<Goods> goods = goodsService.selectAll();
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

    @RequestMapping(value = "/shangpinguanli")
    public ModelAndView shangpinguanli()
    {
        ModelAndView modelAndView = new ModelAndView("shangcheng/shangpinguanli");
        List<Goods> goods = goodsService.selectAll();
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

    @RequestMapping(value = "/xiugaishangpin")
    public ModelAndView xiugaishangpin(@RequestParam Integer itemid)
    {
        ModelAndView modelAndView = new ModelAndView();
        Goods goods = goodsService.selectByItemid(itemid);
        if(goods!=null)
        {
            modelAndView.addObject("goods",goods);
            modelAndView.setViewName("shangcheng/xiugaishangpin");
            return modelAndView;
        }
        else
        {
            modelAndView.setViewName("shangcheng/shangpinguanli");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/xiugaishangpinshuxing")
    public ModelAndView xiugaishangpinshuxing(@RequestParam Goods goods)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:shangcheng/shangpinguanli");
        goodsService.update(goods);
        return modelAndView;
    }

    @RequestMapping(value = "/addToGouwuche")
    public ModelAndView addToGouwuche(@RequestParam Integer itemid){
        Goods getgood = goodsService.selectByItemid(itemid);
        ModelAndView modelAndView = new ModelAndView("redirect:shangcheng");
        return modelAndView;
    }

    @RequestMapping(value = "/minusnum")
    public ModelAndView minusnum(@RequestParam Integer gouwucheid,@RequestParam Integer num){
        Gouwuche getgouwuche = gouwucheService.selectByGouwucheid(gouwucheid);
        gouwucheService.minus(getgouwuche,num);
        ModelAndView modelAndView = new ModelAndView("redirect:goods/gouwuche");
        return modelAndView;
    }

    @RequestMapping(value = "/jiesuan")
    public ModelAndView jiesuan(@RequestParam Integer gouwucheid,@RequestParam Integer num){
        Gouwuche getgouwuche = gouwucheService.selectByGouwucheid(gouwucheid);
        gouwucheService.minus(getgouwuche,num);
        ModelAndView modelAndView = new ModelAndView("redirect:goods/gouwuche");
        return modelAndView;
    }
}
