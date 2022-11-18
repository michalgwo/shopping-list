package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.shoppinglist.adapters.ShoppingListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button bAdd;
    private EditText etNewItem;
    private RecyclerView rvItemList;
    private ShoppingListAdapter adapter;

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
        initRecyclerView();
    }


    private void initRecyclerView() {
        adapter = new ShoppingListAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvItemList.setLayoutManager(layoutManager);
        rvItemList.setAdapter(adapter);
    }
}