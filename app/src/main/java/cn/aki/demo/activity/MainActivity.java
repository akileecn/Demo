package cn.aki.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.aki.demo.R;
import cn.aki.demo.jni.JniUtils;

/**
 * Created by Administrator on 2016/2/29.
 * 主页面
 */
public class MainActivity extends Activity {
    static {
        System.loadLibrary("jniTest");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 跳转至二维码页面
     */
    public void toQrCode(View view){
        startActivity(new Intent(this, QrCodeActivity.class));
    }

    /**
     * 调用jni的hello方法
     */
    public void cHello(View view){
        JniUtils jniUtils=new JniUtils();
        String word=jniUtils.hello();
        Toast.makeText(this,word,Toast.LENGTH_SHORT).show();
    }
}
