package com.example.apna_app;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class tab2fragment extends Fragment {
   private  static final  String TAG="Tab2fragment";

    private ArrayList<String> mNames3=new ArrayList<>();
    private  ArrayList<String> mImageUrls3=new ArrayList<>();
    RecyclerView recyclerView1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.tab2_fragment,container,false);

        recyclerView1 =  view.findViewById(R.id.recycler_view4);
        Staggered_recyclerview adapter = new Staggered_recyclerview(mNames3,mImageUrls3,getContext());
        //recyclerView1.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(1,LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(staggeredGridLayoutManager);
        recyclerView1.setAdapter(adapter);

        getImages();


       return view;
    }
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");



        mImageUrls3.add("https://shorturl.at/gptL3");
        mNames3.add("Akash");

        mImageUrls3.add("https://rb.gy/vhvb39");
        mNames3.add("Aman");

        mImageUrls3.add("https://rb.gy/yh61lx");
        mNames3.add("Deepak");


        mImageUrls3.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames3.add("Nilesh");

        mImageUrls3.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames3.add("Abhinav");


        mImageUrls3.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames3.add("Navneet");

        mImageUrls3.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames3.add("Dhiraj");

        mImageUrls3.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames3.add("Vineet");



    }

  /*  private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycler_view4);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames3,mImageUrls3,getContext());
        recyclerView.setAdapter(adapter);
    }*/
}
