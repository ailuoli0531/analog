package com.born.analog.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.born.analog.R;
import com.born.analog.adapter.GoodsAdapter;
import com.born.analog.manager.DbGoodsManager;
import com.born.analog.module.Goods;

import java.util.List;

/**
 * created by born on 2018/12/14.
 * 某一装备的历史列表
 */
public class ListActivity extends BaseActivity {

    private static final String TYPE = "type";
    /**
     *
     * @param context
     * @param type 0 1 2 3 4 5 6
     */
    public static void open(Context context,int type){
        Intent intent = new Intent(context,ListActivity.class);
        intent.putExtra(TYPE,type);
        context.startActivity(intent);
    }

    private int type;
    private ListView goods_list;
    private GoodsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        perseIntent();
        initBar();
        initView();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        query();
    }

    private void initListener() {
      adapter.setOnItemClick(new GoodsAdapter.onItemClick() {
          @Override
          public void clickView(Goods goods, int position) {
            AffixActivity.open(ListActivity.this,goods.getId());
          }

          @Override
          public void clickNew() {
            //创建新装备
              Goods goods = DbGoodsManager.getInstance().createGoods(type);
              AffixActivity.open(ListActivity.this,goods.getId());
          }
      });
    }

    private void perseIntent() {
        type = getIntent().getIntExtra(TYPE,0);
    }

    private void initView() {
        goods_list = findViewById(R.id.goods_list);
        adapter = new GoodsAdapter(this);
        goods_list.setAdapter(adapter);
    }

    private void query(){
        List<Goods> goodsList = DbGoodsManager.getInstance().getGoodsByType(type);
        adapter.notify(goodsList);
    }


}
