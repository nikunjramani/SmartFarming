package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.suggestion_for_crop;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize.crop;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize.cropAdapter;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize.crop_prize;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.url_list;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class crop_suggestion extends AppCompatActivity {
    private List<crops> cropList ;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_suggestion);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cropList=new ArrayList<>();
        getData();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_list.crop_suggestion,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                cropList.add(new crops(
                                        product.getString("crop_name"),
                                        product.getString("description"),
                                        product.getString("soil_type")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            crop_Adapter adapter = new crop_Adapter(crop_suggestion.this, cropList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
