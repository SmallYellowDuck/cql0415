package com.bawei.cql0415;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * 作者:程千浪
 * .时间：2017/4/15 10:04
 * 类用途：
 */

public class leftmemu extends Fragment {
    private View mView;
    private ListView lv;
    private List<gongnengBean.DataBean> mData;
    private Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String json = (String) msg.obj;
                gongnengBean bean = (gongnengBean) new MyGsonUtils(json, gongnengBean.class).jsonToGson();
                mData = bean.getData();
                lv.setAdapter(new MyGNbase(mData,getActivity()));
            }
        };


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null)
        {
            initView(inflater, container);
        }
        return mView;
    }
    private void initView(LayoutInflater inflater, ViewGroup container)
    {
        mView = inflater.inflate(R.layout.memu, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv= (ListView) getView().findViewById(R.id.gn_lv);
            MyXutils.tojson(Mypath.gongnneg,handler);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("key",position);
                intent.putExtra("name",mData.get(position).getName()+"");
                startActivity(intent);
            }
        });
    }
}

