package com.example.nikunjramani.automaticirrigationandcropminitoringsystem.home_page;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.Login;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.R;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.SharedPreferenceConfig;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_details.crop_details;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_prize.crop_prize;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.crop_requirement.crop_requirement;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.suggestion.crop_water_requirement;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.suggestion_for_crop.crop_suggestion;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.url_list;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    MqttAndroidClient client;
    MqttConnectOptions options;
    String motor1, button_text = "ON";
    TextView t1, t2, t3, t4;
    AlertDialog alertDialog1;
    CharSequence[] values = {" Gujarati ", " Hindi", "English"};
    Button motor;
    TextView temprature, humidity;
    CircleProgress co;
    Spinner crop;
    String crop_type;
    TextView moisture1, moisture2;
    String host = "http://nikunjramani.000webhostapp.com/aicms/";
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllWidgets();
        connectMqtt();
        getData();

        Log.d("FCMToken", "token " + FirebaseInstanceId.getInstance().getToken());
//        Toast.makeText(MainActivity.this, "Done"+FirebaseInstanceId.getInstance().getToken(), Toast.LENGTH_SHORT).show();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.crop_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(adapter);
        crop.setOnItemSelectedListener(this);
        // getButton();
        motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button_text == "OFF") {
                    button_text = "ON";
                    motor.setText(button_text);
                    motor1 = "0";
                } else if (button_text == "ON") {
                    button_text = "OFF";
                    motor.setText(button_text);

                    motor1 = "1";
                }
                publish(client, "motor", motor1);

            }
        });
    }

    void getAllWidgets() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t1 = (TextView) findViewById(R.id.t1);
        motor = findViewById(R.id.motor);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        moisture1 = (TextView) findViewById(R.id.moisture1);
        temprature = (TextView) findViewById(R.id.temprature);
        co = (CircleProgress) findViewById(R.id.co);
        humidity = (TextView) findViewById(R.id.humidity);
        crop = (Spinner) findViewById(R.id.croplist);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    void connectMqtt() {
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), url_list.mqtt_url, clientId);
        options = new MqttConnectOptions();

        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
        options.setCleanSession(false);
        options.setUserName(url_list.mqtt_username);
        options.setPassword(url_list.mqtt_password.toCharArray());

    }

    public void publish(MqttAndroidClient client, String topic, String payload) {
        byte[] encodedPayload = new byte[0];
        try {
            encodedPayload = payload.getBytes("UTF-8");
            MqttMessage message = new MqttMessage(encodedPayload);
            client.publish(topic, message);
            Log.d("test", "su");
        } catch (UnsupportedEncodingException | MqttException e) {
            e.printStackTrace();
        }
    }


    public void subscribe(MqttAndroidClient client, String topic) {
        int qos = 1;
        try {
            IMqttToken subToken = client.subscribe(topic, qos);
            subToken.setActionCallback(new IMqttActionListener() {

                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // The message was published
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken,
                                      Throwable exception) {
                    // The subscription could not be performed, maybe the user was not
                    // authorized to subscribe on the specified topic e.g. using wildcards
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        /*Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.referesh_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_referesh) {
            startActivity(getIntent());
        } else if (id == R.id.menu_logout) {
            sharedPreferenceConfig.WriteLoginStatus(false);
            startActivity(new Intent(MainActivity.this, Login.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    void getData() {
        try {
            IMqttToken token = client.connect(options);
            //IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Log.d("file", "onSuccess");
                    //publish(client,"payloadd");
                    subscribe(client, "moisture");
                    subscribe(client, "humidity");
                    subscribe(client, "temprature");
                    subscribe(client, "level");
                    subscribe(client, "motor");

                    client.setCallback(new MqttCallback() {
                        @Override
                        public void connectionLost(Throwable cause) {

                        }

                        @Override
                        public void messageArrived(String topic, MqttMessage message) throws Exception {
                            Log.d("file", message.toString());

                            if (topic.equals("moisture")) {
                                moisture1.setText(message.toString());
                            }

                            if (topic.equals("humidity")) {
                                humidity.setText(message.toString());
                            }

                            if (topic.equals("temprature")) {
                                temprature.setText(message.toString());
                            }

                            if (topic.equals("smoke")) {
                                humidity.setText(message.toString());
                            }
                            if (topic.equals("level")) {
                                co.setProgress(Integer.parseInt(message.toString()));
                            }

                        }

                        @Override
                        public void deliveryComplete(IMqttDeliveryToken token) {

                        }
                    });
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d("file", "onFailure");

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    void getButton() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, host + "getd.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                if (laptop.getString("status") == "0") {
                                    motor.setText("ON");
                                } else if (laptop.getString("status") == "1") {
                                    motor.setText("OFF");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        crop_type = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.change_language) {
            change_language();
        } else if (id == R.id.crop_requirement) {
            startActivity(new Intent(MainActivity.this, crop_requirement.class));
        } else if (id == R.id.water_requirement_suggestion) {
            startActivity(new Intent(MainActivity.this, crop_water_requirement.class));
        } else if (id == R.id.crop_details) {
            startActivity(new Intent(MainActivity.this, crop_details.class));
        } else if (id == R.id.crop_prize) {
            startActivity(new Intent(MainActivity.this, crop_prize.class));
        } else if (id == R.id.crop_suggetion) {
            startActivity(new Intent(MainActivity.this, crop_suggestion.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void change_language() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Select Your Choice");

        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {

                switch (item) {
                    case 0:
                        t1.setText(getText(R.string.temprature_guj));
                        t2.setText(getText(R.string.humidity_guj));
                        t3.setText(getText(R.string.waterlevel_guj));
                        t4.setText(getText(R.string.moisture_guj));

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                }
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();


    }
}

