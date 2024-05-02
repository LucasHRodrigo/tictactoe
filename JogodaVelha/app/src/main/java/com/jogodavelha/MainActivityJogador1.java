package com.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivityJogador1 extends AppCompatActivity implements View.OnClickListener {

    public EditText editTextPlayer1;
    public Button buttonContinuarTela2;
    public ImageButton imageButtonVoltarTela2;
    public ImageButton imageButtonVolOn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jogador1);

        editTextPlayer1 = findViewById(R.id.editTextPlayer1);
        editTextPlayer1.setOnClickListener(this);

        buttonContinuarTela2 = findViewById(R.id.buttonContinuarTela2);
        buttonContinuarTela2.setOnClickListener(this);

        imageButtonVoltarTela2 = findViewById(R.id.imageButtonVoltarTela2);
        imageButtonVoltarTela2.setOnClickListener(this);

        imageButtonVolOn1 = findViewById(R.id.imageButtonVolOn1);
        imageButtonVolOn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String nomePlayer1 = editTextPlayer1.getText().toString();
        Jogo jogo = new Jogo();
        jogo.setNomeJogador1(nomePlayer1);


        if (view.getId() == R.id.buttonContinuarTela2) {
                if (nomePlayer1.isEmpty() == true) {
                    Toast.makeText(
                            this,
                            "Insira um nome",
                            Toast.LENGTH_SHORT).show();
                } if (nomePlayer1.isEmpty() == false) {
                    Intent intent = new Intent(this, MainActivityJogador2.class);
                    intent.putExtra("jogo", jogo);
                    startActivity(intent);
                    finish();
                }
            } if (view.getId() == R.id.imageButtonVoltarTela2) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } if (view.getId() == R.id.imageButtonVolOn1) {
                Som.parar();
            }
    }
}