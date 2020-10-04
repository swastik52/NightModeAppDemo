package com.example.homeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;


    private Button aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final Boolean isNightModeOn = sharedpreferences.getBoolean("NightMode", false);

        final SharedPreferences.Editor editor=sharedpreferences.edit();

        aSwitch=findViewById(R.id.switch_btn);

        if (isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            aSwitch.setText("Disable Dark Mode");
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            aSwitch.setText("Enable Dark Mode");
        }

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isNightModeOn){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean("NightMode",false);
                    editor.apply();
                    aSwitch.setText("Enable Dark Mode");
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean("NightMode",true);
                    editor.apply();
                    aSwitch.setText("Disable Dark Mode");

                }
                log.d("adding comment as jagat das");
            }
        });

    }
}