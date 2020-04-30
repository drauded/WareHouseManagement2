package com.warehouse.ui.shoppingcart;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.warehouse.db.DbWhCartC;

import java.util.List;

public class ShoppingcartViewModel extends ViewModel  {

    private MutableLiveData<String> mText;

    public ShoppingcartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is shopping cart fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<List<DbWhCartC>> dbWhCartCMutableLiveData;
    public LiveData<List<DbWhCartC>> getListDbWhCartC() {
        return dbWhCartCMutableLiveData;
    }



    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}