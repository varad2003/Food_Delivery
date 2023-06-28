package com.example.foodeasy;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodeasy.databinding.HistoryLayoutBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Product_Cart_Adapter extends RecyclerView.Adapter<Product_Cart_Adapter.ProductHistoryViewHolder>{

    String apiurl="https://192.168.1.11/android/cart_update.php";
    String url="https://192.168.1.11/android/order_history_add.php";
    Context context;
    ArrayList<Product_Cart>product_histories;
    TextView total;
    LinearLayout checkout;


    public Product_Cart_Adapter(Context context, ArrayList<Product_Cart> product_histories, TextView total, LinearLayout checout) {
        this.context = context;
        this.product_histories = product_histories;
        this.total=total;
        this.checkout=checout;
        HttpsTrustManager.allowAllSSL();
    }


    @NonNull
    @Override
    public ProductHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.history_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHistoryViewHolder holder, int position) {
        Product_Cart product_history=product_histories.get(position);
        holder.binding.productName.setText(product_history.getName());
        holder.binding.price.setText(product_history.getPrice() *product_history.getCount()+"");
        holder.binding.count.setText(product_history.getCount()+"");
        updatetotal();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
                ){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        final String login_status = "login_status" ;
                        SharedPreferences sharedpreferences = context.getSharedPreferences(login_status, Context.MODE_PRIVATE);
                        String user_mail= sharedpreferences.getString("email",null);
                        Map<String,String> map=new HashMap<String,String>();
                        map.put("email",user_mail);
                        map.put("total_amount",total.getText()+"");

                        return map;

                    }
                };
                RequestQueue queue= Volley.newRequestQueue(context);
                queue.add(request);
            }
        });

        holder.binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_history.setCount(product_history.getCount() + 1);
                resetdata(product_history);
                notifyDataSetChanged();
                updatetotal();
            }


        });

        holder.binding.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_history.setCount(product_history.getCount() - 1);
                if( product_history.getCount() <=0){
                    resetdata(product_history);
                    product_histories.remove(position);
                    notifyItemRemoved(position);
                }
                else{
                    resetdata(product_history);
                    notifyDataSetChanged();
                }
                updatetotal();

            }
        });

    }

    private void resetdata(Product_Cart product) {

        StringRequest request=new StringRequest(Request.Method.POST, apiurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                final String login_status = "login_status" ;
                SharedPreferences sharedpreferences = context.getSharedPreferences(login_status, Context.MODE_PRIVATE);
                String user_mail= sharedpreferences.getString("email",null);
                Map<String,String> map=new HashMap<String,String>();
                map.put("email",user_mail);
                map.put("count",product.getCount()+"");
                map.put("product_id",product.getId()+"");
                return map;

            }
        };
        RequestQueue queue= Volley.newRequestQueue(context);
        queue.add(request);

    }

    private void updatetotal() {
        double total_amount=0;
        for(Product_Cart item:product_histories){
            total_amount=total_amount+(item.getPrice())*(item.getCount());
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
