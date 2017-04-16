package com.bawei.cql0415;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.List;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener {
        private ImageButton ib;
    private TextView title;
    private ListView lv;
    private Medicinebase mMedicinebase;
        private Handler handler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    String json = (String) msg.obj;
                    MedicineBean mb = (MedicineBean) new MyGsonUtils(json, MedicineBean.class).jsonToGson();
                    List<MedicineBean.DataBean> data = mb.getData();
                    mMedicinebase = new Medicinebase(MainActivity.this, data);
                    lv.setAdapter(mMedicinebase);

                }
            };
    private String mName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initmemu();
        Intent intent = getIntent();
        int key = intent.getIntExtra("key", 8);
        mName = intent.getStringExtra("name");
        if (key==0){
            title.setText(mName);
            MyXutils.tojson(Mypath.quanbu,handler);
        }
        if (key==1){
            title.setText(mName);
            MyXutils.tojson(Mypath.xiyao,handler);
        }
        if (key==2){
            title.setText(mName);
            MyXutils.tojson(Mypath.zhongyan,handler);
        }
        else{
            MyXutils.tojson(Mypath.quanbu,handler);
        }

    }

    private void initmemu() {
        leftmemu leftmemu = new leftmemu();
        setBehindContentView(R.layout.rongqi);
        getSupportFragmentManager().beginTransaction().replace(R.id.rq_fra, leftmemu).commit();
        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.setBehindScrollScale(1.0f);
    }

    private void initview() {
        ib= (ImageButton) findViewById(R.id.ib);
        ib.setOnClickListener(this);
        lv= (ListView) findViewById(R.id.lv);
        title= (TextView) findViewById(R.id.tv_title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib:
                getSlidingMenu().showMenu();
                break;
        }
    }


}
