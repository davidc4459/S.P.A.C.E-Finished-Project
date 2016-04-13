package com.david.spacev4.UserPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.david.spacev4.R;
import com.david.spacev4.UserPages.ArtsAndCrafts.viewArtsAndCraftsListInfo;
import com.david.spacev4.UserPages.Competition.viewCompetitionListInfo;
import com.david.spacev4.UserPages.TalksAndClasses.viewTalksAndClassesListInfo;

public class userMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void onClick(View view) {
        Intent newActivity = null;
        switch (view.getId()) {    //depending on the button pressed the correct activity is launched
            case R.id.AllPostsButton:
                //Intent intent1 = new Intent(getBaseContext(), viewAllPosts.class);
                //startActivity(intent1);
                break;
            case R.id.TalksAndClassesButton:
                Intent intent2 = new Intent(getBaseContext(), viewTalksAndClassesListInfo.class);
                startActivity(intent2);
                break;
            case R.id.ArtsAndCraftsButton:
                Intent intent3 = new Intent(getBaseContext(), viewArtsAndCraftsListInfo.class);
                startActivity(intent3);
                break;
            case R.id.CompetitionsButton:
                Intent intent4 = new Intent(getBaseContext(), viewCompetitionListInfo.class);
                startActivity(intent4);
                break;
            case R.id.DateSearchButton:
                //Intent intent5 = new Intent(getBaseContext(), DatePostRetrieval.class);
                //startActivity(intent5);
                break;

        }
    }

}
