package com.warehouse.ui.shoppingcart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.warehouse.R;

public class ShoppingcartFragment extends Fragment {

    private ShoppingcartViewModel ShoppingcartViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ShoppingcartViewModel =
                ViewModelProviders.of(this).get(ShoppingcartViewModel.class);
        ShoppingcartViewModel.setContext(this.getActivity().getApplicationContext());

        View root = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        final TextView textView = root.findViewById(R.id.text_shoppingcart);
        ShoppingcartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
