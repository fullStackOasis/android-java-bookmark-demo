package com.fullstackoasis.bookmarkdemo.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fullstackoasis.bookmarkdemo.Constants;
import com.fullstackoasis.bookmarkdemo.R;
import com.fullstackoasis.bookmarkdemo.ui.button.ButtonFragment;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private SharedPreferences sp;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constants.BOOKMARK_KEY, Constants.BOOKMARK_MAIN);
        editor.commit();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView tv = getActivity().findViewById(R.id.tv_message);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ButtonFragment())
                        .commitNow();
            }
        });
    }

}