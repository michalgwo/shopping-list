package com.example.shoppinglist.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoppinglist.models.ShoppingListItem;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<ShoppingListItem>> items;

    public LiveData<List<ShoppingListItem>> getItems() {
        return items;
    }
}
