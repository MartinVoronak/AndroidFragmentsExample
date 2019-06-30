package com.example.tutorialfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;


/*
* Fragments DO NOT talk directly to each other
* */

public class TopSectionFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    //gets data from fragment
    TopSectionListener activityCommander;
    public interface TopSectionListener{
        public void createMeme(String top, String Bottom);
    }

    //called whenever we attach fragment to acttivity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            activityCommander = (TopSectionListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);

        final Button button = (Button) view.findViewById(R.id.buton);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               buttonClicked(v);
            }
        });

        return view;
    }


    public void buttonClicked(View view){
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
