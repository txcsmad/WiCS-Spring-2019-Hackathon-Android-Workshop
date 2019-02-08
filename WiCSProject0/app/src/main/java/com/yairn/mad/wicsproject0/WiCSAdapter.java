package com.yairn.mad.wicsproject0;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class WiCSAdapter extends RecyclerView.Adapter<ItemHolder> {

    private ArrayList<Integer> container;

    public WiCSAdapter(ArrayList<Integer> con) {
        container = con;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_holder,
                viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {

        itemHolder.setImage("https://images.unsplash.com/photo-1529933037705-0d537317ae7b?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=2524b7a67224f19e9a89dfbd33365c39&dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb");
        itemHolder.setText("Browser");
        itemHolder.setButtonOnClick(0);
    }

    @Override
    public int getItemCount() {
        return container.size();
    }
}
