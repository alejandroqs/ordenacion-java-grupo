package ordenar_vector;

import static java.lang.System.currentTimeMillis;

public class Ordenar1Vector implements OrdenarVector {

    @Override
    public String nombreMetodo() {
        return "Selección Lineal con Intercambio";
    }

    @Override
    public void ordena(int[] v, DatosEstadisticos de) {
        int menor;
        int pos;
        double t_inicio = currentTimeMillis();

        for (int i = 0; i < v.length - 1; i++) {
            menor = v[i];
            pos = i;

            for (int j = i + 1; j < v.length; j++) {
                if (menor > v[j]) { //Comparación//
                    menor = v[j];
                    pos = j;
                }
            }
            v[pos] = v[i]; //Movimiento//
            v[i] = menor;
        }

        double t_fin = currentTimeMillis();
        de.estableceTiempo((t_fin - t_inicio) / 1000);
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
