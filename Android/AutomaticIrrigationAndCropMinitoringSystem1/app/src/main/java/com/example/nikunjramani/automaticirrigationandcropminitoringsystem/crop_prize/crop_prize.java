package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.url_list;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class crop_prize extends AppCompatActivity {
    private List<crop> cropList ;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_prize);
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
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_list.get_crop_prize,
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
                                cropList.add(new crop(
                                        product.getString("crop_prize"),
                                        product.getString("crop_name")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            cropAdapter adapter = new cropAdapter(crop_prize.this, cropList);
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

    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        return super.getActionBar();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
