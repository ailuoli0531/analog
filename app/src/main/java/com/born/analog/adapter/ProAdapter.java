package com.born.analog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.born.analog.R;
import com.born.analog.module.Pro;

import java.util.List;

/**
 * created by born on 2018/12/15.
 */
public class ProAdapter extends BaseAdapter {
    private List<Pro> proList;
    private LayoutInflater inflater;
    public ProAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }
    public void notify(List<Pro> proList){
        this.proList= proList;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return proList==null?0:proList.size();
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
        ViewHolder viewHolder ;
        if(view==null){
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.item_pro,null);
            viewHolder.pro_name = view.findViewById(R.id.pro_name);
            viewHolder.pro_space = view.findViewById(R.id.pro_space);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Pro pro = proList.get(i);
        viewHolder.pro_name.setText(pro.getName());
        viewHolder.pro_space.setText(pro.getSpace());
        return view;
    }

    private class ViewHolder {
        TextView pro_name;
        TextView pro_space;
    }
}