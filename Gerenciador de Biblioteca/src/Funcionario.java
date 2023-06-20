import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class Funcionario{
    private Funcionario(){}
    public static void funcoesFunc(){
        String opcao;
        Funcionario funcAdmin = new Funcionario();
        do{
            Menus.funcionario();
            opcao = ES.ler().next();

            switch(opcao){
                case "1":
                    System.out.print("\n\n\t\t##--Relatório de Alunos--##\n\n");
                    funcAdmin.cadAluno();
                    break;
                case "2":
                    System.out.print("\n\n\t\t##--Cadastro de Livros--##\n\n");
                    funcAdmin.cadLivro();
                    break;
                case "3":
                    System.out.print("\n\n\t\t##--Relatório de Alunos--##\n\n");
                    funcAdmin.relAlunos();
                    break;
                case "4":
                    System.out.print("\n\n\t\t##--Relatório de Livros--##\n\n");
                    funcAdmin.relLivros();
                    break;
                case "5":
                    System.out.print("\n\n\t##--Consultar Livro--##\n");
                    funcAdmin.consulLivro();
                    break;
                case "6":
                    System.out.print("\n\n\t\t##--Consultar Aluno--##\n\n");
                    funcAdmin.consulAluno();
                    break;
                case "7":
                    System.out.print("\n\n\t\t##--Gerar Multas--##\n\n");
                    funcAdmin.gerarMulta();
                    break;
                case "8":
                    System.out.println("\nRetornando...");
                    break;
                default:
                    System.out.println("\nERROR: Opçao invalida!");
            }
        }while(!opcao.equals("8"));
    }
    private void cadAluno(){
        Aluno aluno = new Aluno();
        String opcao1;

        System.out.print("Matricula: ");
        aluno.setIdAluno(ES.ler().nextInt());
        System.out.print("Nome: ");
        aluno.setNome(ES.ler().nextLine());
        System.out.print("Telefone: ");
        aluno.setTelefone(ES.ler().next());
        System.out.print("Rua: ");
        aluno.setRua(ES.ler().nextLine());
        System.out.print("Bairro: ");
        aluno.setBairro(ES.ler().nextLine());
        System.out.print("Cidade: ");
        aluno.setCidade(ES.ler().nextLine());

        // Casso ocorra erro na inserçao dos dados
        System.out.print("\nDeseja modificar alguma coisa?\n(1 - sim)\n(2 - nao)\nOpçao: ");
        opcao1 = ES.ler().next();
        if(opcao1.equals("1")){
            String opcao2;
            do{
                System.out.print(
                        "1 - Matricula\n2 - Nome\n3 - Telefone\n" +
                        "4 - Rua\n5 - Bairro\n6 - Cidade\n7 - Sair\nOpção: "
                );
                opcao2 = ES.ler().next();
                switch(opcao2){
                    case "1":
                        System.out.println("Matricula: ");
                        aluno.setIdAluno(ES.ler().nextInt());
                        break;
                    case "2":
                        System.out.println("Nome: ");
                        aluno.setNome(ES.ler().nextLine());
                        break;
                    case "3":
                        System.out.println("Telefone: ");
                        aluno.setTelefone(ES.ler().nextLine());
                        break;
                    case "4":
                        System.out.println("Rua: ");
                        aluno.setRua(ES.ler().nextLine());
                        break;
                    case "5":
                        System.out.println("Bairro: ");
                        aluno.setBairro(ES.ler().nextLine());
                        break;
                    case "6":
                        System.out.println("Cidade: ");
                        aluno.setCidade(ES.ler().nextLine());
                        break;
                    case "7":
                        break;
                    default:
                        System.out.println("ERROR: Opçao invalida!");
                }
            }while(!opcao2.equals("7"));
        }

        try{
            FileWriter escreArq = new FileWriter("banco_dados/alunos.txt", true);
            escreArq.write(
                    aluno.getIdAluno() + ";" +
                        aluno.getNome() + ";" +
                        aluno.getTelefone() + ";" +
                        aluno.getRua() + ";" +
                        aluno.getBairro() + ";" +
                        aluno.getCidade() + ";" +
                        aluno.getMultas() + "\n"
            );
            escreArq.close();
            System.out.println("\nAluno Cadastrado!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void cadLivro(){
        Livro livro = new Livro();
        String opcao1;

        System.out.print("Nome: ");
        livro.setNome(ES.ler().nextLine());
        System.out.print("Editora: ");
        livro.setEditora(ES.ler().nextLine());
        System.out.print("Autor: ");
        livro.setAutor(ES.ler().nextLine());
        System.out.print("Quantidade: ");
        livro.setQuantidade(ES.ler().nextLine());

        // Casso ocorra erro na inserçao dos dados
        System.out.print("\nDeseja modificar alguma coisa?\n(1 - sim)\n(2 - nao)\nOpçao: ");
        opcao1 = ES.ler().next();
        if(opcao1.equals("1")){
            String opcao2;
            do{
                System.out.print(
                        "1 - Nome\n2 - Editora\n" +
                        "3 - Autor\n4 - Quantidade\n5 - Sair\nOpção: "
                );
                opcao2 = ES.ler().next();
                switch(opcao2){
                    case "1":
                        System.out.println("Nome: ");
                        livro.setNome(ES.ler().nextLine());
                        break;
                    case "2":
                        System.out.println("Editora: ");
                        livro.setEditora(ES.ler().nextLine());
                        break;
                    case "3":
                        System.out.println("Autor: ");
                        livro.setAutor(ES.ler().nextLine());
                        break;
                    case "4":
                        System.out.println("Quantidade: ");
                        livro.setQuantidade(ES.ler().nextLine());
                        break;
                    case "5":
                        break;
                    default:
                        System.out.println("ERROR: Opçao invalida!");
                }
            }while(!opcao2.equals("5"));
        }

        try{
            FileWriter escreArq = new FileWriter("banco_dados/livros.txt", true);
            escreArq.write(
                    livro.getNome() + ";" +
                        livro.getEditora() + ";" +
                        livro.getAutor() + ";" +
                        livro.getQuantidade() + "\n"
            );
            escreArq.close();
            System.out.println("\nLivro cadastrado!");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    private void relAlunos(){
        Scanner lerArq = null;
        try{
            File arquivo = new File("banco_dados/alunos.txt");
            lerArq = new Scanner(arquivo);
            while(lerArq.hasNext()){
                String linha = lerArq.nextLine();
                Menus.funcRelAlunos(linha);
            }
            lerArq.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(lerArq != null) lerArq.close();
        }
    }
    private void relLivros(){
        Scanner lerArq = null;
        try{
            File arquivo = new File("banco_dados/livros.txt");
            lerArq = new Scanner(arquivo);
            while (lerArq.hasNext()){
                String linha = lerArq.nextLine();
                Menus.funcRelLivros(linha);
            }
            lerArq.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(lerArq != null) lerArq.close();
        }
    }
    private void consulLivro(){
        Scanner lerArq = null;

        try {
            String opcao;
            String palavra;
            int contAux;

            do{
                File arquivo = new File("banco_dados/livros.txt");
                lerArq = new Scanner(arquivo);

                contAux = 0;

                System.out.print("\nPesquisar: ");
                palavra = ES.ler().nextLine();
                System.out.println("\n");

                while (lerArq.hasNext()){
                    String linha = lerArq.nextLine();
                    if(linha.contains(palavra)){
                        Menus.funcRelLivros(linha);
                        contAux++;
                    }
                }
                if(contAux == 0) System.out.println("Nenhum livro encontrado!");
                do{
                    System.out.print("\nDeseja realizar outra pesquisa?\n1 - Sim\n2 - Não\nOpção: ");
                    opcao = ES.ler().next();
                    if(!opcao.equals("1") && !opcao.equals("2")){
                        System.out.println("ERROR: Opção inválida!");
                    }
                }while(!opcao.equals("1") && !opcao.equals("2"));
            } while(!opcao.equals("2"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(lerArq != null) lerArq.close();
        }
    }
    private void consulAluno(){
        Scanner lerArq = null;

        try {
            String opcao;
            String palavra;
            int contAux;

            do{
                File arquivo = new File("banco_dados/alunos.txt");
                lerArq = new Scanner(arquivo);

                contAux = 0;

                System.out.print("Pesquisar: ");
                palavra = ES.ler().nextLine();
                System.out.println("\n");

                while (lerArq.hasNext()){
                    String linha = lerArq.nextLine();
                    if(linha.contains(palavra)){
                        Menus.funcRelAlunos(linha);
                        contAux++;
                    }
                }
                if(contAux == 0) System.out.println("Nenhum aluno encontrado!");
                do{
                    System.out.print("\nDeseja realizar outra pesquisa?\n1 - Sim\n2 - Não\nOpção: ");
                    opcao = ES.ler().next();
                    if(!opcao.equals("1") && !opcao.equals("2")){
                        System.out.println("ERROR: Opção inválida!");
                    }
                }while(!opcao.equals("1") && !opcao.equals("2"));
            } while(!opcao.equals("2"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(lerArq != null) lerArq.close();
        }
    }
    private void gerarMulta(){
        Scanner lerArq = null;
        LinkedList <String> listaAlunos = new LinkedList<>();
        String matriculaTemp;

        try{
            File arquivo = new File("banco_dados/alunos.txt");
            lerArq = new Scanner(arquivo);

            while (lerArq.hasNext()){
                String linha = lerArq.nextLine();
                listaAlunos.add(linha);
            }
            lerArq.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(lerArq != null) lerArq.close();
        }

        int indexTemp;
        String opcaoTemp = "";

        do{
            indexTemp = -1;
            System.out.print("\nMatricula do Aluno: ");
            matriculaTemp = ES.ler().next();

            for (int i = 0; i < listaAlunos.size(); i++) {
                if (listaAlunos.get(i).contains(matriculaTemp)) {
                    indexTemp = i;
                }
            }
            if (indexTemp < 0){
                System.out.println("Aluno não encontrado!");
                System.out.print("Deseja procurar novamente?\n1 - sim\n2 - não\nOpção: ");
                opcaoTemp = ES.ler().next();
            }
            if (indexTemp >= 0){
                String[] alunoTemp = listaAlunos.get(indexTemp).split(";");
                System.out.println("\nMatricula: "+alunoTemp[0]+"\nNome: "+alunoTemp[1]+"\nMultas: "+alunoTemp[6]+"\nMulta adicionada com sucesso!");
            }
        }while(opcaoTemp.equals("1"));

        String[] alunoTemp = listaAlunos.get(indexTemp).split(";");
        alunoTemp[6] = String.valueOf(Integer.parseInt(alunoTemp[6]) + 1);
        listaAlunos.set(indexTemp, alunoTemp[0]+";"+alunoTemp[1]+";"+alunoTemp[2]+";"+alunoTemp[3]+";"+alunoTemp[4]+";"+alunoTemp[5]+";"+alunoTemp[6]);

        try{
            FileWriter escreArq = new FileWriter("banco_dados/alunos.txt");
            for (String i : listaAlunos){
                escreArq.write(i+"\n");
            }
            escreArq.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}