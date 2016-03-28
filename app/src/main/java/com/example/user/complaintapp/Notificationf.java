package com.example.user.complaintapp;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.user.complaintapp.R.layout.subject;

public class Notificationf extends Fragment {
    ArrayAdapter<String> t;
    private  ListView l;
   Button b11;
    public Notificationf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notificationf, container, false);

        l=(ListView)v.findViewById(R.id.l);
        final String[] note ={"red","blue","green"};

        t = new ArrayAdapter<String>(getActivity(), R.layout.subject,R.id.sub,note);
        l.setAdapter(t);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = parent.g(position);
                Toast.makeText(getActivity().getApplicationContext(), "Observation Cancelled", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }

    /*@Override
    public void onStart() {
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), "Observation Cancelled", Toast.LENGTH_LONG).show();
            }
        });
    }*/
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        // TODO Auto-generated method stub
//        super.onListItemClick(l, v, position, id);
//
//    }




   /* public void open(View view) {
      /*  TextView tempb=(TextView)view;
        String S= tempb.getText().toString();
        Toast.makeText(getActivity().getApplicationContext(),
                S,
                Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("key", S);
        NotifyV n=new NotifyV();
        n.setArguments(bundle);
        Fragment mFragment = new NotifyV();
        FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frag, mFragment).commit();
    }*/



}
