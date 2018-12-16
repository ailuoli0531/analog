package com.born.analog.manager;

import com.born.analog.dao.DaoHelper;
import com.born.analog.dao.PannelDao;
import com.born.analog.module.Pannel;

/**
 * created by born on 2018/12/16.
 * 个人属性面板管理
 */
public class DbPannelManager {
    private static DbPannelManager manager;
    private static PannelDao pannelDao;
    public static DbPannelManager getInstance(){
        if(manager==null){
            manager = new DbPannelManager();
        }
        if(pannelDao==null){
            pannelDao = DaoHelper.getInstance().getSession().getPannelDao();
        }

        return manager;
    }

    /**
     * 获取属性面板，没有则创建
     * @return
     */
    public Pannel getPannel(){
       Pannel pannel =  pannelDao.queryBuilder().unique();
       if(pannel==null){
           pannel = new Pannel();
           pannelDao.insertOrReplace(pannel);
       }
       return pannel;
    }


}
