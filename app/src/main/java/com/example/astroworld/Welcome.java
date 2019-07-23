package com.example.astroworld;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {

    ImageView bg;
    ImageView arr[]=new ImageView[12];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SEND_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.READ_PHONE_STATE}, 123);
        }
        else
            data();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
               data();
            }
        }
    }
    public void data()
    {
        Animation b= AnimationUtils.loadAnimation(this,R.anim.zoomin_zoomout);
        bg=findViewById(R.id.bg);
        for(int i=0;i<12;i++)
        {
            String id="sign"+(i+1);
            int resID=getResources().getIdentifier(id,"id",getPackageName());
            arr[i]=findViewById(resID);
        }
        bg.startAnimation(b);
        Animation a= AnimationUtils.loadAnimation(this,R.anim.rotateing);
        for(int i=0;i<12;i++)
        {
            arr[i].startAnimation(a);
        }
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Welcome.this,Login.class);
                startActivity(i);
            }
        },4000);
    }
}
