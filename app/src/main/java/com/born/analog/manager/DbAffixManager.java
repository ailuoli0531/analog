package com.born.analog.manager;

import com.born.analog.Helper;
import com.born.analog.dao.AffixBeanDao;
import com.born.analog.dao.DaoHelper;
import com.born.analog.module.Affix;
import com.born.analog.module.AffixBean;
import com.born.analog.module.Goods;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * created by born on 2018/12/14.
 * 词条库管理
 */
public class DbAffixManager {
    private static DbAffixManager manager;
    private static AffixBeanDao affixBeanDao;

    public static DbAffixManager getInstance() {
        if (manager == null) {
            manager = new DbAffixManager();
        }
        if (affixBeanDao == null) {
            affixBeanDao = DaoHelper.getInstance().getSession().getAffixBeanDao();
        }

        return manager;
    }

    /***
     * @param affixId
     * @return
     */
    public AffixBean getAffixById(String affixId) {
        WhereCondition wc = AffixBeanDao.Properties.Id.eq(affixId);
        return affixBeanDao.queryBuilder().where(wc).unique();
    }

    /**
     * 通过装备id查询词条列表
     *
     * @param goodsId
     * @return
     */
    public List<AffixBean> getAffixListByGoodsId(String goodsId) {
        Goods goods = DbGoodsManager.getInstance().getGoodsById(goodsId);
        WhereCondition wc = AffixBeanDao.Properties.GoodsId.eq(goodsId);
        WhereCondition wc2 = AffixBeanDao.Properties.Position.le(goods.getLength()+1);
        return affixBeanDao.queryBuilder().where(wc,wc2).list();
    }

    /**
     * 根据原来的词条，生成新词条
     *
     * @param goods
     * @return
     */
    public List<AffixBean> createAffixList(Goods goods) {
        List<AffixBean> affixBeanList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String affixId = Helper.buildAffixId(goods.getId(),i);
            AffixBean affixBean = DbAffixManager.getInstance().getAffixById(affixId);
            if (affixBean.getType() == Affix.TYPE_NORMAL || affixBean.getType() == Affix.TYPE_PERCENT) {
                Affix affix = Helper.getAffixByTAG(affixBean.getTag());
                affixBean.setSpace(Helper.getRandom(affix.getMinSpace(), affix.getMaxSpace()));
                affixBeanList.add(affixBean);
            } else {
                affixBeanList.add(affixBean);
            }
        }
        //从第4条开始
        for (int i = 4; i <= goods.getLength(); i++) {
            AffixBean affixBean = Helper.getAffixBean(goods.getId(), affixBeanList, goods.getType());
            DbAffixManager.getInstance().insert(affixBean);
            affixBeanList.add(affixBean);
        }
        return affixBeanList;
    }


    public void insert(List<AffixBean> affixBeanList) {
        affixBeanDao.insertOrReplaceInTx(affixBeanList);
    }

    /**
     * 新入库或替换
     *
     * @param affixBean
     * @return
     */
    public long insert(AffixBean affixBean) {
        return affixBeanDao.insertOrReplace(affixBean);
    }
}
