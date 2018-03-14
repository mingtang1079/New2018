package com.example.tangming.new2018;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.SupportActivity;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tangming on 2018/3/13.
 */

public class ViewTwo extends LinearLayout implements LifecycleObserver {


    public ViewTwo(Context context) {
        super(context);
        init(context);
    }

    public ViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context mContext) {
        if (mContext instanceof SupportActivity) {
            LifecycleOwner mLifecycleOwnerm = (LifecycleOwner) mContext;
            mLifecycleOwnerm.getLifecycle().addObserver(this);
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate() {

        // TODO: 2018/3/13 网络请求、数据处理、逻辑处理等等

        TextView mTextViewm = new TextView(this.getContext());
        mTextViewm.setText("我是视图2");
        addView(mTextViewm);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onDestroy() {

    }
}
