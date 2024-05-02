package com.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button buttonContinuar;
    public ImageButton imageButtonVolOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Som.executar(this, R.raw.start);

        buttonContinuar = findViewById(R.id.buttonContinuar);
        buttonContinuar.setOnClickListener(this);

        imageButtonVolOn = findViewById(R.id.imageButtonVolOn);
        imageButtonVolOn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonContinuar) {
            Intent intent = new Intent(this, MainActivityJogador1.class);
            startActivity(intent);
        } if (view.getId() == R.id.imageButtonVolOn) {
            Som.parar();
        }
    }
}