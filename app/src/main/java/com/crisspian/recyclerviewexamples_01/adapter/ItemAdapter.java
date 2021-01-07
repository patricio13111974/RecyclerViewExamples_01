package com.crisspian.recyclerviewexamples_01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.recyclerviewexamples_01.databinding.ItemListDataBinding;
import com.crisspian.recyclerviewexamples_01.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding binding=ItemListDataBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item itemListHolder=itemList.get(position);
        holder.textView.setText(itemListHolder.getItemDescription());
        Glide.with(holder.imageView.getContext()).load(itemListHolder.getUrlImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public ItemViewHolder(@NonNull ItemListDataBinding itemBinding) {
            super(itemBinding.getRoot());
            textView=itemBinding.tvItem;
            imageView=itemBinding.ivItem;
        }
    }

}
