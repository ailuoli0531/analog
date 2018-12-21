package com.born.analog.manager;

import com.born.analog.AnaLogTag;
import com.born.analog.Helper;
import com.born.analog.dao.DaoHelper;
import com.born.analog.dao.GoodsDao;
import com.born.analog.module.Affix;
import com.born.analog.module.AffixBean;
import com.born.analog.module.Goods;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * created by born on 2018/12/14.
 */
public class DbGoodsManager {
    private static DbGoodsManager manager;
    private static GoodsDao goodsDao;
    public static DbGoodsManager getInstance(){
        if(manager==null){
            manager = new DbGoodsManager();
        }
        if(goodsDao==null){
            goodsDao = DaoHelper.getInstance().getSession().getGoodsDao();
        }

        return manager;
    }

    /**
     * 通过type 查询 goods结合
     * @param type
     * @return
     */
    public List<Goods> getGoodsByType(int type){
        WhereCondition wc = GoodsDao.Properties.Type.eq(type);
        return goodsDao.queryBuilder().where(wc).list();
    }

    /**
     * 通过唯一ID 查询goods
     * @param goodId
     * @return
     */
    public Goods getGoodsById(String goodId){
        WhereCondition wc = GoodsDao.Properties.Id.eq(goodId);
        return goodsDao.queryBuilder().where(wc).unique();
    }

    /**
     * 入库
     * @param goods
     */
    public long insert(Goods goods){
        return goodsDao.insertOrReplace(goods);
    }

    /**
     * 入库
     * @param goodsList
     */
    public void insert(List<Goods> goodsList){
         goodsDao.insertOrReplaceInTx(goodsList);
    }

    /**
     * 创建新装备，并入库
     * @param type
     * @return
     */
    public Goods createGoods(int type){
        Goods goods = Goods.create(type);
        if(type == 0){
            createWeapon(goods);
        }else if(type==1){
            createArmour(goods);
        }else if(type==2){
            createHand(goods);
        }else if(type==3){
            createShoes(goods);
        }else if(type==4){
            createNecklace(goods);
        }
        insert(goods);
        return goods;
    }

