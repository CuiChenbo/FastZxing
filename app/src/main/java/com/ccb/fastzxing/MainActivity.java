package com.ccb.fastzxing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.ccb.zxinglibrary.FastZxingApp;
import com.ccb.zxinglibrary.ui.CameraActivity;
import com.ccb.zxinglibrary.ui.ScanActivity;
import com.ccb.zxinglibrary.utils.ScanUtils;
import com.ccb.zxinglibrary.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private final int REQUESTCODE = 9;
    private AppCompatEditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.tv);
        FastZxingApp.init(MainActivity.this.getApplication());
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
          //扫描需要用到相机权限、读取相册需要用到读取文件权限；
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA , Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    public void scan(View view) {
        startActivityForResult(new Intent(this, ScanActivity.class) , REQUESTCODE);
    }

    public void camera(View view) {
        startActivity(new Intent(this, CameraActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK){
            et.setText("扫描结果:"+data.getExtras().getString(ScanUtils.RESULT_STRING));
        }
    }

    public void makescan(View view) {
        ImageView iv = findViewById(R.id.iv);
        if (TextUtils.isEmpty(et.getText().toString())){
            ToastUtils.show(MainActivity.this,"先输入内容，再制作二维码");
        }
        iv.setImageBitmap(ScanUtils.createImage(et.getText().toString() , 500,500,null));
    }
}
