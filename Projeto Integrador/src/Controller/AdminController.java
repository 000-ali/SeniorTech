package Controller;

import Modelo.Tutorial;
import service.TutorialService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {

    private TutorialService service = new TutorialService();
    private Scanner sc = new Scanner(System.in);

    public void menu() throws Exception {

        int opc;

        do {
            System.out.println("\n--- MENU DO ADMIN ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("5 - Sair");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    cadastrar();
                break;

                case 2:
                    atualizar();
                break;

                case 3:
                    excluir();
                break;

                case 4:
                    listar();
                break;
            }

        } while (opc != 5);
    }

    private void cadastrar() throws Exception {
        System.out.println("Título:");
        String titulo = sc.nextLine();

        System.out.println("Descrição:");
        String descricao = sc.nextLine();

        System.out.println("Categoria:");
        String categoria = sc.nextLine();

        Tutorial t = new Tutorial(titulo, descricao, categoria);
        service.cadastrar(t);

        System.out.println("Tutorial cadastrado!");
    }

    private void atualizar() throws Exception {
        listar();
        System.out.println("Digite o ID para atualizar:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Novo título:");
        String titulo = sc.nextLine();

        System.out.println("Nova descrição:");
        String descricao = sc.nextLine();

        System.out.println("Nova categoria:");
        String categoria = sc.nextLine();

        Tutorial t = new Tutorial(id, titulo, descricao, categoria);
        service.atualizar(t);

        System.out.println("Atualizado com sucesso!");
    }

    private void excluir() throws Exception {
        listar();
        System.out.println("ID do tutorial para excluir:");
        int id = sc.nextInt();

        service.excluir(id);

        System.out.println("Excluído!");
    }

    private void listar() throws Exception {
        ArrayList<Tutorial> lista = service.buscar("");

        System.out.println("\n--- LISTA DE TUTORIAIS ---");
        for (Tutorial t : lista) {
            System.out.println(t.getIdTutorial() + " - " + t.getTitulo());
        }
    }
}
