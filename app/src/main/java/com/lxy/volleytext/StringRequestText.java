package com.lxy.volleytext;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * @author LiXinyu
 * @date 2017/10/20 13:46.
 */

public class StringRequestText extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textlayout);
        initView();
        initData();
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.tv);
    }

    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest("https://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        textView.setText(s);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(this.toString(), "onErrorResponse: ",volleyError );
            }
        });
        requestQueue.add(stringRequest);
    }
}
