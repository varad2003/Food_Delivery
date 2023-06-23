package com.example.foodeasy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Profile_Fragment extends Fragment {

//    String first_name,last_name,email,phone;
    public final String apiurl="https://192.168.1.2/android/profile_data_fetch.php";
    TextInputEditText email,address,phone,full_name;
    TextView first_name;

    String user_mail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile_, container, false);

        HttpsTrustManager.allowAllSSL();

        TextView logout,update;

        logout=view.findViewById(R.id.logout_btn);
        update=view.findViewById(R.id.update_btn);

        final String login_status = "login_status" ;
        SharedPreferences sharedpreferences = getContext().getSharedPreferences(login_status, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        user_mail= sharedpreferences.getString("email",null);

        fetchdata(view);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove(login_status);
                editor.apply();
                editor.commit();
                startActivity(new Intent(getContext(),Login.class));

            }
        });

        return view;
    }

    private void fetchdata(View view)
    {
        StringRequest request=new StringRequest(Request.Method.POST, apiurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray ja=new JSONArray(response);
                    JSONObject jo=null;

                    jo=ja.getJSONObject(0);
                    first_name=view.findViewById(R.id.first_name);
                    email=view.findViewById(R.id.email);
                    phone=view.findViewById(R.id.phone);
                    address=view.findViewById(R.id.address);
                    full_name=view.findViewById(R.id.fullname);

                    email.setKeyListener(null);
                    full_name.setKeyListener(null);
                    phone.setKeyListener(null);
                    address.setKeyListener(null);

                    first_name.setText(jo.getString("first_name"));
                    String fullname=jo.getString("first_name")+" "+jo.getString("last_name");
                    full_name.setText(fullname);
                    phone.setText(jo.getString("phone"));
                    email.setText(jo.getString("email"));
                    address.setText("Address");

                }catch (Exception ex)
                {
                    System.out.println(response);
                    Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<String,String>();
                map.put("email",user_mail);
                return map;

            }
        };
        RequestQueue queue= Volley.newRequestQueue(getContext());
        queue.add(request);

    }


}