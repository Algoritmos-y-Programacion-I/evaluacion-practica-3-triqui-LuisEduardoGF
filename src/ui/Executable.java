
package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private boolean flag;

    public Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
        flag = false;
    }

    public void run() {
        while (!flag) {
            System.out.println("\n\nBienvenido al menú:\n");
            System.out.println("Opciones:\n" 
                    + "1. Imprimir tablero \n" 
                    + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" 
                    + "4. Verificar ganador \n" 
                    + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }
        }
    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run();
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Ingrese la posición de su jugada (fila y columna, de 0 a 2):");
        int i = reader.nextInt();
        int j = reader.nextInt();
        reader.nextLine();

        if (cont.jugadaHumano(i, j)) {
            System.out.println("Jugada realizada con éxito.");
        } else {
            System.out.println("Coordenadas inválidas o casilla ocupada. Intente de nuevo.");
        }
        imprimirTablero();
    }

    private void validarGanador() {
        String ganador = cont.verificarGanador();
        if (!ganador.equals(" ")) {
            if (ganador.equals("X")) {
                System.out.println("La máquina (X) ha ganado.");
            } else {
                System.out.println("El humano (O) ha ganado.");
            }
            flag = true; 
        } else {
            System.out.println("No hay ganador todavía.");
        }
    }

    private void salir() {
        System.out.println("Saliendo del programa.");
        flag = true;
    }
}
