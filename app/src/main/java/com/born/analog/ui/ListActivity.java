package com.born.analog.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.born.analog.Helper;
import com.born.analog.R;
import com.born.analog.adapter.AffixAdapter;
import com.born.analog.adapter.GoodsAdapter;
import com.born.analog.manager.DbAffixManager;
import com.born.analog.manager.DbGoodsManager;
import com.born.analog.module.Affix;
import com.born.analog.module.AffixBean;
import com.born.analog.module.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * created by born on 2018/12/14.
 * 某一装备的历史列表
 */
public class ListActivity extends BaseActivity implements View.OnClickListener {

    private static final String TYPE = "type";

    /**
     * @param context
     * @param type    0 1 2 3 4 5 6
     */
    public static void open(Context context, int type) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(TYPE, type);
        context.startActivity(intent);
    }

    private int type;
    private ListView goods_list;
    private GoodsAdapter goodsAdapter;

    private ListView listView;
    private TextView text_name;
    private TextView text_base;
    private List<AffixBean> affixBeanList;
    private AffixAdapter affixAdapter;
    private Button crash, chou, use;
    private int position = -1;

    private Goods goods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        perseIntent();
        initBar();
        initView();
        initListener();
        query();
        initData();

    }


    private void initListener() {

        crash.setOnClickListener(this);
        use.setOnClickListener(this);
        chou.setOnClickListener(this);

        goodsAdapter.setOnItemClick(new GoodsAdapter.onItemClick() {
            @Override
            public void clickView(Goods g, int position) {
                goods = g;
                refreshDetail();
                goodsAdapter.notify(position);
            }

            @Override
            public void clickNew() {
                //创建新装备
                goods = DbGoodsManager.getInstance().createGoods(type);
                refreshDetail();
                query();
                goodsAdapter.notify(0);
            }
        });
    }

    private void perseIntent() {
        type = getIntent().getIntExtra(TYPE, 0);
    }

    private void initView() {
        goods_list = findViewById(R.id.goods_list);
        goodsAdapter = new GoodsAdapter(this);
        goods_list.setAdapter(goodsAdapter);

        listView = findViewById(R.id.listview);
        text_name = findViewById(R.id.name);
        text_base = findViewById(R.id.base);
        crash = findViewById(R.id.crash);
        chou = findViewById(R.id.chou);
        use = findViewById(R.id.use);
    }

    private void query() {
        List<Goods> goodsList = DbGoodsManager.getInstance().getGoodsByType(type);
        goodsAdapter.notify(goodsList);
    }


    private void initData() {
        affixBeanList = new ArrayList<>();
        affixAdapter = new AffixAdapter(this, affixBeanList);
        listView.setAdapter(affixAdapter);
        //查询当前穿戴的装备
        goods = DbGoodsManager.getInstance().getUsedGoodsByType(type);
        if (goods == null) {
            return;
        }

        refreshDetail();
    }

    /**
     * 刷新右边详情的展示
     */
    private void refreshDetail() {
        checkUse();
        affixBeanList = DbAffixManager.getInstance().getAffixListByGoodsId(goods.getId());
        refreshHead();
        affixAdapter.notify(affixBeanList, position);
    }


    /**
     * 检查是否穿戴
     */
    private void checkUse() {
        boolean isUse = goods.getUse() == 1;
        if (isUse) {
            use.setText("已穿戴");
            use.setClickable(false);
        } else {
            use.setText("穿戴");
            use.setClickable(true);
        }
    }

    /**
     * 刷新头部信息 基础 姓名
     */
    private void refreshHead() {
        text_name.setText(goods.getName());
        if (affixBeanList.size() > 5) {
            text_name.setTextColor(getResources().getColor(R.color.purple));
//            text_base.setTextColor(getResources().getColor(R.color.purple));
        } else {
            text_name.setTextColor(getResources().getColor(R.color.pink));
//            text_base.setTextColor(getResources().getColor(R.color.pink));
        }
        //每增加一个词条，基础+100
        int type = goods.getBase_type();
        Affix affix = Helper.getAffixByTAG(goods.getBase_name());
        StringBuilder sb = new StringBuilder(affix.getDescribe());
        //判断包含几个神赐属性
        int sc = Helper.includeSC(goods);
        if (type == Affix.TYPE_NORMAL) {
            //固定值
            int space = goods.getBase_number() + (affixBeanList.size() - 3) * 100 + goods.getBase_number() / 2 * sc;
            sb.append(" ");
            sb.append(space);
            goods.setBase_space(space);
        } else if (type == Affix.TYPE_MIN_MAX) {
            //最大最小
            int min = goods.getBase_minNumber() + (affixBeanList.size() - 3) * 100 + goods.getBase_minNumber() / 2 * sc;
            int max = goods.getBase_maxNumber() + (affixBeanList.size() - 3) * 100 + goods.getBase_maxNumber() / 2 * sc;
            sb.append(" ");
            sb.append(min);
            sb.append("-");
            sb.append(max);
            goods.setBase_minSpace(min);
            goods.setBase_maxSpace(max);
        }
        DbGoodsManager.getInstance().insert(goods);
        text_base.setText(sb);
    }


    /**
     * 洗装备
     */
    private void wash(){
        position = -1;
        goods.setLength(Helper.getLength());
        List<AffixBean> affixBeans = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeans);
        DbGoodsManager.getInstance().insert(goods);

        affixBeanList.clear();
        affixBeanList.addAll(affixBeans);

        refreshHead();
        affixAdapter.notify(affixBeanList,position);
    }

    private Runnable washRun=new Runnable() {
        @Override
        public void run() {
            hideDialog();
            wash();
        }
    };

    private Runnable chouRun = new Runnable() {
        @Override
        public void run() {
            hideDialog();
            chou();
        }
    };

    /**
     * 抽装备
     */
    private void chou() {
        //根据goods长度随机一个position
        int length = affixBeanList.size();
        position = Helper.getRandom(0,length-1);
        AffixBean affixBean = affixBeanList.get(position);
        affixBeanList.remove(affixBean);
        affixBean = Helper.getAffixBean(goods,affixBeanList,position);
        DbAffixManager.getInstance().insert(affixBean);

        affixBeanList.clear();
        affixBeanList = DbAffixManager.getInstance().getAffixListByGoodsId(goods.getId());
        refreshHead();
        affixAdapter.notify(affixBeanList,position);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.crash){
            showDialog();
            view.postDelayed(washRun,500);
        }else if(view.getId() == R.id.use){
            useGoods();
        }else if(view.getId() == R.id.chou){
            showDialog();
            view.postDelayed(chouRun,500);
        }
    }

    /**
     * 穿戴
     */
    private void useGoods() {
        DbGoodsManager.getInstance().useGoods(goods);
        checkUse();
        query();
    }
}
