package de.it_koenning.aodcustomizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toolbar;

public class MainActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PrefManager();
    }
    private void PrefManager() {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = getPrefs.getBoolean("firstRun", true);

        if (isFirstRun) {
            //  Make a new preferences editor
            SharedPreferences.Editor e = getPrefs.edit();
            //  Edit preference to make it false because we don't want this to run again
            e.putBoolean("firstRun", false);
            //  Apply changes
            e.apply();
            //Start
            Intent intent = new Intent(this, MainIntroActivity.class);
            startActivity(intent);
            //Exit the MainActivity to only have the Intro Open
            finish();
        }
        else if(!isFirstRun){
            StartSettings();
        }
    }
    private void StartSettings(){
        Intent settingsIntent = new Intent();
        settingsIntent.setClass(getApplicationContext(), Preferences.class);
        startActivity(settingsIntent);
        finish();
    }
}