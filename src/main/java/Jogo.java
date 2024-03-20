package main.java;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private List<Jogador> jogadores;
    private Baralho baralho;
    private Carta cartaNaMesa;

    public Jogo(List<String> nomesJogadores){
        jogadores = new ArrayList<>();
        for(String nome : nomesJogadores){
            jogadores.add(new Jogador(nome));
        }

        baralho = new Baralho();
        baralho.montarBaralho();
        baralho.embaralhar();
        cartaNaMesa = baralho.getCartaDoTopo();
        baralho.removerCartaDoTopo();
        distribuirCartas();
    }

    private void distribuirCartas(){
        for (Jogador jogador : jogadores) {
            for (int i = 0; i < 7; i++) {
                jogador.adicionarCarta(baralho.getCartaDoTopo());
                baralho.removerCartaDoTopo();
            }
        }
    }

    public void realizarJogada(Carta carta){
        if (podeJogar(carta)){
            cartaNaMesa = carta;
        } else {
            System.out.println("Jogada Inválida!");
        }
    }

    private boolean podeJogar(Carta carta){
        if (carta.getCor().equals(cartaNaMesa.getCor()) ||
            carta.getTipo().equals(cartaNaMesa.getTipo()) ||
            carta.getTipo().equals("Coringa")) {
            return true;
        } else{
            return false;
        }
    }

    public boolean jogoAcabou(){
        for (Jogador jogador : jogadores) {
            if (jogador.getMao().isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
