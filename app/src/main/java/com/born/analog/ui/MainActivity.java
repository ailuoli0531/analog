package com.born.analog.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.born.analog.AnaLog;
import com.born.analog.R;
import com.born.analog.module.SelectBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private GridView gridView;
    private List<SelectBean> beanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnaLog.init(this);

        initView();
        initGoods();
    }

    private void initView() {
        gridView = findViewById(R.id.gridview);
    }

    private void initGoods() {
        beanList = new ArrayList<>();
        SelectBean weapon = new SelectBean();
        weapon.setName("武器");
        weapon.setType(0);
        beanList.add(weapon);

        SelectBean armour = new SelectBean();
        armour.setName("护甲");
        armour.setType(1);
        beanList.add(armour);

        SelectBean hand = new SelectBean();
        hand.setName("护手");
        hand.setType(2);
        beanList.add(hand);

        SelectBean shoes = new SelectBean();
        shoes.setName("护腿");
        shoes.setType(3);
        beanList.add(shoes);

        SelectBean necklace = new SelectBean();
        necklace.setName("项链");
        necklace.setType(3);
        beanList.add(necklace);

        gridView.setAdapter(new GridAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AffixActivity.open(MainActivity.this, beanList.get(i).getType());
            }
        });
    }

    private class GridAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        public GridAdapter() {
            layoutInflater = LayoutInflater.from(MainActivity.this);
        }

        @Override
        public int getCount() {
            return beanList.size();
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
            view = layoutInflater.inflate(R.layout.item_goods,null);
            final TextView textView = view.findViewById(R.id.goods_name);
            textView.setText(beanList.get(i).getName());
            return view;
        }
    }

}
