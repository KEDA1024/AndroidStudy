package com.cody.myandroidstudy.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.cody.myandroidstudy.R;
import com.cody.myandroidstudy.rxjava.Demo1Activity;

public class MainActivity extends BaseActivity {

    private Button btnCircleProgress;
    private Button btnRxjavaDemo;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        btnCircleProgress = (Button) findViewById(R.id.btn_circle_progress);
        btnRxjavaDemo = (Button) findViewById(R.id.btn_rxjava_demo);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        btnCircleProgress.setOnClickListener(this);
        btnRxjavaDemo.setOnClickListener(this);
    }

    @Override
    public void progress(View v) {
        switch (v.getId()) {
            case R.id.btn_circle_progress:
                startActivity(new Intent(this, CircleProgressActivity.class));
                break;

            case R.id.btn_rxjava_demo:
                startActivity(new Intent(this, Demo1Activity.class));
                break;

            default:
                break;
        }
    }
}
