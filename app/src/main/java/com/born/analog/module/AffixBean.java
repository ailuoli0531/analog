package com.born.analog.module;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * created by born on 2018/12/10.
 */
@Entity
public class AffixBean {
    //唯一id 生成规则：goodsId+"_"+position
    @Unique
    private String id;
    //属性代号
    private String tag;
    //属性名
    private String name;
    //值类型
    private int type;
    //值
    private int space;
    //在词条中的位置
    private int position;
    //所属装备id
    private String goodsId;
    @Generated(hash = 639474552)
    public AffixBean(String id, String tag, String name, int type, int space,
            int position, String goodsId) {
        this.id = id;
        this.tag = tag;
        this.name = name;
        this.type = type;
        this.space = space;
        this.position = position;
        this.goodsId = goodsId;
    }
    @Generated(hash = 1485004947)
    public AffixBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTag() {
        return this.tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getSpace() {
        return this.space;
    }
    public void setSpace(int space) {
        this.space = space;
    }
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public String getGoodsId() {
        return this.goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
