package com.example.shoppinglist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglist.R;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> itemList;

    public ShoppingListAdapter(List<String> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here Inflating your recyclerview item layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new RvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof RvViewHolder) {
            final RvViewHolder itemViewHolder = (RvViewHolder) holder;

            String item = itemList.get(position);
            itemViewHolder.tvListRow.setText(item);
        }
    }

    public static class RvViewHolder extends RecyclerView.ViewHolder {
        private TextView tvListRow;

        public RvViewHolder(@NonNull View itemView)  {
            super(itemView);
            tvListRow = itemView.findViewById(R.id.tvListRow);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
