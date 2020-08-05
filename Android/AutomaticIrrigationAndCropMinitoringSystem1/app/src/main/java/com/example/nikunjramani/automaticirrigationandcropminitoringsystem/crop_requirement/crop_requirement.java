package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_requirement;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;

public class crop_requirement extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_requirement);
        t1=findViewById(R.id.t1);
        t1.setText("1. Rice\n" +
                "Temperature: 22 -32 degree Celsius          \n" +
                "Rainfall: 150-300 cm    \n" +
                "Soil:  Deep clayey and loamy soil\n\n" +
                "2. Wheat\n" +
                "Temperature: 10-15 degree Celsius (Sowing time); 21-26 degree Celsius (Ripening & Harvesting)\n" +
                "Rainfall: 75-100 cm      \n" +
                "Soil:  Well-drained fertile loamy and clayey loamy\n" +
                "How the pre-monsoon rain became the boon of India's markets and Farmers!\n" +
                "3. Millets\n\n" +
                "Temperature: 27-32 degree Celsius \n" +
                "Rainfall: 50-100 cm      \n" +
                "Soil: They are less sensitive to soil deficiencies. They can be grown in inferior alluvial or loamy soil\n" +
                "4. Grams\n\n" +
                "Temperature: 20-25 degree Celsius (Mild cool & Dry Climate)        \n" +
                "Rainfall: 40-45 cm        \n" +
                "Soil:  Loamy Soil\n\n" +
                "5. Sugar Cane\n" +
                "Temperature: 21-27 degree Celsius \n" +
                "Rainfall: 75-150 cm      \n" +
                "Soil:  Deep rich loamy soil\n" +
                "Forest-based Industry\n\n" +
                "6. Cotton\n" +
                "Temperature: 21-30 degree Celsius \n" +
                "Rainfall: 50-100 cm      \n" +
                "Soil:  Black soil of Deccan and Malwa Plateau. However, it also grows well in alluvial soils of the Sutlej-Ganga plain and red and laterite soils of the peninsular region\n" +
                "\n7. Oilseeds\n" +
                "Temperature: 20-30 degree Celsius \n" +
                "Rainfall: 50-75 cm        \n" +
                "Soil: Well drained light sandy loams, red, yellow and black soils are well suited for its cultivation.\n" +
                "\n8. Tea\n" +
                "Temperature: 20-30 degree Celsius \n" +
                "Rainfall: 150-300 cm    \n" +
                "Soil:  Well drained, deep friable loamy soil.\n" +
                "Agro-Based Industries in India\n" +
                "\n9. Coffee\n" +
                "Temperature: 15-28 degree Celsius \n" +
                "Rainfall: 150-250 cm    \n" +
                "Soil:  Well drained, deep friable loamy soil\n" +
                "\n");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
