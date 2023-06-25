package com.example.foodeasy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodeasy.databinding.ActivityMarketplaceBinding;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {

    Product_adapter product_adapter;
    ArrayList<Product>products;
//    ActivityMarketplaceBinding binding;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_, container, false);

        initiateProducts(view);


        return view;
    }

    private void initiateProducts(View view) {
        products=new ArrayList<>();
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        products.add(new Product("Pizza","Full grilled chicken pizza with legpiece ","https://media.istockphoto.com/id/1192094401/photo/delicious-vegetarian-pizza-on-white.webp?s=1024x1024&w=is&k=20&c=ZQKSxLVVwUgwFEUuDcam6Kc-7IdjpKw4wWA--6HbFZw=",200.00,1));
        product_adapter=new Product_adapter(getContext(),products);
        recyclerView=view.findViewById(R.id.product_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(product_adapter);

    }
}