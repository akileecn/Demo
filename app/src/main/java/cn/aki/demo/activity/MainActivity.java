package cn.aki.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.aki.demo.R;

/**
 * Created by Administrator on 2016/2/29.
 * 主页面
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 跳转至二维码页面
     */
    public void toQrCode(View view){
        startActivity(new Intent(this,QrCodeActivity.class));
    }
}
