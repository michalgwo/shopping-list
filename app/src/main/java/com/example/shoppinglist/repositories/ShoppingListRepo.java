package com.example.shoppinglist.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.shoppinglist.models.ShoppingListItem;

import java.util.List;

public class ShoppingListRepo {
    public static ShoppingListRepo instance;
    private MutableLiveData<List<ShoppingListItem>> shoppingList;

    public static ShoppingListRepo getInstance() {
        if (instance == null) {
            instance = new ShoppingListRepo();
        }

        return instance;
    }

    public MutableLiveData<List<ShoppingListItem>> getShoppingList() {
        return shoppingList;
    }
}
