import java.net.ServerSocket;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) {
      try {
        ServerSocket servidor = new ServerSocket(8080);
        System.out.println("Servidor ouvindo a porta 8080");
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        Estoque estoque = new Estoque();
        boolean acabou = false;
        Produto produto;
        do{
            produto = (Produto) entrada.readObject();
            if (!produto.getNome().equals("terminar")) {
                String resposta = estoque.movimentarEstoque(produto);
                saida.writeObject(resposta);
            }
            else acabou = true;
        } while(!acabou);
            System.out.println("A execução terminou!");
            entrada.close();
            saida.close();
        }   
      catch(Exception e) {
         System.out.println("Erro: " + e.getMessage());
      }
    }     
  }