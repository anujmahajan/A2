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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.user.complaintapp.R.layout.subject;


public class Notificationf extends Fragment {

    private  ListView l;

    public Notificationf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notificationf, container, false);

        l=(ListView)v.findViewById(R.id.lvn);
        String[] note ={"red","blue","green"};
        ArrayAdapter<String> t;
        t = new ArrayAdapter<String>(getActivity(), R.layout.subject,R.id.sub,note);
        l.setAdapter(t);


        return v;
    }


    public void open(View view) {
      /*  TextView tempb=(TextView)view;
        String S= tempb.getText().toString();
        Toast.makeText(getActivity().getApplicationContext(),
                S,
                Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("key", S);
        NotifyV n=new NotifyV();
        n.setArguments(bundle);*/
        Fragment mFragment = new NotifyV();
        FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frag, mFragment).commit();
    }


}
