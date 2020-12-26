package vip.epss.dao;

import vip.epss.domain.Gouwuche;

import java.util.List;

public interface GouwucheMapper {
    //根据传入的用户对象,向数据库插入一条记录
    public Integer insert(Gouwuche Gouwuche);
    //删除记录,根据主键uid删除一条记录
    public Integer delete(Integer gouwucheid);
    //修改记录
    public Integer update(Gouwuche Gouwuche);
    //查询所有记录
    public List<Gouwuche> selectAll();
    //查询一条记录,根据主键查询
    public Gouwuche selectByGouwucheid(Integer gouwucheid);
    //查询一条记录,根据所属用户查询
    public List<Gouwuche> selectByUid(Integer uid);
}
