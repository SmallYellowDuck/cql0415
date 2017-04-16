package com.bawei.cql0415;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 作者:程千浪
 * .时间：2017/4/15 10:52
 * 类用途：
 */

public class Medicinebase extends BaseAdapter{
private  List<MedicineBean.DataBean> data;
    private Context context;

    public Medicinebase(Context context, List<MedicineBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView=convertView.inflate(context,R.layout.medicinelistview,null);
            vh.title= (TextView) convertView.findViewById(R.id.name);
            vh.type= (TextView) convertView.findViewById(R.id.type);
            vh.price= (TextView) convertView.findViewById(R.id.prince);
            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        vh.title.setText(data.get(position).getTitle());
        vh.type.setText(data.get(position).getApply());
        vh.price.setText(data.get(position).getBuy_price()+"元");
        return convertView;
    }
    class  ViewHolder{
        TextView title,type,price;
    }
}
