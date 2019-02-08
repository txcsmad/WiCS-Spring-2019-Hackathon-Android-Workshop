package com.yairn.mad.finalwicsproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemCardAdapter extends RecyclerView.Adapter<ItemCardHolder> {

    private ArrayList<TypeData> container = null;

    /*
     * The constructor of the adapter requires a container
     */
    public ItemCardAdapter(ArrayList<TypeData> container) {
        this.container = container;
    }

    /*
     * The KittenItemHolder method inflates/creates the Kitten Items based on the kitten_item_card layout
     */
    @Override
    public ItemCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cardView = layoutInflater.inflate(R.layout.item_card_holder, parent, false);
        return new ItemCardHolder(cardView);
    }

    /*
     * The onBindViewHolder method, binds the position of the item in the RecycleView with its own data.
     */
    @Override
    public void onBindViewHolder(@NonNull ItemCardHolder holder, int position) {

        holder.setType(container.get(position));
        holder.setText();

        holder.setButtonOnClick();

        if(container.get(position).type == Type.Image) {
            holder.setImage();
        } else {
            holder.setImage(container.get(position).resource);
        }
    }

    /* The getItemCount returns the number of items in the Adapter */
    @Override
    public int getItemCount() {
        return container.size();
    }
}
