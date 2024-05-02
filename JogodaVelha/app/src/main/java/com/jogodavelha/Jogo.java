package com.jogodavelha;

import java.io.Serializable;

public class Jogo implements Serializable {
    private String nomeJogador1;
    private String nomeJogador2;
    private String nomeVencedor;
    private String jogadorAtual;
    private String marcacao;
    private boolean ganhador;
    private int qtdeJogadasDisponiveis;

    public Jogo() {
        this.nomeJogador1 = "";
        this.nomeJogador2 = "";
        this.nomeVencedor = "";
        this.ganhador = false;
        this.qtdeJogadasDisponiveis = 9;
        this.marcacao = "X";
    }

    public String getNomeJogador1() {
        return nomeJogador1;
    }

    public void setNomeJogador1(String nomeJogador1) {
        this.nomeJogador1 = nomeJogador1;
    }

    public String getNomeJogador2() {
        return nomeJogador2;
    }

    public void setNomeJogador2(String nomeJogador2) {
        this.nomeJogador2 = nomeJogador2;
    }

    public String getNomeVencedor() {
        return nomeVencedor;
    }

    public void setNomeVencedor(String nomeVencedor) {
        this.nomeVencedor = nomeVencedor;
    }

    public String getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(String jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public String getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }

    public boolean isGanhador() {
        return ganhador;
    }

    public void setGanhador(boolean ganhador) {
        this.ganhador = ganhador;
    }

    public int getQtdeJogadasDisponiveis() {
        return qtdeJogadasDisponiveis;
    }

    public void setQtdeJogadasDisponiveis(int qtdeJogadasDisponiveis) {
        this.qtdeJogadasDisponiveis = qtdeJogadasDisponiveis;
    }

    public void alterarMarcacao() {
        if (marcacao.equals("X")) {
            marcacao = "0";
        } else {
            marcacao = "X";
        }
    }

    public void alterarJogador() {
        if (jogadorAtual.equals(nomeJogador1)) {
            jogadorAtual = nomeJogador2;
        } else {
            jogadorAtual = nomeJogador1;
        }
    }
}
