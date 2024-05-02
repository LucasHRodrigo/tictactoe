package com.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivityJogador2 extends AppCompatActivity implements View.OnClickListener {

    public EditText editTextPlayer2;
    public Button buttonContinuarTela3;
    public ImageButton imageButtonVoltarTela3;
    public ImageButton imageButtonVolOn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jogador2);

        editTextPlayer2 = findViewById(R.id.editTextPlayer2);
        editTextPlayer2.setOnClickListener(this);

        buttonContinuarTela3 = findViewById(R.id.buttonContinuarTela3);
        buttonContinuarTela3.setOnClickListener(this);

        imageButtonVoltarTela3 = findViewById(R.id.imageButtonVoltarTela3);
        imageButtonVoltarTela3.setOnClickListener(this);

        imageButtonVolOn2 = findViewById(R.id.imageButtonVolOn2);
        imageButtonVolOn2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String nomePlayer2 = editTextPlayer2.getText().toString();
        Intent telajogador1 = getIntent();
        Jogo jogo = (Jogo) telajogador1.getSerializableExtra("jogo");
        jogo.setNomeJogador2(nomePlayer2);
        if (view.getId() == R.id.buttonContinuarTela3) {
                if (nomePlayer2.isEmpty() == true) {
                Toast.makeText(
                        this,
                        "Insira um nome",
                        Toast.LENGTH_SHORT).show();
                } if (nomePlayer2.isEmpty() == false) {
                    Intent intent = new Intent(this, JogoActivity.class);
                    intent.putExtra("jogo", jogo);
                    startActivity(intent);
                    finish();
                    Som.parar();

            }
            } if (view.getId() == R.id.imageButtonVoltarTela3) {
                Intent intent = new Intent(this, MainActivityJogador1.class);
                startActivity(intent);
                finish();
            } if (view.getId() == R.id.imageButtonVolOn2) {
                Som.parar();
        }
    }
}