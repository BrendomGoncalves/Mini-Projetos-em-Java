public class Livro{
    private String nome;
    private String editora;
    private String autor;
    private String quantidade;

    public Livro(){}
    public Livro(String nome, String editora, String autor, String quantidade){
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.quantidade = quantidade;
    }
    public String getNome(){
        return nome;
    }
    public String getEditora(){
        return editora;
    }
    public String getAutor(){
        return autor;
    }
    public String getQuantidade(){
        return quantidade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setQuantidade(String quantidade){
        this.quantidade = quantidade;
    }
}