package com.example.jchen415.mywaytormobileapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class Appertizer extends Fragment {


    public Appertizer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);

        ImageButton eggroll = (ImageButton) v.findViewById(R.id.eggroll);
        ImageButton friedChicken = (ImageButton) v.findViewById(R.id.friedchicken);
        ImageButton springroll = (ImageButton) v.findViewById(R.id.springroll);

        eggroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), eggroll.class));
            }
        });

        springroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), springRoll.class));
            }
        });

        friedChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), friedChicken.class));
            }
        });

        return v;
        }

}
