package com.born.analog.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.born.analog.AnaLog;
import com.born.analog.R;
import com.born.analog.module.Pro;
import com.born.analog.module.SelectBean;
import com.born.analog.net.RequestUtil;
import com.born.analog.net.base.SimpleCallBack;
import com.born.analog.net.module.EquipModule;
import com.born.analog.ui.view.InfoDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private GridView gridView;
    private List<SelectBean> beanList;
    private TextView text_mypro,text_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initGoods();

    }

    private void initView() {
        gridView = findViewById(R.id.gridview);
        text_mypro = findViewById(R.id.text_mypro);
        text_info = findViewById(R.id.text_info);
        text_mypro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProActivity.class));
            }
        });
        text_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new InfoDialog(MainActivity.this).show();
            }
        });
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
        necklace.setType(4);
        beanList.add(necklace);

        gridView.setAdapter(new GridAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListActivity.open(MainActivity.this, beanList.get(i).getType());
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

    @Override
    protected void onResume() {
        super.onResume();
        queryEquip();
    }

    private void queryEquip(){
        showDialog();
        RequestUtil.queryEquip(new SimpleCallBack<List<EquipModule>>() {

            @Override
            public void onSuccess(List<EquipModule> equipModules) {
                hideDialog();
                Log.d("xxxx",equipModules.size()+"");
            }

            @Override
            public void onFail() {
                hideDialog();
            }
        });
    }
}
