package com.example.wuzhangzhang.shijian3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static android.R.attr.permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "缺少打电话权限", Toast.LENGTH_SHORT).show();


                    return;
                }

                String phonenumber = "13800138000";
                String encodedPhonenumber = null;
                try {
                    encodedPhonenumber = URLEncoder.encode(phonenumber, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + encodedPhonenumber)));
            }
        });
    }
}
