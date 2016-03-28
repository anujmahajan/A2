package com.example.user.complaintapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


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
        View v=inflater.inflate(R.layout.fragment_notify_v, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "Observation msdnfsdmbnCanceholy shitlled", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        t=(TextView)getActivity().findViewById(R.id.tv);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String i = bundle.getString("key");
            t.setText(i);

        }
    }
}
