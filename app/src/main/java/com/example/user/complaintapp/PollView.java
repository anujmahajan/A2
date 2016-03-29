package com.example.user.complaintapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PollView extends Fragment {

     String Json,i2;
    public PollView() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_poll_view, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
           //id of the complaint for the view to show
            i2 = bundle.getString("id");
            Json= Login.ip + "viewpoll.json/"+i2;            //view poll
            request();
        }
        return v;
    }

    private void request() {

    }

}
