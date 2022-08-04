package com.example.fragmenttofragment.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmenttofragment.R;

public class Page2_Fragment extends Fragment {

    TextView textView;
    ImageView back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_page2_,container,false);
        textView=v.findViewById(R.id.txt2);
        Bundle bundle=this.getArguments();
        String data= bundle.getString("key");
        textView.setText(data);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back=view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Page1_Fragment fragment=new Page1_Fragment();
                getFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
            }
        });
    }
}