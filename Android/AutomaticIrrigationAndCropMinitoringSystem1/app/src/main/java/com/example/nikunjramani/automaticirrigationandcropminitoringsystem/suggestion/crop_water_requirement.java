package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.suggestion;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;

public class crop_water_requirement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_water_requirement);

        ListView listView = (ListView) findViewById(R.id.crop_list);
        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.crop_require_water, android.R.layout.simple_list_item_1);
        listView.setAdapter(aa);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
