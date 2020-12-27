package vip.epss.domain;

import java.io.Serializable;

public class Gouwuchexianshi implements Serializable {
    private Integer xianshiid;
    private Integer gouwucheid;
    private Integer itemid;
    private Integer uid;
    private String itemname;
    private float itemprice;
    private String owner;
    private Integer number;

    public Gouwuchexianshi(Integer xianshiid, Integer gouwucheid,Integer itemid, Integer uid, String itemname, float itemprice, String owner, Integer number) {
        this.xianshiid = xianshiid;
        this.gouwucheid = gouwucheid;
        this.itemid = itemid;
        this.uid = uid;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.owner = owner;
        this.number = number;
    }

    public Gouwuchexianshi() {
    }

    @Override
    public String toString() {
        return "Gouwuchexianshi{" +
                "xianshiid=" + xianshiid +
                ", gouwucheid='" + gouwucheid + '\'' +
                ", itemid='" + itemid + '\'' +
                ", uid='" + uid + '\'' +
                ", itemname='" + itemname + '\'' +
                ", itemprice='" + itemprice + '\'' +
                ", owner='" + owner + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public Integer getXianshiid() {
        return xianshiid;
    }

    public void setXianshiid(Integer xianshiid) {
        this.xianshiid = xianshiid;
    }

    public Integer getGouwucheid() {
        return gouwucheid;
    }

    public void setGouwucheid(Integer gouwucheid) {
        this.gouwucheid = gouwucheid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getNumber() { return number; }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getItemprice() { return itemprice; }

    public void setItemprice(float itemprice) { this.itemprice = itemprice; }
}