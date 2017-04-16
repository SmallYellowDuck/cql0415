package com.bawei.cql0415;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 作者:程千浪
 * .时间：2017/4/15 10:27
 * 类用途：
 */

public class MyGNbase extends BaseAdapter {
    private Context context;
    private List<gongnengBean.DataBean> date;

    public MyGNbase(List<gongnengBean.DataBean> date, Context context) {
        this.date = date;
        this.context = context;
    }

    @Override
    public int getCount() {
        return date.size();
    }

    @Override
    public Object getItem(int position) {
        return date.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=convertView.inflate(context,R.layout.gongnenglistview,null);
        TextView gntv= (TextView) convertView.findViewById(R.id.gntv);
        String name = date.get(position).getName();
        gntv.setText(name);
        return convertView;
    }
}
