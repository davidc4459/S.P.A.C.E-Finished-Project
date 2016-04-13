package com.david.spacev4.UserPages.TalksAndClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.david.spacev4.R;
import com.example.david.myapplication.backend.talksAndClassesPostApi.model.TalksAndClassesPost;

public class TalksAndClassesDetailFragmentation extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private TalksAndClassesPost mItem;
    private Context context;

    public TalksAndClassesDetailFragmentation() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = TalksAndClassesListFragmentation.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_talks_and_classes_detail_fragmentation,
                container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.circle_detail))
                    .setText(mItem.getTopic());
            ((TextView) rootView.findViewById(R.id.circle_view))
                    .setText("Organisers: " + mItem.getSpeakerName() + "\nAgeGroup: " + mItem.getAgeGroup() + "\nDate: " + mItem.getDate() + "\nTime: " + mItem.getTime() + "\nInformation: " + mItem.getInformation());
        }

        return rootView;
    }
}

