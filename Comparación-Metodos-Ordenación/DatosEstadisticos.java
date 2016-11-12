package comparacion_metodos;

/**
 * 
 * @Author Alejandro Quesada Suárez y Alberto Monzón López
 */

public class DatosEstadisticos {

    private double tiempo;
    private int n_comparaciones;
    private int n_movimientos;

    public DatosEstadisticos() {
        this.tiempo = 0.0;
        this.n_comparaciones = 0;
        this.n_movimientos = 0;
    }

    public void añadeTiempo(double ms) {
        this.tiempo = this.tiempo + ms;
    }

    public void estableceTiempo(double ms) {
        this.tiempo = ms;
    }

    public double dameTiempo() {
        return this.tiempo;
    }

    public void añadeComparacion() {
        this.n_comparaciones++;
    }

    public void añadeMovimiento() {
        this.n_movimientos++;
    }

    public void estableceComparaciones(int n_comparaciones) {
        this.n_comparaciones = n_comparaciones;
    }

    public void estableceMovimientos(int n_movimientos) {
        this.n_movimientos = n_movimientos;
    }

    public int dameComparaciones() {
        return n_comparaciones;
    }

    public int dameMovimientos() {
        return n_movimientos;
    }
}
