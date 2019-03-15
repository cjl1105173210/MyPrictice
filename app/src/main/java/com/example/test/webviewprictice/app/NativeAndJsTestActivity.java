package com.example.test.webviewprictice.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.webviewprictice.R;
/*webview练习*/

public class NativeAndJsTestActivity extends AppCompatActivity {

    private WebView mWebView;
    private TextView logTextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_and_js_test);
        initView();
        initWebView();
        initListener();
    }




    private void initView() {
        //获取webview实例，webview用来加载html
        mWebView = (WebView) findViewById(R.id.webview);
        logTextView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
    }
    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        // 1.启用javascript
        mWebView.getSettings().setJavaScriptEnabled(true);
        //2.给webview添加js接口
        mWebView.addJavascriptInterface(this, "cjl");

        //3.打开网页时不调用系统浏览器， 而是在本WebView中显示：
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //4.加载html，两种方式（加载本地html，加载网上获取的html）
        // 1)从assets目录下面加载html如下
        mWebView.loadUrl("file:///android_asset/html1.html");
         /*  //2)从网上获取并加载html如下
        mWebView.loadUrl("http://www.baidu.com");*/
    }

    /*注意事项
   按返回键时， 不退出程序而是返回上一浏览页面*/
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initListener() {
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 触发html中的自定义的无参函数actionFromNative()
                mWebView.loadUrl("javascript:actionFromNative()");
                // 触发html中的自定义的有参函数actionFromNativeWithParam
                mWebView.loadUrl("javascript:actionFromNativeWithParam(" + "'come from Native'" + ")");
            }
        });

    }
    //js调用native函数后的回调（js调用native的代码在上述html文件中）
    @android.webkit.JavascriptInterface
    public void actionFromJs() {
        runOnUiThread(new Runnable() {
            @Override
            public void  run() {
//                Toast.makeText(NativeAndJsTestActivity.this, "js调用了Native函数", Toast.LENGTH_SHORT).show();
                String text = logTextView.getText() + "\njs调用了Native函数";
                logTextView.setText(text);
            }
        });
    }

   @android.webkit.JavascriptInterface
    public void actionFromJsWithParam(final String str){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(NativeAndJsTestActivity.this, "js调用了Native函数传递参数：" + str, Toast.LENGTH_SHORT).show();
                String text = logTextView.getText() +  "\njs调用了Native函数传递参数：" + str;
                logTextView.setText(text);
            }
        });
    }
}
