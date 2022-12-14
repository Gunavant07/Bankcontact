package com.example.bankcontact;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Modeldata> l1 =new ArrayList();

    int[] img={R.drawable.boi,R.drawable.bob,R.drawable.icici,R.drawable.hdfc1,R.drawable.indusind,
            R.drawable.punjabb,R.drawable.cbi1,R.drawable.kotak1,R.drawable.dena,R.drawable.sbi};
    String[] name={"Bank Of India","Bank Of Baroda","ICICI Bnk","HDFC Bank","Indusind","Punjab National Bank",
            "Central Bank Of India","Kotak","Dena Bank","State Bank Of India"};
    String[] number={"1800 103 1906","1800 102 4455","1860 120 7777","1800 202 6161","1860 267 7777","1860 267 7777",
            "1800 22 1911","1860 266 0811","1800 233 6427","1800 1234"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBinding();
        for(int i=0;i< name.length;i++)
        {
            Modeldata m1=new Modeldata();
            m1.setImg(img[i]);
            m1.setName(name[i]);
            m1.setNumber(number[i]);
            l1.add(m1);
        }
        initSetup();
    }
    private void initBinding() {
        recyclerView=findViewById(R.id.recyclerview);
    }

    private void initSetup() {
        rvAdapter adapter =new rvAdapter(this,l1);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


}