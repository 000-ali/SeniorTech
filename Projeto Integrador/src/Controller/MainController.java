package Controller;

import Controller.IdosoController;
import Controller.AdminController;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Idoso");
        System.out.println("2 - Administrador");
        int opc = sc.nextInt();

        if (opc == 1) {
            new IdosoController().menu();
        } else {
            new AdminController().menu();
        }
    }
}
