package com.example.apna_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apna_app.R;
import com.example.apna_app.adapter.RecyclerViewAdapter1;
import com.example.apna_app.photoss;

import java.util.ArrayList;

public class tab1fragment extends Fragment {
    private static final String TAG = "Tab1fragment";
    private ArrayList<photoss> mNames1 = new ArrayList<>();
    private Context mContext1;
    RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNames1.add(new photoss("Nilesh", R.drawable.nil));
        mNames1.add(new photoss("Navneet",R.drawable.nav));
        mNames1.add(new photoss("Sinha",R.drawable.a));
        mNames1.add(new photoss("Aman Anand",R.drawable.b));
        mNames1.add(new photoss("Abhinav Aditya",R.drawable.c));
        mNames1.add(new photoss("Chotu",R.drawable.ch));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
            Log.d(TAG, "initRecyclerView: init recyclerview");
        recyclerView =(RecyclerView)view.findViewById(R.id.recyclerView1);
        RecyclerViewAdapter1 adapter = new RecyclerViewAdapter1(mNames1,  mContext1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext1));
        return view;

    }
    }


