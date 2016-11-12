package comparacion_metodos;

/**
 * 
 * @Author Alejandro Quesada Suárez y Alberto Monzón López
 */

import java.util.ArrayList;

public class MediaDatosEstadisticos {

    private final ArrayList<DatosEstadisticos> v_de;

    public MediaDatosEstadisticos() {
        this.v_de = new ArrayList<>();
    }

    public void añadeDatosEstadisticos(DatosEstadisticos de) {
        this.v_de.add(de);
    }

    public double dameMediaTiempos() {
        double media_tiempo = 0.0;
        for (int i = 0; i < v_de.size(); i++) {
            media_tiempo += v_de.get(i).dameTiempo();
        }
        media_tiempo /= v_de.size();
        return media_tiempo;
    }

    public double dameMediaComparaciones() {
        double media_comp = 0.0;
        for (int i = 0; i < v_de.size(); i++) {
            media_comp += v_de.get(i).dameComparaciones();
        }
        media_comp /= v_de.size();
        return media_comp;
    }

    public double dameMediaMovimientos() {
        double media_mov = 0.0;
        for (int i = 0; i < v_de.size(); i++) {
            media_mov += v_de.get(i).dameMovimientos();
        }
        media_mov /= v_de.size();
        return media_mov;
    }
}
