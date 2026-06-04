package com.tao.android.myfirstandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tao.android.myfirstandroid.activity.DataStorageActivity;
import com.tao.android.myfirstandroid.activity.NetworkActivity;
import com.tao.android.myfirstandroid.activity.SecondActivity;
import com.tao.android.myfirstandroid.activity.UiActivity;

public class MainActivity extends AppCompatActivity {
    private  static final String TAG = "MainActivity";
    private static final String KEY_COUNTER = "counter_value";


    private int counter=0;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.d("MainActivity", "onCreate");
        Log.d(TAG,"onCreate :Activity is being created");

        //核心操作 将主界面加载进来
        setContentView(R.layout.activity_main);

        android.widget.Button mybutton = findViewById(R.id.main_button_toSecond);
        View toUiButton = findViewById(R.id.main_button_toUi);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER,0);
            Log.d(TAG,"onCreate : Restroing counter from save state "+counter);
        }

        EdgeToEdge.enable(this);



        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(KEY_COUNTER,counter);

                bundle.putString("NAME", "Aime");
                bundle.putInt("AGE", 25);
                bundle.putBoolean("IS_VIP", true);
                intent.putExtras(bundle);
                startActivity(intent);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        toUiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UiActivity.class );
//                Bundle bundle = new Bundle();
//                bundle.putInt(KEY_COUNTER,counter);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"进入UI Test界面",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        // ✨ AI 补充：跳转到数据存储学习页面
        // 同时演示 SQLite 和 SharedPreferences 两种存储方式
        View toDataStorageButton = findViewById(R.id.main_button_toDataStorage);
        toDataStorageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataStorageActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "进入数据存储学习页面", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //后续
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        View toNetWorkTestButton = findViewById(R.id.main_button_toNetWorkTest);
        toNetWorkTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"进入网络测试界面",Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER,counter);
        Log.d(TAG,"onSaveInstanceState : Saving counter from state "+counter);
    }
}