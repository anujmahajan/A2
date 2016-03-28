package com.example.user.complaintapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResolveD extends Fragment {

     Button b1,b2,b3,b4,b5,b6;
    public ResolveD() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resolve_d, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        b1=(Button)getActivity().findViewById(R.id.status);
        b2=(Button)getActivity().findViewById(R.id.poll);
        b3=(Button)getActivity().findViewById(R.id.redun);
        b4=(Button)getActivity().findViewById(R.id.up);
        b5=(Button)getActivity().findViewById(R.id.down);
        b6=(Button)getActivity().findViewById(R.id.thread);
        //check status
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

             checkstatus();
            }
        });
        //set up poll
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
             setpoll();

            }
        });
       //mark redundant
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

             redundant();
            }
        });
        //upvote
        b4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
             upvote();
            }
        });
         //downvote
        b5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                downvote();

            }
        });
        //view thread
        b6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
             viewthread();

            }
        });



    }

    //marks complaint redundant
    private void redundant() {

    }
    //upvotes a complaint
    private void upvote() {
    }
    //downvotes a complaint
    private void downvote() {
    }

    //views a thread
    private void viewthread() {
    }
    //sets up a poll
    private void setpoll() {
    }
    //check status
    private void checkstatus() {
    }
}
