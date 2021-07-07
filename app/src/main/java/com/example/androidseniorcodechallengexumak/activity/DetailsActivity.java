package com.example.androidseniorcodechallengexumak.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.androidseniorcodechallengexumak.R;
import com.example.androidseniorcodechallengexumak.fragment.characterDetail.CharacterDetailFragment;
import com.example.androidseniorcodechallengexumak.fragment.characterList.CharacterListFragment;
import com.example.androidseniorcodechallengexumak.model.BreakingBadCharacter;

public class DetailsActivity extends AppCompatActivity {

    private BreakingBadCharacter character;

    public DetailsActivity(){
        super(R.layout.activity_details);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {

            this.character = (BreakingBadCharacter) getIntent().getSerializableExtra("character");

            Bundle bundle = new Bundle();
            bundle.putSerializable("character", character);

            getSupportActionBar().setTitle(this.character.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_details_view, CharacterDetailFragment.class, bundle)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}