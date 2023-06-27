package com.example.foodeasy;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.text.NoCopySpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodeasy.databinding.HistoryLayoutBinding;
import com.example.foodeasy.databinding.ProductsLayoutBinding;

import java.util.ArrayList;

public class Product_History_Adapter extends RecyclerView.Adapter<Product_History_Adapter.ProductHistoryViewHolder>{

    Context context;
    ArrayList<Product_History>product_histories;
    TextView total;

    public Product_History_Adapter(Context context, ArrayList<Product_History> product_histories,TextView total) {
        this.context = context;
        this.product_histories = product_histories;
        this.total=total;
    }

    @NonNull
    @Override
    public ProductHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.history_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHistoryViewHolder holder, int position) {
        Product_History product_history=product_histories.get(position);
        holder.binding.productName.setText(product_history.name);
        holder.binding.price.setText(product_history.price*product_history.getCount()+"");
        holder.binding.count.setText(product_history.getCount()+"");
        updatetotal();

        holder.binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_history.count= product_history.getCount()+1;
                notifyDataSetChanged();
                updatetotal();
            }


        });

        holder.binding.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_history.count= product_history.getCount()-1;
                if(  product_history.count==0){
                    product_histories.remove(position);
                    notifyItemRemoved(position);
                }
                else{
                    notifyDataSetChanged();
                }
                updatetotal();
            }
        });

    }

    private void updatetotal() {
        double total_amount=0;
        for(Product_History item:product_histories){
            total_amount=total_amount+(item.price)*(item.count);
        }
        total.setText(total_amount+"");
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
