package com.example.foodeasy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Profile_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile_, container, false);


        TextView logout,update;

        logout=view.findViewById(R.id.logout_btn);
        update=view.findViewById(R.id.update_btn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String login_status = "login_status" ;
                SharedPreferences sharedpreferences = getContext().getSharedPreferences(login_status, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.remove(login_status);
                editor.apply();
                editor.commit();
                startActivity(new Intent(getContext(),Login.class));

            }
        });

        return view;
    }
}