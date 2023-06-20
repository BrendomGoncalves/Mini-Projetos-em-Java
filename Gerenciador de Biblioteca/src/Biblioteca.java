public class Biblioteca{
    public static void executando(){
        String opcao; // opção do menu login

        //verificaMultas(); em breve
        do{
            Menus.login(); // menu login
            opcao = ES.ler().next(); // opção escolhida
            switch(opcao){
                case "1":
                    if(Autentica.login()){
                        Funcionario.funcoesFunc();
                    }
                    break;
                case "2":
                    if(Autentica.login()){
                        Aluno.func();
                    }
                    break;
                case "3":
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nERROR: Opção inválida!!");
            }
        }while(!opcao.equals("3"));
    }
}