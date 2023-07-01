package com.example.foodeasy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Products_order_history_fragment extends Fragment {

    RecyclerView recyclerView;
    TextView date_and_time,total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_products_order_history_fragment, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        date_and_time=view.findViewById(R.id.date_and_time);
        total=view.findViewById(R.id.total_amt);

        date_and_time.setText("Date and time");
        total.setText(1000+"");

        ArrayList<Product_history_sample>product_history_samples=new ArrayList<>();
        product_history_samples.add(new Product_history_sample("Pizza",1,100));
        product_history_samples.add(new Product_history_sample("Pizza",1,100));
        product_history_samples.add(new Product_history_sample("Pizza",1,100));

        Product_history_sample_adapter product_history_sample_adapter=new Product_history_sample_adapter(getContext(),product_history_samples);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(product_history_sample_adapter);

        return view;
    }
}