package com.example.user.complaintapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Resolvef extends ListFragment {
private  ListView l;
    public Resolvef() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notificationf, container, false);

        //l=(ListView)v.findViewById(R.id.lvr);
        String[] note ={"rdfkjshed","bludjfse","grekdjfnskdfnen"};
        ArrayAdapter<String> t;
        t = new ArrayAdapter<String>(getActivity(), R.layout.subject,R.id.sub,note);
        setListAdapter(t);


        return v;
    }


}
