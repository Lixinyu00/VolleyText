package com.lxy.volleytext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_1;
    private Button button_2;
    private Button button_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
    }

    private void initView() {
        button_1=(Button)findViewById(R.id.btn_1);
        button_2=(Button)findViewById(R.id.btn_2);
        button_3=(Button)findViewById(R.id.btn_3);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_1:
                intent.setClass(this,StringRequestText.class);
                break;
            case R.id.btn_2:
                intent.setClass(this,JsonRequestText.class);
                break;
            case R.id.btn_3:
                intent.setClass(this,ImageRequestText.class);
                break;
        }
        startActivity(intent);
    }
}
