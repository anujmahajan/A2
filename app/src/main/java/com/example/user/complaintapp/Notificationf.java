package com.example.user.complaintapp;


import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
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

public class Notificationf extends ListFragment {
    ArrayAdapter<String> t;
    private  ListView l;
   Button b11;
    final String[] note ={"red","blue","green"};
    public Notificationf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notificationf, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        t = new ArrayAdapter<String>(getActivity(), R.layout.subject,R.id.sub,note);
        setListAdapter(t);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String S = (String)l.getItemAtPosition(position);
        Toast.makeText(getActivity().getApplicationContext(),
                S,
                Toast.LENGTH_SHORT).show();

    /*
     * The second fragment not yet loaded.
     * Load MyDetailFragment by FragmentTransaction, and pass
     * data from current fragment to second fragment via bundle.
     */

            NotifyV myDetailFragment = new NotifyV();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", S);
            myDetailFragment.setArguments(bundle);
        android.app.FragmentManager fm =getFragmentManager();

        if (fm.findFragmentById(android.R.id.content) == null) {
            android.app.FragmentTransaction ft = fm.beginTransaction();
            // FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
            ft.replace(R.id.frag, myDetailFragment);
            ft.commit();
        }



    }






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
