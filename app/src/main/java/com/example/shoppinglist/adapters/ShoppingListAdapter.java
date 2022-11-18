package com.example.shoppinglist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglist.R;
import com.example.shoppinglist.models.ShoppingListItem;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ShoppingListItem> itemList;

    public ShoppingListAdapter(List<ShoppingListItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new RvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof RvViewHolder) {
            final RvViewHolder itemViewHolder = (RvViewHolder) holder;
            ShoppingListItem item = itemList.get(position);
            itemViewHolder.tvListRow.setText(item.getName());
            itemViewHolder.tvListRowTime.setText(item.getRelativeTime());
        }
    }

    public static class RvViewHolder extends RecyclerView.ViewHolder {
        private TextView tvListRow, tvListRowTime;

        public RvViewHolder(@NonNull View itemView)  {
            super(itemView);
            tvListRow = itemView.findViewById(R.id.tvListRow);
            tvListRowTime = itemView.findViewById(R.id.tvListRowTime);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
