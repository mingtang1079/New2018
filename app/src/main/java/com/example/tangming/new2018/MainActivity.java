package com.example.tangming.new2018;

import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.appbaselib.base.BaseModel;
import com.appbaselib.network.ResponceSubscriber;
import com.appbaselib.rx.RxHelper;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;
import io.reactivex.ObservableConverter;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ResponceSubscriber mResponceSubscriber = new ResponceSubscriber<LoginIdentity>() {
            @Override
            protected void onSucess(LoginIdentity mLoginIdentity) {
                Log.d("tag=---->", mLoginIdentity.access_token);
            }

            @Override
            protected void onFail(String message) {

            }
        };


        //  BaseModel<LoginIdentity> mLoginIdentity =
        Http.getDefault().login("18780191171", "123456")
              //  .compose(RxHelper.<LoginIdentity>handleResult())
                .as(AutoDispose.<BaseModel<LoginIdentity>>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(mResponceSubscriber);

        Http.getDefault().login("18780191171", "123456")
                .as(RxHelper.handleResult(this))
                .subscribe(mResponceSubscriber);
    }

}
