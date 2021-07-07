package com.example.androidseniorcodechallengexumak.fragment.characterDetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidseniorcodechallengexumak.R;
import com.example.androidseniorcodechallengexumak.model.BreakingBadCharacter;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private BreakingBadCharacter character;

    private ImageView characterImageView;
    private TextView nicknameViewText;
    private TextView occupationTextView;
    private TextView statusTextView;
    private TextView portrayedTextView;

    public CharacterDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterDetailFragment newInstance(String param1, String param2) {
        CharacterDetailFragment fragment = new CharacterDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);

        this.character = (BreakingBadCharacter) getArguments().getSerializable("character");

        nicknameViewText = (TextView) view.findViewById(R.id.nicknameDetailTextView);
        occupationTextView = (TextView) view.findViewById(R.id.occupationValueTextView);
        statusTextView = (TextView) view.findViewById(R.id.statusValueTextView);
        portrayedTextView = (TextView) view.findViewById(R.id.portayedValueTextView);
        characterImageView = (ImageView) view.findViewById(R.id.characterDetailImageView);

        Picasso.get()
                .load(character.getImg())
                .into(characterImageView);

        nicknameViewText.setText(character.getNickname());
        occupationTextView.setText(character.getOccupation());
        statusTextView.setText(character.getStatus());
        portrayedTextView.setText(character.getPortrayed());

        return view;
    }
}