package com.example.test.webviewprictice.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.webviewprictice.R;

public class MainActivity extends AppCompatActivity {

    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }



    private void initView() {
        bt1=(Button)findViewById(R.id.bt1);
    }
    private void initListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NativeAndJsTestActivity.class);
                startActivity(intent);
            }
        });
    }


}
