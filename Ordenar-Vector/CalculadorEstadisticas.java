package ordenar_vector;

public class CalculadorEstadisticas {

    public static DatosEstadisticos[] estadisticaOrdenaVector(OrdenarVector m, int tam_vector) {
        DatosEstadisticos de_inv= new DatosEstadisticos();
        DatosEstadisticos de_ran= new DatosEstadisticos();
        DatosEstadisticos[] v_de = new DatosEstadisticos[2];
        int[] v_inv = GeneraCaso.generaVector(tam_vector,false);
        int[] v_ran; //¡Modificado!
        
        //Tiempo Ordenación Inversa.
        m.ordena(v_inv, de_inv);
        v_de[0] = de_inv;
        
        //Tiempo Media Aleatorio.
        double aux = 0.0;
        for (int i = 0; i < 10; i++) {
            v_ran = GeneraCaso.generaVector(tam_vector,true); //¡Modificado!
            m.ordena(v_ran, de_ran);
            aux += de_ran.dameTiempo();
        }
        aux = aux/10;
        de_ran.estableceTiempo(aux);
        
        v_de[1] = de_ran;
        
        return v_de;
    }

    public static DatosEstadisticos[][] estadisticasOrdenaVectores(OrdenarVector m, int[] tam_vectores) {
        DatosEstadisticos[][] m_val = new DatosEstadisticos[tam_vectores.length][2];
        
        for (int i = 0; i < tam_vectores.length; i++) {
            m_val[i] = estadisticaOrdenaVector(m, tam_vectores[i]);
        }
        
        return m_val;
    }

}
