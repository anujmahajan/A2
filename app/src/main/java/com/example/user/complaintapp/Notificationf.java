package com.example.user.complaintapp;


import android.support.v4.app.ListFragment;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.user.complaintapp.R.layout.subject;

public class Notificationf extends ListFragment {
    ArrayAdapter<String> t;
    String[] array1;
    private static int udone=0;
    private static ArrayList<String> comp_id,comp_txt,comp_prio,comp_compl,comp_resolv,comp_poll,comp_thread,comp_anon,comp_status;
    private static String JSON_URL ;
    public Notificationf() {
        // Required empty public constructor
        JSON_URL= Login.ip + "default/mynotes.json";

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
        //get the json data to fill the adapter
         comp_id=new ArrayList<String>();
         comp_txt=new ArrayList<String>();
         comp_prio=new ArrayList<String>();
         comp_compl=new ArrayList<String>();
         comp_resolv=new ArrayList<String>();
         comp_poll=new ArrayList<String>();
         comp_thread=new ArrayList<String>();
         comp_anon=new ArrayList<String>();
         comp_status=new ArrayList<String>();
        requestdata();
    }

    private void requestdata() {

        JsonObjectRequest jreq = new JsonObjectRequest(Request.Method.GET,
                JSON_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {


                try {
                    // Parsing json object response
                    JSONArray complist = response.getJSONArray("mynotes");
                    Boolean b=response.getBoolean("success");
                    if(b)
                    {
                        for (int i = 0; i < complist.length(); i++) {
                            JSONObject compl = (JSONObject) complist.get(i);
                            comp_id.add(compl.getString("id"));
                            comp_txt.add(compl.getString("maintext"));
                            comp_prio.add(compl.getString("priority"));
                            comp_compl.add(compl.getString("complainer"));
                            comp_resolv.add(compl.getString("resolver"));
                            comp_poll.add(compl.getString("pollId"));
                            comp_thread.add(compl.getString("threadId"));
                            comp_anon.add(compl.getString("anony"));
                            comp_status.add(compl.getString("status"));
                        }
                        array1 = comp_id.toArray(new String[comp_id.size()]);
                        t = new ArrayAdapter<String>(getActivity(), R.layout.subject,R.id.sub,array1);
                        setListAdapter(t);
                        //udone set to 1 for non repetative json results
                        if (complist.length()>0){
                            udone=1;//for static put 1
                        }}}
                catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),
                            "Error: NOT WORKING " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }}}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }});
        RequestQueue RequestP = Volley.newRequestQueue(getActivity());
        RequestP.add(jreq);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String S = (String)l.getItemAtPosition(position);
        //based on s get the remaining string values
        int y=comp_id.indexOf(S);
        String S1=comp_txt.get(y);
        String S2=comp_prio.get(y);
        String S3=comp_compl.get(y);
        String S4=comp_poll.get(y);
        String S5=comp_resolv.get(y);
        String S6=comp_thread.get(y);
        String S7=comp_anon.get(y);
        String S8=comp_status.get(y);
            NotifyV myDetailFragment = new NotifyV();
            Bundle bundle = new Bundle();
            bundle.putString("txt", S1);
        bundle.putString("id", S);
        bundle.putString("prio", S2);
        bundle.putString("comp", S3);
        bundle.putString("poll", S4);
        bundle.putString("res", S5);
        bundle.putString("thread", S6);
        bundle.putString("anon", S7);
        bundle.putString("status",S8);
            myDetailFragment.setArguments(bundle);
        FragmentManager fm =getFragmentManager();

        if (fm.findFragmentById(android.R.id.content) == null) {
            FragmentTransaction ft = fm.beginTransaction();
            // FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
            ft.replace(R.id.frag, myDetailFragment);
            ft.commit();
        }}

}
