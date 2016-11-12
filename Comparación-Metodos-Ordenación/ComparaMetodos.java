package comparacion_metodos;

/**
 * 
 * @Author Alejandro Quesada Suárez y Alberto Monzón López
 */

public class ComparaMetodos {

    public static void main(String[] args) {
        /* 
         * Mas abajo mantengo bucles para compatibilidad
         * con mediciones con varios tamaños de muestra.
         * Actualmente no implementadas por la complegidad de la salida.
         */
        //final int[] tam_vector = {1000, 2000, 4000, 8000, 16000, 32000};
        final int[] tam_vector = {32000};
        OrdenarVector m1 = new Ordenar1Vector();
        OrdenarVector m2 = new Ordenar2Vector();
        /* 
         * Distribución del vector MediaDatosEstadisticos[i][j][k]:
         * i: 0 = Metodo de ordenación 1. 1 = Metodo de ordenación 2.
         * j: [0-n] = Tamaño del vector muestra proporcionado por tam_vector.
         * k: 0 = Media inversa. 1 = Media aleatoria.
         */
        MediaDatosEstadisticos[][][] resultados;
        resultados = new MediaDatosEstadisticos[2][2][tam_vector.length];
        
        // Calculo de datos:
        for (int i = 0; i < tam_vector.length; i++) {
            resultados[0][i] = estadisticaOrdenaVector(m1, tam_vector[i]);
            resultados[1][i] = estadisticaOrdenaVector(m2, tam_vector[i]);
        }
        
        // Impresión en pantalla:
        System.out.printf("Metodos en orden inverso para 32000 elementos:\n");

        for (int i = 0; i < tam_vector.length; i++) {
            System.out.printf("\t\t\t\tMetodo 1\t\t\tMetodo 2\n");
            System.out.printf("Tiempo medio (s)\t\t");
            System.out.printf("%6.4f\t\t\t\t", resultados[0][i][0].dameMediaTiempos());
            System.out.printf("%6.4f\n", resultados[1][i][0].dameMediaTiempos());
            System.out.printf("Nº medio de comaparaciones\t");
            System.out.printf("%6.2f\t\t\t", resultados[0][i][0].dameMediaComparaciones());
            System.out.printf("%6.2f\n", resultados[1][i][0].dameMediaComparaciones());
            System.out.printf("Nº medio de movimientos\t\t");
            System.out.printf("%6.2f\t\t\t", resultados[0][i][0].dameMediaMovimientos());
            System.out.printf("%6.2f\n", resultados[1][i][0].dameMediaMovimientos());
        }
        System.out.printf("\n");
        System.out.printf("Metodos en orden aleatorio para 32000 elementos:\n");

        for (int i = 0; i < tam_vector.length; i++) {
            System.out.printf("\t\t\t\tMetodo 1\t\t\tMetodo 2\n");
            System.out.printf("Tiempo medio (s)\t\t");
            System.out.printf("%6.4f\t\t\t\t", resultados[0][i][1].dameMediaTiempos());
            System.out.printf("%6.4f\n", resultados[1][i][1].dameMediaTiempos());
            System.out.printf("Nº medio de comaparaciones\t");
            System.out.printf("%6.2f\t\t\t", resultados[0][i][1].dameMediaComparaciones());
            System.out.printf("%6.2f\n", resultados[1][i][1].dameMediaComparaciones());
            System.out.printf("Nº medio de movimientos\t\t");
            System.out.printf("%6.2f\t\t\t", resultados[0][i][1].dameMediaMovimientos());
            System.out.printf("%6.2f\n", resultados[1][i][1].dameMediaMovimientos());
        }
    }

    private static MediaDatosEstadisticos[] estadisticaOrdenaVector(OrdenarVector m, int tam_vector) {
        MediaDatosEstadisticos mde_inv = new MediaDatosEstadisticos();
        MediaDatosEstadisticos mde_ran = new MediaDatosEstadisticos();
        DatosEstadisticos de;
        int[] v;

        //Tiempo Ordenación Inversa.       
        for (int i = 0; i < 10; i++) {
            v = GeneraCaso.generaVector(tam_vector, false); //Fixed!
            de = new DatosEstadisticos();
            m.ordena(v, de);
            mde_inv.añadeDatosEstadisticos(de);
        }

        //Tiempo Media Aleatorio.
        for (int i = 0; i < 10; i++) {
            v = GeneraCaso.generaVector(tam_vector, true); //Fixed!
            de = new DatosEstadisticos();
            m.ordena(v, de);
            mde_ran.añadeDatosEstadisticos(de);
        }

        return new MediaDatosEstadisticos[]{mde_inv, mde_ran};
    }
}
