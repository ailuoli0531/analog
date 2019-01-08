package com.born.analog.manager;

import com.born.analog.dao.DaoHelper;
import com.born.analog.dao.UserDao;
import com.born.analog.module.User;

/**
 * created by born on 2019/1/8.
 */
public class DbUserManager {
    private static DbUserManager manager;
    private static UserDao userDao;

    public static DbUserManager getInstance(){
        if(manager==null){
            manager = new DbUserManager();
        }
        if (userDao == null) {
            userDao = DaoHelper.getInstance().getSession().getUserDao();
        }
        return manager;
    }

    /**
     * 获取登录信息
     * @return
     */
    public User getUser(){
        User user = null;
        long count =  userDao.queryBuilder().count();
        if(count>0){
            user = userDao.queryBuilder().list().get(0);
        }
        return user;
    }

    /**
     * 更新
     * @param user
     * @return
     */
    public long updateUser(User user){
        userDao.queryBuilder().list().clear();
        return userDao.insertOrReplace(user);
    }
}
