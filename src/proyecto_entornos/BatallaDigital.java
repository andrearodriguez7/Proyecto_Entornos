package proyecto_entornos;

import java.util.List;
import java.util.Scanner;

public class BatallaDigital {
    private Digimon enemigo;

    public BatallaDigital() {
        this.enemigo = generarDigimonAleatorio();
    }

    private Digimon generarDigimonAleatorio() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String nombreDigimon = nombres[(int) (Math.random() * nombres.length)];
        return new Digimon(nombreDigimon);
    }

    public void pelea(Domador domador) {
        Digimon miDigimon = eligeDigimon(domador);
        if (miDigimon == null) {
            System.out.println("No tiene Digimons para la batalla");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (enemigo.getSalud() > 0 && miDigimon.getSalud() > 0) {
        	System.out.println("Enemigo:", enemigo.getNombre(), "- hp: ", enemigo.getSalud());
        	System.out.println("Mi digi:", miDigimon.getNombre(), "- hp: ", miDigimon.getSalud());
            System.out.println("1. Ataque1");
            System.out.println("2. Ataque2");
            System.out.println("3. Capturar");
            int accion = scanner.nextInt();

            switch (accion) {
                case 1:
                    miDigimon.ataque1(enemigo);
                    break;
                case 2:
                    miDigimon.ataque2(enemigo);
                    break;
                case 3:
                    domador.capturar(enemigo);
                    break;
                default:
                    System.out.println("Acción no válida. Elige 1, 2 o 3.");
                    break;
            }

            if (enemigo.getSalud() > 0) {
                enemigo.ataque1(miDigimon);
            }
        }
        
        System.out.println("La batalla ha terminado.");
        
        if (enemigo.getSalud() <= 0) {
            System.out.println("El enemigo ha sido derrotado");
        }
        if (miDigimon.getSalud() <= 0) {
            System.out.println("Tu Digimon ha sido derrotado");
        }
    }

    private Digimon eligeDigimon(Domador domador) {
    	List<Digimon> equipo = domador.getEquipo();
    	
        System.out.println("Elige un Digimon para la batalla:");
        for (int i = 0; i < equipo.size(); i++) {
            System.out.println((i + 1) + ". " + equipo.get(i).getNombre());
        }
        
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        
        if (eleccion > 0 && eleccion <= equipo.size()) {
            return equipo.get(eleccion - 1);
        }
        System.out.println("Selección no válida.");
        return null;
    }
}
