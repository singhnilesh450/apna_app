package com.example.apna_app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.apna_app.ImainInterface;
import com.example.apna_app.R;
import com.example.apna_app.adapter.RecyclerViewAdapter;
import com.example.apna_app.adapter.SectionPageAdapter;
import com.example.apna_app.photoss;
import com.example.apna_app.fragments.tab1fragment;
import com.example.apna_app.tab2fragment;
import com.example.apna_app.fragments.tab3fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ImainInterface {
    private static final String TAG = "MainActivity";

    private SectionPageAdapter selectionPageAdapter;
    private ViewPager view_pager;
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.a:
                Toast.makeText(this, "Apna_app web", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.b:
                Toast.makeText(this, "Starred message", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.newgroup:
                Toast.makeText(this, "New group", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImages();

        selectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());
        view_pager=(ViewPager)findViewById(R.id.view_pager);
        setupViewPager(view_pager);
        TabLayout tabLayout=(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(view_pager);
        tabLayout.setBackgroundColor(Color.parseColor("#808000"));

    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");



        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Akash");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Aman");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Deepak");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Nilesh");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Abhinav");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("Navneet");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Dhiraj");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Vineet");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
    }

    public  void setupViewPager(ViewPager viewPager){
        SectionPageAdapter adapter=new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1fragment(),"Chats");
        adapter.addFragment(new tab2fragment(),"Posts");
        adapter.addFragment(new tab3fragment(),"Videos");
       // adapter.addFragment(new tab3fragment(),"Games");
        //adapter.addFragment(new tab3fragment(),"Private");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void inflateviewdialoffragment(photoss ph) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this,R.style.Theme_AppCompat_Light_Dialog);
          alertDialog.setTitle("Are you Sure?");
         alertDialog.setMessage("would you like to delete?");
        alertDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.create();
        alertDialog.show();
    }

}
