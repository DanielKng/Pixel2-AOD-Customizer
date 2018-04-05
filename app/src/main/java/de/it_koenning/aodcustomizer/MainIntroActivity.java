package de.it_koenning.aodcustomizer;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.github.paolorotolo.appintro.AppIntro2;
import de.it_koenning.aodcustomizer.slides.FirstSlide;
import de.it_koenning.aodcustomizer.slides.FourthSlide;
import de.it_koenning.aodcustomizer.slides.SecondSlide;
import de.it_koenning.aodcustomizer.slides.ThirdSlide;


public class MainIntroActivity extends AppIntro2 {
    //Declaring the slides
    FirstSlide first_slide = new FirstSlide();
    SecondSlide second_slide = new SecondSlide();
    ThirdSlide third_slide = new ThirdSlide();
    FourthSlide fourth_slide = new FourthSlide();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Status-Bar
        showStatusBar(false);
        //Open up the slides
        addSlide(first_slide);
        addSlide(second_slide);
        addSlide(third_slide);
        addSlide(fourth_slide);

        // OPTIONAL METHODS
        //Animations
        setFadeAnimation();
        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(false);
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
    }

    private void StartMainActivity(){
        Intent startMain = new Intent(MainIntroActivity.this, MainActivity.class);
        startActivity(startMain);
    }
}
