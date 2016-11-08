package com.cody.myandroidstudy.rxjava;


import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cody.myandroidstudy.R;
import com.cody.myandroidstudy.activity.BaseActivity;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by CodyYang on 2016/11/7.
 * 异步处理，由图片id取得图片并显示
 */
public class Demo1Activity extends BaseActivity{

    private Button btnShowImg;
    private ImageView ivShowImg;

    @Override
    public void initView() {
        setContentView(R.layout.activity_demo1);
        btnShowImg = (Button) findViewById(R.id.btn_show_img);
        ivShowImg = (ImageView) findViewById(R.id.iv_show_img);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        btnShowImg.setOnClickListener(this);
    }

    @Override
    public void progress(View v) {
        switch (v.getId()) {
            case R.id.btn_show_img:
                getImageAsync();
                break;

            default:
                break;
        }
    }

    /**
     * 异步调用，由图片id取得图片并显示
     */
    private void getImageAsync() {
        final int drawableRes = R.mipmap.img1;
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getTheme().getDrawable(drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
        .subscribeOn(Schedulers.io()) //指定 subscribe()发生在IO线程
        .observeOn(AndroidSchedulers.mainThread()) // 指定subscriber的回调发生在主线程中
        .subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Demo1Activity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Drawable drawable) {
                ivShowImg.setImageDrawable(drawable);
            }
        });
    }


    /**
     * 简单的create使用demo
     */
    public static void createDemo() {

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        for (int i = 1; i < 5; i++) {
                            subscriber.onNext(i);
                        }
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.print("Sequence complete");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error:" + e.getMessage());
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("Next:" + item);
            }
        });

    }



}
