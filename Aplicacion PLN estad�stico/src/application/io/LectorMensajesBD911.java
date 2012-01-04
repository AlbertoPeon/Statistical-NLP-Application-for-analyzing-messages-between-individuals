package application.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.util.TimeStamp;

/**
 * Clase que extiende la clase encargada de la persistencia de los datos. Esta
 * clase implementa el método encargado de leer los Mensajes a partir del texto
 * formateados de la forma en que lo están los mensajes liberados por Wikileaks
 * sobre el atentado del 11-S en New York.
 * 
 * Para más info:
 * 
 * @see <a href="http://911.wikileaks.org/">http://911.wikileaks.org/</a>
 * 
 * @see <a
 *      href="http://www.reddit.com/r/reddit.com/comments/a7xpt/conspiracy_theories_commence_wikileaks_to_release/">http://www.reddit.com/r/reddit.com/comments/a7xpt/conspiracy_theories_commence_wikileaks_to_release/</a>
 * 
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class LectorMensajesBD911 extends LectorMensajesTextoBD {

	public LectorMensajesBD911() {
		super();
	}

	public void cargarMensajesTexto(String path) {
		File f = new File(path);
		BufferedReader br = null;
		try {
			conn = conectarDB();
			try {
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO mensajes "
								+ "(VISIBLE,EMISOR,RECEPTOR,TIMESTAMP,TEXTO) " +
										"VALUES (?,?,?,?,?)");
				try {
					conn.setAutoCommit(false);
					try {
						br = new BufferedReader(new FileReader(f));
						String linea = "";
						String[] campos = null;
						int line = 0;
						linea = br.readLine();
						do {
							campos = linea.split("  ");
							try {
								ps.setBoolean(1, true);
								ps.setString(2, "");
								ps.setString(3, getReceptor(campos));
								ps.setString(4, getTimeStamp(campos).toString());
								ps.setString(5, getTexto(linea));
								System.out.println("Line: " + ++line);
								ps.executeUpdate();
							} catch (NoProtocolException e) {
								System.out.println(e.getMessage());
							}
							linea = br.readLine();
						} while (linea != null);
					} finally {
						conn.commit();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("finish");
	}

	private TimeStamp getTimeStamp(String[] campos) {
		String[] division = campos[0].split(" ");
		return new TimeStamp(division[0], division[1]);
	}

	private String getReceptor(String[] campos) {
		String[] division = campos[0].split(" ");
		insertarIndividuo(division[3]);
		return division[3];
	}

	private void insertarIndividuo(String individuo) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Individuos "
							+ "(INDIVIDUO_NOMBRE) VALUES (?)");
			ps.setString(1, individuo);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getTexto(String linea) throws NoProtocolException {
		String prot = buscarProtocolo(linea);
		String[] s = linea.split(prot);
		return eliminarEspacios(s[s.length - 1]);
	}

	private String eliminarEspacios(String s) {
		String string = s;
		while (string.startsWith(" ")) {
			string = string.substring(1);
		}
		return string;
	}

	private String buscarProtocolo(String linea) throws NoProtocolException {
		if (linea.contains("ALPHA")) {
			return "ALPHA";
		} else if (linea.contains("ST NUM")) {
			return "ST NUM";
		} else if (linea.contains("SH/TONE")) {
			return "SH/TONE";
		}
		throw new NoProtocolException("Mensajes sin protocolo");
	}

}
