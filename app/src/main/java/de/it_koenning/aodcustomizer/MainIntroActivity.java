package de.it_koenning.aodcustomizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.github.paolorotolo.appintro.AppIntro2;
import de.it_koenning.aodcustomizer.slides.FirstSlide;


public class MainIntroActivity extends AppIntro2 {
    FirstSlide first_slide = new FirstSlide();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide Status-Bar
        showStatusBar(false);
        //Open up the slides
        addSlide(first_slide);

        // OPTIONAL METHODS

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        StartMainActivity();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        StartMainActivity();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
        StartMainActivity();
    }

    private void StartMainActivity(){
        Intent startMain = new Intent(MainIntroActivity.this, MainActivity.class);
        startActivity(startMain);
    }
}
