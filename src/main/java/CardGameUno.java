package main.java;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CardGameUno {
    public static void main(String[] args) {
        // Cria uma instância do jogo com três jogadores
        Jogo jogo = new Jogo(Arrays.asList("Jogador1", "Jogador2", "Jogador3"));

        // Loop principal do jogo
        while (true) {
            // Limpa o console
            limparConsole();

            // Itera sobre cada jogador
            for (Jogador jogador : jogo.getJogadores()) {
                System.out.println("Carta atual no monte:");
                Carta cartaAtual = jogo.getCartaNaMesa();
                System.out.println(cartaAtual.getCor() + " " + cartaAtual.getAcao());
                System.out.println();

                // Exibe separador
                exibirSeparador();

                // Exibe a mão do jogador
                System.out.println("Mão de " + jogador.getNome() + ":");
                int indiceCarta = 0;
                for (Carta carta : jogador.getMao()) {
                    System.out.println(indiceCarta + ": " + carta.getCor() + " " + carta.getAcao());
                    indiceCarta++;
                }

                // Solicita a jogada do jogador
                Scanner scanner = new Scanner(System.in);
                System.out.println("É a vez de " + jogador.getNome() + ". Digite o índice da carta que deseja jogar:");
                int indiceEscolhido = scanner.nextInt();

                // Realiza a jogada do jogador
                Carta cartaJogada = jogador.getMao().get(indiceEscolhido);
                jogo.realizarJogada(cartaJogada);
                jogador.removerCarta(cartaJogada);

                // Verifica se o jogador ganhou o jogo
                if (jogador.getMao().isEmpty()) {
                    // Exibe o nome do jogador vencedor
                    exibirSeparador();
                    System.out.println("O jogo acabou! O jogador " + jogador.getNome() + " venceu!");
                    return; // Encerra o programa
                }

                // Aguarda um pequeno intervalo antes de limpar o console
                aguardar(2000);
                limparConsole();
            }
        }
    }

    // Método para exibir um separador visual
    private static void exibirSeparador() {
        System.out.println("----------------------------------");
    }

    // Método para limpar o console
    private static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para aguardar um pequeno intervalo
    private static void aguardar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
