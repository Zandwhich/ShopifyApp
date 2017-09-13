package com.example.alex.shopifyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AwesomeBronzeBagsActivity extends AppCompatActivity {

    TextView title;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awesome_bronze_bags);

        title = (TextView) findViewById(R.id.textView_BagsTitle);
        number = (TextView) findViewById(R.id.textView_BagsNumber);
    }
}
