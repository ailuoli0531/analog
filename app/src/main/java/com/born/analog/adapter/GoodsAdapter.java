package com.born.analog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.born.analog.R;
import com.born.analog.module.Goods;

import java.util.List;

/**
 * created by born on 2018/12/14.
 */
public class GoodsAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Goods> goodsList;
    private onItemClick onItemClick;
    private Context context;
    private boolean showNew = false;
    private int position = -1;
    public GoodsAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

    public void notify(List<Goods> goodsList){
        this.goodsList = goodsList;

        if(goodsList.size()<10){
            showNew = true;
        }else {
            showNew = false;
        }

        notifyDataSetChanged();
    }

    public void notify(int position){
        if(this.position == position){
            return;
        }
        this.position = position;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        int count;
        if(goodsList==null || goodsList.size()==0){
            count =1;
        }else{
            count = goodsList.size();
        }
        return count;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.item_end_new,null);
            viewHolder.goods_name = view.findViewById(R.id.goods_name);
            viewHolder.goods_new = view.findViewById(R.id.goods_new);
            viewHolder.goods_layout = view.findViewById(R.id.goods_layout);
            viewHolder.goods_use = view.findViewById(R.id.goods_use);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        if(goodsList==null || goodsList.size()==0){
            viewHolder.goods_layout.setVisibility(View.GONE);
            viewHolder.goods_new.setVisibility(View.VISIBLE);
        } else{
            viewHolder.goods_layout.setVisibility(View.VISIBLE);
            if(i == getCount()-1 && showNew){
                viewHolder.goods_new.setVisibility(View.VISIBLE);
            }else{
                viewHolder.goods_new.setVisibility(View.GONE);
            }
            Goods goods = goodsList.get(i);
            viewHolder.goods_name.setText(goods.getName());
            if(goods.getUse()==1){
                viewHolder.goods_use.setVisibility(View.VISIBLE);
                viewHolder.goods_use.setText("已穿戴");
            }else {
                viewHolder.goods_use.setVisibility(View.GONE);
            }
            if(position==i){
                viewHolder.goods_layout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }else{
                viewHolder.goods_layout.setBackgroundColor(context.getResources().getColor(R.color.transparent));
            }
        }

        viewHolder.goods_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null){
                    onItemClick.clickView(goodsList.get(i),i);
                }
            }
        });

        viewHolder.goods_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null){
                    onItemClick.clickNew();
                }
            }
        });

        return view;
    }

    private static class ViewHolder{
        TextView goods_name;
        TextView goods_new;
        TextView goods_use;
        RelativeLayout goods_layout;
    }



    public interface onItemClick{
        void clickView(Goods goods,int position);
        void clickNew();
    }

}
