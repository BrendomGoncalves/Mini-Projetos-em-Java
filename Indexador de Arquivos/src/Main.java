import java.io.*;
import java.util.*;
/**
 * Projeto Gerenciador de Índices
 * Autores: Brendom V. G. Gonçalves
 *          Bruno F. S. Pereira
 * UESC - Universidade Estadual de Santa Cruz
 * Disciplina: Organização e Recuperação da Informação
 * Professor: Elinaldo Santos de Goes Junior
 */
public class Main
{
    // Objeto para leitura do teclado
    public static Scanner scanner = new Scanner(System.in);

    // Lista dos paths do conjunto de arquivos
    private static final LinkedList<String> listaPaths = new LinkedList<>();

    // Lista das palavras desconsideradas
    private static final LinkedList<String> listaDescon = new LinkedList<>();

    // Lista do conteúdo de todos os arquivos do conjunto de arquivos
    private static final LinkedList<String> dados = new LinkedList<>();

    // Lista de consultas
    private static final LinkedList<String> listaConsultas = new LinkedList<>();

    // Lista de arquivos que favorecem a consulta
    private static final LinkedList<String> listaResposta = new LinkedList<>();

    // String conjunto          - caminho do arquivo
    // LinkedList<String> lista - lista encadeada para armazenar o arquivo
    // boolean confirm          - confirmação se a lista precisa de tratamento
    public static void captaArquivo(String arquivo, LinkedList<String> lista, boolean confirm){
        try {
            // Abertura de arquivo
            File arq = new File(arquivo);
            Scanner lerArq = new Scanner(arq);
            if(confirm){
                while(lerArq.hasNextLine()){
                    String data = lerArq.next();
                    data = data.replaceAll("[^a-zZ1-9]", "");
                    if(!listaDescon.contains(data)){
                        if(!lista.contains(data)) lista.add(data);
                    }
                }
                Collections.sort(lista); // Ordenando as palavras dos arquivos contidos na lista
            } else {
                while(lerArq.hasNextLine()){
                    lista.add(lerArq.next());
                }
            }
            lerArq.close(); // Fechamento do arquivo
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void indexa(){
        int contadorArq = 0;
        String[][] indexBaseDados = new String[dados.size()][2];

        for(int i = 0; i<dados.size(); i++){
            for(int j=0;j<2;j++){
                switch(j){
                    case 0:
                        indexBaseDados[i][j] = dados.get(i);
                        break;
                    case 1:
                        indexBaseDados[i][j] = Integer.toString(i);
                        break;
                }
            }
        }
        while(contadorArq < listaPaths.size()){
            LinkedList<String> conteudo = new LinkedList<>();
            try {
                Scanner lerArq = new Scanner(new File(listaPaths.get(contadorArq)));
                while(lerArq.hasNextLine()){
                    String data = lerArq.next();
                    data = data.replaceAll("[^a-zZ1-9 ]", "");
                    if(!listaDescon.contains(data)){
                        conteudo.add(data);
                    }
                }
                lerArq.close();
            } catch(IOException e){
                e.printStackTrace();
            }

            HashSet<String> conteudoTemp = new HashSet<>(conteudo);

            verificaConsulta(conteudoTemp, contadorArq);

            for(String s : conteudoTemp){
                if(!listaDescon.contains(s)){
                    int qnt = 0;
                    for(String value : conteudo){
                        if(s.equals(value)) qnt++;
                    }
                    int index = 0;
                    for(int i = 0; i<dados.size(); i++){
                        if(s.equals(indexBaseDados[i][0])){
                            index = Integer.parseInt(indexBaseDados[i][1]);
                        }
                    }
                    StringBuilder itemLista = new StringBuilder(dados.get(index));
                    dados.set(index, String.valueOf((itemLista.append(" ").append(contadorArq+1).append(",").append(qnt))));
                }
            }
            contadorArq++;
        }
    }

    // Hashset<String> lista    - lista sem repetições do conteúdo do arquivo aberto em indexa
    // int arquivo              - numero do arquivo atual na função indexa
    private static void verificaConsulta(HashSet<String> lista, int arquivo){
        int confirmConsulta = 0;
        for(String s: listaConsultas) if(lista.contains(s)) confirmConsulta++;
        if(confirmConsulta == listaConsultas.size()) listaResposta.add(listaPaths.get(arquivo));
    }

    // LinkedList<String> lista - lista do conteúdo de todos os arquivos do conjunto de arquivos
    // String pasta             - path(caminho) da pasta que será salvo o 'indice.txt' e a 'resposta.txt'
    public static void salvaArquivos(LinkedList<String> lista, String pasta) throws IOException{
        FileWriter arq = new FileWriter(pasta + "\\indice.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for(String s : lista){
            String[] data = s.split(" ");
            String dataCmp = "";
            data[0] = data[0] + ": ";
            for(int i=0;i<data.length;i++){
                if(i < data.length - 1) dataCmp = dataCmp.concat(data[i]+" ");
                else dataCmp = dataCmp.concat(data[i]);
            }
            gravarArq.printf(dataCmp + "\n");
        }
        arq.close();
        gravarArq.close();
    }

    // Hashset<String> lista    - lista sem repetições do path dos arquivos que satisfazem a consulta
    // String pasta             - path(caminho) da pasta que será salvo a resposta (resposta.txt)
    public static void salvaResposta(LinkedList<String> lista, String pasta) throws IOException{
        FileWriter arq = new FileWriter(pasta + "\\resposta.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf(lista.size() + "\n");
        for(String s:lista) gravarArq.printf(s+"\n");

        arq.close();
        gravarArq.close();
    }

    public static void main(String[] args) throws IOException
    {
        // Leitura dos três argumentos (conjunto de arquivos, desconsideradas, consulta)
        System.out.print("\nArquivo conjunto:\n-> ");
        String conjunto = scanner.nextLine();

        System.out.print("\nArquivo Desconsideradas:\n-> ");
        String desconsideradas = scanner.nextLine();

        System.out.print("\nArquivo Consulta:\n-> ");
        String consulta = scanner.nextLine();

        // Leitura da pasta destino dos resultados
        System.out.print("\nPasta para salvar 'indice.txt' e 'resposta.txt':\n-> ");
        String pasta = scanner.nextLine();

        // Leitura do arquivo conjunto.txt
        captaArquivo(conjunto, listaPaths, false);

        // Leitura do arquivo 'desconsideradas.txt'
        captaArquivo(desconsideradas, listaDescon, false);

        // Leitura do arquivo 'consulta.txt'
        captaArquivo(consulta, listaConsultas, false);

        // Leitura e tratamento dos arquivos 'a.txt', 'b.txt' e 'c.txt'
        for(String s: listaPaths) captaArquivo(s, dados, true);

        // Indexando os dados dos arquivos 'a.txt', 'b.txt' e 'c.txt' contidos na lista dados
        indexa();

        // Salvando os dados de indexação no arquivo 'indice.txt'
        salvaArquivos(dados, pasta);

        // Salvando os dados da consulta no arquivo 'resposta.txt'
        salvaResposta(listaResposta, pasta);
    }
}