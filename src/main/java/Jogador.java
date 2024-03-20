package main.java;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private ArrayList<Carta> mao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<Carta>();
    }

    public void adicionarCarta(Carta carta) {
        mao.add(carta);
    }

    public void removerCarta(Carta carta) {
        mao.remove(carta);
    }

    public List<Carta> getMao() {
        return mao;
    }

    public String getNome() {
        return nome;
    }

}
