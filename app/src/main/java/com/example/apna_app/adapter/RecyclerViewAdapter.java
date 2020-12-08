package com.example.apna_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apna_app.R;
import com.example.apna_app.fragments.statusfrafment;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter  {
    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<String> mNames=new ArrayList<>();
    private  ArrayList<String> mImageUrls=new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapter(ArrayList<String> name, ArrayList<String> image, Context context) {
            mNames = name;
            mImageUrls = image;
            mcontext = context;
    }

    public RecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //this inflate each new individual layout
        Log.d(TAG,"onCreateViewHolder:call");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder:call");


        Glide.with(mcontext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into((ImageView) holder.itemView.findViewById(R.id.image_view));
        ((TextView)holder.itemView.findViewById(R.id.name)).setText(mNames.get(position));

        ((ImageView) holder.itemView.findViewById(R.id.image_view)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:clicked on Image"+mNames.get(position));

                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                statusfrafment f=new statusfrafment(mImageUrls.get(position));
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.parent_layout_main,f).addToBackStack(null).commit();
               // Toast.makeText(mcontext, mNames.get(position), Toast.LENGTH_SHORT).show();*/
               /* Glide.with(mcontext)
                        .asBitmap()
                        .load(mImageUrls.get(position))
                        .into(holder. ((statusfrafment)mcontext).imageView);*/
               /* Intent intent=new Intent(mcontext,GallaryActivity.class);
                intent.putExtra("Image_URL",mImageUrls.get(position));
                mcontext.startActivity(intent);*/


            }
        });
    }



    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        //widgets
        CircleImageView image;
        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_view);
            name=itemView.findViewById(R.id.name);

        }
    }


}
