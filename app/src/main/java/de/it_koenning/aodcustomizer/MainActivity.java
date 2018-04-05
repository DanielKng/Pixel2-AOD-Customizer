package de.it_koenning.aodcustomizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = getPrefs.getBoolean("firstRun", true);

        if (isFirstRun) {
            //  Make a new preferences editor
            SharedPreferences.Editor e = getPrefs.edit();

            //  Edit preference to make it false because we don't want this to run again
            e.putBoolean("firstRun", false);

            //  Apply changes
            e.apply();

            Intent intent = new Intent(this, MainIntroActivity.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_main);
    }
}