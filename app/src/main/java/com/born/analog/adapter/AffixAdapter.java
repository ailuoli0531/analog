package com.born.analog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.born.analog.Helper;
import com.born.analog.R;
import com.born.analog.module.Affix;
import com.born.analog.module.AffixBean;

import java.util.List;

/**
 * created by born on 2019/1/10.
 */
public class AffixAdapter  extends BaseAdapter {
    private LayoutInflater inflater;
    private int pink,purple,green;
    private Context context;
    private List<AffixBean> affixBeanList;
    private int position = -1;
    public AffixAdapter(Context context,List<AffixBean> affixBeanList){
        this.context = context;
        inflater = LayoutInflater.from(context);
        pink = context.getResources().getColor(R.color.pink);
        purple = context.getResources().getColor(R.color.purple);
        green = context.getResources().getColor(R.color.green);
        this.affixBeanList =affixBeanList;
    }

    public void notify(List<AffixBean> affixBeanList,int postion){
        this.affixBeanList = affixBeanList;
        this.position = postion;
        notifyDataSetChanged();
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
        Affix affix = Helper.getAffixByTAG(affixBean.getTag());

//            name.setText(affix.getDescribe());
        StringBuilder sb = new StringBuilder();
        sb.append(affix.getDescribe());
        if(affix.getType() == Affix.TYPE_NORMAL){
            sb.append(affixBean.getSpace());
        }
        else if(affix.getType() == Affix.TYPE_PERCENT){
            sb.append(affixBean.getSpace());
            sb.append("%");
        }

        describe.setText(sb);

        if(affixBeanList.size()>5){
            name.setTextColor(purple);
            describe.setTextColor(purple);
        }else{
            name.setTextColor(pink);
            describe.setTextColor(pink);
        }

        if(i==position){
            name.setTextColor(green);
            describe.setTextColor(green);
//                position = -1;
        }

        return view;
    }
}
