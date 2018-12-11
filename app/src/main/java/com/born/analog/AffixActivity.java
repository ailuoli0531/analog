package com.born.analog;

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

import java.util.ArrayList;
import java.util.List;

/**
 * created by born on 2018/12/10.
 */
public class AffixActivity extends BaseActivity {
    public static String EXTRA_TYPE = "extra_type";

    /**
     * type:0武器 1护甲 2手套 3项链 4护腿
     * @param activity
     * @param type
     */
    public static void open(BaseActivity activity,int type){
        Intent intent = new Intent(activity,AffixActivity.class);
        intent.putExtra(EXTRA_TYPE,type);
        activity.start(intent);
    }

    private int type;
    private ListView listView;
    private TextView textView;
    private List<AffixBean> affixBeanList;
    private AffixAdapter adapter;
    private Button reset,crash,chou;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affix);
        parseIntent();
        initView();
        initData();
    }

    private void parseIntent() {
        type = getIntent().getIntExtra(EXTRA_TYPE,0);
    }

    private void initView() {
        listView = findViewById(R.id.listview);
        textView = findViewById(R.id.name);
        reset = findViewById(R.id.reset);
        crash = findViewById(R.id.crash);
        chou = findViewById(R.id.chou);

        crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wash();
            }
        });
    }

    private void initData() {
        if(type==0){
            affixBeanList = new ArrayList<>();
            AffixBean bean1 = Helper.createAffixBean(Helper.getAffixByName("力量"));
            AffixBean bean2 = Helper.createAffixBean(Helper.getAffixByName("攻速"));
            AffixBean bean3 = Helper.createAffixBean(Helper.getAffixByName("最大攻击力提升"));
            affixBeanList.add(bean1);
            affixBeanList.add(bean2);
            affixBeanList.add(bean3);
            int length = Helper.getLength();

            for(int i=0;i<length;i++){
                AffixBean bean = Helper.getAffixBean(affixBeanList,0);
                affixBeanList.add(bean);
            }

            adapter = new AffixAdapter();
            listView.setAdapter(adapter);
        }
    }

    /**
     * 洗装备
     */
    private void wash(){
        List<AffixBean> affixBeans = new ArrayList<>();

        for(int i=0;i<3;i++){
            AffixBean affixBean = affixBeanList.get(i);
            if(affixBean.getType()==0 || affixBean.getType()==3){
                Affix affix = Helper.getAffixByName(affixBean.getName());
                affixBean.setSpace(Helper.getRandom(affix.getMinSpace(),affix.getMaxSpace()));
                affixBeans.add(affixBean);
            }else{
                affixBeans.add(affixBean);
            }
        }

        int length = Helper.getLength();
        for(int i=0;i<length;i++){
            AffixBean bean = Helper.getAffixBean(affixBeans,0);
            affixBeans.add(bean);
        }
        affixBeanList.clear();
        affixBeanList.addAll(affixBeans);
        adapter.notifyDataSetChanged();
    }


    private  class AffixAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        public AffixAdapter(){
            inflater = LayoutInflater.from(AffixActivity.this);
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
            return view;
        }
    }
}
