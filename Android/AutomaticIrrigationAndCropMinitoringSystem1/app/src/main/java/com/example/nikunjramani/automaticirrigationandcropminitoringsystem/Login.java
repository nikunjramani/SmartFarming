package com.example.nikunjramani.automaticirrigationandcropminitoringsystem;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nikunjramani.automaticirrigationandcropminitoringsystem.home_page.MainActivity;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button login;
    String e1,e2,str,url_cid;
    Integer cid;
    EditText email,password;
    SharedPreferenceConfig sharedPreferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        login=findViewById(R.id.login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        sharedPreferenceConfig = new SharedPreferenceConfig(Login.this);

        if (sharedPreferenceConfig.ReadLoginStatus()) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RequestQueue queue = Volley.newRequestQueue(Login.this);
                e1 = email.getText().toString().trim();
                e2= password.getText().toString().trim();

                AsyncTask<String, String, String> demoLogin = new AsyncTask<String, String, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        final String token=FirebaseInstanceId.getInstance().getToken();
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_list.login_url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("1")) {
                                    url_cid=url_list.domain+"/aicms/getcid.php?email"+e1;
                                    getcid();
                              //      SharedPreferenceConfig.getcid(cid);
                                    sharedPreferenceConfig.getEmaill(e1.trim());
sharedPreferenceConfig.WriteLoginStatus(true);
send_token();
                                    Intent i = new Intent(Login.this, MainActivity.class);
                                    startActivity(i);
                                    Toast.makeText(Login.this, "Account Successfully Login", Toast.LENGTH_LONG).show();

                                } else {
                                    str="fail";
                                    Toast.makeText(Login.this, "Invalid Email And Password", Toast.LENGTH_LONG).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Login.this, "Error" + error, Toast.LENGTH_SHORT).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> par = new HashMap<>();
                                par.put("email", e1);
                                par.put("password", e2);
                                par.put("token",token);
                                return par;
                            }
                        };
                        queue.add(stringRequest);
                        return str;
                    }

                    @Override
                    protected void onPostExecute(String s) {

                    }
                };
                demoLogin.execute();

            }
        });
    }
    void getcid(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url_cid,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                                JSONObject laptop = array.getJSONObject(0);
                                cid= laptop.getInt("cid");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
void send_token(){
    final String token = FirebaseInstanceId.getInstance().getToken();
    final String reemail = "nikunj@patelbhai";

    if (token == null) {
        Toast.makeText(this, "Token not generated", Toast.LENGTH_LONG).show();
        return;
    }
    RequestQueue queue = Volley.newRequestQueue(Login.this);
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url_list.fcm_register_device, new com.android.volley.Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
                Toast.makeText(Login.this, " Successfully", Toast.LENGTH_LONG).show();
        }
    }, new com.android.volley.Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(Login.this, "Error" + error, Toast.LENGTH_SHORT).show();
        }
    }) {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> par = new HashMap<>();
            par.put("token", token);
            par.put("email", reemail);
            return par;
        }
    };
    queue.add(stringRequest);
}


}
