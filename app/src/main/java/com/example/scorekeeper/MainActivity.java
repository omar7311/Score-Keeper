package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int score1;
    private int score2;
    private TextView textView_score1;
    private TextView textView_score2;
    private final String SCORE_TEAM1="score team1";
    private final String SCORE_TEAM2="score team2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_score1=findViewById(R.id.score1);
        textView_score2=findViewById(R.id.score2);
        if(savedInstanceState!=null){
            score1=savedInstanceState.getInt(SCORE_TEAM1);
            score2=savedInstanceState.getInt(SCORE_TEAM2);
            textView_score1.setText(String.valueOf(score1));
            textView_score2.setText(String.valueOf(score2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu,menu);
        int currentMode=getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        int nightDay= AppCompatDelegate.getDefaultNightMode();
        if(nightDay==AppCompatDelegate.MODE_NIGHT_YES ||currentMode==Configuration.UI_MODE_NIGHT_YES){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            menu.findItem(R.id.night_mode).setIcon(R.drawable.ic_night_mode);
        }
        else menu.findItem(R.id.night_mode).setIcon(R.drawable.night_mode);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nightDay= AppCompatDelegate.getDefaultNightMode();
        if(nightDay==AppCompatDelegate.MODE_NIGHT_YES)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        return true;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SCORE_TEAM1,score1);
        outState.putInt(SCORE_TEAM2,score2);
        super.onSaveInstanceState(outState);
    }

    public void decreaseButtonTeam2(View view) {
        if(score2!=0){
        score2--;
        textView_score2.setText(String.valueOf(score2));
    }
    }

    public void increaseButtonTeam2(View view) {
        score2++;
        textView_score2.setText(String.valueOf(score2));
    }

    public void decreaseButtonTeam1(View view) {
        if (score1 != 0) {
            score1--;
            textView_score1.setText(String.valueOf(score1));
        }
    }

    public void increaseButtonTeam1(View view) {
        score1++;
        textView_score1.setText(String.valueOf(score1));
    }
}