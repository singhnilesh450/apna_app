package com.example.apna_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class zoom extends Fragment {
    ImageView imageView5;
    private ArrayList<String> mImageUrls = new ArrayList<>();
   photoss ph;



    public zoom(photoss photoss1) {
        ph=photoss1;
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
        View view=inflater.inflate(R.layout.zoom,container,false);

         imageView5=(ImageView) view.findViewById(R.id.image_view3);
         imageView5.setImageResource(ph.getPhoto());
       //  download();
  /*Glide.with(statusfrafment.this)
                .asBitmap()
                .load(mImageUrls)
                .into(imageView);*/


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
