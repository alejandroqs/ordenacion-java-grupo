package ordenar_vector;

public class MuestraResultados {

    public static void main(String[] args) {
        final int[] tam_vector = {1000, 2000, 4000, 8000, 16000, 32000};
        Ordenar1Vector m = new Ordenar1Vector();
        DatosEstadisticos[][] de;

        de = CalculadorEstadisticas.estadisticasOrdenaVectores(m, tam_vector);

        System.out.printf("\tVector en orden inversoTiempo\tVector en orden aleatorioTiempo\n");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%6d\t\t\t\t", tam_vector[i]);
            System.out.printf("%6.3f\t\t\t\t", de[i][0].dameTiempo());
            System.out.printf("%6.3f\n", de[i][1].dameTiempo());
        }
    }
}
