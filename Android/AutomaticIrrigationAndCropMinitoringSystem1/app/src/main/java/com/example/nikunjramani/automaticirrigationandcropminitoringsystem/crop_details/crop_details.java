package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;

public class crop_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_details);
        TextView crop_details;
        crop_details=(TextView)findViewById(R.id.crop_details);
        crop_details.setText("•  Rice:\n" +
                "\n" +
                "The principal food grain of India is rice. In terms of rice production, the country holds the second position all over the world. Rice is grown in approximately 34% of the overall cropped territory of the country. Rice production comprises 42% of the overall food crop production in the country.\n" +
                "\n" +
                "For rice production, it is essential that the production fields receive a mean precipitation of 125 cm every year. It is also necessary that the average temperature of the place stays at 23° C.\n" +
                "\n" +
                "In India, rice is grown in the eastern and western shoreline areas, Northeast India, and the drainage basin of river Ganga. The important rice growing states in India are as follows:\n" +
                "•\tPunjab\n" +
                "•\tWest Bengal\n" +
                "•\tUttar Pradesh\n" +
                "Other than these states, rice is cultivated in the following states of India:\n" +
                "•\tKarnataka\n" +
                "•\tTamil Nadu\n" +
                "•\tHaryana\n" +
                "•\tOrissa\n" +
                "•\tChhattisgarh\n" +
                "•\tBihar\n" +
                "•\tMaharashtra\n" +
                "•\tAssam\n" +
                "\n" +
                "\n" +
                "•  Wheat: \n" +
                "\n" +
                "The second most important food grain cultivated in India is wheat. The Rabi season is the ideal time to grow wheat. The Green Revolution in India paved the way for a substantial development in wheat production in the nation. Since the revolution, the production of the second most important food crop has risen considerably. The elements that contributed to increased wheat production are better seeds, right usage of water supply, and manures.\n" +
                "\n" +
                "In India, wheat is grown in regions which receive a mean precipitation of 75 cm. The region should also have productive soil. The state of Uttar Pradesh ranks first in terms of wheat production. About 35% of the overall wheat production is done by the state. Other than Uttar Pradesh, states like Haryana and Punjab also produce a significant amount of wheat.\n" +
                "\n" +
                "\n" +
                "•  Jowar: \n" +
                "\n" +
                "Jowar is a major food grain in India as well. The ideal climate for cultivation of Jowar should be warm and arid and the average annual rainfall should be 45 cm.\n" +
                "\n" +
                "The state of Maharashtra is the leading producer of Jowar in the country. The state houses about 50% of the overall area for Jowar production in India.\n" +
                "\n" +
                "Maharashtra cultivates about 52% of the overall Jowar production in the country. Other important producers of Jowar include states like Andhra Pradesh, Karnataka, and Tamil Nadu.\n" +
                "\n" +
                "\n" +
                "•  Pulses: \n" +
                "\n" +
                "Pulses are cultivated in the arid areas of the country. These harvests supply nitrogen to the earth. The population of India prefers a diet which contains pulses since they carry a significant degree of proteins.\n" +
                "\n" +
                "The top producer of pulses in India is the state of Madhya Pradesh. The state contributes 24% of the overall pulses production of the nation. Other major pulse producing states include Rajasthan and Uttar Pradesh.\n" +
                "\n" +
                "\n" +
                "•  Jute \n" +
                "\n" +
                "India is a prominent jute producing nation across the world. Some of the important jute producing states in the country are Bihar, West Bengal, and Orissa. A negligible amount of jute is produced in Uttar Pradesh and Assam.\n" +
                "\n" +
                "\n" +
                "•  Coffee: \n" +
                "\n" +
                "The states of Kerala, Karnataka, and Tamil Nadu are the major coffee producers in India. They house a number of coffee estates and farms in Southern India. Indian coffee is famous for its flavor and aroma. As a result, it has a significant demand in the global coffee market. India is a major exporter of coffee because of this. The Nilgiri Mountain Ranges produce coffee on a substantial scale. \n" +
                "\n" +
                "\n" +
                "•  Rubber: \n" +
                "\n" +
                "Rubber is a tree crop which is grown in agricultural estates. It is made from latex which is emitted from the stems of the plants. The ideal weather for rubber growing is a warm and moist weather and the soil should be sufficiently watered. The following states are the important cultivators of rubber in India:\n" +
                "•\tKarnataka\n" +
                "•\tKerala\n" +
                "•\tTamil Nadu\n" +
                "Kerala ranks as the topmost producer of rubber in the country.\n");
    }
}
