package principal;

public class Cliente implements Runnable {

	private Bandeja bandeja;
	private int idCliente;
    private int espera;
	
	public Cliente(Bandeja bandeja, int idCliente) {
		this.bandeja = bandeja;
		this.idCliente = idCliente;
		this.espera = 0;
	}
	
	
    public void run() {
        while(true){
            bandeja.comerBurger(idCliente);
            try{
            	espera = (int) Math.random()*3000+1000;
                Thread.sleep(espera);
            }
            catch (InterruptedException e) { 
            }
        }
    }
}
