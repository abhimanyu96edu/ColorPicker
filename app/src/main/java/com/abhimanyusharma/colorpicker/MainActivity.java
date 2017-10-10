package com.abhimanyusharma.colorpicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ColorPickerView colorPickerView;
    private static String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        colorPickerView = findViewById(R.id.color_picker_view);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        colorPickerView.addOnColorSelectedListener(new OnColorSelectedListener() {
            @Override
            public void onColorSelected(int selectedColor) {

                // Handle on color change
                Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));

                b = String.valueOf(selectedColor);
                a = "#"+Integer.toHexString(selectedColor).toUpperCase();
                button.setText(a);
                button.setBackgroundColor(selectedColor);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "selectedColor: " + a, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("color", a);
                i.putExtra("value", b);
                startActivity(i);

            }
        });
    }
}
/* https://github.com/QuadFlask/colorpicker */
