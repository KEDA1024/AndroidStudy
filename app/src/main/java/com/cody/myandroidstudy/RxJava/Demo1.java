package com.cody.myandroidstudy.rxjava;


import android.graphics.drawable.Drawable;


import rx.Observable;


/**
 * Created by CodyYang on 2016/11/7.
 * 异步处理，由图片id取得图片并显示
 */
public class Demo1{

//    int drawableRes = ...;
//    ImageView imageView = ...;
    Observable.create(new Observable.OnSubscribe<Drawable>() {
        @Override
        public void call(Subscriber<? super Drawable> subscriber) {
            Drawable drawable = getTheme().getDrawable(drawableRes));
            subscriber.onNext(drawable);
            subscriber.onCompleted();
        }
    });


}
