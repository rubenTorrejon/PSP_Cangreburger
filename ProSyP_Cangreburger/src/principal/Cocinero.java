package principal;

public class Cocinero implements Runnable {
	
    private final Bandeja bandeja;
    private final int idCocinero;
    private int espera;
 
    
    /**
     * Constructor de la clase
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idproductor Identificador del productor
     */
    public Cocinero(Bandeja bandeja, int idCocinero) {
        this.bandeja = bandeja;
        this.idCocinero = idCocinero;
    }
 
    
    public void run() {
        while(true){
            bandeja.cocinarBurger(idCocinero);
            try{
            	espera = (int) Math.random()*3000+1000;
                Thread.sleep(espera);
            }
            catch (InterruptedException e) { 
            }
        }
    }

}
