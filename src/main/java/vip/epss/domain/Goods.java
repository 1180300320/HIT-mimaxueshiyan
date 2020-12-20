package vip.epss.domain;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer itemid;
    private String itemname;
    private String owner;
    private long number;

    public Goods(Integer itemid, String itemname, String owner, long number) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.owner = owner;
        this.number = number;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "User{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                ", owner='" + owner + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
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

    public void setNumber(long number) {
        this.number = number;
    }
}