package Modelo;

public class Tutorial {

    private int idTutorial;
    private String titulo;
    private String descricao;
    private String categoria;

    public Tutorial(int idTutorial, String titulo, String descricao, String categoria) {
        this.idTutorial = idTutorial;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Tutorial(String titulo, String descricao, String categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public int getIdTutorial() { return idTutorial; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getCategoria() { return categoria; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
