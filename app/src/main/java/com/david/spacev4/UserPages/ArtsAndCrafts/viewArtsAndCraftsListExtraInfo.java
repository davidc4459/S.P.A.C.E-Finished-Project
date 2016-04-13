package com.david.spacev4.UserPages.ArtsAndCrafts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.david.spacev4.R;

public class viewArtsAndCraftsListExtraInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_arts_and_crafts_list_extra_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(ArtsAndCraftsDetailFragmentation.ARG_ITEM_ID, getIntent()
                    .getStringExtra(ArtsAndCraftsDetailFragmentation.ARG_ITEM_ID));
            ArtsAndCraftsDetailFragmentation fragment = new ArtsAndCraftsDetailFragmentation();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.circle_detail_container, fragment).commit();
        }
    }

}