    /**
     * 武器
     * @param goods
     */
    public void createWeapon(Goods goods){
        goods.setName("四象灭魔刀 + "+getGoodsByType(goods.getType()).size());
        goods.setLength(Helper.getLength());
        goods.setBase_type(Affix.TYPE_MIN_MAX);
        goods.setBase_name(AnaLogTag.MIN_MAX_A);
        goods.setBase_minNumber(1000);
        goods.setBase_maxNumber(2000);
        AffixBean bean1 = Helper.createAffixBean(goods.getId(),0,Helper.getAffixByTAG(AnaLogTag.POWER));
        AffixBean bean2 = Helper.createAffixBean(goods.getId(),1,Helper.getAffixByTAG(AnaLogTag.SPEED));
        AffixBean bean3 = Helper.createAffixBean(goods.getId(),2,Helper.getAffixByTAG(AnaLogTag.MAX_A_P));
        DbAffixManager.getInstance().insert(bean1);
        DbAffixManager.getInstance().insert(bean2);
        DbAffixManager.getInstance().insert(bean3);

        List<AffixBean> affixBeanList = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeanList);
    }



    /**
     * 护甲
     * @param goods
     */
    public void createArmour(Goods goods){
        goods.setName("四象护甲 + "+getGoodsByType(goods.getType()).size());
        goods.setLength(Helper.getLength());
        goods.setBase_type(Affix.TYPE_NORMAL);
        goods.setBase_name(AnaLogTag.DEF);
        goods.setBase_number(1000);
        AffixBean bean1 = Helper.createAffixBean(goods.getId(),0,Helper.getAffixByTAG(AnaLogTag.BLOOD));
        AffixBean bean2 = Helper.createAffixBean(goods.getId(),1,Helper.getAffixByTAG(AnaLogTag.CRIT_T));
        AffixBean bean3 = Helper.createAffixBean(goods.getId(),2,Helper.getAffixByTAG(AnaLogTag.DEF));
        DbAffixManager.getInstance().insert(bean1);
        DbAffixManager.getInstance().insert(bean2);
        DbAffixManager.getInstance().insert(bean3);

        List<AffixBean> affixBeanList = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeanList);
    }

    /**
     * 护甲
     * @param goods
     */
    public void createHand(Goods goods){
        goods.setName("四象护手 + "+getGoodsByType(goods.getType()).size());
        goods.setLength(Helper.getLength());
        goods.setBase_type(Affix.TYPE_NORMAL);
        goods.setBase_name(AnaLogTag.BLOOD);
        goods.setBase_number(1000);
        AffixBean bean1 = Helper.createAffixBean(goods.getId(),0,Helper.getAffixByTAG(AnaLogTag.AGI));
        AffixBean bean2 = Helper.createAffixBean(goods.getId(),1,Helper.getAffixByTAG(AnaLogTag.POWER));
        AffixBean bean3 = Helper.createAffixBean(goods.getId(),2,Helper.getAffixByTAG(AnaLogTag.ACC));
        DbAffixManager.getInstance().insert(bean1);
        DbAffixManager.getInstance().insert(bean2);
        DbAffixManager.getInstance().insert(bean3);

        List<AffixBean> affixBeanList = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeanList);
    }

    /**
     * 护甲
     * @param goods
     */
    public void createShoes(Goods goods){
        goods.setName("四象足具 + "+getGoodsByType(goods.getType()).size());
        goods.setLength(Helper.getLength());
        goods.setBase_type(Affix.TYPE_NORMAL);
        goods.setBase_name(AnaLogTag.DEF);
        goods.setBase_number(500);
        AffixBean bean1 = Helper.createAffixBean(goods.getId(),0,Helper.getAffixByTAG(AnaLogTag.AGI));
        AffixBean bean2 = Helper.createAffixBean(goods.getId(),1,Helper.getAffixByTAG(AnaLogTag.BLOOD));
        AffixBean bean3 = Helper.createAffixBean(goods.getId(),2,Helper.getAffixByTAG(AnaLogTag.ELU));
        DbAffixManager.getInstance().insert(bean1);
        DbAffixManager.getInstance().insert(bean2);
        DbAffixManager.getInstance().insert(bean3);

        List<AffixBean> affixBeanList = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeanList);
    }

    /**
     * 护甲
     * @param goods
     */
    public void createNecklace(Goods goods){
        goods.setName("四象项链 + "+getGoodsByType(goods.getType()).size());
        goods.setBase_type(Affix.TYPE_NORMAL);
        goods.setBase_name(AnaLogTag.CRIT);
        goods.setBase_number(500);
        goods.setLength(Helper.getLength());
        AffixBean bean1 = Helper.createAffixBean(goods.getId(),0,Helper.getAffixByTAG(AnaLogTag.AGI));
        AffixBean bean2 = Helper.createAffixBean(goods.getId(),1,Helper.getAffixByTAG(AnaLogTag.POWER));
        AffixBean bean3 = Helper.createAffixBean(goods.getId(),2,Helper.getAffixByTAG(AnaLogTag.CRIT));
        DbAffixManager.getInstance().insert(bean1);
        DbAffixManager.getInstance().insert(bean2);
        DbAffixManager.getInstance().insert(bean3);

        List<AffixBean> affixBeanList = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeanList);
    }

    /**
     * 穿戴这条装备，同类型只能装备一条
     * @param goods
     * @return
     */
    public void useGoods(Goods goods){
        goods.setUse(1);
        WhereCondition wc = GoodsDao.Properties.Use.eq(1);
        WhereCondition wc2 = GoodsDao.Properties.Type.eq(goods.getType());
        List<Goods> goodsList = goodsDao.queryBuilder().where(wc,wc2).list();
        if(goodsList!=null && !goodsList.isEmpty()){
            for(Goods g : goodsList){
                g.setUse(0);
            }
        }
        insert(goodsList);
        insert(goods);
    }
}
