package com.born.analog.manager;

import com.born.analog.Helper;
import com.born.analog.dao.DaoHelper;
import com.born.analog.dao.GoodsDao;
import com.born.analog.module.AffixBean;
import com.born.analog.module.Goods;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
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
        AffixBean bean1 = Helper.createAffixBean(goods.getId_one(),Helper.getAffixByName("力量"));
        AffixBean bean2 = Helper.createAffixBean(goods.getId_two(),Helper.getAffixByName("攻速"));
        AffixBean bean3 = Helper.createAffixBean(goods.getId_three(),Helper.getAffixByName("最大攻击力提升"));
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
        AffixBean bean1 = Helper.createAffixBean(goods.getId_one(),Helper.getAffixByName("气血"));
        AffixBean bean2 = Helper.createAffixBean(goods.getId_two(),Helper.getAffixByName("暴击伤害减少"));
        AffixBean bean3 = Helper.createAffixBean(goods.getId_three(),Helper.getAffixByName("防御"));
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
        AffixBean bean1 = Helper.createAffixBean(goods.getId_one(),Helper.getAffixByName("敏捷"));
        AffixBean bean2 = Helper.createAffixBean(goods.getId_two(),Helper.getAffixByName("力量"));
        AffixBean bean3 = Helper.createAffixBean(goods.getId_three(),Helper.getAffixByName("精准"));
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
        AffixBean bean1 = Helper.createAffixBean(goods.getId_one(),Helper.getAffixByName("敏捷"));
        AffixBean bean2 = Helper.createAffixBean(goods.getId_two(),Helper.getAffixByName("气血"));
        AffixBean bean3 = Helper.createAffixBean(goods.getId_three(),Helper.getAffixByName("闪避"));
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
        goods.setLength(Helper.getLength());
        AffixBean bean1 = Helper.createAffixBean(goods.getId_one(),Helper.getAffixByName("敏捷"));
        AffixBean bean2 = Helper.createAffixBean(goods.getId_two(),Helper.getAffixByName("力量"));
        AffixBean bean3 = Helper.createAffixBean(goods.getId_three(),Helper.getAffixByName("暴击伤害增加"));
        DbAffixManager.getInstance().insert(bean1);
        DbAffixManager.getInstance().insert(bean2);
        DbAffixManager.getInstance().insert(bean3);

        List<AffixBean> affixBeanList = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeanList);
    }
}