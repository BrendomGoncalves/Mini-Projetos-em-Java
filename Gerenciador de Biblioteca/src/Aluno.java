public class Aluno{
    private int idAluno;
    private int multas;
    private String nome;
    private String telefone;
    private String rua;
    private String bairro;
    private String cidade;

    public Aluno(){}
    public Aluno(int id, int multas, String nome, String tel, String rua, String bairro, String cidade){
        this.idAluno = id;
        this.multas = multas;
        this.nome = nome;
        this.telefone = tel;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    public int getIdAluno(){
        return idAluno;
    }
    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getRua(){
        return rua;
    }
    public String getBairro(){
        return bairro;
    }
    public String getCidade(){
        return cidade;
    }
    public int getMultas() {
        return multas;
    }
    public void setIdAluno(int idAluno){
        this.idAluno = idAluno;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public static void func(){
        System.out.println("Olá");
    }
}