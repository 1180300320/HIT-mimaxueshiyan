package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.GoodsMapper;
import vip.epss.domain.Goods;
import vip.epss.domain.User;
import vip.epss.service.GoodsService;

import java.util.List;

@Service(value = "goodsService")
public class GoodsServiceImpl  implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Integer delete(Integer itemid) {
        return goodsMapper.delete(itemid);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public Integer minus(Goods goods, Integer num) {
        Goods getItem = goodsMapper.selectByItemid(goods.getItemid());
        Integer getnum = Math.toIntExact(getItem.getNumber());
        if(getnum - num>=0)
        {
            getItem.setNumber(getnum - num);
            return goodsMapper.update(getItem);
        }
        else
        {
            delete(goods.getItemid());
            return -1;
        }
    }

    @Override
    public Integer addgoods(Goods goods, Integer num) {
        Goods getItem = goodsMapper.selectByItemid(goods.getItemid());
        Integer getnum = Math.toIntExact(getItem.getNumber());
        getItem.setNumber(getnum + num);
        return goodsMapper.update(getItem);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public Goods selectByItemid(Integer itemid) {
        return goodsMapper.selectByItemid(itemid);
    }

    @Override
    public List<Goods> selectByOwnername(String owner) {
        return goodsMapper.selectByOwnername(owner);
    }
}