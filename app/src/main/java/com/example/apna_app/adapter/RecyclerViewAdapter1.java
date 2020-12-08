package com.example.apna_app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apna_app.ImainInterface;
import com.example.apna_app.Mycustomdialog;
import com.example.apna_app.R;
import com.example.apna_app.photoss;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.DialogInterface.*;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter{
    private static final String TAG = "RecyclerViewAdapter1";

    private ArrayList<photoss> mNames1=new ArrayList<>();

    private  Context mContext1;
    private  FragmentManager fm;
    private ImainInterface imainInterface;
    public RecyclerViewAdapter1(ArrayList<photoss> image, Context context1) {
        mNames1 =image;
        mContext1 = context1;
    }

    @NonNull
    @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitemvertical,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder:call");

       int currentPos=position;

        ((ImageView) holder.itemView.findViewById(R.id.image_view1)).setImageResource(mNames1.get(position).getPhoto());

        ((TextView)holder.itemView.findViewById(R.id.text_view1)).setText(mNames1.get(position).getName());

        ((ImageView) holder.itemView.findViewById(R.id.image_view1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:clicked on Image"+mNames1.get(position));
              AppCompatActivity activity=(AppCompatActivity)v.getContext();
              //  zoom o=new zoom(mNames1.get(position));
                Mycustomdialog mycustomdialog=new Mycustomdialog(mNames1.get(position));
               // activity.getSupportFragmentManager().beginTransaction().replace(R.id.parent_layout_main,mycustomdialog).addToBackStack(null).commit();
                mycustomdialog.show(activity.getSupportFragmentManager(),"Mycustomdialog");
               /* Glide.with(mContext1)
                        .asBitmap()
                        .load(mNames1.get(position))
                        .into((ImageView) holder.itemView.findViewById(R.id.image_view));*/
               // Toast.makeText(mContext1,mNames1.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        ( holder.itemView.findViewById(R.id.parent_layout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imainInterface.inflateviewdialoffragment(mNames1.get(position));


            }
        });
      //  ((TextView) holder.itemView.findViewById(R.id.text_view1)).setOnClickListener(new View.OnClickListener() {
         //   @Override



          //  public void onClick(View v) {

                // AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext1,R.style.Theme_AppCompat_Light_Dialog);
               //  alertDialog.setTitle("Are you Sure?");
                // alertDialog.setMessage("would you like to delete?");
                 //alertDialog.setNegativeButton("Yes", new OnClickListener() {
                    // @Override
                  //   public void onClick(DialogInterface dialog, int which) {
                  //     dialog.dismiss();
                     }
                // });
                // alertDialog.create();
               //  alertDialog.show();

                 //.setIcon(android.R.drawable.ic_dialog_alert).setTitle("Are you Sure?").setMessage("would you like to delete?").setNegativeButton("no",null).show();
                        //.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  //  @Override
                  //  public void onClick(DialogInterface dialog, int which) {

                  //  }
               // })
                    //    .setNegativeButton("No",null)
                       // .show();

          //  }
       // });


  /*  @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG,"onBindViewHolder:call");



        Glide.with(mContext1)
                .asBitmap()
                .load(mImageUrls1.get(position))
               // .into((ImageView) viewHolder.itemView.findViewById(R.id.image_view1));
                .into(viewHolder.image1);
        viewHolder.imagename.setText(mNames1.get(position));

       viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:clicked on Image"+mNames1.get(position));
                Toast.makeText(mContext1,mNames1.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }*/

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        imainInterface=(ImainInterface) mContext1;
    }

    @Override
    public int getItemCount() {
        return  mNames1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
          CircleImageView image1;
          TextView imagename;
         RelativeLayout parent_layout;

        public ViewHolder(@NonNull View itemView1) {
            super(itemView1);

            image1=itemView1.findViewById(R.id.image_view1);
            imagename=itemView1.findViewById(R.id.text_view1);
            parent_layout=itemView1.findViewById(R.id.parent_layout);

        }
    }
}
