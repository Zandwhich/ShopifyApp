package com.example.alex.shopifyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;

public class NapoleonBatzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_napoleon_batz);

        final TextView title = (TextView) findViewById(R.id.textView_NapoleonTitle);
        final TextView number = (TextView) findViewById(R.id.textView_NapoleonNumber);

        String url = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println("We actually got a response");
                    try{
                        double price = 0;
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray orders = jsonObject.getJSONArray("orders");
                        for (int i = 0; i < orders.length(); i++)
                        {
                            JSONObject order = orders.getJSONObject(i);
                            if (order.has("customer"))
                            {
                                JSONObject customer = order.getJSONObject("customer");
                                if (customer.has("first_name") &&
                                        customer.getString("first_name").equals("Napoleon") &&
                                        customer.has("last_name") &&
                                        customer.getString("last_name").equals("Batz"))
                                {
                                    if (order.has("total_price"))
                                    {
                                        price += order.getDouble("total_price");
                                    }
                                }
                            }
                        }
                        number.setText("CAD$" + price);
                    }
                    catch (JSONException e){
                        System.out.println("There was an error with parsing the JSON.");
                    }

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error);
                }
        });

        requestQueue.add(stringRequest);
    }
}
