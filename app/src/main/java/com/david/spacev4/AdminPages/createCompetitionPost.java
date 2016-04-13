package com.david.spacev4.AdminPages;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.david.spacev4.R;
import com.example.david.myapplication.backend.competitionPostApi.CompetitionPostApi;
import com.example.david.myapplication.backend.competitionPostApi.model.CompetitionPost;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.List;


public class createCompetitionPost extends AppCompatActivity {
    int PostIDInt;
    String PostID;
    private TimePicker ActivityTime;
    String TimeString;
    int hour;
    int minute;
    private DatePicker ActivityDate;
    String DateString;
    int Day;
    int Month;
    String CompetitionString;
    TextView CompetitionText;
    String OrganisersString;
    TextView OrganisersText;
    String AgeGroupString;
    TextView AgeGroupText;
    String InformationString;
    TextView informationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_competition_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void onClick(View view) {
        Intent newActivity = null;
        switch (view.getId()) {    //depending on the button pressed the correct activity is launched
            case R.id.Post:
                HandlePostButtonClick();
                Intent intent1 = new Intent(getBaseContext(), adminHomePage.class);
                startActivity(intent1);
                break;

        }
        if (newActivity != null) startActivity(newActivity);
    }
    private void HandlePostButtonClick() {
        this.CompetitionText = (TextView) findViewById(R.id.CompetitionTypeeditText);
        CompetitionString = CompetitionText.getText().toString();

        this.OrganisersText = (TextView) findViewById(R.id.OrganiserseditText);
        OrganisersString = OrganisersText.getText().toString();

        this.AgeGroupText = (TextView) findViewById(R.id.AgeGroupeditText);
        AgeGroupString = AgeGroupText.getText().toString();

        this.ActivityDate = (DatePicker) findViewById(R.id.datePicker);
        Day = ActivityDate.getDayOfMonth();
        Month = ActivityDate.getMonth();
        Month ++;
        DateString = Integer.toString(Day) + "/" + Integer.toString(Month);

        this.ActivityTime = (TimePicker) findViewById(R.id.timePicker);
        hour = ActivityTime.getCurrentHour();
        minute = ActivityTime.getCurrentMinute();
        TimeString = Integer.toString(hour) + ":" + Integer.toString(minute);

        this.informationText = (TextView) findViewById(R.id.InformationeditText);
        InformationString = informationText.getText().toString();

        CompetitionPost post = new CompetitionPost();

        post.setPost("1");
        post.setCompetitionType(CompetitionString);
        post.setOrganisers(OrganisersString);
        post.setAgeGroup(AgeGroupString);
        post.setDate(DateString);
        post.setTime(TimeString);
        post.setInformation(InformationString);

        new uploadAsyncTask().execute(new Pair<Context, CompetitionPost>(this, post));

    }
    class uploadAsyncTask extends AsyncTask<Pair<Context,CompetitionPost>, Void, CompetitionPost> {
        private CompetitionPostApi myApiService = null;
        private Context context;
        @Override
        protected CompetitionPost doInBackground(Pair<Context, CompetitionPost>... params) {
            if(myApiService == null)
            {  // Only do this once
                CompetitionPostApi.Builder builder = new CompetitionPostApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://space-1092.appspot.com/_ah/api/");
                // end options for devappserver
                myApiService = builder.build();
            }
            try {
                List<CompetitionPost> result = myApiService.list().execute().getItems();
                for (CompetitionPost q : result) {
                    PostID = q.getPost();
                }

            }
            catch (IOException e) {
            }
            PostIDInt = Integer.parseInt(PostID);
            PostIDInt ++;
            PostID = Integer.toString(PostIDInt);

            context = params[0].first;
            CompetitionPost post = params[0].second;
            post.setPost(PostID);

            try {
                myApiService.insert(post).execute().getPost();
                return post;
            } catch (IOException e) {
                return post;
            }
        }

        @Override
        protected void onPostExecute(CompetitionPost result)
        {

        }
    }

}