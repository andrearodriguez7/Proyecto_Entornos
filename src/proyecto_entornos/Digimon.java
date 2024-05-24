package proyecto_entornos;

/**
 * Clase que representa a un Digimon con atributos y métodos para atacar y recibir daño.
 */
public class Digimon {
    private String nombre;
    private int nivel;
    private int puntosDeAtaque;
    private int salud;
    private int dp1;
    private int dp2;

    /**
     * Constructor que inicializa un Digimon con un nombre y establece sus atributos aleatoriamente.
     *
     * @param nombre El nombre del Digimon.
     */
    public Digimon(String nombre) {
        this.nombre = nombre;
        this.nivel = (int) (Math.random() * 5) + 1;
        this.puntosDeAtaque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * Obtiene el nombre del Digimon.
     *
     * @return El nombre del Digimon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la salud del Digimon.
     *
     * @return La salud del Digimon.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Realiza el primer ataque sobre otro Digimon, reduciendo los puntos de poder (DP1).
     * Si el Digimon tiene suficientes DP1, el enemigo recibe daño basado en los puntos de ataque del Digimon.
     *
     * @param enemigo El Digimon enemigo que recibirá el ataque.
     */
    public void ataque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.recibirDanio(puntosDeAtaque);
            dp1--;
            System.out.println(nombre + " realizó Ataque1 a " + enemigo.getNombre());
        } else {
            System.out.println(nombre + " no tiene DP1 suficientes para atacar.");
        }
    }

    /**
     * Realiza el segundo ataque sobre otro Digimon, reduciendo los puntos de poder (DP2).
     * Si el Digimon tiene suficientes DP2, el enemigo recibe el doble de daño basado en los puntos de ataque del Digimon.
     *
     * @param enemigo El Digimon enemigo que recibirá el ataque.
     */
    public void ataque2(Digimon enemigo) {
        if (dp2 >= 2) {
            enemigo.recibirDanio(2 * puntosDeAtaque);
            dp2 -= 2;
            System.out.println(nombre + " realizó Ataque2 a " + enemigo.getNombre());
        } else {
            System.out.println(nombre + " no tiene DP2 suficientes para atacar.");
        }
    }

    /**
     * Reduce la salud del Digimon al recibir daño.
     * Si la salud es menor que cero, se establece a cero.
     *
     * @param danio La cantidad de daño recibido.
     */
    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " recibió " + danio + " puntos de daño. Salud restante: " + salud);
    }
}
