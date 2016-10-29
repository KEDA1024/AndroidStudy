package com.cody.myandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initView();
		initData();
		initListener();
	}

	@Override
	public void onClick(View v) {
		progress(v);
	}

	public abstract void initView();
	public abstract void initData();
	public abstract void initListener();
	public abstract void progress(View v);


}
