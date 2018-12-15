package com.born.analog.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.widget.GridView;

import com.born.analog.Helper;
import com.born.analog.R;
import com.born.analog.adapter.ProAdapter;
import com.born.analog.module.Pro;

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
        hp.setSpace(String.valueOf(Helper.QueryPro(hp.getName())));

        list.add(hp);

        adapter.notify(list);
    }

}
