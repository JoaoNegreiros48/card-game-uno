package main.java;

public class Carta {
    private String cor;
    private String tipo;
    private String acao;

    public Carta(String cor, String tipo, String acao){
        this.cor = cor;
        this.tipo = tipo;
        this.acao = acao;
    }

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getAcao(){
        return acao;
    }

    public void setAcao(String acao){
        this.acao = acao;
    }
}
