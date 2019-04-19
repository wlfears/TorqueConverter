package com.whiskeytangoapps.torqueconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convertTorqueButton = findViewById(R.id.convertTorqueButton);
        Button calculateTorqueButton = findViewById(R.id.calculateTorqueButton);

        convertTorqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConvertTorque.class);
                startActivity(intent);
            }
        });

        calculateTorqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculateTorque.class);
                startActivity(intent);
            }
        });
    }
}
