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
public class Sides extends Fragment {


    public Sides() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sides, container, false);

        ImageButton fries = (ImageButton) v.findViewById(R.id.chesefries);
        ImageButton union = (ImageButton) v.findViewById(R.id.union);
        ImageButton curly = (ImageButton) v.findViewById(R.id.curly);

        fries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), cheesefries.class));
            }
        });

        union.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), unionring.class));
            }
        });

        curly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), curlyfries.class));
            }
        });

        return v;
    }

}
