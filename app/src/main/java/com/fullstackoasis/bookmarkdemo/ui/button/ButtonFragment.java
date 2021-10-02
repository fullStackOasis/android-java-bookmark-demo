package com.fullstackoasis.bookmarkdemo.ui.button;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fullstackoasis.bookmarkdemo.Constants;
import com.fullstackoasis.bookmarkdemo.R;
import com.fullstackoasis.bookmarkdemo.ui.image.ImageFragment;
import com.fullstackoasis.bookmarkdemo.ui.main.MainViewModel;

public class ButtonFragment extends Fragment {

    private MainViewModel mViewModel;
    private SharedPreferences sp;

    public static com.fullstackoasis.bookmarkdemo.ui.button.ButtonFragment newInstance() {
        return new com.fullstackoasis.bookmarkdemo.ui.button.ButtonFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.button_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp = getActivity().getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constants.BOOKMARK_KEY, Constants.BOOKMARK_BUTTON);
        editor.commit();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button button = getActivity().findViewById(R.id.btn_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ImageFragment())
                        .commitNow();
            }
        });
    }
}