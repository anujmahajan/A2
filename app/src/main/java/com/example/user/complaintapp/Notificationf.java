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
    private  ListView l;
    TextView t1,t2;
    private static int udone=0;
    public static ArrayList<String> comp_id=new ArrayList<String>();
    public static ArrayList<String> id=new ArrayList<String>();
    public static ArrayList<String> CCodes=new ArrayList<String>();
    private String jsonResponse;
    private static String JSON_URL ;
    final String[] note ={"red","blue","green"};
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
                        }
                        String[] array1 = comp_id.toArray(new String[comp_id.size()]);
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
        }}

}
