package com.example.user.complaintapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyV extends Fragment {

    TextView t;
    public NotifyV() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        t=(TextView)getActivity().findViewById(R.id.tv);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String i = bundle.getString("key");
            t.setText(i);

        }
        return inflater.inflate(R.layout.fragment_notify_v, container, false);
    }

}
