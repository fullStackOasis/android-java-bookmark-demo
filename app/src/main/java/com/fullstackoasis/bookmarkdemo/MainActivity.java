package com.fullstackoasis.bookmarkdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.fullstackoasis.bookmarkdemo.ui.button.ButtonFragment;
import com.fullstackoasis.bookmarkdemo.ui.image.ImageFragment;
import com.fullstackoasis.bookmarkdemo.ui.main.MainFragment;
import com.fullstackoasis.bookmarkdemo.ui.text.TextFragment;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            navigateToFragment();
        }
    }

    private void navigateToFragment() {
        sp = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        String where = sp.getString(Constants.BOOKMARK_KEY, null);

        Fragment f = null;
        switch (where) {
            case Constants.BOOKMARK_BUTTON:
                f = ButtonFragment.newInstance();
                break;
            case Constants.BOOKMARK_IMAGE:
                f = ImageFragment.newInstance();
                break;
            case Constants.BOOKMARK_TEXT:
                f = TextFragment.newInstance();
                break;
            default:
                f = MainFragment.newInstance();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f)
                .commitNow();
    }
}