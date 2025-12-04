package Modelo;

public class UsuarioIdoso extends Pessoa {

    public UsuarioIdoso(int id, String nome, int idade) {
        super(id, nome, idade);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENU DO IDOSO ---");
        System.out.println("1 - Buscar tutorial");
        System.out.println("2 - Ouvir último tutorial");
        System.out.println("3 - Sair");
    }
}
