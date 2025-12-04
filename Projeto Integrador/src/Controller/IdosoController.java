package Controller;

import Modelo.Tutorial;
import service.TutorialService;
import Util.AudioTTS;
import java.util.ArrayList;
import java.util.Scanner;

public class IdosoController {

    private TutorialService service = new TutorialService();
    private Scanner sc = new Scanner(System.in);
    private Tutorial ultimoTutorial;

    public void menu() throws Exception {

        int opc;

        do {
            System.out.println("\n--- MENU DO IDOSO ---");
            System.out.println("1 - Buscar tutorial");
            System.out.println("2 - Ouvir último tutorial");
            System.out.println("3 - Sair");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    buscar();
                break;

                case 2:
                    ouvir();
                break;
            }

        } while (opc != 3);
    }

    private void buscar() throws Exception {
        System.out.println("Digite uma palavra para buscar:");
        String termo = sc.nextLine();

        ArrayList<Tutorial> lista = service.buscar(termo);

        if (lista.isEmpty()) {
            System.out.println("Nenhum tutorial encontrado.");
            return;
        }

        ultimoTutorial = lista.get(0);

        System.out.println("\nTutorial encontrado:");
        System.out.println("Título: " + ultimoTutorial.getTitulo());
        System.out.println("Descrição: \n" + ultimoTutorial.getDescricao());
    }

    private void ouvir() throws Exception {
        if (ultimoTutorial == null) {
            System.out.println("Busque um tutorial primeiro!");
            return;
        }

        // Texto do tutorial recebido do banco
        String texto = ultimoTutorial.getDescricao();

        System.out.println("Gerando áudio...");

        // Gera o áudio no arquivo tutorial.mp3
        AudioTTS.ler(texto, "tutorial.mp3");

        System.out.println("Áudio gerado com sucesso: tutorial.mp3");
    }

}
