package com.example.apna_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

class Staggered_recyclerview extends RecyclerView.Adapter  {
    private static final String TAG = "Staggered_recyclerview";

    //vars
    private ArrayList<String> mNames3=new ArrayList<>();
    private  ArrayList<String> mImageUrls3=new ArrayList<>();
    private Context mcontext3;

    public Staggered_recyclerview(ArrayList<String> name, ArrayList<String> image, Context context) {
        mNames3 = name;
        mImageUrls3 = image;
        mcontext3 = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.staggeredrecyclerview,parent,false);
        return new ViewHolder(view);
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder:call");

        RequestOptions requestOptions=new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);
        Glide.with(mcontext3)
                .load(mImageUrls3.get(position))
                .into((ImageView) holder.itemView.findViewById(R.id.image4));
        ((TextView)holder.itemView.findViewById(R.id.name2)).setText(mNames3.get(position));

        ((ImageView) holder.itemView.findViewById(R.id.image4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:clicked on Image"+mNames3.get(position));

                // AppCompatActivity activity=(AppCompatActivity)v.getContext();
                //statusfrafment f=new statusfrafment(mImageUrls3.get(position));
                //  activity.getSupportFragmentManager().beginTransaction().replace(R.id.parent_layout_main,f).addToBackStack(null).commit();
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
        return mImageUrls3.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{

        //widgets
        ImageView image4;
        TextView name2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image4=itemView.findViewById(R.id.image4);
            name2=itemView.findViewById(R.id.name2);

        }
    }


}
