package principal;

public class Main {

    private static Bandeja bandeja;
    private static Thread [] cocineros;
    private static Thread [] clientes;
    private static final int CANTIDADCLIENTES = 500;
    private static final int CANTIDADCOCINEROS = 5;
	
    public static void main(String[] args) {

	        bandeja = new Bandeja();
	        cocineros = new Thread[CANTIDADCOCINEROS];
	        clientes = new Thread[CANTIDADCLIENTES];
	 
	        for(int i=0; i<CANTIDADCOCINEROS; i++){
	            cocineros[i] = new Thread(new Cocinero(bandeja, i));
	        }
	        for(int j=0; j<CANTIDADCOCINEROS; j++){
	        	cocineros[j].start();
	        }
	        for(int k=0; k<CANTIDADCLIENTES; k++){
	            clientes[k] = new Thread(new Cliente(bandeja, k));
	        }
	        for(int l=0; l<CANTIDADCLIENTES; l++){
	        	clientes[l].start();
	        }
	        
	}

}


