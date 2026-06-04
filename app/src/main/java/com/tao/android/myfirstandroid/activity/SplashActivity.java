package com.tao.android.myfirstandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tao.android.myfirstandroid.MainActivity;
import com.tao.android.myfirstandroid.R;

/**
 * ClassName: SplashActivity
 * Package: com.tao.android.myfristandroid.activity
 * Description:
 *
 * @Author ct
 * @Create 2026/6/2 17:08
 * @Version 1.0
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(()->{
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);

//            Bundle bundle = new Bundle();
//
//            bundle.putString("USER_NAME","Aime");
//            bundle.putInt("USER_AGE",25);
//            bundle.putBoolean("IS_VIP",true);
//
//            intent.putExtras(bundle);

            startActivity(intent);
            finish();

        },2000);
    }
}
