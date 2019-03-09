package com.example.bottomspace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mItems;

    RecyclerViewAdapter(List<String> items) {
        mItems = items;
    }

    @Override
    public @NonNull
    RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder vh = (ItemViewHolder) holder;
        String itemText = mItems.get(position);

        vh.mItemTextView.setText(itemText);
        int bgColor = (position % 2 == 0)
                ? android.R.color.holo_blue_light
                : android.R.color.holo_green_light;
        holder.itemView.setBackgroundColor(
                holder.itemView.getContext().getResources().getColor(bgColor));
    }

    @Override
    public int getItemCount() {
        return (mItems == null) ? 0 : mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView mItemTextView;

        ItemViewHolder(View item) {
            super(item);
            mItemTextView = item.findViewById(android.R.id.text1);
        }
    }

    public void setItems(List<String> items) {
        mItems = items;
    }

    @SuppressWarnings("unused")
    private final static String TAG = "RecyclerViewAdapter";

    private final static int TYPE_ITEM = 1;
}

