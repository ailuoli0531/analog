package com.born.analog.module;

import com.born.analog.util.IdUtil;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * created by born on 2018/12/13.
 */
@Entity
public class Goods {

    public static Goods create(int type){
        Goods goods = new Goods();
        String goodsId = IdUtil.createId(type);
        goods.setType(type);
        goods.setId(goodsId);

        return goods;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return this.length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public long getCreate_time() {
        return this.create_time;
    }
    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }
    public String getCreater() {
        return this.creater;
    }
    public void setCreater(String creater) {
        this.creater = creater;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getUse() {
        return this.use;
    }
    public void setUse(int use) {
        this.use = use;
    }
    public int getBase_type() {
        return this.base_type;
    }
    public void setBase_type(int base_type) {
        this.base_type = base_type;
    }
    public String getBase_name() {
        return this.base_name;
    }
    public void setBase_name(String base_name) {
        this.base_name = base_name;
    }
    public int getBase_minNumber() {
        return this.base_minNumber;
    }
    public void setBase_minNumber(int base_minNumber) {
        this.base_minNumber = base_minNumber;
    }
    public int getBase_maxNumber() {
        return this.base_maxNumber;
    }
    public void setBase_maxNumber(int base_maxNumber) {
        this.base_maxNumber = base_maxNumber;
    }
    public int getBase_number() {
        return this.base_number;
    }
    public void setBase_number(int base_number) {
        this.base_number = base_number;
    }
    public int getBase_space() {
        return this.base_space;
    }
    public void setBase_space(int base_space) {
        this.base_space = base_space;
    }
    public int getBase_minSpace() {
        return this.base_minSpace;
    }
    public void setBase_minSpace(int base_minSpace) {
        this.base_minSpace = base_minSpace;
    }
    public int getBase_maxSpace() {
        return this.base_maxSpace;
    }
    public void setBase_maxSpace(int base_maxSpace) {
        this.base_maxSpace = base_maxSpace;
    }

    //唯一id
    @Unique
    private String id;
    //类型
    private int type;
    //名称
    private String name;
    //词条个数
    private int length;
    //生成时间
    private long create_time;
    //缔造者
    private String creater;
    //拥有者
    private String owner;
    //是否正在穿戴 0未穿戴 1穿戴，同类型只能穿戴一条
    private int use;

    /**固定属性描述
     * 0 最大最小
     * 1 固定值
     * 2 固定百分比
     * 3 百分比最大最小
     */
    //基础属性类型
    private int base_type;
    //基础属性描述
    private String base_name;
    //基础属性值
    private int base_minNumber;
    private int base_maxNumber;
    private int base_number;
    private int base_space;
    private int base_minSpace;
    private int base_maxSpace;
    @Generated(hash = 383150824)
    public Goods(String id, int type, String name, int length, long create_time,
            String creater, String owner, int use, int base_type, String base_name,
            int base_minNumber, int base_maxNumber, int base_number, int base_space,
            int base_minSpace, int base_maxSpace) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.length = length;
        this.create_time = create_time;
        this.creater = creater;
        this.owner = owner;
        this.use = use;
        this.base_type = base_type;
        this.base_name = base_name;
        this.base_minNumber = base_minNumber;
        this.base_maxNumber = base_maxNumber;
        this.base_number = base_number;
        this.base_space = base_space;
        this.base_minSpace = base_minSpace;
        this.base_maxSpace = base_maxSpace;
    }
    @Generated(hash = 1770709345)
    public Goods() {
    }

}
