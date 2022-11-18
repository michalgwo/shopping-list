package com.example.shoppinglist.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoppinglist.models.ShoppingListItem;
import com.example.shoppinglist.repositories.ShoppingListRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<ShoppingListItem>> items;
    private ShoppingListRepo repo;

    public void init() {
        if (items != null) {
            return;
        }

        repo = ShoppingListRepo.getInstance();
        items = repo.getShoppingList();
    }

    public LiveData<List<ShoppingListItem>> getItems() {
        return items;
    }
}
