package proyecto_entornos;

import java.util.List;
import java.util.ArrayList;

public class Domador {
    private String nombre;
    private List<Digimon> equipo;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Digimon> getEquipo() {
        return equipo;
    }

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
