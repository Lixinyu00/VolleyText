package com.lxy.volleytext;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * @author LiXinyu
 * @date 2017/10/20 13:49.
 */

public class JsonRequestText extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textlayout);
        initView();
        initData();
    }

    private void initView() {
        textView=(TextView)findViewById(R.id.tv);
    }

    private void initData() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonRequest=new JsonObjectRequest("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        textView.setText(jsonObject.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(this.toString(), "onErrorResponse: ",volleyError );
            }
        });
        requestQueue.add(jsonRequest);
    }
}
