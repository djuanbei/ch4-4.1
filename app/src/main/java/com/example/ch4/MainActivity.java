package com.example.ch4;

import android.app.LauncherActivity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {

    String[] names = {"设置"};
    Class<?>[] classes = new Class[]{SettingsActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                    Log.d("preference", PreferenceManager
                            .getDefaultSharedPreferences(MainActivity.this).getString("example_text", ""));
                }

            }
        }).start();


    }

    @Override
    public Intent intentForPosition(int position) {
        return new Intent(MainActivity.this, classes[position]);

    }
}
