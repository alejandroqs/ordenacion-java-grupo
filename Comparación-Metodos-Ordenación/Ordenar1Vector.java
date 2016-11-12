package comparacion_metodos;

/**
 * 
 * @Author Alejandro Quesada Suárez y Alberto Monzón López
 */

import static java.lang.System.currentTimeMillis;

public class Ordenar1Vector implements OrdenarVector {

    @Override
    public String nombreMetodo() {
        return "Selección Lineal con Intercambio";
    }
    
    @Override
    public void ordena(int[] v, DatosEstadisticos de) {
        double t_inicio = currentTimeMillis();
        int menor;
        int pos;

        for (int i = 0; i < v.length - 1; i++) {
            menor = v[i];
            pos = i;

            for (int j = i + 1; j < v.length; j++) {
                de.añadeComparacion();                
		if (menor > v[j]) { //Comparación//
                    menor = v[j];
                    pos = j;
                }
            }
            v[pos] = v[i]; //Movimiento//
            de.añadeMovimiento();
            v[i] = menor;
        }

        double t_fin = currentTimeMillis();
        de.estableceTiempo((t_fin - t_inicio) / 1000);
        
        CompruebaCaso.compruebaVector(v, v.length);
    }
}

/*
Procedimiento selinter (vec,n)
para i desde 1 hasta n-1 hacer
   menor <- vec[i]
   pos <- i
   para j desde i+1 hasta n hacer
      si menor>vec[j] entonces
         menor <- vec[j]
         pos <- j
      fin si
   fin para
   vec[pos] <- vec[i]
   vec[i] <- menor
fin para
retornar
 */
