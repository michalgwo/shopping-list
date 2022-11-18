package com.example.shoppinglist.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.shoppinglist.models.ShoppingListItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListRepo {
    public static ShoppingListRepo instance;
    private ArrayList<ShoppingListItem> data;

    public static ShoppingListRepo getInstance() {
        if (instance == null) {
            instance = new ShoppingListRepo();
        }

        return instance;
    }

    public MutableLiveData<List<ShoppingListItem>> createShoppingList() {
        if (data == null) {
            data = new ArrayList<>();
        }

        MutableLiveData<List<ShoppingListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(data);
        return mutableLiveData;
    }
}
