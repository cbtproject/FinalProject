package com.cbt.finalproject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class LessonContent extends AppCompatActivity {
    String LessonContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_about);
        LessonContent = getResources().getString(R.string.lessonContent);
        simulateDayNight(/* DAY */ 0);
        this.setTitle("Lesson");
        Element adsElement = new Element();
        adsElement.setTitle("About Relaxation ");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
//                .addItem(adsElement)
//                .addItem(new Element().setTitle("About the App"))
                .setImage(R.drawable.tips)
//                .addItem(new Element().setTitle("Version 1.2"))

                .setDescription(LessonContent)
//                .addGroup("Connect with us")
//                .addEmail("cbt@gmail.com")
//                .addWebsite("http://cbt.github.io/")
//                .addFacebook("cbt")
//                .addTwitter("cbt")
//                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
//                .addPlayStore("com.ideashower.readitlater.pro")
//                .addGitHub("cbtProject")
//                .addInstagram("medyo80")
                .create();
        setContentView(aboutPage);
    }

    @TargetApi(Build.VERSION_CODES.N)
    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        @SuppressLint("StringFormatInvalid")
        final String copyrights = String.format(getString(R.string.Charts), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.background_media);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LessonContent.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }

}
