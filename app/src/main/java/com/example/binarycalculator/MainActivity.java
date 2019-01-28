package com.example.binarycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = "";
    }
    public void buttonClick(View view) {
        if(view.getId() == R.id.zero) {
            s = s + "0";
        } else if (view.getId() == R.id.one) {
            s = s + "1";
        } else if(view.getId() == R.id.clear) {
            s = "";
        } else {
            throw new RuntimeException("Error in buttonClick;; view unknown");
        }
        updateView();
        updateOutputView();

    }

    /**
     * Updates display to show current count value
     */
    private void updateView() {
        TextView display = findViewById(R.id.input);
        display.setText(String.format("%s", s));
    }
    private void updateOutputView() {
        if (s.equals("")) {
            TextView display = findViewById(R.id.output);
            display.setText(String.format("%s", s));

        } else {
            Integer i = Integer.parseInt(s, 2);
            TextView display = findViewById(R.id.output);
            display.setText(String.format("%d", i));
        }
    }
}
