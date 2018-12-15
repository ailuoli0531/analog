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

    public static DbAffixManager getInstance(){
        if(manager == null){
            manager = new DbAffixManager();
        }
        if(affixBeanDao==null){
            affixBeanDao = DaoHelper.getInstance().getSession().getAffixBeanDao();
        }

        return manager;
    }

    /**
     * 通过id 获取词条
     * @param id
     * @return
     */
    public AffixBean getAffixById(String id){
        WhereCondition wc = AffixBeanDao.Properties.Id.eq(id);
        return affixBeanDao.queryBuilder().where(wc).unique();
    }

    public AffixBean createAffix(String id){
        AffixBean affixBean = new AffixBean();
        affixBean.setId(id);
        return affixBean;
    }

    /**
     * 根据原来的词条，生成新词条
     * @param goods
     * @return
     */
    public List<AffixBean> createAffixList(Goods goods){
        List<AffixBean> affixBeanList = new ArrayList<>();

        for(int i=1;i<=3;i++){
            AffixBean affixBean = null;
            if(i==1){
                affixBean = DbAffixManager.getInstance().getAffixById(goods.getId_1());
            }else if(i==2){
                affixBean = DbAffixManager.getInstance().getAffixById(goods.getId_2());
            }else if(i==3){
                affixBean = DbAffixManager.getInstance().getAffixById(goods.getId_3());
            }
            if(affixBean.getType()==0 || affixBean.getType()==3){
                Affix affix = Helper.getAffixByName(affixBean.getName());
                affixBean.setSpace(Helper.getRandom(affix.getMinSpace(),affix.getMaxSpace()));
                affixBeanList.add(affixBean);
            }else{
                affixBeanList.add(affixBean);
            }
        }

        for(int i=1;i<=goods.getLength();i++){
            if(i==1){
                AffixBean affixBean = Helper.getAffixBean(affixBeanList,goods.getId_4(),goods.getType());
                DbAffixManager.getInstance().insert(affixBean);
                affixBeanList.add(affixBean);
            }else if(i==2){
                AffixBean affixBean = Helper.getAffixBean(affixBeanList,goods.getId_5(),goods.getType());
                DbAffixManager.getInstance().insert(affixBean);
                affixBeanList.add(affixBean);
            }else if(i==3){
                AffixBean affixBean = Helper.getAffixBean(affixBeanList,goods.getId_6(),goods.getType());
                DbAffixManager.getInstance().insert(affixBean);
                affixBeanList.add(affixBean);
            }else if(i==4){
                AffixBean affixBean = Helper.getAffixBean(affixBeanList,goods.getId_7(),goods.getType());
                DbAffixManager.getInstance().insert(affixBean);
                affixBeanList.add(affixBean);
            }else if(i==5){
                AffixBean affixBean = Helper.getAffixBean(affixBeanList,goods.getId_8(),goods.getType());
                DbAffixManager.getInstance().insert(affixBean);
                affixBeanList.add(affixBean);
            }
        }
        return affixBeanList;
    }


    public void insert(List<AffixBean> affixBeanList){
        affixBeanDao.insertOrReplaceInTx(affixBeanList);
    }

    /**
     * 新入库或替换
     * @param affixBean
     * @return
     */
    public long insert(AffixBean affixBean){
        return affixBeanDao.insertOrReplace(affixBean);
    }
}
