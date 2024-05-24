package proyecto_entornos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);

        int numBatallas = 0;
        final int MAX_BATALLAS = 5;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Capturar Digimon");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    BatallaDigital batalla = new BatallaDigital();
                    batalla.iniciarBatalla(domador);
                    numBatallas++;
                    if (numBatallas >= MAX_BATALLAS) {
                        System.out.println("Has completado todas las batallas. Fin del juego");
                        return;
                    }
                    break;
                case 2:
                    capturarDigimon(domador);
                    break;
                case 3:
                    System.out.println("Saliendo del juego...");
                    return;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 3.");
                    break;
            }
        }
    }

    private static void capturarDigimon(Domador domador) {
        Digimon nuevoDigimon = generarDigimonAleatorio();
        System.out.println("Intentando capturar a ..." + nuevoDigimon.getNombre());
        domador.capturar(nuevoDigimon);
    }

    private static Digimon generarDigimonAleatorio() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String nombreDigimon = nombres[(int) (Math.random() * nombres.length)];
        
        Digimon digimon = new Digimon(nombreDigimon);
        digimon.recibirDanio((int)(Math.random() * 80) + 1);
        
        return digimon;
    }
}
