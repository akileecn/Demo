package cn.aki.demo.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import cn.aki.demo.R;

/**
 * Created by Administrator on 2016/2/29.
 * 二维码
 */
public class QrCodeActivity extends Activity implements View.OnClickListener{
    private TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        setContentView(R.layout.activity_qr_code);
        tvContent= (TextView) findViewById(R.id.tv_content);
        Button btnBrowser= (Button) findViewById(R.id.btn_browser);
        Button btnCopy= (Button) findViewById(R.id.btn_copy);
        Button btnScan= (Button) findViewById(R.id.btn_scan);
        btnBrowser.setOnClickListener(this);
        btnCopy.setOnClickListener(this);
        btnScan.setOnClickListener(this);
    }

    /**
     * 接收扫描结果
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!=null){
            String content=result.getContents();
            if(content!=null){
                tvContent.setText(content);
            }else{
                Toast.makeText(this,"取消扫描",Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View v) {
        String content=tvContent.getText().toString();
        switch (v.getId()){
            //打开
            case R.id.btn_browser:
                if(TextUtils.isEmpty(content)){
                    Toast.makeText(this,"请扫描二维码",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(content)));
                }
                break;
            //复制
            case R.id.btn_copy:
                ClipboardManager clipboardManager= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData data=ClipData.newPlainText(null,content);
                clipboardManager.setPrimaryClip(data);
                break;
            //扫描
            case R.id.btn_scan:
                new IntentIntegrator(this).initiateScan();
                break;
            default:
                break;
        }
    }
}
