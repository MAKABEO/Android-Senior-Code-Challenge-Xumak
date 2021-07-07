package com.example.androidseniorcodechallengexumak.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.androidseniorcodechallengexumak.R;
import com.example.androidseniorcodechallengexumak.fragment.characterList.CharacterListFragment;

public class MainActivity extends AppCompatActivity {

    public MainActivity(){
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Breaking Bad Characters");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, CharacterListFragment.class, null)
                    .commit();
        }
    }
}