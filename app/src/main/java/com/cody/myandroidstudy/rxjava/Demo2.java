package com.cody.myandroidstudy.rxjava;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by CodyYang on 2016/11/9.
 */

public class Demo2 {

    private static final String TAG = "Demo2";

    //创建被观察者
    Observable switcher = Observable.create(new Observable.OnSubscribe<String>() {

        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("On");
            subscriber.onNext("Off");
            subscriber.onNext("On");
            subscriber.onNext("On");
            subscriber.onCompleted();
        }
    });

    //偷懒模式1
    Observable switcher1 = Observable.just("On", "Off", "On", "On");

    //偷懒模式2
    String[] kk = {"On", "Off", "On", "On"};
    Observable switcher2 = Observable.from(kk);


    //创建观察者
    Subscriber light = new Subscriber<String>() {

        @Override
        public void onCompleted() {
            //被观察者的onCompleted()事件会走到这里
            Log.d(TAG, "结束观察 ...\n");
        }

        @Override
        public void onError(Throwable e) {
            //出现错误会调用这个方法
        }

        @Override
        public void onNext(String s) {
            //处理传过来的onNext事件
            Log.d(TAG, "handle this ..." + s);
        }
    };

    //偷懒模式（非正常写法）
    Action1 light1 = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.d(TAG, "handle this ..." + s);
        }
    };


    //建立订阅关系
    public void getSubscribe() {
        switcher.subscribe(light);
    }
}
