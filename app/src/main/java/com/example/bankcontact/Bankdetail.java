package com.example.bankcontact;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Bankdetail extends AppCompatActivity {

    String Name,Number;
    int Img;
    TextView txtname,txtnumber;
    ImageView imglogo,imgcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankdetail);
        initBinding();
        getIntentdata();
        setIntentData();
        initCall();
    }

    private void initCall() {

        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=txtnumber.getText().toString();
                Uri uri= Uri.parse("tel:"+number);
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    private void setIntentData() {

        txtname.setText(Name);
        txtnumber.setText(Number);
        imglogo.setImageResource(Img);
    }

    private void getIntentdata() {
        Name=getIntent().getStringExtra("txtname");
        Number=getIntent().getStringExtra("txtnumber");
        Img=getIntent().getIntExtra("imglogo",0);
    }

    private void initBinding() {
        txtname=findViewById(R.id.txtname);
        txtnumber=findViewById(R.id.txtnumber);
        imglogo=findViewById(R.id.imglogo);
        imgcall=findViewById(R.id.imgcall);

    }
}