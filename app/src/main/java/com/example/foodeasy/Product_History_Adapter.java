package com.example.foodeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodeasy.databinding.HistoryLayoutBinding;

import java.util.ArrayList;

public class Product_History_Adapter extends RecyclerView.Adapter<Product_History_Adapter.ProductHistoryViewHolder> {

    Context context;
    ArrayList<Product_History>product_histories;

//    ArrayList<Product_history_sample>product_history_samples;

    public Product_History_Adapter(Context context, ArrayList<Product_History>product_histories){
        this.context=context;
        this.product_histories=product_histories;
//        this.product_history_samples=product_history_samples;
        HttpsTrustManager.allowAllSSL();
    }

    @NonNull
    @Override
    public ProductHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ProductHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.history_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHistoryViewHolder holder, int position) {
       Product_History product_history=product_histories.get(position);

//       ArrayList<Product_history_sample>productHistorySamples=new ArrayList<>();
//       productHistorySamples.add(new Product_history_sample("Pizza",1));
//       productHistorySamples.add(new Product_history_sample("Pizza",1));
//       productHistorySamples.add(new Product_history_sample("Pizza",1));

        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Pizza");
        arrayList.add("burger");
        arrayList.add("fries");

//       Product_history_sample_adapter product_history_sample_adapter=new Product_history_sample_adapter(context,productHistorySamples);
        ArrayAdapter adapter=new ArrayAdapter(context, android.R.layout.simple_list_item_1,arrayList);
       holder.binding.prevOrderLv.setAdapter(adapter);
       holder.binding.dateAndTime.setText(product_history.getDate_and_time());
       holder.binding.totalAmt.setText(product_history.getTotal()+"");
    }

    @Override
    public int getItemCount() {
        return product_histories.size();
    }

    public class ProductHistoryViewHolder extends RecyclerView.ViewHolder{
        HistoryLayoutBinding binding;
        public ProductHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= HistoryLayoutBinding.bind(itemView);
        }
    }
}
