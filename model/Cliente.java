
package model;

import java.awt.Point;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import view.VentanaC;

/**
 * Clase en la que se maneja la comunicación del lado del cliente.
 */
public class Cliente extends Thread {
	/**
	 * Socket utilizado para comunicarse con el servidor.
	 */
	private Socket socket;
	/**
	 * Stream utilizado para el envío de objetos al servidor.
	 */
	private ObjectOutputStream objectOutputStream;
	/**
	 * Stream utilizado para el envío de objetos al servidor.
	 */
	private ObjectInputStream objectInputStream;
	/**
	 * Ventana utilizada para la interfaz gráfica del cliente.
	 */
	private final VentanaC ventana;
	/**
	 * Identificador único del cliente dentro del chat.
	 */
	private String identificador;
	/**
	 * Variable que determina si el cliente escucha o no al servidor, una vez que se
	 * arranca el hilo de comunicación del cliente.
	 */
	private boolean escuchando;
	/**
	 * Variable que almacena la IP del host en el que se ejecuta el servidor.
	 */
	private final String host;
	/**
	 * Varable que almacena el puerto por el cual el servidor escucha las conexiones
	 * de los diversos clientes.
	 */
	private final int puerto;
	private int can;

	/**
	 * Constructor de la clase cliente.
	 * 
	 * @param ventana
	 * @param host
	 * @param puerto
	 * @param nombre
	 */
	public Cliente(VentanaC ventana, String host, Integer puerto, String nombre) {
		this.ventana = ventana;
		this.host = host;
		this.puerto = puerto;
		this.identificador = nombre;
		escuchando = true;
		this.start();
	}

