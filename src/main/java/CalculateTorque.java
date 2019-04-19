package com.whiskeytangoapps.torqueconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculateTorque extends AppCompatActivity {

    double length1;
    double length2;
    double dt;
    double ts;

    EditText length1EditText;
    EditText length2EditText;
    EditText desiredTorqueEditText;
    TextView torqueSettingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_torque);

        length1EditText = findViewById(R.id.length1EditText);
        length2EditText = findViewById(R.id.length2EditText);
        desiredTorqueEditText = findViewById(R.id.desiredTorqueEditText);
        torqueSettingTextView = findViewById(R.id.torqueSettingTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                length1 = Double.parseDouble(length1EditText.getText().toString());
                length2 = Double.parseDouble(length2EditText.getText().toString());
                dt = Double.parseDouble(desiredTorqueEditText.getText().toString());

                ts = (dt * length1) / (length1 + length2);

                DecimalFormat df = new DecimalFormat("#.##");
                String tsString = df.format(ts);

                torqueSettingTextView.setText(tsString);
            }
        });
    }
}
