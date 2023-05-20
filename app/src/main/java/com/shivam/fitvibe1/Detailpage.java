package com.shivam.fitvibe1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class Detailpage extends AppCompatActivity {
    RequestQueue queue;
    TextView txtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpage);

      /*  RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://workout-planner1.p.rapidapi.com/?time=30&muscle=biceps&location=gym&equipment=dumbbells";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.

                        Toast.makeText(getApplicationContext(),response.substring(0,500),Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);*/
      /*  String URL ="https://workout-planner1.p.rapidapi.com/?time=30&muscle=biceps&location=gym&equipment=dumbbells";
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Didnot work",Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);*/

        /*HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://workout-planner1.p.rapidapi.com/?time=30&muscle=biceps&location=gym&equipment=dumbbells"))
                .header("X-RapidAPI-Key", "47a1cfb9f8msh233a86af19467cap167c9ajsn51f38e84b9cc")
                .header("X-RapidAPI-Host", "workout-planner1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());*/
        txtData=findViewById(R.id.lblData);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://workout-planner1.p.rapidapi.com/?time=30&muscle=biceps&location=gym&equipment=dumbbells";
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(getApplicationContext(),response.substring(0,500),Toast.LENGTH_SHORT).show();
                        System.out.print(response);
                        txtData.setText(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-RapidAPI-Key", "47a1cfb9f8msh233a86af19467cap167c9ajsn51f38e84b9cc");
                params.put("X-RapidAPI-Host", "workout-planner1.p.rapidapi.com");

                return params;
            }
        };
        queue.add(getRequest);



    }

}