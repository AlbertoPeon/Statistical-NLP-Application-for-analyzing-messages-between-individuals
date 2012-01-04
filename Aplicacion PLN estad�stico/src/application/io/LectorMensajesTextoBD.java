package application.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import application.io.LectorMensajes;
import application.main.Main;
import application.model.Etiqueta;
import application.model.Grupo;
import application.model.Mensaje;
import application.model.Patron;
import application.model.Individuo;
import application.util.TimeStamp;

/**
 * Clase que implementa los métodos encargados de la persistencia de los datos.
 * Es una clase abstracta por que no implemente el método encargadado de cargar
 * los mensajes desde un fichero de texto. Por defecto, se conecta a una base
 * SQLite
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class LectorMensajesTextoBD implements LectorMensajes {
	private final static String TIPO_DATABASE = "org.sqlite.JDBC";
	private final static String RUTA_DATABASE = "app.db";
	protected Connection conn;
	private Hashtable<String, Individuo> individuosHashTable;

	public LectorMensajesTextoBD() {
		this.individuosHashTable = new Hashtable<String, Individuo>();
	}

	/**
	 * Conecta la aplicación con la base de datos
	 * 
	 * @return el objeto Connection que permite realizar consultas a la base de
	 *         datos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected Connection conectarDB() throws ClassNotFoundException,
			SQLException {
		Class.forName(TIPO_DATABASE);
		Connection conn = DriverManager.getConnection("jdbc:sqlite:"
				+ RUTA_DATABASE);
		return conn;
	}

	abstract public void cargarMensajesTexto(String path);

	public List<Mensaje> leerMensajes() {
		List<Mensaje> mensajes = new LinkedList<Mensaje>();
		try {
			conn = conectarDB();
			try {
				Statement stat = conn.createStatement(
						java.sql.ResultSet.TYPE_FORWARD_ONLY,
						java.sql.ResultSet.CONCUR_READ_ONLY);
				try {
					String sConsulta = "SELECT * FROM mensajes";
					ResultSet rs = stat.executeQuery(sConsulta);
					try {
						int line = 0;
						Mensaje m = null;
						Individuo emisor = null;
						Individuo receptor = null;
						while (rs.next()) {
							emisor = addIndividuoSet(rs.getString(3));
							receptor = addIndividuoSet(rs.getString(4));
							m = new Mensaje(rs.getInt(1), rs.getBoolean(2),
									rs.getString(6), emisor, receptor,
									new TimeStamp(rs.getString(5)));
							obtenerEtiquetas(m);
							mensajes.add(m);
							System.out.println(++line);
						}
					} finally {
						rs.close();
					}
				} finally {
					stat.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mensajes;
	}

	public Hashtable<String, Individuo> leerIndividuos() {
		obtenerIndividuosGrupos();
		return individuosHashTable;
	}

	public List<Grupo> leerGrupos() {
		List<Grupo> grupos = new LinkedList<Grupo>();
		try {
			conn = conectarDB();
			try {
				Statement stat = conn.createStatement(
						java.sql.ResultSet.TYPE_FORWARD_ONLY,
						java.sql.ResultSet.CONCUR_READ_ONLY);
				try {
					String sConsulta = "SELECT * FROM grupos";
					ResultSet rs = stat.executeQuery(sConsulta);
					try {
						while (rs.next()) {
							grupos.add(new Grupo(rs.getString(1)));
						}
					} finally {
						rs.close();
					}
				} finally {
					stat.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grupos;
	}

	public List<Etiqueta> leerEtiquetas() {
		List<Etiqueta> etiquetas = new LinkedList<Etiqueta>();
		try {
			conn = conectarDB();
			try {
				Statement stat = conn.createStatement(
						java.sql.ResultSet.TYPE_FORWARD_ONLY,
						java.sql.ResultSet.CONCUR_READ_ONLY);
				try {
					String sConsulta = "SELECT * FROM etiquetas";
					ResultSet rs = stat.executeQuery(sConsulta);
					try {
						while (rs.next()) {
							etiquetas.add(new Etiqueta(rs.getString(1)));
						}
					} finally {
						rs.close();
					}
				} finally {
					stat.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etiquetas;
	}

	public List<Patron> leerPatrones() {
		List<Patron> patrones = new LinkedList<Patron>();
		try {
			conn = conectarDB();
			try {
				Statement stat = conn.createStatement(
						java.sql.ResultSet.TYPE_FORWARD_ONLY,
						java.sql.ResultSet.CONCUR_READ_ONLY);
				try {
					String sConsulta = "SELECT * FROM patrones";
					ResultSet rs = stat.executeQuery(sConsulta);
					try {
						while (rs.next()) {
							Patron p = new Patron(rs.getString(1),
									rs.getString(2), rs.getString(3),
									rs.getString(4));
							patrones.add(p);
						}
					} finally {
						rs.close();
					}
				} finally {
					stat.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patrones;
	}

	private Individuo addIndividuoSet(String nombre) {
		if (!nombre.equals("")) {
			Individuo individuo = individuosHashTable.get(nombre);
			if (individuo == null) {
				individuo = new Individuo(nombre);
				individuosHashTable.put(nombre, individuo);
			}
			return individuo;
		}
		return null;
	}

	private void obtenerIndividuosGrupos() {
		try {
			conn = conectarDB();
			try {
				Statement stat = conn.createStatement();
				try {
					String sConsulta = "SELECT * FROM IndividuosGrupos";
					ResultSet rs = stat.executeQuery(sConsulta);
					try {
						while (rs.next()) {
							individuosHashTable.get(rs.getString(1)).addGrupo(
									new Grupo(rs.getString(2)));
						}
					} finally {
						rs.close();
					}
				} finally {
					stat.close();
				}
			} finally {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void obtenerEtiquetas(Mensaje m) {
		if (m.getEtiquetas() != null && m.getEtiquetas().isEmpty()) {
			try {
				Statement stat = conn.createStatement(
						java.sql.ResultSet.TYPE_FORWARD_ONLY,
						java.sql.ResultSet.CONCUR_READ_ONLY);
				try {
					String sConsulta = "SELECT * FROM EtiquetasMensajes WHERE ID_MENSAJE="
							+ m.getId();
					ResultSet rs = stat.executeQuery(sConsulta);
					try {
						while (rs.next()) {
							m.etiquetar(new Etiqueta(rs.getString(2)));
						}
					} finally {
						rs.close();
					}
				} finally {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void borrarTodo() {
		try {
			conn = conectarDB();
			try {
				borrar("IndividuosGrupos");
				borrar("EtiquetasMensajes");
				borrar("ETIQUETAS");
				borrar("GRUPOS");
				borrar("PATRONES");
				borrar("Mensajes");
				borrar("Individuos");
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void borrar(String nombreTabla) {
		try {
			String sConsulta = "DELETE FROM " + nombreTabla;
			Statement stmt = conn.createStatement(
					java.sql.ResultSet.TYPE_FORWARD_ONLY,
					java.sql.ResultSet.CONCUR_READ_ONLY);
			try {
				stmt.executeUpdate(sConsulta);

			} finally {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void grabarTodo(Main m) {
		grabarEtiquetas(m.getEtiquetas());
		grabarGrupos(m.getGrupos());
		grabarPatrones(m.getPatrones());
		grabarIndividuos(m.getIndividuos());
		grabarMensajes(m.getMensajes());
	}

	private void grabarIndividuos(Hashtable<String, Individuo> individuosHT) {
		Collection<Individuo> individuos = individuosHT.values();
		try {
			conn = conectarDB();
			try {
				borrar("IndividuosGrupos");
				borrar("Individuos");
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO Individuos "
								+ "(Individuo_nombre) VALUES (?)");
				try {
					conn.setAutoCommit(false);
					try {
						for (Individuo individuo : individuos) {
							ps.setString(1, individuo.getNombre());
							addIndividuoGrupos(individuo);
							ps.executeUpdate();
						}
					} finally {
						conn.commit();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void grabarMensajes(List<Mensaje> mensajes) {
		try {
			conn = conectarDB();
			try {
				borrar("EtiquetasMensajes");
				borrar("Mensajes");
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO mensajes "
								+ "(ID_MENSAJE, VISIBLE,EMISOR,RECEPTOR,"
								+ "TIMESTAMP,TEXTO) VALUES (?, ?,?,?,?,?)");
				try {
					conn.setAutoCommit(false);
					try {
						for (Mensaje mensaje : mensajes) {
							ps.setInt(1, mensaje.getId());
							ps.setBoolean(2, mensaje.isVisible());
							if (mensaje.getEmisor() == null)
								ps.setString(3, "");
							else {
								ps.setString(3, mensaje.getEmisor().toString());
							}
							if (mensaje.getReceptor() == null)
								ps.setString(4, "");
							else {
								ps.setString(4, mensaje.getReceptor()
										.toString());
							}
							ps.setString(5, mensaje.getTimestamp().toString());
							ps.setString(6, mensaje.getTexto());
							addEtiquetaMensaje(mensaje);
							ps.executeUpdate();
						}
					} finally {
						conn.commit();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void addEtiquetaMensaje(Mensaje mensaje) {
		if (mensaje.getEtiquetas() != null && !mensaje.getEtiquetas().isEmpty()) {
			try {
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO EtiquetasMensajes "
								+ "(ID_MENSAJE, ETIQUETA_NOMBRE) VALUES (?, ?)");
				try {
					ps.setInt(1, mensaje.getId());
					for (Etiqueta etiqueta : mensaje.getEtiquetas()) {
						ps.setString(2, etiqueta.toString());
						ps.executeUpdate();
					}
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void addIndividuoGrupos(Individuo individuo) {
		if (individuo.getGrupos() != null && !individuo.getGrupos().isEmpty()) {
			try {
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO IndividuosGrupos "
								+ "(INDIVIDUO_NOMBRE, GRUPO_NOMBRE) VALUES (?, ?)");
				try {
					ps.setString(1, individuo.getNombre());
					for (Grupo grupo : individuo.getGrupos()) {
						ps.setString(2, grupo.toString());
						ps.executeUpdate();
					}
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void grabarPatrones(List<Patron> patrones) {
		try {
			conn = conectarDB();
			try {
				borrar("PATRONES");
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO patrones "
								+ "(CAMPO_PATRON, TIPO_PATRON, VALOR_PATRON, VALOR_PATRON2) VALUES (?,?,?,?)");
				try {
					conn.setAutoCommit(false);
					try {
						for (Patron patron : patrones) {
							ps.setString(1, patron.getCampo().toString());
							ps.setString(2, patron.getTipo().toString());
							ps.setString(3, patron.getValor());
							if (patron.getValor2() == null
									|| patron.getValor2().equals("")) {
								ps.setString(4, "");
							} else {
								ps.setString(4, patron.getValor2());
							}
							ps.executeUpdate();
						}
					} finally {
						conn.commit();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void grabarGrupos(List<Grupo> grupos) {
		try {
			conn = conectarDB();
			try {
				borrar("GRUPOS");
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO grupos "
								+ "(GRUPO_NOMBRE) VALUES (?)");
				try {
					conn.setAutoCommit(false);
					try {
						for (Grupo grupo : grupos) {
							ps.setString(1, grupo.toString());
							ps.executeUpdate();

						}
					} finally {
						conn.commit();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void grabarEtiquetas(List<Etiqueta> etiquetas) {
		try {
			conn = conectarDB();
			try {
				borrar("ETIQUETAS");
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO etiquetas "
								+ "(ETIQUETA_NOMBRE) VALUES (?)");
				try {
					conn.setAutoCommit(false);
					try {
						for (Etiqueta etiqueta : etiquetas) {
							ps.setString(1, etiqueta.toString());
							ps.executeUpdate();
						}
					} finally {
						conn.commit();
					}
				} finally {
					ps.close();
				}
			} finally {
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
