package Modelo;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public abstract void mostrarMenu();
}