	/**
	 * Método run del hilo de comunicación del lado del cliente.
	 */
	public void run() {
		try {
			socket = new Socket(host, puerto);
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			System.out.println("Conexion exitosa!!!!");
			this.enviarSolicitudConexion(identificador);
			this.escuchar();
		} catch (UnknownHostException ex) {
			JOptionPane.showMessageDialog(ventana,
					"Conexión rehusada, servidor desconocido,\n" + "puede que haya ingresado una ip incorrecta\n"
							+ "o que el servidor no este corriendo.\n" + "Esta aplicación se cerrará.");
			System.exit(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(ventana,
					"Conexión rehusada, error de Entrada/Salida,\n" + "puede que haya ingresado una ip o un puerto\n"
							+ "incorrecto, o que el servidor no este corriendo.\n" + "Esta aplicación se cerrará.");
			System.exit(0);
		}

	}

	/**
	 * Método que cierra el socket y los streams de comunicación.
	 */
	public void desconectar() {
		try {
			objectOutputStream.close();
			objectInputStream.close();
			socket.close();
			escuchando = false;
		} catch (Exception e) {
			System.err.println("Error al cerrar los elementos de comunicación del cliente.");
		}
	}

	LinkedList<String> lista = new LinkedList<>();

	public LinkedList<String> getLista() {
		return lista;
	}

	public void setLista(LinkedList<String> lista) {
		this.lista = lista;
	}

	/**
	 * Método que envia un determinado mensaje hacia el servidor.
	 * 
	 * @param cliente_receptor
	 * @param mensaje
	 */
	public void enviarBola(String cliente_receptor, int x, int y) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("MENSAJE");
		// cliente emisor
		lista.add(identificador);
		// cliente receptor
		lista.add(cliente_receptor);
		// mensaje que se desea transmitir
		lista.add(String.valueOf(x));
		lista.add(String.valueOf(y));

		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	public void enviarPuntaje1(String cliente_receptor, int puntaje) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("PUNTAJE1");
		// cliente emisor
		lista.add(identificador);
		// cliente receptor
		lista.add(cliente_receptor);
		// mensaje que se desea transmitir
		lista.add(String.valueOf(puntaje));

		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	public void enviarSaque(String cliente_receptor, String mover) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("SAQUE");
		// cliente emisor
		lista.add(identificador);
		// cliente receptor
		lista.add(cliente_receptor);
		// mensaje que se desea transmitir
		lista.add(mover);

		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	public void enviarPuntaje2(String cliente_receptor, int puntaje) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("PUNTAJE2");
		// cliente emisor
		lista.add(identificador);
		// cliente receptor
		lista.add(cliente_receptor);
		// mensaje que se desea transmitir
		lista.add(String.valueOf(puntaje));

		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	public void enviarJugador(String cliente_receptor, int x, int y) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("JUGADOR");
		// cliente emisor
		lista.add(identificador);
		// cliente receptor
		lista.add(cliente_receptor);
		// mensaje que se desea transmitir
		lista.add(String.valueOf(x));
		lista.add(String.valueOf(y));

		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	public void enviarJugador2(String cliente_receptor, int x, int y) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("JUGADOR2");
		// cliente emisor
		lista.add(identificador);
		// cliente receptor
		lista.add(cliente_receptor);
		// mensaje que se desea transmitir
		lista.add(String.valueOf(x));
		lista.add(String.valueOf(y));

		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	public void escuchar() {
		try {
			while (escuchando) {
				Object aux = objectInputStream.readObject();
				if (aux != null) {
					if (aux instanceof LinkedList) {
						ejecutar((LinkedList<String>) aux);
					} else {
						System.err.println("Se recibió un Objeto desconocido a través del socket");
					}
				} else {
					System.err.println("Se recibió un null a través del socket");
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(ventana, "La comunicación con el servidor se ha\n"
					+ "perdido, este chat tendrá que finalizar.\n" + "Esta aplicación se cerrará.");
			System.exit(0);
		}
	}

	public void ejecutar(LinkedList<String> lista) {
		String tipo = lista.get(0);
		switch (tipo) {
		case "CONEXION_ACEPTADA":
			identificador = lista.get(1);
			for (int i = 2; i < lista.size(); i++) {
				ventana.addContacto(lista.get(i));
			}
			this.lista = lista;
			break;
		case "NUEVO_USUARIO_CONECTADO":
			ventana.addContacto(lista.get(1));
			this.lista = lista;
			break;

		case "MENSAJE":
			ventana.addBola(Integer.parseInt(lista.get(3)), Integer.parseInt(lista.get(4)));
			break;
		case "JUGADOR":
			ventana.addjugador(Integer.parseInt(lista.get(3)), Integer.parseInt(lista.get(4)));
			break;
		case "JUGADOR2":
			ventana.addjugador2(Integer.parseInt(lista.get(3)), Integer.parseInt(lista.get(4)));
			break;
		case "PUNTAJE1":
			ventana.addPuntaje1(Integer.parseInt(lista.get(3)));
			break;
		case "PUNTAJE2":
			ventana.addPuntaje2(Integer.parseInt(lista.get(3)));
			break;
		case "SAQUE":
			ventana.addSaque(lista.get(3));
			break;
		default:
			break;
		}
	}

	public LinkedList getlist() {

		return lista;
	}

	/**
	 * Al conectarse el cliente debe solicitar al servidor que lo agregue a la lista
	 * de clientes, para ello se ejecuta este método.
	 * 
	 * @param identificador
	 */
	private void enviarSolicitudConexion(String identificador) {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("SOLICITUD_CONEXION");
		// cliente solicitante
		lista.add(identificador);
		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	/**
	 * Cuando se cierra una ventana cliente, se debe notificar al servidor que el
	 * cliente se ha desconectado para que lo elimine de la lista de clientes y
	 * todos los clientes lo eliminen de su lista de contactos.
	 */
	public void confirmarDesconexion() {
		LinkedList<String> lista = new LinkedList<>();
		// tipo
		lista.add("SOLICITUD_DESCONEXION");
		// cliente solicitante
		lista.add(identificador);
		try {
			objectOutputStream.writeObject(lista);
		} catch (IOException ex) {
			System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
		}
	}

	/**
	 * Método que retorna el identificador del cliente que es único dentro del chat.
	 * 
	 * @return
	 */
	String getIdentificador() {
		return identificador;
	}
}