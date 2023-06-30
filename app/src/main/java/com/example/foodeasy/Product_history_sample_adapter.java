package com.example.foodeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Product_history_sample_adapter extends ArrayAdapter<Product_history_sample> {
    Context context;
    ArrayList<Product_history_sample>product_history_samples;

    public Product_history_sample_adapter(@NonNull Context context, ArrayList<Product_history_sample> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
        this.context=context;
        this.product_history_samples=arrayList;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.prducts_in_history_listview, parent, false);
        }

        Product_history_sample currentNumberPosition = getItem(position);

        assert convertView != null;
        TextView product_name=convertView.findViewById(R.id.product_name);
        product_name.setText(currentNumberPosition.getName());
        TextView count=convertView.findViewById(R.id.count);
        count.setText(currentNumberPosition.getCount()+"");

        return currentItemView;
    }
}


