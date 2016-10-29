package com.cody.myandroidstudy.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.cody.myandroidstudy.R;

public class MainActivity extends BaseActivity {

    private Button btnCircleProgress;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        btnCircleProgress = (Button) findViewById(R.id.btn_circle_progress);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        btnCircleProgress.setOnClickListener(this);
    }

    @Override
    public void progress(View v) {
        switch (v.getId()) {
            case R.id.btn_circle_progress:
                startActivity(new Intent(this, CircleProgressActivity.class));
                break;

            default:
                break;
        }
    }
}
