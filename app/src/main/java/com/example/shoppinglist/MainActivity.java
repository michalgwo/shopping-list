package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.shoppinglist.adapters.ShoppingListAdapter;
import com.example.shoppinglist.models.ShoppingListItem;
import com.example.shoppinglist.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button bAdd;
    private EditText etNewItem;
    private RecyclerView rvItemList;
    private ShoppingListAdapter adapter;
    private MainActivityViewModel viewModel;

    private void init() {
        bAdd = findViewById(R.id.bAdd);
        etNewItem = findViewById(R.id.etNewItem);
        rvItemList = findViewById(R.id.rvItemList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initViewModel();
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new ShoppingListAdapter(viewModel.getItems().getValue());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvItemList.setLayoutManager(layoutManager);
        rvItemList.setAdapter(adapter);
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getItems().observe(this, shoppingListItems -> {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        });
    }
}