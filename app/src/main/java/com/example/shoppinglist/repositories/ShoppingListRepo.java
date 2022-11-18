package com.example.shoppinglist.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.shoppinglist.models.ShoppingListItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListRepo {
    public static ShoppingListRepo instance;

    public static ShoppingListRepo getInstance() {
        if (instance == null) {
            instance = new ShoppingListRepo();
        }

        return instance;
    }

    public MutableLiveData<List<ShoppingListItem>> createShoppingList() {
        MutableLiveData<List<ShoppingListItem>> data = new MutableLiveData<>();
        data.setValue(new ArrayList<>());
        return data;
    }
}
