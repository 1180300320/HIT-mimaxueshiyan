package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vip.epss.dao.GouwucheMapper;
import vip.epss.domain.Goods;
import vip.epss.domain.Gouwuche;
import vip.epss.service.GouwucheService;
import java.util.List;

/**
 * User的service实现类
 */
@Service(value = "gouwucheService")
public class GouwucheServiceImpl  implements GouwucheService {
    @Autowired
    private GouwucheMapper gouwucheMapper;

    @Override
    public Integer insert(Gouwuche gouwuche) {
        return gouwucheMapper.insert(gouwuche);
    }

    @Override
    public Integer delete(Integer gouwucheid) {
        return gouwucheMapper.delete(gouwucheid);
    }

    @Override
    public Integer update(Gouwuche gouwuche) {
        return gouwucheMapper.update(gouwuche);
    }

    @Override
    public Integer minus(Gouwuche gouwuche, Integer num) {
        Gouwuche getItem = gouwucheMapper.selectByGouwucheid(gouwuche.getGouwucheid());
        Integer getnum = Math.toIntExact(getItem.getItemnum());
        if(getnum - num>0)
        {
            getItem.setItemnum(getnum - num);
            return gouwucheMapper.update(getItem);
        }
        else
        {
            delete(gouwuche.getGouwucheid());
            return -1;
        }
    }

    @Override
    public Integer addgoods(Gouwuche gouwuche, Integer num) {
//        Gouwuche getItem = gouwucheMapper.selectByGouwucheid(gouwuche.getGouwucheid());
        Integer getnum = Math.toIntExact(gouwuche.getItemnum());
        gouwuche.setItemnum(getnum + num);
        return gouwucheMapper.update(gouwuche);
    }

    @Override
    public List<Gouwuche> selectAll() { return gouwucheMapper.selectAll(); }

    @Override
    public Gouwuche selectByGouwucheid(Integer gouwucheid) {
        return gouwucheMapper.selectByGouwucheid(gouwucheid);
    }

    @Override
    public List<Gouwuche> selectByUid(Integer uid) {
//        System.out.println(gouwucheMapper.selectByUid(uid));
        return gouwucheMapper.selectByUid(uid);
    }

    @Override
    public List<Gouwuche> selectByItemid(Integer itemid) {
        return gouwucheMapper.selectByItemid(itemid);
    }

    @Override
    public Gouwuche selectGouwuche(Integer itemid, Integer uid) {
        System.out.println(gouwucheMapper.selectGouwuche(itemid,uid));
        return gouwucheMapper.selectGouwuche(itemid,uid);
    }


}
