package com.jogodavelha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JogoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button0, button1, button2, button3, button4;
    private Button button5, button6, button7, button8;
    private ImageButton imageButtonVoltarTela4;
    private ImageButton imageButtonVolOn4;

    private Jogo jogo;

    private TextView textViewJogadorAtual;

    private String tabuleiro[][] = {
        {"_", "_", "_"},
        {"_", "_", "_"},
        {"_", "_", "_"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        Som.parar();
        Som.executar(this, R.raw.heh);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);

        imageButtonVoltarTela4 = findViewById(R.id.imageButtonVoltarTela4);
        imageButtonVoltarTela4.setOnClickListener(this);

        imageButtonVolOn4 = findViewById(R.id.imageButtonVolOn4);
        imageButtonVolOn4.setOnClickListener(this);

        setarJogadores();
    }

    private void setarJogadores() {
        Intent telaJogador2 = getIntent();
        jogo = (Jogo) telaJogador2.getSerializableExtra("jogo");
        jogo.setJogadorAtual(jogo.getNomeJogador1());

        TextView textViewJogadores = findViewById(R.id.textViewJogadores);
        textViewJogadorAtual = findViewById(R.id.textViewJogadorAtual);

        String jogadores = jogo.getNomeJogador1().concat(" X ").concat(jogo.getNomeJogador2());
        textViewJogadores.setText(jogadores);


    }


    @Override
    public void onClick(View v) {
        Log.d("BUTTON", v.getId() + "");

        if (v.getId() == R.id.button0) {
            button0.setVisibility(View.VISIBLE);
            button0.setText(jogo.getMarcacao());

            tabuleiro[0][0] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button1) {
            button1.setVisibility(View.VISIBLE);
            button1.setText(jogo.getMarcacao());

            tabuleiro[0][1] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button2) {
            button2.setVisibility(View.VISIBLE);
            button2.setText(jogo.getMarcacao());

            tabuleiro[0][2] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button3) {
            button3.setVisibility(View.VISIBLE);
            button3.setText(jogo.getMarcacao());

            tabuleiro[1][0] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button4) {
            button4.setVisibility(View.VISIBLE);
            button4.setText(jogo.getMarcacao());

            tabuleiro[1][1] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button5) {
            button5.setVisibility(View.VISIBLE);
            button5.setText(jogo.getMarcacao());

            tabuleiro[1][2] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button6) {
            button6.setVisibility(View.VISIBLE);
            button6.setText(jogo.getMarcacao());

            tabuleiro[2][0] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button7) {
            button7.setVisibility(View.VISIBLE);
            button7.setText(jogo.getMarcacao());

            tabuleiro[2][1] = jogo.getMarcacao();

        } else if (v.getId() == R.id.button8) {
            button8.setVisibility(View.VISIBLE);
            button8.setText(jogo.getMarcacao());

            tabuleiro[2][2] = jogo.getMarcacao();

        }

        if (v.getId() == R.id.imageButtonVoltarTela4) {
            Intent intent = new Intent(this, MainActivityJogador1.class);
            startActivity(intent);
            Som.parar();
            finish();
        }
        if (v.getId() == R.id.imageButtonVolOn4) {
            Som.parar();
        }

        int numeroJogadas = jogo.getQtdeJogadasDisponiveis() - 1;
        jogo.setQtdeJogadasDisponiveis(numeroJogadas);

        if (jogo.getQtdeJogadasDisponiveis() == 0) {
            velha();
            Som.parar();
        } else {
            verificaGanhador();

            jogo.alterarMarcacao();
            jogo.alterarJogador();
            textViewJogadorAtual.setText("Jogando: ".concat(jogo.getJogadorAtual()));

        }
    }

    private void velha() {
            String msg = "Deu velha!";
            textViewJogadorAtual.setText(msg);
            Som.parar();
            Som.executar(this, R.raw.deu_velha);
    }

    private void verificaGanhador() {
        if (tabuleiro[0][0].equals(jogo.getMarcacao()) &&
                tabuleiro[0][1].equals(jogo.getMarcacao()) &&
                tabuleiro[0][2].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[1][0].equals(jogo.getMarcacao()) &&
                tabuleiro[1][1].equals(jogo.getMarcacao()) &&
                tabuleiro[1][2].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[2][0].equals(jogo.getMarcacao()) &&
                tabuleiro[2][1].equals(jogo.getMarcacao()) &&
                tabuleiro[2][2].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[0][0].equals(jogo.getMarcacao()) &&
                tabuleiro[1][0].equals(jogo.getMarcacao()) &&
                tabuleiro[2][0].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[0][1].equals(jogo.getMarcacao()) &&
                tabuleiro[1][1].equals(jogo.getMarcacao()) &&
                tabuleiro[2][1].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[0][2].equals(jogo.getMarcacao()) &&
                tabuleiro[1][2].equals(jogo.getMarcacao()) &&
                tabuleiro[2][2].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[0][0].equals(jogo.getMarcacao()) &&
                tabuleiro[1][1].equals(jogo.getMarcacao()) &&
                tabuleiro[2][2].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (tabuleiro[0][2].equals(jogo.getMarcacao()) &&
                tabuleiro[1][1].equals(jogo.getMarcacao()) &&
                tabuleiro[2][0].equals(jogo.getMarcacao()))
        {
            jogo.setGanhador(true);
        }

        if (jogo.isGanhador()) {
            Som.parar();
            Som.executar(this, R.raw.success);
            Som.parar();
        }
    }
}