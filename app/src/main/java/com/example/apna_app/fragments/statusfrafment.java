package com.example.apna_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.apna_app.R;

import java.util.ArrayList;

public class statusfrafment extends Fragment {
    ImageView imageView;
    private ArrayList<String> mImageUrls = new ArrayList<>();
   String imageurl;

    public statusfrafment(String imageurl) {
        this.imageurl = imageurl;
    }

    /*  public  void download(){
                imageDownload i=new imageDownload();
                AsyncTask<String, Void, Bitmap> n;

                    try {
                        n=i.execute(mImageUrls.get(p));
                        imageView.setImage(n);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.statusfragment,container,false);

         imageView=(ImageView) view.findViewById(R.id.image_view2);
       //  download();
    try {
        Glide.with(statusfrafment.this)
                .asBitmap()
                .load(imageurl)
                .into(imageView);
    }catch ( Exception e){
        e.printStackTrace();
    }
        return  view;
    }

  /*  public class imageDownload extends AsyncTask<String , Void, Bitmap>{


        @Override
        protected Bitmap doInBackground(String... urls) {

            URL url;
            HttpURLConnection httpURLConnection=null;
            try{
                String result="";
                url=new URL(urls[0]);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream=httpURLConnection.getInputStream();

                Bitmap myBitmap= BitmapFactory.decodeStream(inputStream);
              return  myBitmap;
            }catch (Exception e){
                e.printStackTrace();
            }

      return null;
        }
    }*/
}
