package comparacion_metodos;

/**
 * 
 * @Author Alejandro Quesada Suárez y Alberto Monzón López
 */

import static java.lang.System.currentTimeMillis;

public class Ordenar2Vector implements OrdenarVector {

    @Override
    public String nombreMetodo() {
        return "Contadores de Distribución";
    }
    
    /**
     * El algoritmo inicial tenia la restricción de no poder usarse con 
     * el numero 0 ni el indice 0. Han sido modificados los bucles e indices
     * para su correcto funcionamiento.
     * 
     * @param v     Vector de estrada/salida. Ordenará los valores de entrada.
     * @param de    Objeto que almacena datos estadisticos.
     */
    @Override
    public void ordena(int[] v, DatosEstadisticos de) {
        double t_inicio = currentTimeMillis();
        final int k = 32000; // K es el numero mayor almacenado en v.
        final int n = v.length;
        int[] vecs = new int[n];
        int[] frec = new int[k + 2];

        /*
         * Según las especificaciones de Java un array de enteros
         * comienza inicializado con todos sus valores a 0.
         *
         * for (int i = 0; i < k+2; i++) {frec[i] = 0;}
         */
        for (int i = 1; i <= n; i++) {
            frec[v[i - 1] + 1] = frec[v[i - 1] + 1] + 1; //Movimiento.
            de.añadeMovimiento();
        }

        frec[1] = 1;

        for (int i = 2; i <= k + 1; i++) {
            frec[i] = frec[i] + frec[i - 1]; //movimiento.
            de.añadeMovimiento();
        }
        for (int i = 1; i <= n; i++) {
            vecs[frec[v[i - 1]]-1] = v[i - 1]; //Movimiento.
            de.añadeMovimiento();
            frec[v[i - 1]] = frec[v[i - 1]] + 1; //Movimiento.
            de.añadeMovimiento();
        }

        // Como se usa un array de entrada/salida 
        // sustituimos valores de vecs en v:
        System.arraycopy(vecs, 0, v, 0, n);
        double t_fin = currentTimeMillis();
        de.estableceTiempo((t_fin - t_inicio) / 1000);
        
        CompruebaCaso.compruebaVector(v, n);
    }
}

/*
Procedimiento contdist (vec,vecs,n,k)
para i desde 1 hasta k+1 hacer 
   frec[i]<-0
fin para
para i desde1 hasta n hacer
   frec[vec[i]+1] <-frec[vec[i]+1]+1
fin para
frec[1] <- 1
para i desde 2 hasta k hacer 
   frec[i] <- frec[i] + frec[i-1] 
fin para
para i desde 1 hasta n hacer 
   vecs[frec[vec[i]]] <- vec[i]  
   frec[vec[i]] <- frec[vec[i]]+1  
fin para 
retornar
 */
