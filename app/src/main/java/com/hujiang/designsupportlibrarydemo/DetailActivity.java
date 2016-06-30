package com.hujiang.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private Toolbar toolbar;
    private ImageView imageView;
    private View mBottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.backdrop);
        mBottomLayout = findViewById(R.id.view);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int maxScroll = appBarLayout.getTotalScrollRange();
                Log.d("==maxScroll===", maxScroll+"");
                Log.d("==i===", i+"");
                if(-maxScroll == i){
                    toolbar.setVisibility(View.VISIBLE);
                    findViewById(R.id.seach).setVisibility(View.GONE);
                }else{
                    toolbar.setVisibility(View.GONE);
                    findViewById(R.id.seach).setVisibility(View.VISIBLE);

                }

//                Log.d("==maxScroll===", maxScroll+"");
//                float percentage = (float) Math.abs(i) / (float) maxScroll;
//                Log.d("==percentage===", percentage+"");
//                ViewCompat.setAlpha(toolbar, percentage);

            }
        });


//        setContentView(R.layout.demo_layout);


//        CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.scroll);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

    }
}
