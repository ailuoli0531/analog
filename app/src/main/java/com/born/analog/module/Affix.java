package com.born.analog.module;

/**
 * created by born on 2018/12/10.
 */
public class Affix {
    private long id;
    private String name;
    private int space;
    /**
     * 0 默认最大最小
     * 1 ?
     * 2 固定百分比
     * 3 百分比最大最小
     */
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

}
