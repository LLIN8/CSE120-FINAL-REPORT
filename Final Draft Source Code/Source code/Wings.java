package com.example.jchen415.mywaytormobileapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Wings extends Fragment {


    public Wings() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_wings, container, false);

        ImageButton garlic = (ImageButton) v.findViewById(R.id.garlic);
        ImageButton cheese = (ImageButton) v.findViewById(R.id.cheesechicken);
        ImageButton lemon = (ImageButton) v.findViewById(R.id.lemon);

        garlic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), garlicwings.class));
            }
        });

        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), cheesewing.class));
            }
        });

        lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), lemonwings.class));
            }
        });

        return v;
    }

}
