package vip.epss.service;

import vip.epss.domain.Gouwuche;

import java.util.List;

public interface GouwucheService {
    //根据传入的用户对象,向数据库插入一条记录
    public Integer insert(Gouwuche gouwuche);
    //删除记录,根据主键uid删除一条记录
    public Integer delete(Integer gouwucheid);
    //修改记录
    public Integer update(Gouwuche gouwuche);
//    卖出操作，商品数减少
    public Integer minus(Gouwuche gouwuche,Integer num);
    //增加商品（进货）
//    public Integer addgoods(Gouwuche gouwuche,Integer num);
    //查询所有记录
    public List<Gouwuche> selectAll();
    //查询一条记录,根据主键查询
    public Gouwuche selectByGouwucheid(Integer gouwucheid);
    //查询一条记录,根据所属商家查询
    public List<Gouwuche> selectByUid(Integer uid);
}