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
        goods.setId_one(IdUtil.createId(goodsId,"one"));
        goods.setId_two(IdUtil.createId(goodsId,"two"));
        goods.setId_three(IdUtil.createId(goodsId,"three"));
        goods.setId_four(IdUtil.createId(goodsId,"four"));
        goods.setId_five(IdUtil.createId(goodsId,"five"));
        goods.setId_six(IdUtil.createId(goodsId,"six"));
        goods.setId_seven(IdUtil.createId(goodsId,"seven"));
        goods.setId_eight(IdUtil.createId(goodsId,"eight"));
        goods.setId_nine(IdUtil.createId(goodsId,"nine"));
        goods.setId_ten(IdUtil.createId(goodsId,"ten"));
        return goods;
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
    //基础属性类型
    private String base_type;
    //词条id
    private String id_one;
    private String id_two;
    private String id_three;
    private String id_four;
    private String id_five;
    private String id_six;
    private String id_seven;
    private String id_eight;
    private String id_nine;
    private String id_ten;
    @Generated(hash = 1314041761)
    public Goods(String id, int type, String name, int length, long create_time,
            String creater, String owner, String base_type, String id_one,
            String id_two, String id_three, String id_four, String id_five,
            String id_six, String id_seven, String id_eight, String id_nine,
            String id_ten) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.length = length;
        this.create_time = create_time;
        this.creater = creater;
        this.owner = owner;
        this.base_type = base_type;
        this.id_one = id_one;
        this.id_two = id_two;
        this.id_three = id_three;
        this.id_four = id_four;
        this.id_five = id_five;
        this.id_six = id_six;
        this.id_seven = id_seven;
        this.id_eight = id_eight;
        this.id_nine = id_nine;
        this.id_ten = id_ten;
    }
    @Generated(hash = 1770709345)
    public Goods() {
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
    public String getBase_type() {
        return this.base_type;
    }
    public void setBase_type(String base_type) {
        this.base_type = base_type;
    }
    public String getId_one() {
        return this.id_one;
    }
    public void setId_one(String id_one) {
        this.id_one = id_one;
    }
    public String getId_two() {
        return this.id_two;
    }
    public void setId_two(String id_two) {
        this.id_two = id_two;
    }
    public String getId_three() {
        return this.id_three;
    }
    public void setId_three(String id_three) {
        this.id_three = id_three;
    }
    public String getId_four() {
        return this.id_four;
    }
    public void setId_four(String id_four) {
        this.id_four = id_four;
    }
    public String getId_five() {
        return this.id_five;
    }
    public void setId_five(String id_five) {
        this.id_five = id_five;
    }
    public String getId_six() {
        return this.id_six;
    }
    public void setId_six(String id_six) {
        this.id_six = id_six;
    }
    public String getId_seven() {
        return this.id_seven;
    }
    public void setId_seven(String id_seven) {
        this.id_seven = id_seven;
    }
    public String getId_eight() {
        return this.id_eight;
    }
    public void setId_eight(String id_eight) {
        this.id_eight = id_eight;
    }
    public String getId_nine() {
        return this.id_nine;
    }
    public void setId_nine(String id_nine) {
        this.id_nine = id_nine;
    }
    public String getId_ten() {
        return this.id_ten;
    }
    public void setId_ten(String id_ten) {
        this.id_ten = id_ten;
    }

}
