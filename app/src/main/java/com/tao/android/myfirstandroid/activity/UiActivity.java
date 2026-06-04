package com.tao.android.myfirstandroid.activity;

import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.snackbar.Snackbar;
import com.tao.android.myfirstandroid.MainActivity;
import com.tao.android.myfirstandroid.R;
import com.tao.android.myfirstandroid.adapter.FoodAdapter;
import com.tao.android.myfirstandroid.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UiActivity
 * Package: com.tao.android.myfristandroid.activity
 * Description:
 *
 * @Author ct
 * @Create 2026/6/3 16:07
 * @Version 1.0
 */
public class UiActivity extends AppCompatActivity {
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_modules);

        View backbutton = findViewById(R.id.ui_backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(UiActivity.this, MainActivity.class);
//                startActivity(intent);
//
//                //Toast的替代用 SnackBar
////                Toast.makeText(UiActivity.this,"返回成功！",Toast.LENGTH_SHORT).show();
////                Snackbar.make(v,"返回成功！",Snackbar.LENGTH_SHORT).show();
//                Snackbar.make(v,"已返回主页",Snackbar.LENGTH_LONG).setAction("撤销返回",view -> {
//                    Intent intent2 = new Intent(UiActivity.this,MainActivity.class);
//                    startActivity(intent2);
//                    finish();
//                }).show();
////                finish();

                Snackbar snackbar = Snackbar.make(v, "已返回主页", Snackbar.LENGTH_LONG)
                        .setAction("撤销", view -> {
                            // 撤销 → 什么都不做，留着
                        });

                snackbar.addCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar s, int event) {
                        if (event != DISMISS_EVENT_ACTION) {  // 不是点了"撤销"
                            Intent intent = new Intent(UiActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                snackbar.show();

            }
        });

        EditText editText = findViewById(R.id.ui_editText);
        String text = editText.getText().toString();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <3) {
                    editText.setError("搜索长度不能小于3");
                }else{
                    editText.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        List<FoodItem> foodList=new ArrayList<>();
        foodList.add(new FoodItem("樱桃", R.drawable.cherry, "好吃的水果"));
        foodList.add(new FoodItem("咖啡", R.drawable.coffee, "提神醒脑的饮品"));
        foodList.add(new FoodItem("披萨", R.drawable.pizza, "意大利经典美食"));
        foodList.add(new FoodItem("荔枝", R.drawable.lizhi, "甜甜的热带水果"));
        foodList.add(new FoodItem("运动", R.drawable.sprots, "保持身体健康"));
        foodList.add(new FoodItem("水", R.drawable.water, "生命之源"));
        foodList.add(new FoodItem("食物", R.drawable.food, "丰富的食物"));
        foodList.add(new FoodItem("AI", R.drawable.ai, "人工智能"));
        foodList.add(new FoodItem("工作", R.drawable.work, "努力工作"));
        foodList.add(new FoodItem("花", R.drawable.han1, "漂亮的花"));

        RecyclerView recyclerView = findViewById(R.id.ui_recyclerView);
//        线性
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        网格
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

//        瀑布
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        FoodAdapter adapter = new FoodAdapter(foodList);

        recyclerView.setAdapter(adapter);


    }



}
