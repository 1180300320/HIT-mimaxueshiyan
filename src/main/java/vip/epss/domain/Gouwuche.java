package vip.epss.domain;

import java.io.Serializable;

public class Gouwuche implements Serializable {
    private Integer gouwucheid;
    private Integer uid;
    private Integer itemid;
    private Integer itemnum;

    public Gouwuche(Integer gouwucheid,Integer uid,Integer itemid,Integer itemnum) {
        this.gouwucheid = gouwucheid;
        this.uid = uid;
        this.itemid = itemid;
        this.itemnum = itemnum;
    }

    public Gouwuche() {
    }

    @Override
    public String toString() {
        return "Gouwuche{" +
                "gouwucheid=" + gouwucheid +
                ", uid='" + uid + '\'' +
                ", itemid='" + itemid + '\'' +
                ", itemnum='" + itemnum + '\'' +
                '}';
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getGouwucheid() {
        return gouwucheid;
    }

    public void setGouwucheid(Integer gouwucheid) {
        this.gouwucheid = gouwucheid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getItemnum() { return itemnum; }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }


}