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
        goods.setId_1(IdUtil.createId(goodsId,1));
        goods.setId_2(IdUtil.createId(goodsId,2));
        goods.setId_3(IdUtil.createId(goodsId,3));
        goods.setId_4(IdUtil.createId(goodsId,4));
        goods.setId_5(IdUtil.createId(goodsId,5));
        goods.setId_6(IdUtil.createId(goodsId,6));
        goods.setId_7(IdUtil.createId(goodsId,7));
        goods.setId_8(IdUtil.createId(goodsId,8));
        goods.setId_9(IdUtil.createId(goodsId,9));
        goods.setId_10(IdUtil.createId(goodsId,10));
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
    public String getBase_type() {
        return this.base_type;
    }
    public void setBase_type(String base_type) {
        this.base_type = base_type;
    }
    public String getId_1() {
        return this.id_1;
    }
    public void setId_1(String id_1) {
        this.id_1 = id_1;
    }
    public String getId_2() {
        return this.id_2;
    }
    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }
    public String getId_3() {
        return this.id_3;
    }
    public void setId_3(String id_3) {
        this.id_3 = id_3;
    }
    public String getId_4() {
        return this.id_4;
    }
    public void setId_4(String id_4) {
        this.id_4 = id_4;
    }
    public String getId_5() {
        return this.id_5;
    }
    public void setId_5(String id_5) {
        this.id_5 = id_5;
    }
    public String getId_6() {
        return this.id_6;
    }
    public void setId_6(String id_6) {
        this.id_6 = id_6;
    }
    public String getId_7() {
        return this.id_7;
    }
    public void setId_7(String id_7) {
        this.id_7 = id_7;
    }
    public String getId_8() {
        return this.id_8;
    }
    public void setId_8(String id_8) {
        this.id_8 = id_8;
    }
    public String getId_9() {
        return this.id_9;
    }
    public void setId_9(String id_9) {
        this.id_9 = id_9;
    }
    public String getId_10() {
        return this.id_10;
    }
    public void setId_10(String id_10) {
        this.id_10 = id_10;
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
    //基础属性类型
    private String base_type;
    //词条id
    private String id_1;
    private String id_2;
    private String id_3;
    private String id_4;
    private String id_5;
    private String id_6;
    private String id_7;
    private String id_8;
    private String id_9;
    private String id_10;
    @Generated(hash = 111393729)
    public Goods(String id, int type, String name, int length, long create_time,
            String creater, String owner, int use, String base_type, String id_1,
            String id_2, String id_3, String id_4, String id_5, String id_6,
            String id_7, String id_8, String id_9, String id_10) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.length = length;
        this.create_time = create_time;
        this.creater = creater;
        this.owner = owner;
        this.use = use;
        this.base_type = base_type;
        this.id_1 = id_1;
        this.id_2 = id_2;
        this.id_3 = id_3;
        this.id_4 = id_4;
        this.id_5 = id_5;
        this.id_6 = id_6;
        this.id_7 = id_7;
        this.id_8 = id_8;
        this.id_9 = id_9;
        this.id_10 = id_10;
    }
    @Generated(hash = 1770709345)
    public Goods() {
    }
   
}
