package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    private ArrayList<Carta> cartas;

    public Baralho(){
        cartas = new ArrayList<Carta>();
    }

    public void montarBaralho(){
        // Cartas numéricas
        for (String cor : new String[]{"Vermelho", "Azul", "Verde", "Amarelo"}) {
            for (int i = 0; i < 9; i++) {
                cartas.add(new Carta(cor, "Numerada", String.valueOf(i)));
            }
        }

        // Cartas de ação com cores (+2, pula vez, etc.)
        for (String cor : new String[]{"Vermelho", "Azul", "Verde", "Amarelo"}) {
            cartas.add(new Carta(cor, "Ação", "Pular"));
            cartas.add(new Carta(cor, "Ação", "Reverter"));
            cartas.add(new Carta(cor, "Ação", "Mais 2"));
        }

        // Cartas coringa
        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta("Coringa", "Coringa", "Troca de Cor"));
            cartas.add(new Carta("Coringa", "Coringa", "Mais 4"));
        }   
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta getCartaDoTopo() {
        if (!cartas.isEmpty()) {
            return cartas.get(0);
        } else {
            return null; // Retorna null se o baralho estiver vazio
        }
    }

    // Método para remover a carta do topo do baralho
    public void removerCartaDoTopo() {
        if (!cartas.isEmpty()) {
            cartas.remove(0);
        }
    }
}
