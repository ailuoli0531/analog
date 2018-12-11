package com.born.analog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by born on 2018/12/10.
 * 概率控制
 */
public class Helper {
    /**
     * 7条词条的概率 千分比 下同
     */
    private static int Pro_7 = 1;
    /**
     * 6条词条的概率
     */
    private static int Pro_6 = 10;
    /**
     * 5条词条的概率
     */
    private static int Pro_5 = 100;

    /**
     * 生成min-max并包含 int整数
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min,int max){
        Random random = new Random();
        int randNum = random.nextInt(max-min+1) + min;
        return randNum;
    }

    /**
     * 随机生成的额外词条长度
     * @return
     */
    public static int getLength(){
        int cur = getRandom(1,1000);
        if(cur<=Pro_7){
            return 7-3;
        }else if(cur<=(Pro_7+Pro_6)){
            return 6-3;
        }else if(cur<=(Pro_7+Pro_6+Pro_5)){
            return 5-3;
        }else{
            return 4-3;
        }
    }

    /**
     * 获取下一条词条
     * type 装备类型
     * @return
     */
    public static AffixBean getAffixBean(List<AffixBean> affixBeanList,int type){
        if(type==0){
            //武器
            return getAffixBeanWeapon(affixBeanList);
        }
        return null;
    }

    /**
     * 根据已有词缀生成下一条词缀
     * @param affixBeanList
     * @return
     */
    public static AffixBean getAffixBeanWeapon(List<AffixBean> affixBeanList){
        List<Affix> wepon = new ArrayList<>(AnaLog.Affix_Weapon);

        dealList(affixBeanList, wepon);
        //过滤完后，获取总概率值
        int totalPro = getTotalPro(wepon);
        //生成范围内随机值
        int curPro = getRandom(1,totalPro);
        //获取当前词条
        Affix affix = getAffixByNum(wepon,curPro);
        //生成装备词缀
        return createAffixBean(affix);
    }

    /**
     * 处理一下集合数据
     * @param affixBeanList
     * @param affixList
     */
    private static void dealList(List<AffixBean> affixBeanList, List<Affix> affixList) {
        for(AffixBean affixBean : affixBeanList){
            //存在哪个，哪个的概率就减少1/N
            Affix affix = getAffixByName(affixBean.getName(),affixList);
            int maxPro = affix.getMaxPro()-1;
            if(maxPro<=0){
                //已经超过最大出现次数，移除掉
                affixList.remove(affix);
            }else{
                int pro = affix.getPro()-(affix.getPro()/affix.getMaxPro());
                affix.setPro(pro);
                affix.setMaxPro(maxPro);
            }
        }
    }

    /**
     * 根据词条 生成当前的词缀
     * @param affix
     * @return
     */
    public static AffixBean createAffixBean(Affix affix){
        AffixBean affixBean = new AffixBean();
        affixBean.setName(affix.getName());
        affixBean.setType(affix.getType());
        int type = affix.getType();
        if(type==0 || type==3){
            //大小值或百分比最大最小
            int num = getRandom(affix.getMinSpace(),affix.getMaxSpace());
            affixBean.setSpace(num);
        }else if(type==1){
            //没有
        }else if(type==2){
            //固定百分比
            affixBean.setSpace(affix.getSpace());
        }
        return affixBean;
    }

    /**
     * 通过生成的随机值，获取当前的词条
     * @param affixList
     * @param cur
     * @return
     */
    private static Affix getAffixByNum(List<Affix> affixList,int cur){
        int length=0;
        for(Affix affix : affixList){
            length +=affix.getPro();
            if(cur<=length){
                return affix;
            }
        }
        return null;
    }

    /**
     * 通过名字查找词条
     * @param name
     * @return
     */
    public static Affix getAffixByName(String name){
        for(Affix affix : AnaLog.AffixList){
            if(affix.getName().equals(name)){
                return affix;
            }
        }
        return null;
    }

    /**
     * 通过名字查找词条
     * @param name
     * @return
     */
    public static Affix getAffixByName(String name,List<Affix> affixList){
        for(Affix affix : affixList){
            if(affix.getName().equals(name)){
                return affix;
            }
        }
        return null;
    }

    /**
     * 获取总概率值
     * @param affixList
     * @return
     */
    public static int getTotalPro(List<Affix> affixList){
        int total = 0;
        for(Affix affix : affixList){
            total+=affix.getPro();
        }
        return total;
    }
}
