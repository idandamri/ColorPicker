package com.example.idan.color_picker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    SeekBar sbRed, sbGreen, sbBlue;
    EditText RedText, BlueText, GreenText;
    TextView ColorHex;
    int color,colorRed = 128,colorGreen = 128,colorBlue = 128;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        initEvents();
    }

    private void initEvents() {
        sbBlue.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbRed.setOnSeekBarChangeListener(this);
        button.setOnClickListener(this);
    }

    private void initLayout() {
        sbBlue = (SeekBar) findViewById(R.id.SeekBlue);
        sbRed = (SeekBar) findViewById(R.id.SeekRed);
        sbGreen = (SeekBar) findViewById(R.id.SeekGreen);

        RedText = (EditText) findViewById(R.id.RedText);
        BlueText = (EditText) findViewById(R.id.BlueText);
        GreenText = (EditText) findViewById(R.id.GreenText);
        ColorHex = (TextView) findViewById(R.id.ColorHex);

        RedText.setEnabled(false);
        BlueText.setEnabled(false);
        GreenText.setEnabled(false);

        button = (Button) findViewById(R.id.button);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch(seekBar.getId()){
            case R.id.SeekRed:
                colorRed = sbRed.getProgress();
            case R.id.SeekGreen:
                colorGreen = sbGreen.getProgress();
            case R.id.SeekBlue:
                colorBlue = sbBlue.getProgress();
        }

        RedText.setText(String.valueOf(colorRed), TextView.BufferType.EDITABLE);
        GreenText.setText(String.valueOf(colorGreen), TextView.BufferType.EDITABLE);
        BlueText.setText(String.valueOf(colorBlue), TextView.BufferType.EDITABLE);

        color = Color.argb(255, colorRed, colorGreen, colorBlue);
        ColorHex.setBackgroundColor(color);
        ColorHex.setText("#"+String.format("#%s", Integer.toHexString(color)).toUpperCase().substring(3));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
//        Toast.makeText(getBaseContext(),"Your Message1", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
//        Toast.makeText(getBaseContext(),"Your Message2", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"You pressed the colorful button!!", Toast.LENGTH_LONG).show();
    }
}
