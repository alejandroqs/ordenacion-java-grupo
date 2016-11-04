public class DatosEstadisticos{
    private double tiempo;
    
    public DatosEstadisticos(){
        this.tiempo = 0.0;
    }
    
    public void añadeTiempo(double ms){
        this.tiempo = this.tiempo + ms;
    }
    
    public void estableceTiempo(double ms){
        this.tiempo = ms;
    }
    
    public double dameTiempo(){
        return this.tiempo;
    }
}
