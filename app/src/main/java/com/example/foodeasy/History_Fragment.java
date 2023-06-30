package com.example.foodeasy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class History_Fragment extends Fragment {

    String apiurl="https://192.168.43.221/android/cart_fetch_data.php";

    RecyclerView recyclerView;
    Product_History_Adapter product_history_adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_history_, container, false);
        HttpsTrustManager.allowAllSSL();

        recyclerView=view.findViewById(R.id.history_recycler_view);

        ArrayList<Product_History>product_histories=new ArrayList<>();
        product_histories.add(new Product_History( "name",  "date_and_time",  2, 200.0 ));
        product_histories.add(new Product_History( "name",  "date_and_time",  2, 200.0 ));
        product_histories.add(new Product_History( "name",  "date_and_time",  2, 200.0 ));
        product_histories.add(new Product_History( "name",  "date_and_time",  2, 200.0 ));



        product_history_adapter=new Product_History_Adapter(getContext(),product_histories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(product_history_adapter);


        return view;
    }


}