package com.example.fragmenttofragment.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fragmenttofragment.R;

public class Page1_Fragment extends Fragment {

    ListView listView;
    String[] names={"Adroid","Java","DataBase","SQLite","Pyton"};
    ArrayAdapter<String> arrayAdapter;

    public Page1_Fragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page1_,container,false);
        view.setBackgroundColor(Color.WHITE);

        listView=view.findViewById(R.id.list1);
        arrayAdapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle=new Bundle();
                String tempListValue=arrayAdapter.getItem(i).toString();
                bundle.putString("key",tempListValue);
                Page2_Fragment fragment=new Page2_Fragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
            }
        });
        // Inflate the layout for this fragment
        return view;

    }
}