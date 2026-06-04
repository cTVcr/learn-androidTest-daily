package com.tao.android.myfirstandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tao.android.myfirstandroid.MainActivity;
import com.tao.android.myfirstandroid.R;

/**
 * ClassName: SecondActivity
 * Package: com.tao.android.myfristandroid.activity
 * Description:
 *
 * @Author ct
 * @Create 2026/6/2 18:05
 * @Version 1.0
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        TextView infoName = findViewById(R.id.second_text_data_name);
        TextView infoAge = findViewById(R.id.second_text_data_age);
        TextView infoVip = findViewById(R.id.second_text_data_VIP);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String name = bundle.getString("NAME");
            String age = String.valueOf(bundle.getInt("AGE"));
            String vip = String.valueOf(bundle.getBoolean("IS_VIP"));
            infoName.setTextSize(20);
            infoAge.setTextSize(20);
            infoVip.setTextSize(20);
            infoName.append(" :"+name);
            infoAge.append(" :"+age);
            infoVip.append(" :"+vip);
        }

        Button backButton = findViewById(R.id.main_button_backToSecond);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
