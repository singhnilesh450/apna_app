package com.example.apna_app.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.apna_app.R;

public class GallaryActivity extends AppCompatActivity {
    private static final String TAG = "GallaryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        Log.d(TAG,"sjs:jdiihjdi");
        getImage();

    }
    private void getImage(){
        Log.d(TAG,"bj:getting images");
        if(getIntent().hasExtra("Image_URL")){

            String imurl=getIntent().getStringExtra("Image_URL");
            setImage(imurl);
        }
    }
    private  void setImage(String imurl){

        ImageView imm=findViewById(R.id.imm);
        Glide.with(this).asBitmap().load(imurl).into(imm);
    }
}
