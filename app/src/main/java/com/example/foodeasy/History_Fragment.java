package com.example.foodeasy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class History_Fragment extends Fragment {

    RecyclerView recyclerView;
    TextView total;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history_, container, false);

        recyclerView=view.findViewById(R.id.history_recycler_view);
        total=view.findViewById(R.id.total_amt);

        ArrayList<Product_History>history_products=new ArrayList<>();
        history_products.add(new Product_History("Veg chicken pizza",1,2,100,200));
        history_products.add(new Product_History("Pizza",1,2,100,200));
        history_products.add(new Product_History("Pizza",1,2,100,200));

        Product_History_Adapter product_history_adapter=new Product_History_Adapter(getContext(),history_products,total);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(product_history_adapter);

        return view;
    }
}