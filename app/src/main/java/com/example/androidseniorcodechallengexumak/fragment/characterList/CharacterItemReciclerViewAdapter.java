package com.example.androidseniorcodechallengexumak.fragment.characterList;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.androidseniorcodechallengexumak.R;
import com.example.androidseniorcodechallengexumak.activity.DetailsActivity;
import com.example.androidseniorcodechallengexumak.model.BreakingBadCharacter;
import com.example.androidseniorcodechallengexumak.utils.Connector;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class CharacterItemReciclerViewAdapter extends RecyclerView.Adapter<CharacterItemReciclerViewAdapter.ViewHolder> {

    private List<BreakingBadCharacter> characters;

    private int page;
    private int limit;
    private int offset;
    private View view;

    public CharacterItemReciclerViewAdapter(View view) {
        this.view = view;
        characters = new ArrayList<>();
        this.limit = 10;
        this.offset = 0;
        this.page = 0;
        getdata(limit,offset);
    }

    public void getdata(int limit, int offset) {
        ProgressBar bar = (ProgressBar) view.findViewById(R.id.chracterProgressBar);
        bar.setVisibility(View.VISIBLE);
        Call<List<BreakingBadCharacter>> call= Connector.getInstance().getInfoApi().getInfoData(limit, offset);
        call.enqueue(new Callback<List<BreakingBadCharacter>>() {
            @Override
            public void onResponse(Call<List<BreakingBadCharacter>> call, Response<List<BreakingBadCharacter>> response) {
                characters.addAll(response.body());
                notifyDataSetChanged();
                bar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<BreakingBadCharacter>> call, Throwable t) {

            }
        });
    }

    public void loadMore(){
        this.page++;
        this.offset = this.limit;
        this.limit *= this.page;
        getdata(this.limit,this.offset);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_character_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = characters.get(position);
        holder.nameTextView.setText(characters.get(position).getName());
        holder.nicknameViewText.setText(characters.get(position).getNickname());
        Picasso.get()
                .load(characters.get(position).getImg())
                .into(holder.characterImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("character", characters.get(position));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameTextView;
        public final TextView nicknameViewText;
        public final ImageView characterImageView;
        public BreakingBadCharacter mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            nicknameViewText = (TextView) view.findViewById(R.id.nicknameTextView);
            characterImageView = (ImageView) view.findViewById(R.id.characterImageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nameTextView.getText() + "'";
        }
    }
}