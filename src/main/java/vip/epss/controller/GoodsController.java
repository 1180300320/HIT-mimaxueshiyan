package vip.epss.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.epss.domain.Goods;
import vip.epss.domain.Gouwuche;
import vip.epss.domain.Gouwuchexianshi;
import vip.epss.service.GoodsService;
import vip.epss.service.GouwucheService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GouwucheService gouwucheService;


//    用户从商城跳转到购物车
    @RequestMapping(value = "/gouwuche")
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

//    用户登录跳转到商城
    @RequestMapping(value = "/shangcheng")
    public ModelAndView shangcheng()
    {
        ModelAndView modelAndView = new ModelAndView("shangcheng/shangcheng");
        List<Goods> goods = goodsService.selectAll();
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

//    商家登录跳转到商品管理界面
    @RequestMapping(value = "/shangpinguanli")
    public ModelAndView shangpinguanli(@RequestParam String ownername)
    {
        ModelAndView modelAndView = new ModelAndView("shangcheng/shangpinguanli");
        List<Goods> goods = goodsService.selectByOwnername(ownername);
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

//    商家删除一个商品按钮
    @RequestMapping(value = "/deleteItem")
    public ModelAndView deleteItem(@RequestParam Integer itemid){
        goodsService.delete(itemid);
        ModelAndView modelAndView = new ModelAndView("redirect:shangpinguanli");
        return modelAndView;
    }

//    商家跳转到修改商品界面
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

//    商家修改商品方法
    @RequestMapping(value = "/xiugaishangpinshuxing")
    public ModelAndView xiugaishangpinshuxing(@RequestParam Integer itemid,@RequestParam Goods goods)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:shangcheng/shangpinguanli");
        Goods getgood = goodsService.selectByItemid(itemid);
        if(goods.getItemname() == null)
            goods.setItemname(getgood.getItemname());
        if(goods.getOwner() == null)
            goods.setOwner(getgood.getOwner());

        goodsService.update(goods);
        return modelAndView;
    }

//    从商城添加商品至购物车
    @RequestMapping(value = "/addToGouwuche")
    public ModelAndView addToGouwuche(@RequestParam Integer itemid, @RequestParam Integer uid){
        Goods getgood = goodsService.selectByItemid(itemid);
        ModelAndView modelAndView = new ModelAndView("redirect:shangcheng");
        if(gouwucheService.selectGouwuche(itemid,uid) != null)
        {
            goodsService.minus(getgood,1);
            gouwucheService.addgoods(gouwucheService.selectGouwuche(itemid,uid),1);
        }
        else
        {
            Gouwuche gouwuche =new Gouwuche(null,uid,itemid,1);
            gouwucheService.insert(gouwuche);
            goodsService.minus(getgood,1);
        }
            return modelAndView;
    }

//    购物车减少商品按钮
    @RequestMapping(value = "/minusnum")
    public ModelAndView minusnum(@RequestParam Integer uid, @RequestParam Integer gouwucheid,@RequestParam Integer num){
        Gouwuche getgouwuche = gouwucheService.selectByGouwucheid(gouwucheid);
        if(getgouwuche.getItemnum()-num > 0) {
            goodsService.addgoods(goodsService.selectByItemid(getgouwuche.getItemid()), num);
            gouwucheService.minus(getgouwuche, num);
        }
        else if(getgouwuche.getItemnum()-num == 0)
        {
            goodsService.addgoods(goodsService.selectByItemid(getgouwuche.getItemid()), num);
            gouwucheService.delete(gouwucheid);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:gouwuche?uid="+uid);
//        ModelAndView modelAndView = new ModelAndView("redirect:gouwuche");
//        modelAndView.addObject(uid);
        return modelAndView;
    }

//    购物车结算按钮
    @RequestMapping(value = "/jiesuan")
    public ModelAndView jiesuan(@RequestParam Integer gouwucheid,@RequestParam Integer num){
        Gouwuche getgouwuche = gouwucheService.selectByGouwucheid(gouwucheid);
        gouwucheService.minus(getgouwuche,num);
        ModelAndView modelAndView = new ModelAndView("redirect:goods/gouwuche");
        return modelAndView;
    }
}
