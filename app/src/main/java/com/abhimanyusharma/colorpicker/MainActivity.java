package com.abhimanyusharma.colorpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.OnColorSelectedListener;

public class MainActivity extends AppCompatActivity {

    Button button;
    ColorPickerView colorPickerView;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        colorPickerView = findViewById(R.id.color_picker_view);

        colorPickerView.addOnColorSelectedListener(new OnColorSelectedListener() {
            @Override
            public void onColorSelected(int selectedColor) {

                // Handle on color change
                Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));

                a = Integer.toHexString(selectedColor).toUpperCase();
                button.setText(a);
                button.setBackgroundColor(selectedColor);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "selectedColor: #" + a, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
/* https://github.com/QuadFlask/colorpicker */
