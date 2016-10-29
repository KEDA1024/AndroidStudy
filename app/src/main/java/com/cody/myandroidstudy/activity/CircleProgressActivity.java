package com.cody.myandroidstudy.activity;

import android.os.Handler;
import android.view.View;

import com.cody.myandroidstudy.R;
import com.cody.myandroidstudy.view.CircleProgressView;

/**
 * Created by CodyYang on 2016/10/29.
 */

public class CircleProgressActivity extends BaseActivity {

    private final int TIME_PROGRESS = 30;
    private int curProgress = 0;
    private boolean isOddNumber= false; //是否是奇数阶段
    private Handler handler = new Handler();
    Runnable runnableProgress = new Runnable() {

        @Override
        public void run() {

            if (circleProgressView != null) {

                if (curProgress == 0) {  //定义奇数和偶数阶段
                    isOddNumber = true;
                } else if (curProgress >= 100) {
                    isOddNumber = false;
                }

                if (isOddNumber) { //奇数阶段累加1
                    curProgress += 1;
                } else {           //偶数阶段递减1
                    curProgress -= 1;
                }

                circleProgressView.setProgress(curProgress, isOddNumber);

            }
            handler.postDelayed(this, TIME_PROGRESS); //handler自带方法实现定时器
        }
    };
    private CircleProgressView circleProgressView;


    @Override
    public void initView() {
        setContentView(R.layout.activity_circle_progress);
        circleProgressView = (CircleProgressView) findViewById(R.id.circle_progress_view);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
    }

    @Override
    public void progress(View v) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(runnableProgress, TIME_PROGRESS);//设置转圈进度定时器
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnableProgress);  //取消转圈进度定时器线程
    }
}
