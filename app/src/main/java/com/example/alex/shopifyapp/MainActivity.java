package com.example.alex.shopifyapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView napoleonBatz;
    TextView awesomeBronzeBags;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        napoleonBatz = (TextView) findViewById(R.id.textView_NapoleonBatz);
        awesomeBronzeBags = (TextView) findViewById(R.id.textView_AwesomeBronzeBags);

        napoleonBatz.setClickable(true);
        awesomeBronzeBags.setClickable(true);

        final Intent napoleonIntent = new Intent(this, NapoleonBatzActivity.class);
        final Intent bagsIntent = new Intent(this, AwesomeBronzeBagsActivity.class);

        napoleonBatz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                napoleonBatz.setTextColor(Color.BLUE);
                startActivity(napoleonIntent);
            }
        });

        awesomeBronzeBags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awesomeBronzeBags.setTextColor(Color.BLUE);
                startActivity(bagsIntent);
            }
        });

    }
}
