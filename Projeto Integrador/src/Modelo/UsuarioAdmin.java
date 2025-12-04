package Modelo;

public class UsuarioAdmin extends Pessoa {

    public UsuarioAdmin(int id, String nome, int idade) {
        super(id, nome, idade);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENU DO ADMIN ---");
        System.out.println("1 - Cadastrar tutorial");
        System.out.println("2 - Atualizar tutorial");
        System.out.println("3 - Excluir tutorial");
        System.out.println("4 - Listar tutoriais");
        System.out.println("5 - Sair");
    }
}
