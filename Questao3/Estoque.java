import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> estoque = new ArrayList<>();

    public String movimentarEstoque(Produto produto){
        System.out.println("Recebido: " + produto.getNome() + " " + produto.getQuantidade());
        int id = this.verificarProdutor(produto);
        if(id != -1){
            if(produto.getQuantidade() > 0){
                System.out.println("Coloca Produto");
                return this.entradaProduto(id, produto);
            }else{
                System.out.println("Retira Produto");
                return this.saidaProduto(id, produto);
            }
        }else{
            if(produto.getQuantidade() > 0) {
                this.cadastrarProduto(produto);
                System.out.println("----------------------------------------------");
                this.mostrarProdutos();                
                System.out.println("----------------------------------------------");
                return "Novo Produto Cadastrado";
            } else return "Produto Inexistente";
        }
        
    }

    private void mostrarProdutos(){
        for (int i = 0; i < this.estoque.size(); i++) {
            System.out.println("Produto: " + this.estoque.get(i).getNome());
        }
    }

    private int verificarProdutor(Produto produto){
        for (int i = 0; i < this.estoque.size(); i++) {
            if(produto.getNome().equals(this.estoque.get(i).getNome())){
                System.out.println("Produto existe!");
                return i;
            }
        }
        System.out.println("Produto Inexistente");
        return -1;
    }

    private void cadastrarProduto(Produto produto){
        this.estoque.add(produto);
    }

    private String entradaProduto(int id, Produto produto){
        this.estoque.get(id).entradaQuantidade(produto.getQuantidade());
        return "Quantidade do produto " + produto.getNome() + " foi atualizada para: " + 
        this.estoque.get(id).getQuantidade();
    }

    private String saidaProduto(int id, Produto produto){
        if((produto.getQuantidade()*-1) <= this.estoque.get(id).getQuantidade()){
            this.estoque.get(id).saidaQuantidade(produto.getQuantidade());
            return "Quantidade do produto " + produto.getNome() + " foi atualizada para: " + 
            this.estoque.get(id).getQuantidade();
        }else {
            return "Não é possível fazer a saída de estoque – quantidade menor que o valor desejado";
        }
    }
    
}