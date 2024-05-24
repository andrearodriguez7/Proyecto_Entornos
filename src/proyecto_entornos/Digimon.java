package proyecto_entornos;

public class Digimon {
    private String nombre;
    private int nivel;
    private int puntosDeAtaque;
    private int salud;
    private int dp1;
    private int dp2;

    public Digimon(String nombre) {
        this.nombre = nombre;
        this.nivel = (int) (Math.random() * 5) + 1;
        this.puntosDeAtaque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void ataque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.recibirDanio(puntosDeAtaque);
            dp1--;
            System.out.println(nombre + " realizó Ataque1 a " + enemigo.getNombre());
        } else {
            System.out.println(nombre + " no tiene DP1 suficientes para atacar.");
        }
    }

    public void ataque2(Digimon enemigo) {
        if (dp2 >= 2) {
            enemigo.recibirDanio(2 * puntosDeAtaque);
            dp2 -= 2;
            System.out.println(nombre + " realizó Ataque2 a " + enemigo.getNombre());
        } else {
            System.out.println(nombre + " no tiene DP2 suficientes para atacar.");
        }
    }

    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " recibió " + danio + " puntos de daño. Salud restante: " + salud);
    }
}