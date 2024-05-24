package proyecto_entornos;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa a un domador de Digimon.
 * El domador puede capturar Digimon y mantenerlos en su equipo.
 */
public class Domador {
    private String nombre;
    private List<Digimon> equipo;

    /**
     * Constructor que inicializa un domador con un nombre.
     *
     * @param nombre El nombre del domador.
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del domador.
     *
     * @return El nombre del domador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el equipo de Digimon del domador.
     *
     * @return Una lista con los Digimon del equipo del domador.
     */
    public List<Digimon> getEquipo() {
        return equipo;
    }

    /**
     * Intenta capturar un Digimon y añadirlo al equipo del domador.
     * Solo se puede capturar el Digimon si su salud es 20 o menos y si el equipo del domador tiene menos de 3 Digimon.
     *
     * @param digimon El Digimon a capturar.
     */
    public void capturar(Digimon digimon) {
        if (digimon.getSalud() <= 20) {
            if (equipo.size() < 3) {
                equipo.add(digimon);
                System.out.println(digimon.getNombre() + " se ha unido a su equipo");
            } else {
                System.out.println("Equipo lleno, no se puede unir");
            }
        } else {
            System.out.println("No se puede unir");
        }
    }
}
