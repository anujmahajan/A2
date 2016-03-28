package com.example.user.complaintapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Detailsf extends Fragment {

Button b11;
    public Detailsf() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_detailsf, container, false);
        b11=(Button)v.findViewById(R.id.b);
        //button listener
        b11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Fragment fragment = new NotifyV();

                //getActivity().getSupportFragmentManager().beginTransaction()
                  //      .replace(R.id.frag, fragment ).commit();
                Toast.makeText(getActivity(), "Observation msdnfsdmbnCancelled", Toast.LENGTH_SHORT).show();

            }
        });

        return v;

    }


}
