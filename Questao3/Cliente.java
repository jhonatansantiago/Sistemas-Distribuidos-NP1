import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
      try {
        Socket cliente = new Socket("localhost", 8080);
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        
        Scanner teclado = new Scanner(System.in);

        String nome;
        int quantidade;

        Produto produto;
        int i = 0;
        while(i < 1){
            produto = new Produto();

            System.out.println("Nome do produto: ");
            nome = teclado.next();

            System.out.println("Quantidade do produto: ");
            quantidade = teclado.nextInt();

            produto.setNome(nome);
            produto.setQuantidade(quantidade);

            saida.flush();
            saida.writeObject(produto);
            System.out.println("Enviando Requisição");
        
            System.out.println((String) entrada.readObject());
            
        }
        saida.close();
        entrada.close();
        cliente.close();
        System.out.println("Conexão encerrada"); 
      }
      catch(Exception e) {
        System.out.println("Erro: " + e.getMessage());
      }
    }
  }