package de.it_koenning.aodcustomizer;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v4.app.NotificationCompat;
@SuppressWarnings("deprecation")

public class Preferences extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        //Reset Data Clicked
        Preference reset_dataPref = findPreference("reset_data");
        reset_dataPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                try {
                    // clearing app data
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("pm clear de.it_koenning.aodcustomizer");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        //Username got opened and user changed something
        Preference usernamePref = findPreference("username");
        // Listens for change in value, and then changes the title if required.
        usernamePref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                return true;
            }
        });
        //If the user changed the Mail
        Preference mailPref = findPreference("usermail");
        // Listens for change in value, and then changes the title if required.
        mailPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                return true;
            }
        });
        //If the user changed the Mail
        Preference batteryPref = findPreference("batterySetting");
        // Listens for change in value, and then changes the title if required.
        mailPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            }
        });
    }
}
