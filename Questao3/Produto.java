import java.io.Serializable;

public class Produto implements Serializable{

    private String nome;
    private int quantidade;

    Produto(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    Produto(){}

    public String getNome(){
        return this.nome;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setQuantidade(int quantidadeNova){
        this.quantidade = quantidadeNova;
    }

    public void entradaQuantidade(int valor){
        this.quantidade += valor;
    }

    public void saidaQuantidade(int valor){
        this.quantidade = this.quantidade + valor;
    }
}