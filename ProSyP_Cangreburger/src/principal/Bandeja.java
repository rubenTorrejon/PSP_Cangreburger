package principal;

public class Bandeja {
	
	private int cangreburgers = 0;
	private int cangreburgersVendidas = 0;
	private int clientesHambrientos = 0;
	
	/**
	 * Constructor vacío
	 */
	public Bandeja() {
	}
	
	
	/**
	 * Añade una cangreburger a la bandeja y lo notifica por pantalla
	 * @param numCocinero
	 */
	public synchronized void cocinarBurger(int numCocinero) {
		cangreburgers++;
		System.out.println("El cocinero " + numCocinero + " ha cocinado una cangreburger.\n"
							+ "Hay " + cangreburgers + " cangreburgers en la bandeja.\n");
		notify();
	}
	
	
	/**
	 * Reduce una cangreburger de la bandeja y notifica por pantalla.
	 * @param numCliente
	 */
	public synchronized void comerBurger(int numCliente) {
		while(cangreburgers == 0) {
			try {
				clientesHambrientos++;
				System.out.println("El cliente " + numCliente + " tiene hambre, pero no hay cangreburgers.\n"
									+ "Los clientes se han quedado con las ganas " + clientesHambrientos + " veces.\n");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cangreburgers--;
		cangreburgersVendidas++;
		System.out.println("El cliente " + numCliente + " ha pedido una cangreburger.\n"
							+ "Hay " + cangreburgers + " cangreburgers en la bandeja.\n"
							+ "Se han servido hasta ahora " + cangreburgersVendidas + " cangreburgers.\n");
		notify();
	}
	
	
}
