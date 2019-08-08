package modelo;

public class Escola {
    private String nome;
    private String sigla;
    private String endereco;
    private int nr_alunos;
    private Double area;
    private int codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNr_alunos() {
        return nr_alunos;
    }

    public void setNr_alunos(int nr_alunos) {
        this.nr_alunos = nr_alunos;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    @Override
    public String toString() {
        return sigla;
    }
}
