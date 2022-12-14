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
        items = repo.createShoppingList();
    }

    public LiveData<List<ShoppingListItem>> getItems() {
        return items;
    }

    public void addItem(ShoppingListItem item) {
        List<ShoppingListItem> itemsList = items.getValue();
        assert itemsList != null;
        itemsList.add(item);
        items.postValue(itemsList);
    }

    public void removeItem(ShoppingListItem item) {
        List<ShoppingListItem> itemsList = items.getValue();
        assert itemsList != null;
        itemsList.remove(item);
        items.postValue(itemsList);
    }
}
