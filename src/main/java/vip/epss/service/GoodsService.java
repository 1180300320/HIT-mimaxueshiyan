package vip.epss.service;

import vip.epss.domain.Goods;

import java.util.List;

public interface GoodsService {
    //根据传入的用户对象,向数据库插入一条记录
    public Integer insert(Goods goods);
    //删除记录,根据主键uid删除一条记录
    public Integer delete(Integer itemid);
    //修改记录
    public Integer update(Goods goods);
    //卖出操作，商品数减少
    public Integer minus(Goods goods,Integer num);
    //增加商品（进货）
    public Integer addgoods(Goods goods,Integer num);
    //查询所有记录
    public List<Goods> selectAll();
    //查询一条记录,根据主键查询
    public Goods selectByItemid(Integer itemid);
    //查询一条记录,根据所属商家查询
    public Goods selectByOwnername(String owner);
}
