package com.born.analog.util;

import com.born.analog.module.Goods;

/**
 * created by born on 2018/12/13.
 */
public class IdUtil {
    /**
     * 创建一个唯一Id
     * type 是Goods的type
     * @return
     */
    public static String createId(int type){
        long cur = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(type);
        sb.append("_");
        sb.append(cur);
        return sb.toString();
    }


    /**
     * 根据goods的ID创建内部的每个词条Id
     * @param goodsId
     * @param location
     * @return
     */
    public static String createId(String goodsId,String location){
        StringBuilder sb = new StringBuilder(location);
        sb.append(goodsId);
        return sb.toString();
    }
}
