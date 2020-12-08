package com.example.apna_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class Mycustomdialog extends DialogFragment {
  photoss phh;
  ImageView imageView1;
  TextView textView1,textView2;
    private static final String TAG = "Mycustomdialog";

    public Mycustomdialog(photoss photoss) {
        phh=photoss;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.dialog_mycustom,container,false);

        imageView1=(ImageView) view.findViewById(R.id.imagee);
        imageView1.setImageResource(phh.getPhoto());
       textView1=view.findViewById(R.id.namee);
       textView1.setText(phh.getName());
        textView2=view.findViewById(R.id.nameee);
       textView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getDialog().dismiss();
           }
       });
       imageView1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                 zoom o=new zoom(phh);
               getDialog().dismiss();
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.parent_layout_main,o).addToBackStack(null).commit();

           }
       });
        return  view;
    }
}
