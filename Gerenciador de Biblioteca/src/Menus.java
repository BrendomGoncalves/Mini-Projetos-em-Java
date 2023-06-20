public class Menus{
    private Menus(){}
    public static void login(){
        System.out.print("\n##---------Biblioteca---------##\n");
        System.out.print("|------------------------------|\n");
        System.out.print("| [1] - Login Funcionario      |\n");
        System.out.print("| [2] - Login Aluno            |\n");
        System.out.print("| [3] - Sair                   |\n");
        System.out.print("|------------------------------|\n");
        System.out.print("Digite uma opção (1 - 3): ");
    }
    public static void funcionario(){
        System.out.print("\n\t##--Funcionario Menu--##\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("| [1] - Cadastrar Aluno           |\n");
        System.out.print("| [2] - Cadastrar Livro           |\n");
        System.out.print("| [3] - Relatório de Alunos       |\n");
        System.out.print("| [4] - Relatório de Livros       |\n");
        System.out.print("| [5] - Consultar Livro           |\n");
        System.out.print("| [6] - Consultar Aluno           |\n");
        System.out.print("| [7] - Gerar Multas              |\n");
        System.out.print("| [8] - Voltar                    |\n");
        System.out.print("|---------------------------------|\n");
        System.out.print("Digite uma opção (1 - 8): ");
    }
    public static void funcRelAlunos(String linha) {
        String[] linhaSep = linha.split(";");
        System.out.print("| [" + linhaSep[0] + "] - " + linhaSep[1] + " - (" + linhaSep[2] + ") - (" + linhaSep[3].toUpperCase() + "/" + linhaSep[4].toUpperCase() + "/" + linhaSep[5].toUpperCase() + ") Multas ("+linhaSep[6]+")\n");
    }
    public static void funcRelLivros(String linha){
        String[] linhaSep = linha.split(";");
        System.out.print("| " + linhaSep[0] + " - [" + linhaSep[1] + " / " + linhaSep[2] + "] (qnt: " + linhaSep[3] + ")\n");
    }
}
