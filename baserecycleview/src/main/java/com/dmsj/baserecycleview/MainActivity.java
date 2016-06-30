package com.dmsj.baserecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List list =new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add("我是"+i);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listview);

        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);

            recyclerView.setAdapter(new BaseRecycleAdapter<String>(R.layout.content_main,list) {
                @Override
                protected void getView(BaseRecycleViewHolder helper, int position, String item) {
                  TextView textView = helper.getView(R.id.text);
                    textView.setText(item);
                }
            });

    }

}
