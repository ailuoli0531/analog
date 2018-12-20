package com.born.analog.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.born.analog.Helper;
import com.born.analog.R;
import com.born.analog.manager.DbAffixManager;
import com.born.analog.manager.DbGoodsManager;
import com.born.analog.module.AffixBean;
import com.born.analog.module.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * created by born on 2018/12/10.
 */
public class AffixActivity extends BaseActivity implements View.OnClickListener {
    public static String EXTRA_ID = "extra_id";

    /**
     * type:0武器 1护甲 2手套 3护腿 4项链
     * @param activity
     * @param goodsId
     */
    public static void open(BaseActivity activity,String goodsId){
        Intent intent = new Intent(activity,AffixActivity.class);
        intent.putExtra(EXTRA_ID,goodsId);
        activity.start(intent);
    }

    private String goodsId;
    private ListView listView;
    private TextView text_name;
    private TextView text_base;
    private List<AffixBean> affixBeanList;
    private AffixAdapter adapter;
    private Button reset,crash,chou,use;

    private Goods goods;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affix);
        parseIntent();
        initView();
        initData();
        initListener();
    }



    private void parseIntent() {
        goodsId = getIntent().getStringExtra(EXTRA_ID);
    }

    private void initView() {
        listView = findViewById(R.id.listview);
        text_name = findViewById(R.id.name);
        text_base = findViewById(R.id.base);
        reset = findViewById(R.id.reset);
        crash = findViewById(R.id.crash);
        chou = findViewById(R.id.chou);
        use = findViewById(R.id.use);

    }

    private void initListener() {
        crash.setOnClickListener(this);
        use.setOnClickListener(this);
    }

    private void initData() {
        affixBeanList = new ArrayList<>();
        adapter = new AffixAdapter();
        listView.setAdapter(adapter);
        if(goodsId==null){
            finish();
        }

        goods = DbGoodsManager.getInstance().getGoodsById(goodsId);

        checkUse();

        affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_1()));
        affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_2()));
        affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_3()));

        for(int i =1;i<=goods.getLength();i++){
            if(i==1){
                affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_4()));
            }else if(i==2){
                affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_5()));
            }else if(i==3){
                affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_6()));
            }else if(i==4){
                affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_7()));
            }else if(i==5){
                affixBeanList.add(DbAffixManager.getInstance().getAffixById(goods.getId_8()));
            }
        }

        refreshHead();
        adapter.notifyDataSetChanged();
    }

    /**
     * 检查是否穿戴
     */
    private void checkUse() {
        boolean isUse = goods.getUse()==1;
        if(isUse){
            use.setText("已穿戴");
            use.setClickable(false);
        }else{
            use.setText("穿戴");
            use.setClickable(true);
        }
    }

    /**
     * 洗装备
     */
    private void wash(){

        goods.setLength(Helper.getLength());
        List<AffixBean> affixBeans = DbAffixManager.getInstance().createAffixList(goods);

        DbAffixManager.getInstance().insert(affixBeans);
        DbGoodsManager.getInstance().insert(goods);

        affixBeanList.clear();
        affixBeanList.addAll(affixBeans);

        refreshHead();
        adapter.notifyDataSetChanged();
    }

    /**
     * 刷新头部信息 基础 姓名
     */
    private void refreshHead(){
        text_name.setText(goods.getName());
        if(affixBeanList.size()>5){
            text_name.setTextColor(getResources().getColor(R.color.purple));
            text_base.setTextColor(getResources().getColor(R.color.purple));
        }else{
            text_name.setTextColor(getResources().getColor(R.color.pink));
            text_base.setTextColor(getResources().getColor(R.color.pink));
        }
        //每增加一个词条，基础+100
        int type = goods.getBase_type();
        StringBuilder sb = new StringBuilder(goods.getBase_name());
        //判断包含几个神赐属性
        int sc = Helper.includeSC(goods);
        if(type==1){
            //固定值
            int space = goods.getBase_number()+(affixBeanList.size()-3)*100+goods.getBase_number()/2*sc;
            sb.append(" ");
            sb.append(space);
            goods.setBase_space(space);
        }else if(type==0){
            //最大最小
            int min = goods.getBase_minNumber()+(affixBeanList.size()-3)*100 + goods.getBase_minNumber()/2*sc;
            int max = goods.getBase_maxNumber()+(affixBeanList.size()-3)*100 + goods.getBase_maxNumber()/2*sc;
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

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.crash){
            wash();
        }else if(view.getId() == R.id.use){
            useGoods();
        }
    }

    /**
     * 穿戴
     */
    private void useGoods() {
        DbGoodsManager.getInstance().useGoods(goods);
        checkUse();
    }


    private  class AffixAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private int pink,purple;
        public AffixAdapter(){
            inflater = LayoutInflater.from(AffixActivity.this);
            pink = getResources().getColor(R.color.pink);
            purple = getResources().getColor(R.color.purple);
        }


        @Override
        public int getCount() {
            return affixBeanList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.item_affix,null);
            final TextView name = view.findViewById(R.id.name);
            final TextView describe = view.findViewById(R.id.describe);
            AffixBean affixBean = affixBeanList.get(i);
            name.setText(affixBean.getName());
            describe.setText(String.valueOf(affixBean.getSpace()));

            if(affixBeanList.size()>5){
                name.setTextColor(purple);
                describe.setTextColor(purple);
            }else{
                name.setTextColor(pink);
                describe.setTextColor(pink);
            }

            return view;
        }
    }
}
