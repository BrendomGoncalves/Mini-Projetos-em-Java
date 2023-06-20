import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Autentica{
    private Autentica(){}
    public static boolean login(){ // Painel de login
        System.out.print("\n\t##--LOGIN--##\n\nUsuário: ");
        String user = ES.ler().next(); // nome do usuario/admin
        System.out.print("Senha: ");
        String usersenha = ES.ler().next(); // senha do usuario/funcionario
        if(autenticaUsuario(user, usersenha)){ // autenticaçao do usuario
            System.out.println("\nLogado!");
            return true;
        } else {
            return false;
        }
    }
    private static boolean autenticaUsuario(String nome, String senha){
        Scanner lerArq = null;
        try{
            File arquivo = new File("banco_dados/usuarios.txt");
            lerArq = new Scanner(arquivo);
            boolean veriUsu = false;  //quando existir usuário, mas a senha estiver errada

            if(!nome.equals("admin")){
                while(lerArq.hasNext()){ // lendo arquivo usurios.txt por linha
                    String[] data = lerArq.next().split(";");
                    if(data[1].equals(nome)){
                        veriUsu = true;
                        if(data[2].equals(senha)){
                            return true;
                        }
                    }
                }
            } else {
                String[] data = lerArq.next().split(";");
                if(data[1].equals(nome)){
                    veriUsu = true;
                    if(data[2].equals(senha)){
                        return true;
                    }
                }
            }
            if(veriUsu){
                System.out.println("\nSenha incorreta!");
            } else System.out.println("\nERROR: Usuário não existe.");

        } catch(FileNotFoundException e){ // caso nao encontre o arquivo
            e.printStackTrace(); // mostrar erro encontrado na abertura do arquivo
        } finally {
            if(lerArq != null) lerArq.close();
        }
        return false;
    }
}