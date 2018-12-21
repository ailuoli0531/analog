package com.born.analog.module;

/**
 * created by born on 2018/12/10.
 */
public class Affix {

    //单值
    public static final int TYPE_NORMAL = 0;
    //百分值
    public static final int TYPE_PERCENT = 1;
    //固定描述
    public static final int TYPE_FINAL = 2;
    //百分比最大最小
    public static final int TYPE_MIN_MAX = 3;

    private long id;
    private String name;
    private int space;
    private int type;
    private int minSpace;
    private int maxSpace;
    /**
     * 概率 万分比 不写则表示普通 概率均分
     */
    private int pro;
    /**
     * 最多出现次数
     */
    private int maxPro;
    /**
     * 属性识别码
     */
    private String Tag;
    /**
     * 属性描述
     */
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMinSpace() {
        return minSpace;
    }

    public void setMinSpace(int minSpace) {
        this.minSpace = minSpace;
    }

    public int getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(int maxSpace) {
        this.maxSpace = maxSpace;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public int getMaxPro() {
        return maxPro;
    }

    public void setMaxPro(int maxPro) {
        this.maxPro = maxPro;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
