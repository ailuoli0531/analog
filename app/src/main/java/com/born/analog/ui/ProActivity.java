package com.born.analog.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.widget.GridView;

import com.born.analog.AnaLogTag;
import com.born.analog.Helper;
import com.born.analog.R;
import com.born.analog.adapter.ProAdapter;
import com.born.analog.dao.DaoHelper;
import com.born.analog.dao.GoodsDao;
import com.born.analog.module.AffixBean;
import com.born.analog.module.Goods;
import com.born.analog.module.Pro;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * created by born on 2018/12/15.
 * 属性栏
 */
public class ProActivity extends BaseActivity {
    private GridView proList;
    private ProAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);
        initBar();
        initView();
        query();
    }

    private void initView() {
        proList = findViewById(R.id.pro_list);
        adapter = new ProAdapter(this);
        proList.setAdapter(adapter);
    }

    private void query() {
        List<Pro> list = new ArrayList<>();

        Pro hp = new Pro();
        hp.setName("气血");
        hp.setSpace(String.valueOf(getBlood()));
        list.add(hp);

        Pro fy = new Pro();
        fy.setName("防御");
        fy.setSpace(String.valueOf(getDef()));
        list.add(fy);

        Pro mj = new Pro();
        mj.setName("敏捷");
        mj.setSpace(String.valueOf(getAgility()));
        list.add(mj);

        Pro gj = new Pro();
        int[] attack = getAttack();
        gj.setSpace(attack[0]+"-"+attack[1]);
        gj.setName("攻击力");
        list.add(gj);

        Pro cirt = new Pro();
        cirt.setName("暴击伤害");
        cirt.setSpace(String.valueOf(getCrit()));
        list.add(cirt);

        Pro cirtP = new Pro();
        cirtP.setName("暴击率");
        cirtP.setSpace(String.valueOf(getCritP()));
        list.add(cirtP);

        Pro Tcirt = new Pro();
        Tcirt.setName("暴击减伤");
        Tcirt.setSpace(String.valueOf(getTCrit()));
        list.add(Tcirt);

        Pro TcirtP = new Pro();
        TcirtP.setName("抗暴击");
        TcirtP.setSpace(String.valueOf(getTCritP()));
        list.add(TcirtP);

        Pro endA = new Pro();
        endA.setName("最终伤害增加");
        endA.setSpace(String.valueOf(getEndAttack()));
        list.add(endA);

        Pro endT = new Pro();
        endT.setName("最终伤害减少");
        endT.setSpace(String.valueOf(getEndAttack()));
        list.add(endT);

        adapter.notify(list);
    }

    /**
     * 力量
     *
     * @return
     */
    private int getPower() {
        return getPro(AnaLogTag.POWER);
    }

    /**
     * 敏捷
     *
     * @return
     */
    private int getAgility() {
        return getPro(AnaLogTag.AGI);
    }

    /**
     * 获取气血
     *
     * @return
     */
    private int getBlood() {
        int extra = getPro(AnaLogTag.BLOOD);
        int base = getBase(AnaLogTag.BLOOD);
        return extra + base;
    }

    /**
     * 获取防御
     * @return
     */
    private int getDef(){
        int extra = getPro(AnaLogTag.DEF);
        int base = getBase(AnaLogTag.DEF);
        int power = getPower();
        return extra+base+power*10;
    }

    /**
     * 获取最大最小攻击力
     * @return
     */
    private int[] getAttack(){
        int extra_Min=getPro(AnaLogTag.MIN_A);
        int extra_Max = getPro(AnaLogTag.MAX_A);
        int base_min = 0;
        int base_max = 0;
        WhereCondition w1 = GoodsDao.Properties.Use.eq(1);
        List<Goods> goodsList = DaoHelper.getInstance().getSession().getGoodsDao().queryBuilder().where(w1).list();
        for (Goods goods : goodsList) {
            if (goods.getBase_name().equals(AnaLogTag.MIN_MAX_A)) {
                base_min += goods.getBase_minSpace();
                base_max += goods.getBase_maxSpace();
            }
        }
        int powerA = getPower()*10;
        int min = extra_Min+base_min+powerA;
        int max = extra_Max+base_max+powerA;

        int percent_min = getPro(AnaLogTag.MIN_A_P);
        int percent_max = getPro(AnaLogTag.MAX_A_P);

        min= min*percent_min/100 + min;
        max= max*percent_max/100 + max;

        if(min>max){
            int cur = max;
            max = min;
            min = cur;
        }

        int[] attacks = new int[]{min,max};
        return attacks;
    }

    /**
     * 精准
     * @return
     */
    private int getAccurate(){
        int agility = getAgility()*2;
        int extra=getPro(AnaLogTag.ACC);
        return agility+extra;
    }

    /**
     * 躲避
     * @return
     */
    private int getElude(){
        int agiltity=getAgility()*2;
        int extra = getPro(AnaLogTag.ELU);
        return agiltity+extra;
    }

    /**
     * 暴击伤害
     * @return
     */
    private int getCrit(){
        int base = getBase(AnaLogTag.CRIT);
        int extra= getPro(AnaLogTag.CRIT);
        return base+extra;
    }

    /**
     * 暴击率
     * @return
     */
    private int getCritP(){
        int base = getBase(AnaLogTag.CRIT_P);
        int extra= getPro(AnaLogTag.CRIT_P);
        return base+extra;
    }

    /**
     * 抗暴率
     * @return
     */
    private int getTCritP(){
        int base = getBase(AnaLogTag.T_CRIT_P);
        int extra= getPro(AnaLogTag.T_CRIT_P);
        return base+extra;
    }

    /**
     * 暴击减伤
     * @return
     */
    private int getTCrit(){
        int base = getBase(AnaLogTag.CRIT_T);
        int extra= getPro(AnaLogTag.CRIT_T);
        int percent = getPro(AnaLogTag.CRIT_T_P);
        int normal = base+extra;
        int num = normal*percent/100+normal;
        return num;
    }

    /**
     * 最终伤害增加
     * @return
     */
    private int getEndAttack(){
        int extra = getPro(AnaLogTag.END_A);
        return extra;
    }

    /**
     * 最终伤害减免
     * @return
     */
    private int getEndDef(){
        int extra = getPro(AnaLogTag.END_T);
        int percent = getPro(AnaLogTag.END_T_P);
        return extra*percent/100+extra;
    }

    /**
     * 攻速
     * @return
     */
    private int getSpeed(){
        int extra = getPro(AnaLogTag.SPEED);
        return extra;
    }

    private int getPro(String tag) {
        List<AffixBean> list = Helper.querySql(tag);
        int power = 0;
        if (list != null) {
            for (AffixBean affixBean : list) {
                power += affixBean.getSpace();
            }
        }
        return power;
    }

    private int getBase(String tag) {
        int base = 0;
        WhereCondition w1 = GoodsDao.Properties.Use.eq(1);
        List<Goods> goodsList = DaoHelper.getInstance().getSession().getGoodsDao().queryBuilder().where(w1).list();
        for (Goods goods : goodsList) {
            if (goods.getBase_name().equals(tag)) {
                base += goods.getBase_space();
            }
        }
        return base;
    }
}
