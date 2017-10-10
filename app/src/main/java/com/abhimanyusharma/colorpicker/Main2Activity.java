package com.abhimanyusharma.colorpicker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.textView);

        String text = getIntent().getStringExtra("color");
        String val = getIntent().getStringExtra("value");

        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

        int color = Integer.parseInt(val, 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color) & 0xFF;
        //int b = (color >> 0) & 0xFF;

        tv.setText("Color = " + text + "\n\nr = " + r + "\n\ng = " + g + "\n\nb = " + b);
        tv.setTextSize(20);
        tv.setTextColor(Integer.parseInt(val));

    }
}
